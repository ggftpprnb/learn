package string;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Calendar;
import java.util.Date;

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


        System.out.println(Long.parseLong("0001"));
    }

    /**
     * 根据ID和安全码，推导出邀请码。邀请码=ID+安全码
     * 邀请码至少为6位数。若ID+安全码不足6位，则在邀请码前面补0
     *
     * @param id            分店ID
     * @param securityCode  分店安全码
     * @return
     */
    public static String getInviteCode(Long id,String securityCode){
        String ic = null;
        if(id!=null && securityCode!=null){
            ic = String.format("%03d %s",id,securityCode);
        }

        return ic;
    }

    /**
     * 随机生成3位数字安全码
     *
     * @return
     */
    public static String getSecurityCode() {
        Double random = Math.random() * 1000;
        return String.format("%03d",random.longValue());
    }

    @Test
    public void format(){

        System.out.println(getInviteCode(1l,getSecurityCode()));


        System.out.println(String.format("%4$s %3$S %2$B %1$b %4$H %3$h %2$b %1$S","a", "b", "c", "d"));
        System.out.println(String.format("%s %<s %<s %<s", "a", "b", "c", "d"));
        System.out.println(String.format("%n"));
        System.out.println(String.format("%1$tm %1$te,%1$tY",new Date()));


        System.out.println(String.format("%n %s %s",0.1,0.2));

        System.out.println(String.format("%2$.2s %1$1s", "1", "456"));
        System.out.println(String.format("%2$5.2s", "123", "456"));
        System.out.println(String.format("%2$4.2s", "123", "456789"));
    }
}
