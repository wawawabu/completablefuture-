package it.com.cas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class AtomicReferenceDemo {
    private AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void lock(){
        Thread thread = Thread.currentThread();
        while (!atomicReference.compareAndSet(null,thread)){
            try {
                TimeUnit.MICROSECONDS.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        System.out.println(thread.getName()+" entry lock");

    }
    public void unlock(){
        Thread thread = Thread.currentThread();
        if (atomicReference.compareAndSet(thread,null)){
            System.out.println(thread.getName()+" exit lock");
        }


    }



    public AtomicReference<Thread> getAtomicReference() {

        return atomicReference;
    }

    public void setAtomicReference(AtomicReference<Thread> atomicReference) {
        this.atomicReference = atomicReference;
    }

    public static void main(String[] args) {

/*        int[] ints = new int[10];
        ints[0] = 2;
        System.out.println(ints.length);*/
        ArrayList<Object> objects = new ArrayList<>();

        AtomicReferenceDemo atomicReferenceDemo = new AtomicReferenceDemo();
        new Thread(()->{
            atomicReferenceDemo.lock();
            try {
                TimeUnit.SECONDS.sleep(2L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                atomicReferenceDemo.unlock();
            }


        }
                ,"t1").start();

        new Thread(()->{
            atomicReferenceDemo.lock();
            atomicReferenceDemo.unlock();

        }
                ,"t2").start();



        //new LongAccumulator();

        //new ReentrantLock();
        int a=2;
        int b = 4;
        if(a==3){
            System.out.println(22222);
        } else if (b==4) {
            System.out.println(44444);
        }

    }
}
