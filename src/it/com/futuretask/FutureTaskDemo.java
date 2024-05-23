package it.com.futuretask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class FutureTaskDemo {

    public static void main(String[] args) {

        FutureTask<String> stringFutureTask = new FutureTask<>(new MyThead());

        Thread thread = new Thread(stringFutureTask);
        System.out.println("线程启动");
        thread.start();
        try {
            System.out.println("------------------");
            String s = stringFutureTask.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("线程结束");
    }


}

class MyThead implements Callable<String> {

    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(2L);
        return "Hello this is futureTask exercise";
    }
}
