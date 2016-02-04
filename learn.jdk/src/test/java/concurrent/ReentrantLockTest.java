package concurrent;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jian01.zhu on 2016/2/1.
 */
public class ReentrantLockTest {

    private ReentrantLock reentrantLock = new ReentrantLock();

    @Test
    public void lock_test() throws InterruptedException {
        Runnable runnable = ()->{
            reentrantLock.lock();
            System.out.println("线程["+Thread.currentThread().getName()+"]获得锁定");
            try {
                Thread.sleep(1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程["+Thread.currentThread().getName()+"]释放锁定");
            reentrantLock.unlock();
        };

        final ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        ExecutorCompletionService<String> executorCompletionService = new ExecutorCompletionService<>(cachedThreadPool);
        executorCompletionService.submit(runnable,"1");
        executorCompletionService.submit(runnable,"2");

        try {
            executorCompletionService.take().get();
            executorCompletionService.take().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
