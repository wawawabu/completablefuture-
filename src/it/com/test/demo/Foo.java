package it.com.test.demo;

public class Foo {
    public int i;
    public Foo(){
        System.out.println("father: "+this.getClass().getName());
        i=3;
        System.out.println("father: "+this.i);
    }
    public void add(){
        //this();
        this.i = 1000;
    }

    public static void main(String[] args) {
        Foo bar = new Bar();
        bar.add();
        System.out.println(bar.i);
        /*System.out.println(bar.getClass().getName());it.com.test.demo.Bar
                                                        it.com.test.demo.Foo
        System.out.println(Foo.class.getName());*/
    }
}
class Bar extends Foo{
    public int i;
    public Bar(){
        System.out.println("this: "+this.getClass().getName());
        i=5;
    }
    public void add(){
        this.i = 9000;
    }
}
