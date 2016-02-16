package mp.function.token;

/**
 * Created by jian01.zhu on 2016/2/3.
 */
public interface ITokenInfo {


    /**
     * 获取redis中进程锁的key
     * @return
     */
    String getRedisLockKey();


    /**
     * 获取token在redis的key
     * @return
     */
    String getRedisKey();


    /**
     * 获取备份token在redis中的key
     * @return
     */
    String getRedisBackUpKey();

    /**
     * 获取最新的token,这里会重新去请求微信Api
     * @return
     */
    String getToken();

}
