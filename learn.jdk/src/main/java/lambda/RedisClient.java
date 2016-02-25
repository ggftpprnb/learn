package lambda;

/**
 * Created by jian01.zhu on 2016/2/22.
 */
public class RedisClient implements AutoCloseable {


    public String doSth(){
        System.out.println("doSth.");
        return "doSth.";
    }

    @Override
    public void close(){

    }
}
