package ex;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("test");
            ObjectInputStream in = new ObjectInputStream(fis);
            Object object = in.readObject();
            A a1 = (A) object;
            in.close();
            fis.close();
            System.out.println(a1.getX());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
