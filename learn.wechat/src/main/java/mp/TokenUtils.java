package mp;

import jedis.JedisUtils;
import mp.token.AccessTokenInfo;
import mp.token.ITokenInfo;
import mp.token.JsApiTicketInfo;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by jian01.zhu on 2016/2/4.
 */
public class TokenUtils {

    private static byte[] lock = new byte[0];

    private static ITokenInfo accessToken = new AccessTokenInfo();

    private static ITokenInfo jsApiTicket = new JsApiTicketInfo();


    public static String getAccessToken(){
        return getToken(accessToken);
    }


    public  static String getJsApiTicket(){
        return getToken(jsApiTicket);
    }

    /**
     *
     * 获取accessToken或jsApiTicket。
     * 首先从缓存中获取accessToken或jsApiTicket值，若值不存在，则调用微信接口，获取accessToken或jsApiTicket。
     * 调用微信接口获取accessToken或jsApiTicket时，需要处理集群并发问题。
     * 1、多个请求，同时到达不同机器，保证只有一台机器调用微信接口。
     * 2、多个请求，同时到达一台机器时，作并发处理，保证只调用一次微信接口。
     *
     * @param tokenInfo     accessToken或jsApiTicket相关的信息
     * @param lock          若值为null或空串，则表明没有被调用此方法的线程锁定
     * @return
     */
    private static String getTokenSync(ITokenInfo tokenInfo,String lock) {
        String redisKey = tokenInfo.getRedisKey();
        String token = JedisUtils.get(redisKey);
        String redisLock = null;

        //缓存中没有值，则证明redis已失效。以下是重新获取token的方法
        if (StringUtils.isBlank(token)) {

            //锁定当前机器，使当前机器只有一条线程去重新获取token
            System.out.println(lock);
            synchronized (lock){
                System.out.println(lock);
                //获得线程锁
                try {
                    //重试次数，最多重试三次。进行http请求才作为一次重试
                    int repeat = 0;
                    do {

                        //重新判断redis中有没有token
                        token = JedisUtils.get(redisKey);
                        if (StringUtils.isBlank(token)) {
                            //没有token，判断线程是否获得进程锁

                            redisLock = JedisUtils.get(tokenInfo.getRedisLockKey(), Constants.RedisConstants.DEFAULT_USELESS_VALUE);
                            boolean isLock = Objects.equals(lock, redisLock);
                            if(!isLock){
                                //线程没有获得进程锁，尝试使用redis锁定，若锁定成功，则本机器去调用微信接口
                                String newLock = UUID.randomUUID().toString();
                                long flag = JedisUtils.setnx(tokenInfo.getRedisLockKey(), newLock,Constants.RedisConstants.ONE_MINUTES);
                                if (flag > 0) {
                                    lock = newLock;
                                    isLock = true;
                                }
                            }

                            if (isLock) {
                                //redis锁定成功，进行请求
                                token = tokenInfo.getToken();
                                repeat++;
                            } else {
                                //redis锁定失效，睡眠100毫秒，再循环尝试
                                TimeUnit.MILLISECONDS.sleep(100);
                            }
                        }


                    } while (StringUtils.isBlank(token) && repeat<3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if(Objects.equals(lock,redisLock)) JedisUtils.del(tokenInfo.getRedisLockKey());
                }
            }

        }

        return token;
    }

    /**
     * 利用accessToken过期时间为2小时，且新旧accessToken可以平滑过渡的特性，实现平滑更新accessToken。
     * redis中，有两个key保存accessToken。
     * 一个key过期时间为30分钟,暂且称为A。
     * 另外一个key过期时间为60分钟，暂且称为B。
     * <p>
     * 当A过期时，使用cache.setnx方法去锁定更新redis的线程。
     * 获得锁定的线程，将进行更新流程，成功获取accessToken时，同时更新redis中的两个key。
     * 更新不成功时，把B中的值设置到A中去，且设置过期时间为1分钟，1分钟后，调用此方法并且获得redis锁的线程继续更新accessToken
     * <p>
     * 没有获得锁定的线程，直接使用B的值，若B的值为空，则重新获取
     * <p>
     * 更新时，使用getTokenSync方法
     *
     * @return
     */
    private static String getToken(ITokenInfo tokenInfo) {
        System.out.println("getToken");
        String redisKey = tokenInfo.getRedisKey();
        String token = JedisUtils.get(redisKey, "");

        //缓存中没有值，则证明redis已失效。以下是重新获取token的方法
        if (StringUtils.isBlank(token)) {

            String redisBackUpKey = tokenInfo.getRedisBackUpKey();
            String lockKey = tokenInfo.getRedisLockKey();
            String lock = UUID.randomUUID().toString();

            long flag = JedisUtils.setnx(lockKey,lock, Constants.RedisConstants.ONE_MINUTES);
            if (flag > 0) {

                token = getTokenSync(tokenInfo,lock);
                updateCacheToken(token,tokenInfo);

                JedisUtils.del(lockKey);
            } else {
                token = JedisUtils.get(redisBackUpKey, "");
                if(StringUtils.isBlank(token)){
                    token = getTokenSync(tokenInfo,lock);
                    updateCacheToken(token,tokenInfo);
                }
            }
        }

        return token;
    }

    /**
     * 更新缓存中,token的值
     * @param token
     * @param tokenInfo
     */
    private static void updateCacheToken(String token, ITokenInfo tokenInfo){
        if(StringUtils.isNoneBlank(token)){
            JedisUtils.set(tokenInfo.getRedisKey(), token, Constants.RedisConstants.HALF_AN_HOUR);
            JedisUtils.set(tokenInfo.getRedisBackUpKey(), token, Constants.RedisConstants.ONE_HOUR);
        }else {
            token = JedisUtils.get(tokenInfo.getRedisBackUpKey());
            JedisUtils.set(tokenInfo.getRedisBackUpKey(), token, Constants.RedisConstants.ONE_MINUTES);
        }
    }
}
