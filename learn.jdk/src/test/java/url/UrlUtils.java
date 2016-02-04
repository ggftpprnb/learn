package url;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by jian01.zhu on 2015/12/29.
 */
public class UrlUtils {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = URLEncoder.encode("http://www.baidu.com","utf-8");
        System.out.println(str);
    }
}
