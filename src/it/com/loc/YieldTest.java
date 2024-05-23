package it.com.loc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class YieldTest {
    public static void main(String[] args) {
        String hello = new String("hell") + new String("o");
        //String intern = hello.intern();
        String a = "hello";
        //System.out.println(intern == a);
        System.out.println(hello == a);
/*        Person person = new Person();
        person.i = 110;
        Person clone = null;
        try {
            clone = person.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("异常exception");
            throw new RuntimeException(e);
        }finally {
            System.out.println("----------");
            person.i = 100;
            System.out.println(person);
            System.out.println("________________");
            System.out.println(clone);
            System.out.println(person==clone);
        }*/


        /*String path = YieldTest.class.getClassLoader().getResource("Main.class").getPath();
        System.out.println(path);*/
/*        String hello = new String("hello");

        new Thread(()->{
            synchronized (hello){
                System.out.println("t1获取锁");

                try {
                    Thread.yield();
                    System.out.println("yield执行");
                    TimeUnit.SECONDS.sleep(2L);
                    System.out.println("又获取到锁");

                    //yield();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        new Thread(()->{
            synchronized (hello){
                System.out.println("t2获取锁");
            }
        }).start();


        try {
            TimeUnit.SECONDS.sleep(5L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
    }

    public static void tests(Object... arr) {
        Object o = arr[3];
        System.out.println(o);
        System.out.println("hello world !!! fighting.");
    }
}
