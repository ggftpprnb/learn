package forkjoin.noreturn;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jian01.zhu on 2016/2/1.
 */
public class ProductGenerator {


    public static Product generator(String name,Integer price){
        return new Product(name,price);
    }

    public static List<Product> generatorList(Integer size){
        return Stream.iterate(BigInteger.ONE, e -> e.add(BigInteger.ONE))
                .limit(size)
                .map(e -> generator("name:" + e.intValue(), 10))
                .collect(Collectors.toList());
    }
}
