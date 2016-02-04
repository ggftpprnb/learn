package concurrent;

import java.util.Collection;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jian01.zhu on 2016/2/1.
 */
public class ExecutorCompletionServiceUtils {

    /**
     * 完成集合中的所有线程
     *
     * @param collection
     */
    public static void completeAll(Collection<Runnable> collection) {

        final ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorCompletionService executorCompletionService = new ExecutorCompletionService(cachedThreadPool);

        collection.forEach(e->executorCompletionService.submit(e,e.toString()));

        try {
            executorCompletionService.take().get();
            executorCompletionService.take().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
