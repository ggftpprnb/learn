package sync;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * Created by jian01.zhu on 2016/1/28.
 */
public class SyncUtils {

    private SyncResult syncResult;

    private AtomicInteger atomicInteger = new AtomicInteger();

    public AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }

    public SyncResult getSyncResult() {
        synchronized (atomicInteger) {
            System.out.println(Thread.currentThread().getName());
            if (syncResult == null) {
                if (syncResult == null) {
                    syncResult = new SyncResult();
                    syncResult.setId("id");
                    syncResult.setName("name");
                    System.out.println("syncResult");
                    atomicInteger.incrementAndGet();
                }
            }
        }

        return syncResult;
    }


    public static synchronized String syncStaticMethod() {
        String threadName = Thread.currentThread().getName();

        try {
            Thread.sleep(1000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        final Stream<BigInteger> stream = Stream.iterate(BigInteger.ONE, e -> e.add(BigInteger.ONE)).limit(5);
        stream.forEach(e -> System.out.println(threadName + "getThreadName:-----------" + e.intValue()));

        return threadName;
    }

    public static synchronized String syncStaticMethod2() {
        String threadName = Thread.currentThread().getName();
        final Stream<BigInteger> stream = Stream.iterate(BigInteger.ONE, e -> e.add(BigInteger.ONE)).limit(5);
        stream.forEach(e -> System.out.println(threadName + "getThreadName2:-----------" + e.intValue()));
        return threadName;
    }

    public static String staticMethod() {
        String threadName = Thread.currentThread().getName();
        final Stream<BigInteger> stream = Stream.iterate(BigInteger.ONE, e -> e.add(BigInteger.ONE)).limit(5);
        stream.forEach(e -> System.out.println(threadName + "getThreadName3:-----------" + e.intValue()));
        return threadName;
    }

    public void getThreadName_newObject() {
        systemOut(Thread.currentThread().getName() + "getThreadName_newObject");
    }

    public synchronized void syncMethod_newObject1() {
        systemOut(Thread.currentThread().getName() + "getThreadName_newObject1");
    }

    public synchronized void syncMethod_newObject2() {
        String threadName = Thread.currentThread().getName();
        final Stream<BigInteger> stream = Stream.iterate(BigInteger.ONE, e -> e.add(BigInteger.ONE)).limit(5);
        stream.forEach(e -> System.out.println(threadName + "syncMethod_newObject2:-----------" + e.intValue()));
    }

    public synchronized void syncMethod_newObject3() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String threadName = Thread.currentThread().getName();
        final Stream<BigInteger> stream = Stream.iterate(BigInteger.ONE, e -> e.add(BigInteger.ONE)).limit(5);
        stream.forEach(e -> System.out.println(threadName + "syncMethod_newObject3:-----------" + e.intValue()));
    }

    public void syncThis(){
        synchronized (this){
            String threadName = Thread.currentThread().getName();
            final Stream<BigInteger> stream = Stream.iterate(BigInteger.ONE, e -> e.add(BigInteger.ONE)).limit(5);
            stream.forEach(e -> System.out.println(threadName + "syncThis:-----------" + e.intValue()));
        }
    }

    public void syncObject(){
        synchronized (atomicInteger){
            String threadName = Thread.currentThread().getName();
            final Stream<BigInteger> stream = Stream.iterate(BigInteger.ONE, e -> e.add(BigInteger.ONE)).limit(5);
            stream.forEach(e -> System.out.println(threadName + "syncObject:-----------" + e.intValue()));
        }
    }

    public void syncClass(){
        synchronized (SyncUtils.class){
            String threadName = Thread.currentThread().getName();
            final Stream<BigInteger> stream = Stream.iterate(BigInteger.ONE, e -> e.add(BigInteger.ONE)).limit(5);
            stream.forEach(e -> System.out.println(threadName + "syncClass:-----------" + e.intValue()));
        }
    }

    public void syncClass2(){
        synchronized (SyncUtils.class){
            String threadName = Thread.currentThread().getName();
            final Stream<BigInteger> stream = Stream.iterate(BigInteger.ONE, e -> e.add(BigInteger.ONE)).limit(5);
            stream.forEach(e -> System.out.println(threadName + "syncClass2:-----------" + e.intValue()));
        }
    }

    private static void systemOut(String methodName){
        System.out.println("=========================");
        System.out.println("方法["+methodName+"]锁住线程了！！！");
        for(int i=0;i<50;i++){
            System.out.println(i);
        }
        System.out.println("方法["+methodName+"]释放线程了！！！");
        System.out.println("=========================");
    }
}
