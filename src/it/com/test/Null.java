package it.com.test;

import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class Null {
    public static void haha(){
        System.out.println("haha");
    }

    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
/*                try {
                    TimeUnit.SECONDS.sleep(3L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }*/
                try {
                    sleep(10000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("aaaaa");
            }
        };
        thread.start();

        System.out.println("bbbbb");


    }

    public static void Null() {

        String s1 = String.valueOf("hello");
        String s2 = new String("hello");

        System.out.println(s1==s2);


    }
}
