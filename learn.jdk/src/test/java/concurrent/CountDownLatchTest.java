package concurrent;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jian01.zhu on 2016/1/29.
 */
public class CountDownLatchTest {

    @Test
    public void countDownLatch_test() throws InterruptedException {
        // 开始的倒数锁
        final CountDownLatch begin = new CountDownLatch(2);
        // 结束的倒数锁
        final CountDownLatch end = new CountDownLatch(10);
        // 十名选手
        final ExecutorService exec = Executors.newFixedThreadPool(10);
        for (int index = 0; index < 10; index++) {
            final int NO = index + 1;
            Runnable run = () -> {
                try {
                    begin.await();//一直阻塞
                    Thread.sleep((long) (Math.random() * 10000));
                    System.out.println("No." + NO + " arrived");
                } catch (InterruptedException e) {
                } finally {
                    end.countDown();
                }
            };
            exec.submit(run);
        }
        System.out.println("Game Start");
        begin.countDown();
        begin.countDown();
        end.await();
        System.out.println("Game Over");
        exec.shutdown();
    }

}
