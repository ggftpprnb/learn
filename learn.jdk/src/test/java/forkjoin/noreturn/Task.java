package forkjoin.noreturn;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * Created by jian01.zhu on 2016/2/1.
 */
public class Task extends RecursiveAction {

    private List<Product> products;

    private int increment;

    public Task(List<Product> products, int increment) {
        this.products = products;
        this.increment = increment;
    }

    @Override
    protected void compute() {
        if (products.size() < 10) {
            //更新价格
            updatePrice();
        } else {
            int middle = products.size() / 2;

            Task task1 = new Task(products.subList(0, middle), increment);
            Task task2 = new Task(products.subList(middle, products.size()), increment);
            invokeAll(task1, task2);
        }
    }

    private void updatePrice() {
        products.forEach(e -> e.setPrice(e.getPrice() + increment));
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Product> products = ProductGenerator.generatorList(10000);

        Long startTime = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Task task = new Task(products, 2);
        forkJoinPool.execute(task);
        task.get();

        Long endTime = System.currentTimeMillis();
        System.out.println("endTime-startTime:[" + (endTime - startTime) + "]");

        startTime = System.currentTimeMillis();
        products.forEach(e -> e.setPrice(1));
        endTime = System.currentTimeMillis();
        System.out.println("endTime-startTime:[" + (endTime - startTime) + "]");


        //final Optional<Product> first = products.stream().filter(e -> !e.getPrice().equals(12)).findFirst();
        //first.ifPresent(System.out::println);
    }
}
