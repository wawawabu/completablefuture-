package it.com.results;

import java.util.concurrent.*;

public class CompletableHandle {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                3,
                0L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        CompletableFuture.supplyAsync(()->88,threadPoolExecutor).handle((integer, throwable) -> {
/*                    try {
                        TimeUnit.SECONDS.sleep(5L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }*/
                    //System.out.println(1/0);
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(111);return integer+100;
                }).handle((integer, throwable) -> {
                    System.out.println(222);
                    System.out.println(Thread.currentThread().getName());
                    return integer+1000;});
                /*.whenComplete((integer, throwable) -> {
                    if (throwable==null){
                        System.out.println("success: "+integer);
                    }
                }).exceptionally(throwable -> {
                    System.out.println("throw Exception");
                    throwable.printStackTrace();
                    return null;
                });*/
        System.out.println("主线程忙别的事情");
        threadPoolExecutor.shutdown();
    }
}
