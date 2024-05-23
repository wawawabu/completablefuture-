package it.com.supplyasync;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class SupplyAsyncCompletable {
    private static List<NetMail> netMailList = Arrays.asList(
            new NetMail("jingd", 124.44),
            new NetMail("tbao", 134.44),
            new NetMail("pxixi", 138.88)
    );

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
        System.out.println("开始-------------------");
        long begin = System.currentTimeMillis();
        List<String> collect = netMailList.stream()
                .map(netMail ->
                        CompletableFuture.supplyAsync
                                (
                                        () -> String.format("in %s price is %.2f", netMail.getProductName(), netMail.getPrice())
                                )

                ).collect(Collectors.toList()).stream().map(CompletableFuture::join).collect(Collectors.toList());
        long end = System.currentTimeMillis();
        System.out.println("结束-------------------" + (end - begin));
        System.out.println(collect);

    }
}


class NetMail {
    private String productName;

    public NetMail(String productName, Double price) {
        this.productName = productName;
        this.price = price;
    }

    private Double price;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        try {
            TimeUnit.SECONDS.sleep(1L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
