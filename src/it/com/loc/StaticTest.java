package it.com.loc;

public class StaticTest {
    public static int num = 10;
    static {
        System.out.println("staticTest 静态代码块执行");
    }
}
