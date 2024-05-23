package it.com.classdemo;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Father {
    public static Demo demo = new Demo();

    static {
        System.out.println("father 静态代码块");
        Integer integer = Integer.valueOf(2);
        Integer integer1 = Integer.valueOf(2);
        System.out.println((integer1+integer)==4);
        new ReentrantLock();

    }


}
