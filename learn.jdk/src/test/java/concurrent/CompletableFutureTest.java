package concurrent;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Stream;

/**
 * Created by jian01.zhu on 2016/2/2.
 */
public class CompletableFutureTest {


    @Test
    public void completableFuture_runAsync_test() throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                completableFuture.complete("success");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        String resp = completableFuture.get(500, TimeUnit.MILLISECONDS);
        System.out.println(resp);

    }

    @Test
    public void completableFuture_supplyAsync_test() throws ExecutionException, InterruptedException {
        final CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return Thread.currentThread().getName();
        });

        System.out.println(completableFuture.isDone());
        System.out.println(completableFuture.get());
        System.out.println(completableFuture.isDone());

    }

    @Test
    public void completableFuture_allOf_test() throws ExecutionException, InterruptedException {

        final CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return Thread.currentThread().getName();
        });

        final CompletableFuture<String> supplyAsync2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return Thread.currentThread().getName();
        });

        final CompletableFuture<Void> allOf = CompletableFuture.allOf(supplyAsync, supplyAsync2);
        System.out.println(allOf.isDone());
        System.out.println(allOf.get());
        System.out.println(allOf.isDone());
    }

    @Test
    public void completableFuture_anyOf_test() throws ExecutionException, InterruptedException {

        final CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return Thread.currentThread().getName() + "[supplyAsync]";
        });

        final CompletableFuture<String> supplyAsync2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return Thread.currentThread().getName() + "[supplyAsync2]";
        });

        final CompletableFuture<Object> anyOf = CompletableFuture.anyOf(supplyAsync, supplyAsync2);
        System.out.println(anyOf.isDone());
        System.out.println(anyOf.get());
        System.out.println(anyOf.isDone());

    }

    @Test
    public void completableFuture_anyOf2_test() throws ExecutionException, InterruptedException {


        final CompletableFuture<String> completableFutureA = CompletableFuture.completedFuture("A");
        final CompletableFuture<String> completableFutureB = CompletableFuture.completedFuture("B");

        final CompletableFuture<Object> anyOf = CompletableFuture.anyOf(completableFutureB, completableFutureA);
        System.out.println(anyOf.isDone());
        System.out.println(anyOf.get());
        System.out.println(anyOf.isDone());


    }

    @Test
    public void completableFuture_acceptEither_test() throws ExecutionException, InterruptedException {

        final CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return Thread.currentThread().getName() + "[supplyAsync]";
        });

        final CompletableFuture<String> supplyAsync2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return Thread.currentThread().getName() + "[supplyAsync2]";
        });

        //supplyAsync.

        final CompletableFuture<Void> completableFuture = supplyAsync.acceptEither(supplyAsync2, e -> System.out.println(e.toUpperCase()));
        System.out.println(completableFuture.isDone());
        System.out.println(completableFuture.join());

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void completableFuture_acceptEitherAsync_test() throws ExecutionException, InterruptedException {

        final CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return Thread.currentThread().getName() + "[supplyAsync]";
        });

        final CompletableFuture<String> supplyAsync2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return Thread.currentThread().getName() + "[supplyAsync2]";
        });

        //supplyAsync.

        final CompletableFuture<Void> completableFuture = supplyAsync.acceptEitherAsync(supplyAsync2, e -> System.out.println(e.toUpperCase()));
        System.out.println(completableFuture.isDone());
        System.out.println(completableFuture.join());

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void completableFuture_applyToEither_test() throws ExecutionException, InterruptedException {

        final CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return Thread.currentThread().getName() + "[supplyAsync]";
        });

        final CompletableFuture<String> supplyAsync2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return Thread.currentThread().getName() + "[supplyAsync2]";
        });


        final CompletableFuture<String> completableFuture = supplyAsync.applyToEither(supplyAsync2, e -> e.toUpperCase());
        System.out.println(completableFuture.isDone());
        System.out.println(completableFuture.join());

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    @Test
    public void completableFuture_completeExceptionally_test() throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                completableFuture.completeExceptionally(new RuntimeException("throw by myself"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        System.out.println(completableFuture.isDone());
        String resp = completableFuture.join();
        System.out.println("resp:"+resp);

    }

    @Test
    public void completableFuture_exceptionally_test() throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                completableFuture.completeExceptionally(new RuntimeException("RuntimeException"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(completableFuture.isDone());
        String resp = completableFuture.exceptionally(e-> {
            System.out.println(e.getMessage());
            return e.getMessage();
        }).get();
        System.out.println("resp:" + resp);


    }

    @Test
    public void completableFuture_getNow_test() throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                completableFuture.complete("normal");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(completableFuture.isDone());
        String resp = completableFuture.getNow("backup");
        System.out.println("resp:" + resp);

    }

    @Test
    public void completableFuture_getNumberOfDependents_test() throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(completableFuture.getNumberOfDependents());
                completableFuture.complete("normal");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        CompletableFuture.runAsync(() -> {
            try {
                System.out.println(completableFuture.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        System.out.println(completableFuture.isDone());
        String resp = completableFuture.get();
        System.out.println("resp:" + resp);

    }

    @Test
    public void completableFuture_handle_test() throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(completableFuture.getNumberOfDependents());
                completableFuture.complete("normal");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        System.out.println(completableFuture.isDone());
        final CompletableFuture<String> handle = completableFuture.handle((a, b) -> {
            System.out.println("a:" + a);
            System.out.println("b:" + b);
            return a+b.getMessage();
        });
        String resp = handle.get();
        System.out.println("resp:" + resp);

    }

    @Test
    public void completableFuture_join_test() throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName());
                completableFuture.complete("normal");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        System.out.println(completableFuture.isDone());

        String resp = completableFuture.join();
        System.out.println(Thread.currentThread().getName());
        System.out.println("resp:" + resp);

    }

    @Test
    public void completableFuture_obtrudeException_test() throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                completableFuture.complete("normal");
                completableFuture.obtrudeException(new RuntimeException("throw by myself"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(completableFuture.isDone());
        String resp = completableFuture.get();
        System.out.println("resp:" + resp);
        resp = completableFuture.get();
        System.out.println("resp2:" + resp);
        completableFuture.obtrudeException(new RuntimeException("throw by myself"));
        resp = completableFuture.get();
        System.out.println("resp3:"+resp);

    }

    @Test
    public void completableFuture_runAfterBoth_test() throws ExecutionException, InterruptedException, TimeoutException {

        final CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return Thread.currentThread().getName();
        });

        final CompletableFuture<String> supplyAsync2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return Thread.currentThread().getName();
        });

        final CompletableFuture<Void> runAfterBoth = supplyAsync2.runAfterBoth(supplyAsync, () -> {
            System.out.println("both done");
        });

        Long beginTime = System.currentTimeMillis();
        runAfterBoth.join();
        Long endTime = System.currentTimeMillis();
        System.out.println("endTime-beginTime:"+(endTime-beginTime));

    }

    @Test
    public void completableFuture_runAfterEither_test() throws ExecutionException, InterruptedException, TimeoutException {

        final CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return Thread.currentThread().getName();
        });

        final CompletableFuture<String> supplyAsync2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return Thread.currentThread().getName();
        });

        final CompletableFuture<Void> runAfterBoth = supplyAsync2.runAfterEither(supplyAsync, () -> {
            System.out.println("either done");
        });

        Long beginTime = System.currentTimeMillis();
        runAfterBoth.join();
        Long endTime = System.currentTimeMillis();
        System.out.println("endTime-beginTime:"+(endTime-beginTime));

    }

    @Test
    public void completableFuture_thenAccept_test() throws ExecutionException, InterruptedException, TimeoutException {

        final CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return Thread.currentThread().getName();
        });

        final CompletableFuture<Void> thenAccept = supplyAsync.thenAccept(e -> e.toUpperCase());

        Long beginTime = System.currentTimeMillis();
        thenAccept.join();
        Long endTime = System.currentTimeMillis();
        System.out.println("endTime-beginTime:" + (endTime - beginTime));

    }


    @Test
    public void completableFuture_thenAcceptBoth_test() throws ExecutionException, InterruptedException, TimeoutException {

        final CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return Thread.currentThread().getName();
        });

        final CompletableFuture<String> supplyAsync2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return Thread.currentThread().getName();
        });

        final CompletableFuture<Void> thenAcceptBoth = supplyAsync2.thenAcceptBoth(supplyAsync, (a, b) -> System.out.println(a.concat(b).toUpperCase()));

        Long beginTime = System.currentTimeMillis();
        thenAcceptBoth.join();
        Long endTime = System.currentTimeMillis();
        System.out.println("endTime-beginTime:" + (endTime - beginTime));

    }


    @Test
    public void completableFuture_thenApply_test() throws ExecutionException, InterruptedException, TimeoutException {

        final CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return Thread.currentThread().getName();
        });

        final CompletableFuture<String> thenApply = supplyAsync.thenApply(e -> e.toUpperCase());

        Long beginTime = System.currentTimeMillis();
        final String resp = thenApply.get();
        System.out.println(resp);
        Long endTime = System.currentTimeMillis();
        System.out.println("endTime-beginTime:" + (endTime - beginTime));

    }


    @Test
    public void completableFuture_thenCombine_test() throws ExecutionException, InterruptedException, TimeoutException {

        final CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return Thread.currentThread().getName();
        });

        final CompletableFuture<String> supplyAsync2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return Thread.currentThread().getName();
        });

        final CompletableFuture<String> thenCombine = supplyAsync2.thenCombine(supplyAsync, (a, b) -> a.concat("=====").concat(b).toUpperCase());

        Long beginTime = System.currentTimeMillis();
        final String resp = thenCombine.get();
        System.out.println(resp);
        Long endTime = System.currentTimeMillis();
        System.out.println("endTime-beginTime:" + (endTime - beginTime));

    }

    @Test
    public void completableFuture_thenCompose_test() throws ExecutionException, InterruptedException, TimeoutException {

        final CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return Thread.currentThread().getName();
        });

        final CompletableFuture<StringBuilder> thenCompose = supplyAsync.thenCompose(e -> CompletableFuture.completedFuture(new StringBuilder("new CompletableFuture").append("------").append(e)));

        Long beginTime = System.currentTimeMillis();
        final String resp = thenCompose.get().toString();
        System.out.println(resp);
        Long endTime = System.currentTimeMillis();
        System.out.println("endTime-beginTime:" + (endTime - beginTime));

    }

    @Test
    public void completableFuture_thenRun_test() throws ExecutionException, InterruptedException, TimeoutException {

        final CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return Thread.currentThread().getName();
        });

        final CompletableFuture<Void> thenRun = supplyAsync.thenRun(()-> {
            System.out.println("what");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Long beginTime = System.currentTimeMillis();
        thenRun.join();
        Long endTime = System.currentTimeMillis();
        System.out.println("endTime-beginTime:" + (endTime - beginTime));

    }


    @Test
    public void completableFuture_whenComplete_test() throws ExecutionException, InterruptedException, TimeoutException {

        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        CompletableFuture.runAsync(()->{
            completableFuture.completeExceptionally(new RuntimeException("runtime"));
        });

        final CompletableFuture<String> whenComplete = completableFuture.whenComplete((a, e) -> {
            System.out.println("a:"+a);
            System.out.println("e:"+e);
        });

        Long beginTime = System.currentTimeMillis();
        whenComplete.get();
        Long endTime = System.currentTimeMillis();
        System.out.println("endTime-beginTime:" + (endTime - beginTime));

    }
}
