package it.com.runs;

import org.w3c.dom.ls.LSOutput;

import java.util.concurrent.*;

public class CompletableFutureRuns {
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

        CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MICROSECONDS.sleep(20L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName());
            return 888;
        }, threadPoolExecutor).thenRun(() -> {

            try {
                TimeUnit.MICROSECONDS.sleep(202L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName());
        }).thenRun(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        System.out.println("主线程先去忙其他事情");
        threadPoolExecutor.shutdown();


    }
}
