package extendsuper;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jian01.zhu on 2016/2/24.
 */
public class SuperAndExtends {

    static class Food {
    }

    static class Fruit extends Food {
    }

    static class Apple extends Fruit {
    }

    static class RedApple extends Apple {
    }

    @Test
    public void test_extend() {
        List<? extends Fruit> fruits = new ArrayList<Apple>();
        //compile error:

        /*
        fruits.add(new Apple());
        fruits.add(new Fruit());
        fruits.add(new Object());
        */
        fruits.add(null);

        final Fruit fruit = fruits.get(0);
        System.out.println(fruit);
    }

    @Test
    public void test_super(){
        List<? super Fruit> fruits = new ArrayList<Food>();
        fruits.add(new Fruit());
        fruits.add(new Apple());
        fruits.add(new RedApple());

        final Object o = fruits.get(0);
        System.out.println(o);
    }
}
