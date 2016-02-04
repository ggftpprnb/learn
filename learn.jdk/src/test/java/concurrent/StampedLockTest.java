package concurrent;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.StampedLock;

/**
 * Created by jian01.zhu on 2016/2/1.
 */
public class StampedLockTest {

    private StampedLock stampedLock = new StampedLock();

    @Test
    public void stampedLock_test() throws InterruptedException, ExecutionException {

        Callable<Long> callable = ()-> stampedLock.tryOptimisticRead();
        Callable<Long> callable2 = ()-> stampedLock.tryOptimisticRead();

        final ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorCompletionService<Long> executorCompletionService = new ExecutorCompletionService(cachedThreadPool);
        executorCompletionService.submit(callable);
        executorCompletionService.submit(callable2);

        final Long stamp1 = executorCompletionService.take().get();
        final Long stamp2 = executorCompletionService.take().get();

        //System.out.println(stamp1);
        //System.out.println(stamp2);

        final long stamp = stampedLock.tryOptimisticRead();

        //System.out.println(stampedLock.tryConvertToWriteLock(stamp));

        final long readLock = stampedLock.readLock();
        //stampedLock.unlockRead(readLock);

        System.out.println(stampedLock.tryConvertToWriteLock(readLock));

        //final long writeLock = stampedLock.writeLock();
        //stampedLock.unlockWrite(writeLock);
        //stampedLock.unlock(writeLock);


        System.out.println(stampedLock.validate(stamp));
        System.out.println(stampedLock.validate(stamp2));
        System.out.println(stampedLock.validate(stamp1));


    }


    @Test
    public void tryConvertToWriteLock_test(){

        Runnable write = ()->{
            final long writeLock = stampedLock.writeLock();
            try {
                Thread.sleep(10000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                stampedLock.unlockWrite(writeLock);
            }
        };
    }
}
