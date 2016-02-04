package list;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * Created by jian01.zhu on 2016/2/1.
 */
public class ListTest {

    @Test
    public void subList_test(){
        List<Integer> list = Lists.newArrayList(1,2,3,4,5);

        List<Integer> newList = list.subList(0,list.size());
        newList.forEach(System.out::println);
    }
}
