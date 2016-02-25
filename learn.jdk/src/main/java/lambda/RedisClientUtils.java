package lambda;

/**
 * Created by jian01.zhu on 2016/2/23.
 */
public class RedisClientUtils {


    public static RedisClient getClient() {
        return new RedisClient();
    }

    public static JedisClient getJedisClient() {
        return new JedisClient();
    }

}
