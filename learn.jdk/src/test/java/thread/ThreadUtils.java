package thread;

import org.junit.Test;
import sync.SyncUtils;

import java.util.concurrent.*;

/**
 * Created by jian01.zhu on 2015/12/29.
 */
public class ThreadUtils {

    @Test
    public void timeUnitTest() throws InterruptedException {
        long begin = System.currentTimeMillis();
        System.out.println("begin:"+begin);
        TimeUnit.SECONDS.sleep(1);
        long end = System.currentTimeMillis();
        System.out.println(end-begin);
    }

    @Test
    public void syncThisTest() throws InterruptedException {

        SyncUtils syncUtils = new SyncUtils();

        Runnable runnable = ()-> syncUtils.getSyncResult();

        final ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        for(int i=0;i<1000;i++){
            cachedThreadPool.execute(runnable);
        }

        cachedThreadPool.awaitTermination(2,TimeUnit.SECONDS);

        System.out.println(syncUtils.getAtomicInteger());

    }

    @Test
    public void syncStaticMethodTest() throws InterruptedException {
        Runnable runnable = ()-> SyncUtils.syncStaticMethod();
        Runnable runnable2 = ()-> SyncUtils.syncStaticMethod2();
        Runnable runnable3 = ()-> SyncUtils.staticMethod();

        final ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        for(int i=0;i<10;i++){
            //cachedThreadPool.execute(runnable);
            cachedThreadPool.execute(runnable2);
            cachedThreadPool.execute(runnable3);
        }

        cachedThreadPool.awaitTermination(12,TimeUnit.SECONDS);

    }

    @Test
    public void syncNewObjectMethodTest() throws InterruptedException {

        SyncUtils syncUtils = new SyncUtils();

        Runnable runnable = ()-> syncUtils.getThreadName_newObject();
        Runnable runnable1 = ()-> syncUtils.syncMethod_newObject1();
        Runnable runnable2 = ()-> syncUtils.syncMethod_newObject2();
        Runnable runnable3 = ()-> SyncUtils.syncStaticMethod2();

        final ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        for(int i=0;i<10;i++){
            cachedThreadPool.execute(runnable);
            cachedThreadPool.execute(runnable1);
            //cachedThreadPool.execute(runnable2);
            //cachedThreadPool.execute(runnable3);
        }

        cachedThreadPool.awaitTermination(20,TimeUnit.SECONDS);

    }

    @Test
    public void syncClassTest() throws InterruptedException {
        SyncUtils syncUtils = new SyncUtils();

        Runnable runnable = ()-> syncUtils.syncClass();
        Runnable runnable1 = ()-> syncUtils.syncClass2();

        final ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        for(int i=0;i<10;i++){
            cachedThreadPool.execute(runnable);
            cachedThreadPool.execute(runnable1);
            //cachedThreadPool.execute(runnable2);
            //cachedThreadPool.execute(runnable3);
        }

        cachedThreadPool.awaitTermination(5,TimeUnit.SECONDS);
    }


    @Test
    public void syncThisAndSyncMethodTest() throws InterruptedException {
        SyncUtils syncUtils = new SyncUtils();

        Runnable runnable = ()-> syncUtils.syncThis();
        Runnable runnable1 = ()-> syncUtils.syncMethod_newObject3();

        final ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        for(int i=0;i<10;i++){
            cachedThreadPool.execute(runnable);
            cachedThreadPool.execute(runnable1);
        }

        cachedThreadPool.awaitTermination(5,TimeUnit.SECONDS);
    }

    @Test
    public void syncObjectAndSyncMethodTest() throws InterruptedException {
        SyncUtils syncUtils = new SyncUtils();

        Runnable runnable = ()-> syncUtils.syncObject();
        Runnable runnable1 = ()-> syncUtils.syncMethod_newObject3();

        final ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        for(int i=0;i<10;i++){
            cachedThreadPool.execute(runnable);
            cachedThreadPool.execute(runnable1);
        }

        cachedThreadPool.awaitTermination(5,TimeUnit.SECONDS);
    }

    @Test
    public void syncStaticMethodAndSyncClassTest() throws InterruptedException, ExecutionException {
        SyncUtils syncUtils = new SyncUtils();

        Runnable runnable = ()-> syncUtils.syncClass2();
        Runnable runnable1 = ()-> syncUtils.syncMethod_newObject2();

        Callable<String> callable = ()->{Thread.sleep(1000); return "success";};
        Callable<String> callable2 = ()->"success2";

        final ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorCompletionService<String> executorCompletionService = new ExecutorCompletionService(cachedThreadPool);

        /*//executorCompletionService.submit(runnable,"1");
        //executorCompletionService.submit(runnable1,"2");
        executorCompletionService.submit(callable);
        executorCompletionService.submit(callable2);

        String str = executorCompletionService.take().get();
        System.out.println("str"+str);
        str = executorCompletionService.take().get();
        System.out.println(str);*/
        cachedThreadPool.submit(runnable);
        cachedThreadPool.submit(runnable1);

        cachedThreadPool.shutdown();
    }
}
