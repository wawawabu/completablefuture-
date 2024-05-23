package it.com.deads;

import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

class Test implements Runnable{
    public Test(String a, String b) {
        this.a = a;
        this.b = b;
    }

    private String a;
    private String b;

    @Override
    public void run() {
        synchronized (a){
            System.out.println("获取"+a+"开始尝试获取"+b);
            try {
                TimeUnit.SECONDS.sleep(2L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (b){
                System.out.println("获取"+b+"成功");
            }
        }
    }
}
public class DeadLocksDemo {
    public static void main(String[] args) {
    /*    String aa = new String("AA");
        String bb = new String("BB");
        new Thread(new Test(aa,bb),"AA").start();
        new Thread(new Test(bb,aa),"BB").start();*/

        WeakHashMap<Integer, String> integerStringWeakHashMap = new WeakHashMap<>();
        Integer key = Integer.valueOf("2");
        //Integer key = new Integer("2");
        integerStringWeakHashMap.put(key,"hashmap");
        System.out.println(integerStringWeakHashMap);

        System.out.println("------------");
        integerStringWeakHashMap.remove(key);
        System.out.println(integerStringWeakHashMap);
        System.out.println("------------");
        //key = null;
        System.out.println(integerStringWeakHashMap);

        System.gc();
        System.gc();
        System.gc();
        try {
            TimeUnit.SECONDS.sleep(1L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(integerStringWeakHashMap);
    }

}
