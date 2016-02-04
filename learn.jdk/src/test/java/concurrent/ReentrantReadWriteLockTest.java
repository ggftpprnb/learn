package concurrent;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by jian01.zhu on 2016/2/1.
 */
public class ReentrantReadWriteLockTest {

    private String value = "default";

    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    private String readValue() {
        reentrantReadWriteLock.readLock().lock();
        System.out.println("线程["+Thread.currentThread().getName()+"]获得readLock");
        try {
            Thread.sleep(1000l);
            return value;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "";
        } finally {
            System.out.println("线程["+Thread.currentThread().getName()+"]释放readLock");
            reentrantReadWriteLock.readLock().unlock();
        }
    }

    private void writeValue(String newValue) {
        reentrantReadWriteLock.writeLock().lock();
        System.out.println("线程["+Thread.currentThread().getName()+"]获得writeLock");
        try {
            Thread.sleep(1000l);
            this.value = newValue;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(this.value);
            System.out.println("线程["+Thread.currentThread().getName()+"]释放writeLock");
            reentrantReadWriteLock.writeLock().unlock();
        }
    }

    @Test
    public void readLock_test() throws InterruptedException {
        Runnable runnable = () -> System.out.println(readValue());
        Runnable runnable2 = () -> System.out.println(readValue());

        ExecutorCompletionServiceUtils.completeAll(Lists.newArrayList(runnable,runnable2));

    }

    @Test
    public void writeLock_test(){
        Runnable runnable = () -> writeValue(Thread.currentThread().getName());
        Runnable runnable2 = () -> writeValue(Thread.currentThread().getName());

        ExecutorCompletionServiceUtils.completeAll(Lists.newArrayList(runnable,runnable2));
    }

    @Test
    public void readWriteLock_test(){
        Runnable runnable = () -> System.out.println(readValue());
        Runnable runnable2 = () -> writeValue(Thread.currentThread().getName());

        ExecutorCompletionServiceUtils.completeAll(Lists.newArrayList(runnable2,runnable));
    }

}
