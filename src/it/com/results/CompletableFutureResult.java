package it.com.results;

import java.util.concurrent.*;

public class CompletableFutureResult {
    public static void main(String[] args) {
        //自定义线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                3,
                0L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        CompletableFuture.supplyAsync(()->888,threadPoolExecutor)
                .thenApplyAsync(integer -> {
                    //System.out.println(1/0);
                    System.out.println(Thread.currentThread().getName());
                    return integer+100;
                },threadPoolExecutor)
                .thenApplyAsync(integer -> {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(222);
                    return integer+1000;
                },threadPoolExecutor)
                .whenCompleteAsync((integer, throwable) -> {
                    if(throwable==null) {
                        System.out.println(Thread.currentThread().getName());
                        try {
                            TimeUnit.SECONDS.sleep(5L);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("success: " + integer);
                    }
                },threadPoolExecutor)
                .exceptionally(throwable -> {
                    throwable.printStackTrace();
                    return null;
                });
        System.out.println("主线程先去忙其他事情");
        threadPoolExecutor.shutdown();


    }
}
