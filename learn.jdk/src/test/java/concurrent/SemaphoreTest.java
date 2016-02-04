package concurrent;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by jian01.zhu on 2016/1/29.
 */
public class SemaphoreTest {

    public class MySemaphore implements Runnable{

        private String username;

        private Semaphore semaphore;

        public MySemaphore(String username,Semaphore semaphore){
            this.username = username;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try{
                if(semaphore.availablePermits()>0){
                    System.out.println("顾客["+this.username+"]进入厕所，有空位");
                }
                else{
                    System.out.println("顾客["+this.username+"]进入厕所，没空位，排队");
                }
                semaphore.acquire(2);
                System.out.println("顾客["+this.username+"]获得坑位,"+semaphore.availablePermits());
                Thread.sleep((int)(Math.random()*1000));
                System.out.println("顾客["+this.username+"]使用完毕");
                semaphore.release(2);
            }
            catch(Exception e){
                e.printStackTrace();
            }

        }
    }

    @Test
    public void semaphore_test() throws InterruptedException {

        ExecutorService list= Executors.newCachedThreadPool();
        Semaphore semaphore=new Semaphore(4);
        semaphore.release(2);
        System.out.println(semaphore.availablePermits());
        for(int i=0;i<10;i++){
            list.submit(new MySemaphore(String.valueOf(i),semaphore));
        }

        Thread.sleep(6000l);

        //list.shutdown();
        /*semaphore.acquireUninterruptibly(2);
        System.out.println("使用完毕，需要清扫了。"+semaphore.availablePermits());
        semaphore.release(2);*/
    }
}
