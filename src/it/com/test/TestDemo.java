package it.com.test;
public class TestDemo {
    public String name = "test";


    public void h(){
        System.out.println("hhhhtest");
    }

    public TestDemo() {
        //System.out.println("testDemo");
    }

    public TestDemo(String name) {

        System.out.println("testBBBBDemo" + name);
    }

    public static void main(String[] args) {
        float floatValue = 0.6332f;
        double doubleValue = 0.6332;

        System.out.println("float类型：" + floatValue);
        System.out.println("double类型：" + doubleValue);
    }
}


class Father {
    public String name = "father";

    public Father() {
        this("hello");
        System.out.println("fatherDemo" + this.getClass());
    }

    public Father(String name) {

        System.out.println("fatherAAAAADemo" + name);
    }

    public String getName() {

        return name;
    }

}
