package concurrent;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created by jian01.zhu on 2016/1/15.
 */
public class ExecutorServiceUtils {

    @Test
    public void submit() throws ExecutionException, InterruptedException {
        final ExecutorService executorService = Executors.newCachedThreadPool();

        Runnable runnable = ()-> System.out.println();

        Callable callable = ()->2;

        final Future<?> future = executorService.submit(callable);
        System.out.println(future.get());
    }
}
