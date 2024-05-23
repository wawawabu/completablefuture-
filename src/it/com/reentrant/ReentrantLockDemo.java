package it.com.reentrant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


class PrintDemo{
    private boolean b = true;
    private boolean c = true;
    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition B = reentrantLock.newCondition();
    private Condition C = reentrantLock.newCondition();

    public void printA(){
        try {
            reentrantLock.lock();
            for (int i = 0; i < 5; i++) {
                System.out.println(i+":"+Thread.currentThread().getName());
            }
            b=false;
        } finally {
            B.signal();
            reentrantLock.unlock();
        }

    }

    public void printB(){
        try {
            reentrantLock.lock();
            while (b){
                try {
                    B.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(i+":"+Thread.currentThread().getName());
            }
            c=false;
        } finally {
            //B.signal();
            C.signal();
            reentrantLock.unlock();
        }

    }
    public void printC(){
        try {
            reentrantLock.lock();
            while (c){
                try {
                    C.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            for (int i = 0; i < 15; i++) {
                System.out.println(i+":"+Thread.currentThread().getName());
            }
        } finally {
            //B.signal();
            //C.signal();
            reentrantLock.unlock();
        }

    }
}
public class ReentrantLockDemo {
    public static void main(String[] args) {
/*        PrintDemo printDemo = new PrintDemo();
        new Thread(printDemo::printC,"CCC").start();
        new Thread(printDemo::printB,"BBB").start();
        new Thread(printDemo::printA,"AAA").start();*/

        //Executors.newFixedThreadPool(3);
        ExecutorService executorService = Executors.newCachedThreadPool();
        Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            int temp = i;
            executorService.execute(()->
            {
                System.out.println(Thread.currentThread().getName()+": "+temp);
                System.out.println();
            });
        }


    }

}
