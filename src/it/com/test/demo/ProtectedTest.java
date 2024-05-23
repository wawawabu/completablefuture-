package it.com.test.demo;
//import it.com.test.Father;


import it.com.test.TestDemo;

public class ProtectedTest {
    public final String sss;
    public ProtectedTest(){
        this.sss = "hello";
    }

    public static void main(String[] args) {
        Class<Integer> integerClass = int.class;
        String b = "aaa";
        String s = new String("aaa");
        String a1 = s.intern();
        System.out.println(a1 == s);
        System.out.println(b==a1);
        System.out.println("a1: "+a1);
        int i = new Integer("10");
        System.out.println(i);
        //Father father = new Father();
    }

    public void ProtectedTest(){

    }
    public static int dev(){
        int i =3;
        try {
            int a = 10/0;
        }catch (Exception e){
            i=4;
            return i;
        }finally {
            i = 5;
            return i;
        }
    }

    public static int getInstance(int i) {
        long result = 0;
        switch (i){
            case 2:
                result = result + i*2;
            case 3:
                result = result + i*3;
        }

        return (int) result;
    }
}
