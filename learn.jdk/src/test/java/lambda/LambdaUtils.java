package lambda;

import java.util.function.Function;

/**
 * Created by jian01.zhu on 2016/2/23.
 */
public class LambdaUtils {


    public <R> R perform(Function<? super RedisClient,R> action){
        try(JedisClient client = RedisClientUtils.getJedisClient()){
            return action.apply(client);
        }
    }

}
