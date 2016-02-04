package text;

import org.junit.Test;

import java.text.MessageFormat;

/**
 * Created by jian01.zhu on 2015/12/14.
 */
public class TextUtils {

    @Test
    public void messageFormatTest(){
        String msg = MessageFormat.format("我是{0},我来自{1},今年{2}岁", "中国人", "北京", "22");

        System.out.println(msg);
    }
}
