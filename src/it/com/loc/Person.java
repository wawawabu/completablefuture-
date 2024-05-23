package it.com.loc;

public class Person implements Cloneable{
    public int i = 100;

    @Override
    public String toString() {
        return "Person{" +
                "i=" + i +
                '}';
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }
}
