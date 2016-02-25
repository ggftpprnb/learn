package timer;

import org.junit.Test;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by jian01.zhu on 2016/2/15.
 */
public class TimerTest {

    @Test
    public void timer_test() throws InterruptedException {
        Timer timer = new Timer();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("say sth.");
            }
        };

        timer.schedule(timerTask,1000);

        TimeUnit.SECONDS.sleep(2);

    }
}
