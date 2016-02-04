package stream;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.io.File;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jian01.zhu on 2015/12/1.
 */
public class StreamUtils {


    private static List<String> strList;
    private static List<Map<String, String>> mapList;
    private static List<List<String>> listList;

    static {
        strList = Lists.newArrayList();

        strList.add("5");
        strList.add("4");
        strList.add("3");
        strList.add("2");
        strList.add("1");
        strList.add("1");
    }

    static {
        mapList = Lists.newArrayList();

        Map<String, String> map1 = Maps.newHashMap();
        map1.put("1k1", "1v1");
        map1.put("1k2", "1v2");
        map1.put("1k3", "1v3");

        Map<String, String> map2 = Maps.newHashMap();
        map1.put("2k1", "2v1");
        map1.put("2k2", "2v2");
        map1.put("2k3", "2v3");

        Map<String, String> map3 = Maps.newHashMap();
        map1.put("3k1", "3v1");
        map1.put("3k2", "3v2");
        map1.put("3k3", "3v3");

        mapList.add(map1);
        mapList.add(map2);
        mapList.add(map3);

    }

    static {
        listList = Lists.newArrayList();

        List<String> list1 = Lists.newArrayList("11", "12", "13", "14", "15");
        List<String> list2 = Lists.newArrayList("21", "22", "23", "24", "25");
        List<String> list3 = Lists.newArrayList("31", "32", "33", "34", "35");

        listList.add(list1);
        listList.add(list2);
        listList.add(list3);
    }

    @Test
    public void testStream_strList() {
        strList.stream().filter(e -> e.compareTo("2") > 0).limit(2).forEach(e -> System.out.println(e));

        strList.forEach(e -> System.out.println(e));


        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            List<Integer> newList = Lists.newArrayList();
            strList.forEach(e -> newList.add(Integer.parseInt(e)));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("endTime-startTime=" + (endTime - startTime));


        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            List<Integer> newList = strList.stream().map(e -> Integer.parseInt(e)).collect(Collectors.toList());
        }
        endTime = System.currentTimeMillis();
        System.out.println("endTime-startTime=" + (endTime - startTime));


        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            Map<String, String> map = Maps.newHashMap();
            strList.forEach(e -> map.put(e, e));
        }
        endTime = System.currentTimeMillis();
        System.out.println("endTime-startTime=" + (endTime - startTime));


        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            Map<String, String> map = strList.stream().collect(Collectors.toMap(e -> e, e -> e));
        }
        endTime = System.currentTimeMillis();
        System.out.println("endTime-startTime=" + (endTime - startTime));

        String str = strList.stream().reduce("1", (e1, e2) -> e1 + "#" + e2);
        System.out.println(str);
    }

    @Test
    public void testStream_mapList() {
        //mapList.stream().map(e->e.)
        System.out.println(strList.stream().allMatch(e -> e.length() != 0));
        System.out.println(strList.stream().anyMatch(e -> e.length() >= 1));
        Lists.newArrayList("1", "2", "3", "3").stream().distinct().forEach(e -> System.out.println(e));
        System.out.println(strList.stream().findAny().get());
        System.out.println(strList.stream().min((e1, e2) -> {
            if (e1.compareTo(e2) >= 1) {
                return -1;
            } else if (e1.compareTo(e2) >= 1) {
                return 0;
            } else {
                return 1;
            }
        }).get());

        System.out.println(strList.stream().noneMatch(e -> e.length() == 0));
        List<String> peekList = strList.stream().filter(e -> !e.equals("2")).peek(System.out::println).collect(Collectors.toList());
        System.out.println(peekList);

        //strList.stream().
        listList.stream().flatMap(e -> e.stream()).forEach(System.out::println);

        strList.stream().skip(2).forEach(System.out::println);

        strList.stream().sorted().forEach(System.out::println);

        strList.stream().sorted((e1, e2) -> e1.compareTo(e2)).forEach(System.out::println);

        strList.stream().parallel().forEach(System.out::println);

        Map<String, List<String>> collect = strList.stream().collect(Collectors.groupingBy(String::toString));
        System.out.println(collect);

        Double collect1 = strList.stream().collect(Collectors.averagingLong(Long::parseLong));
        System.out.println(collect1);

        Long collect2 = strList.stream().filter(e -> e.equals("1")).collect(Collectors.counting());

        System.out.println(strList.stream().filter(e -> e.equals("1")).count() == collect2);

        String collect3 = strList.stream().collect(Collectors.joining("#", "begin", "end"));
        System.out.println(collect3);

        HashSet<String> collect4 = strList.stream().collect(Collectors.toCollection(HashSet::new));
        System.out.println(collect4);

        strList.spliterator().forEachRemaining(System.out::println);

    }

    @Test
    public void testStream_parallel() {

        List<Long> longList = Stream.iterate(1l, item -> item + 1l).limit(10000000).collect(Collectors.toList());

        long startTime = System.currentTimeMillis();
        long sum = longList.stream().reduce(0l, (e1, e2) -> e1 + e2);
        long endTime = System.currentTimeMillis();
        System.out.println("endTime-startTime=" + (endTime - startTime));
        System.out.println(sum);

        startTime = System.currentTimeMillis();
        sum = longList.parallelStream().reduce(0l, (e1, e2) -> e1 + e2);
        endTime = System.currentTimeMillis();
        System.out.println("endTime-startTime=" + (endTime - startTime));
        System.out.println(sum);

    }

    @Test
    public void testMapStream() throws InterruptedException {

        Stream.<String>empty();

        Stream.generate(()->1).limit(10).forEach(System.out::println);

    }
}
