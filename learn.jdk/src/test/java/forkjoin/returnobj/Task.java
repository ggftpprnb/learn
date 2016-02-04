package forkjoin.returnobj;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jian01.zhu on 2016/2/1.
 */
public class Task extends RecursiveTask<Long>{

    private List<Long> numbers;

    public Task(List<Long> numbers) {
        this.numbers = numbers;
    }

    @Override
    protected Long compute() {

        Long sum = 0l;

        if(numbers.size()>2){
            int middle = numbers.size()/2;
            Task task1 = new Task(numbers.subList(0,middle));
            Task task2 = new Task(numbers.subList(middle,numbers.size()));
            invokeAll(task1,task2);
            try {
                sum= task1.get()+task2.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }else{
            for(Long n:numbers){
                sum+=n;
            }
        }

        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final List<Long> list = Stream.iterate(BigInteger.ONE, e -> e.add(BigInteger.ONE)).limit(10000).map(BigInteger::longValue).collect(Collectors.toList());
        Task task = new Task(list);

        Long startTime = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        final Long invoke = forkJoinPool.invoke(task);
        System.out.println(invoke);

        System.out.println(task.join().equals(task.get()));

        Long endTime = System.currentTimeMillis();
        System.out.println("endTime-startTime:[" + (endTime - startTime) + "]");

        startTime = System.currentTimeMillis();
        final Optional<Long> reduce = list.stream().reduce((a, b) -> a + b);
        reduce.ifPresent(System.out::println);

        endTime = System.currentTimeMillis();
        System.out.println("endTime-startTime:[" + (endTime - startTime) + "]");

        forkJoinPool.shutdown();
    }
}
