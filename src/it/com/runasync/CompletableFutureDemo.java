package it.com.runasync;

import java.util.concurrent.*;

public class CompletableFutureDemo {
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

        //创建CompletableFuture
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {

            System.out.println(Thread.currentThread().getName() + " hello runAsync");
            try {
                TimeUnit.SECONDS.sleep(0L);
                //System.out.println("等待结束1111");
                //System.out.println("------------------");
                return "hello world!!!";
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, threadPoolExecutor).whenComplete(((s, throwable) -> {

            try {
                System.out.println(Thread.currentThread().getName()+"2222222222");
                System.out.println(s.substring(0, 3));
                TimeUnit.SECONDS.sleep(5L);
                System.out.println("等待结束2222");
                System.out.println("------------------");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        })).exceptionally(throwable -> {
            if (throwable != null) {
                throwable.printStackTrace();
            }
            return null;
        });

        /*CompletableFuture<Void> helloRunAsync2 = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("hello runAsync");
        }, threadPoolExecutor);*/
        try {
            //helloRunAsync.get();
            //System.out.println("关闭线程池");//会被get()方法阻塞2s时间
            System.out.println(future.join());
            threadPoolExecutor.shutdown();
            System.out.println("关闭线程池");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
