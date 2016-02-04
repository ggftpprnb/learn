package jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.DemoResult;
import model.Type;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.StringWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jian01.zhu on 2016/1/26.
 */
public class JacksonUtils {

    private static ObjectMapper objectMapper;

    private static AtomicInteger atomicInteger = new AtomicInteger();

    private static ReentrantLock lock = new ReentrantLock();

    private static ObjectMapper getObjectMapper() {
        if (objectMapper == null) {
            lock.lock();
            if(objectMapper==null){
                objectMapper = new ObjectMapper();
                atomicInteger.incrementAndGet();
                System.out.println("ObjectMapper实例化");
            }
            lock.unlock();
        }

        return objectMapper;
    }

    /**
     * 把对象转换成字json符串
     *
     * @param srcObj 需要转换成json字符串的对象
     * @return
     */
    public static String toJsonString(Object srcObj) {
        String jsonString = null;

        if (srcObj != null) {
            try {
                StringWriter sw = new StringWriter();
                getObjectMapper().getFactory().createGenerator(sw).writeObject(srcObj);
                jsonString = sw.getBuffer().toString();
                sw.flush();
                sw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return jsonString;
    }

    /**
     * 把json字符串转换成对应的对象
     *
     * @param srcJson json字符串
     * @param clazz   需要转换的对象类型.class
     * @param <T>
     * @return
     */
    public static <T> T jsonString2Obj(String srcJson, Class<T> clazz) {
        T targetObj = null;

        if (!StringUtils.isBlank(srcJson) && clazz != null) {
            try {
                targetObj = getObjectMapper().readValue(srcJson, clazz);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return targetObj;
    }

    public static void main(String[] args) throws InterruptedException {

        DemoResult demoResult = new DemoResult(Type.A);

        Runnable runnable = () -> {
            toJsonString(demoResult);
            System.out.println(Thread.currentThread().getName());
        };

        int n = 100;
        final ExecutorService executorService = Executors.newFixedThreadPool(n);

        for (int i = 0; i < 100; i++) {
            executorService.execute(runnable);
        }

        executorService.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println(atomicInteger.get());
    }
}
