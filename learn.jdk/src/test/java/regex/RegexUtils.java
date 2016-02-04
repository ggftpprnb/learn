package regex;

import org.junit.Test;

import java.util.regex.Pattern;

/**
 * Created by jian01.zhu on 2015/12/29.
 */
public class RegexUtils {



    @Test
    public void test(){

        int times = 10000000;

        Pattern pattern = Pattern.compile("(\\d+\\.?\\d+)|(\\d)");


        String numberStr = "1.1";

        System.out.println(pattern.matcher(numberStr).matches());


        long begin = System.currentTimeMillis();
        for(int i=0;i<times;i++){
            pattern.matcher(numberStr).matches();
        }
        long end = System.currentTimeMillis();
        System.out.println("end-begin:"+(end-begin));

        begin = System.currentTimeMillis();
        for(int i=0;i<times;i++){
            Integer.parseInt(numberStr);
        }
        end = System.currentTimeMillis();
        System.out.println("end-begin:"+(end-begin));


    }
}
