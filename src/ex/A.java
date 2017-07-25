package ex;

import java.io.Serializable;

public class A implements Serializable{
    private int x;

    public A() {}

    public A(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
