package jedis;

import com.google.common.collect.Lists;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * Created by jian01.zhu on 2016/2/4.
 */
public class JedisUtils {

    private static ShardedJedisPool shardedJedisPool;

    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(500);
        jedisPoolConfig.setMaxIdle(50);
        jedisPoolConfig.setMaxWaitMillis(500);
        jedisPoolConfig.setTestOnBorrow(true);

        JedisShardInfo jedisShardInfo = new JedisShardInfo("10.199.250.206", 6379);

        shardedJedisPool = new ShardedJedisPool(jedisPoolConfig, Lists.newArrayList(jedisShardInfo));
    }


    /**
     * 把值写入redis对应的key上，并设置过期时间
     *
     * @param key
     * @param value
     * @param second 过期时间，单位：秒
     * @return
     */
    public static String set(String key, String value, int second) {
        String flag = null;
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            flag = shardedJedis.setex(key, second, value);
        } catch (Exception ex) {
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return flag;
    }

    /**
     * 把值写入redis对应的key上
     *
     * @param key
     * @param value
     * @return
     */
    public static String set(String key, String value) {
        String flag = null;
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            flag = shardedJedis.set(key, value);
        } catch (Exception ex) {
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return flag;
    }


    /**
     * 根据key从redis中获取值
     *
     * @param key
     * @return
     */
    public static String get(String key) {
        String value = null;

        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            value = shardedJedis.get(key);
        } catch (Exception ex) {
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }

        return value;
    }

    /**
     * 根据key从redis中获取值
     *
     * @param key
     * @return
     */
    public static String get(String key, String valueIfAbsent) {
        String value = get(key);

        if (value == null) value = valueIfAbsent;

        return value;
    }

    /**
     * 当key没有对应的value时，才设置，设置成功后，给定一个过期时间
     *
     * @param key
     * @param value
     * @param seconds 过期时间
     * @return
     */
    public static long setnx(String key, String value, int seconds) {
        long flag = 0;

        if (setnx(key, value) > 0) {
            flag = expire(key, seconds);
        }

        return flag;
    }

    /**
     * @param key
     * @param seconds
     * @return
     */
    public static long expire(String key, int seconds) {
        long flag = 0;
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            flag = shardedJedis.expire(key, seconds);
        } catch (Exception ex) {
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return flag;
    }

    /**
     * 当key没有对应的value时，才设置
     *
     * @param key
     * @param value
     * @return
     */
    public static long setnx(String key, String value) {
        long flag = 0;
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            flag = shardedJedis.setnx(key, value);
        } catch (Exception ex) {
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return flag;
    }

    /**
     * 从redis中删除此key 对应的 value
     *
     * @param key
     * @return
     */
    public static long del(String key) {
        long flag = 0;
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            flag = shardedJedis.del(key);
        } catch (Exception ex) {
            returnBrokenResource(shardedJedis);
        } finally {
            returnResource(shardedJedis);
        }
        return flag;
    }

    private static void returnBrokenResource(ShardedJedis shardedJedis) {
        try {
            shardedJedis.close();
            shardedJedisPool.returnBrokenResource(shardedJedis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void returnResource(ShardedJedis shardedJedis) {
        try {
            shardedJedisPool.returnResource(shardedJedis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
