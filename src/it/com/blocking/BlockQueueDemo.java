package it.com.blocking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class BlockQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> objects = new ArrayBlockingQueue<>(3);
        //objects.offer() //尾部添加，返回boolean
        //objects.put(); //尾部添加，会阻塞
        AtomicInteger atomicInteger = new AtomicInteger(0);
        atomicInteger.compareAndSet(0,2);
        atomicInteger.set(2);

        objects.add(1);
        objects.add(2);
        objects.add(3);

            //objects.put(4);//队列容积满时会阻塞插入元素的行为

        //System.out.println(objects.element());//java.util.NoSuchElementException
        //System.out.println(objects.peek());//null
        objects.remove();
        System.out.println(objects.poll());//null
            //System.out.println(objects.take());//没有元素时会阻塞取元素
        System.out.println("----------");
        System.out.println(objects.poll(3L, TimeUnit.SECONDS));
        System.out.println(objects.poll(3L, TimeUnit.SECONDS));
        System.out.println(objects.poll(3L, TimeUnit.SECONDS));
        System.out.println(objects.poll(3L, TimeUnit.SECONDS));
        System.out.println(objects);

        System.out.println("------------------");
        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(2);
        integers.add(3);
        integers.add(4);
        System.out.println(integers);
        System.out.println(integers.pop());

        System.out.println(integers.pop());
        System.out.println(integers.pop());
        //System.out.println(integers.pop());

    }
}
