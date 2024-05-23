package it.com.interrupts;

import java.util.concurrent.TimeUnit;

public class InterruptDemo {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("程序被中断");
                    break;
                }
                System.out.println("t1");
                try {
                    TimeUnit.MILLISECONDS.sleep(20L);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }

        }, "t1");

        t1.start();
        try {
            TimeUnit.MICROSECONDS.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("t2开始");
        Thread t2 = new Thread(() -> {
            System.out.println("中断T1线程");
            t1.interrupt();
        }, "t2");
        t2.start();
    }
}
