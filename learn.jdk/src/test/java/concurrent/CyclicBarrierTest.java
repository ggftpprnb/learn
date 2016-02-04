package concurrent;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * Created by jian01.zhu on 2016/1/29.
 */
public class CyclicBarrierTest {

    // 徒步需要的时间: Shenzhen, Guangzhou, Shaoguan, Changsha, Wuhan
    private static int[] timeWalk = {5, 8, 15, 15, 10};
    // 自驾游
    private static int[] timeSelf = {1, 3, 4, 4, 5};
    // 旅游大巴
    private static int[] timeBus = {2, 4, 6, 6, 7};


    static String now() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(new Date()) + ": ";
    }

    static class Tour implements Runnable {
        private int[] times;
        private CyclicBarrier barrier;
        private String tourName;

        public Tour(CyclicBarrier barrier, String tourName, int[] times) {
            this.times = times;
            this.tourName = tourName;
            this.barrier = barrier;
        }

        public void run() {
            try {
                Thread.sleep(times[0] * 1000);
                System.out.println(now() + tourName + " Reached Shenzhen");
                barrier.await();
                Thread.sleep(times[1] * 1000);
                System.out.println(now() + tourName + " Reached Guangzhou");
                barrier.await();
                Thread.sleep(times[2] * 1000);
                System.out.println(now() + tourName + " Reached Shaoguan");
                barrier.await();
                Thread.sleep(times[3] * 1000);
                System.out.println(now() + tourName + " Reached Changsha");
                barrier.await();
                Thread.sleep(times[4] * 1000);
                System.out.println(now() + tourName + " Reached Wuhan");
                barrier.await();
            } catch (InterruptedException e) {
            } catch (BrokenBarrierException e) {
            }
        }
    }

    @Test
    public void cyclicBarrier_test() throws InterruptedException, ExecutionException {
        // 三个旅行团
        CyclicBarrier barrier = new CyclicBarrier(3);
        ExecutorService exec = Executors.newFixedThreadPool(3);
        ExecutorCompletionService<String> executorCompletionService = new ExecutorCompletionService<String>(exec);

        executorCompletionService.submit(new Tour(barrier, "WalkTour", timeWalk),"WalkTour");
        executorCompletionService.submit(new Tour(barrier, "SelfTour", timeSelf),"SelfTour");
        //executorCompletionService.submit(new Tour(barrier, "BusTour", timeBus),"BusTour");

        executorCompletionService.take().get();
        executorCompletionService.take().get();
        //executorCompletionService.take().get();

    }
}
