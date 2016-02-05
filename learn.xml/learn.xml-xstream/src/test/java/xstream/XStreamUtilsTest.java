package xstream;

import com.google.common.collect.Lists;
import model.User;
import org.junit.Test;

/**
 * Created by jian01.zhu on 2016/2/5.
 */
public class XStreamUtilsTest {

    @Test
    public void obj2xml_test(){
        User user = new User();
        user.setId(1l);
        user.setUsername("zj");

        final String xml = XStreamUtils.obj2xml(user);
        System.out.println(xml);
    }

    @Test
    public void list2xml_test(){
        User user = new User();
        user.setId(1l);
        user.setUsername("zj");

        final String xml = XStreamUtils.obj2xml(Lists.newArrayList(user));
        System.out.println(xml);
    }
}
