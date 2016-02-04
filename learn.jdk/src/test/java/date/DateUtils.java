package date;

import org.junit.Test;

import java.util.Date;

/**
 * Created by jian01.zhu on 2015/12/1.
 */
public class DateUtils {

    @Test
    public void LocalDate() throws InterruptedException {
        Date now = new Date();
        Thread.sleep(10000);
        Date now2 = new Date();

        System.out.println(now.getTime()+"-----------"+now2.getTime());
        System.out.println(now.getTime()==now2.getTime());
    }
}
