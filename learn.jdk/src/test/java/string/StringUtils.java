package string;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by jian01.zhu on 2015/12/17.
 */
public class StringUtils {
    public static void main(String[] args){



    }


    @Test
    public void index(){
        String weekDayStr = "W1";
        Integer weekday = Integer.parseInt(weekDayStr.substring(weekDayStr.indexOf("W")+1));
        System.out.println(weekday);
    }
}
