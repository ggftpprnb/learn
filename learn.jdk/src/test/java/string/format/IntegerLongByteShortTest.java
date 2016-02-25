package string.format;

import org.junit.Test;

/**
 * Created by jian01.zhu on 2016/2/23.
 */
public class IntegerLongByteShortTest {

    private Long l = 15867867l;
    private Integer i = -15;
    private Short s = 16;
    private Byte b = 16;

    @Test
    public void d(){

        String format = "%d";
        System.out.println("Long:"+String.format(format,l));
        System.out.println("Integer:"+String.format(format,i));
        System.out.println("Short:"+String.format(format,s));
        System.out.println("Byte:"+String.format(format,b));
    }

    @Test
    public void o(){
        String format = "%o";
        System.out.println("Long:"+String.format(format,l));
        System.out.println("Integer:"+String.format(format,i));
        System.out.println("Short:"+String.format(format,s));
        System.out.println("Byte:"+String.format(format,b));
    }

    @Test
    public void x(){
        String format = "%x";
        System.out.println("Long:"+String.format(format,l));
        System.out.println("Integer:"+String.format(format,i));
        System.out.println("Short:"+String.format(format,s));
        System.out.println("Byte:"+String.format(format,b));
    }

    @Test
    public void X(){
        String format = "%X";
        System.out.println("Long:"+String.format(format,l));
        System.out.println("Integer:"+String.format(format,i));
        System.out.println("Short:"+String.format(format,s));
        System.out.println("Byte:"+String.format(format,b));
    }

    @Test
    public void plus(){
        String format = "%+d";
        System.out.println("Long:"+String.format(format,l));
        System.out.println("Integer:"+String.format(format,i));
        System.out.println("Short:"+String.format(format,s));
        System.out.println("Byte:"+String.format(format,b));
    }

    @Test
    public void zero(){
        String format = "%05d";
        System.out.println("Long:"+String.format(format,l));
        System.out.println("Integer:"+String.format(format,i));
        System.out.println("Short:"+String.format(format,s));
        System.out.println("Byte:"+String.format(format,b));
    }

    @Test
    public void comma(){
        String format = "%,d";
        System.out.println("Long:"+String.format(format,l));
        System.out.println("Integer:"+String.format(format,i));
        System.out.println("Short:"+String.format(format,s));
        System.out.println("Byte:"+String.format(format,b));
    }

    @Test
    public void brackets(){
        String format = "%(d";
        System.out.println("Long:"+String.format(format,l));
        System.out.println("Integer:"+String.format(format,i));
        System.out.println("Short:"+String.format(format,s));
        System.out.println("Byte:"+String.format(format,b));
    }

    @Test
    public void space(){
        String format = "% d";
        System.out.println("Long:"+String.format(format,l));
        System.out.println("Integer:"+String.format(format,i));
        System.out.println("Short:"+String.format(format,s));
        System.out.println("Byte:"+String.format(format,b));
    }
}
