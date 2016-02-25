package string.format;

import org.junit.Test;

import java.util.Date;

/**
 * Created by jian01.zhu on 2016/2/23.
 */
public class DateFormatTest {

    private Date now = new Date();

    @Test
     public void H(){
        System.out.println(String.format("%tH",now));
    }

    @Test
    public void I(){
        System.out.println(String.format("%tI",now));
    }

    @Test
    public void k(){
        System.out.println(String.format("%tk",now));
    }

    @Test
    public void l(){
        System.out.println(String.format("%tl",now));
    }

    @Test
    public void M(){
        System.out.println(String.format("%tM",now));
    }

    @Test
    public void S(){
        System.out.println(String.format("%tS",now));
    }

    @Test
    public void L(){
        System.out.println(String.format("%tL",now));
    }

    @Test
    public void N(){
        System.out.println(String.format("%tN",now));
    }

    @Test
    public void p(){
        System.out.println(String.format("%tp",now));
    }

    @Test
    public void z(){
        System.out.println(String.format("%tz",now));
    }

    @Test
    public void Z(){
        System.out.println(String.format("%tZ",now));
    }

    @Test
    public void s(){
        System.out.println(String.format("%ts",now));
    }

    @Test
    public void Q(){
        System.out.println(String.format("%tQ",now));
        System.out.println(now.getTime());
    }

    @Test
    public void B(){
        System.out.println(String.format("%tB",now));
    }

    @Test
    public void b(){
        System.out.println(String.format("%tb",now));
    }

    @Test
    public void h(){
        System.out.println(String.format("%th",now));
    }

    @Test
    public void A(){
        System.out.println(String.format("%tA",now));
    }

    @Test
    public void a(){
        System.out.println(String.format("%ta",now));
    }

    @Test
    public void C(){
        System.out.println(String.format("%tC",now));
    }

    @Test
    public void Y(){
        System.out.println(String.format("%tY",now));
    }

    @Test
    public void y(){
        System.out.println(String.format("%ty",now));
    }

    @Test
    public void j(){
        System.out.println(String.format("%tj",now));
    }

    @Test
    public void m(){
        System.out.println(String.format("%tm",now));
    }

    @Test
    public void d(){
        System.out.println(String.format("%td",now));
    }

    @Test
    public void e(){
        System.out.println(String.format("%te",now));
    }

    @Test
    public void R(){
        System.out.println(String.format("%tR",now));
    }

    @Test
    public void T(){
        System.out.println(String.format("%tT",now));
    }

    @Test
    public void r(){
        System.out.println(String.format("%tr",now));
    }

    @Test
    public void D(){
        System.out.println(String.format("%tD",now));
    }

    @Test
    public void F(){
        System.out.println(String.format("%tF",now));
    }

    @Test
    public void c(){
        System.out.println(String.format("%tc",now));
    }
}
