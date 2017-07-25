import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Main {
    private static Scanner scn;
    private static boolean running = true;
    private static ArrayList<Student> students = new ArrayList<>();

    //asdasd
    public static void main(String[] args) {
        loadData();
        scn = new Scanner(System.in);
        while (running){
            String c = scn.nextLine();
            switch (c.toUpperCase()){
                case "EXIT":
                    running = false;
                    break;
                case "ADD":
                    students.add(new Student(scn.next(), scn.nextInt()));
                    break;
                case "PRINT":
                    students.forEach(System.out::println);
                    break;
                default:
                    System.out.println("ERROR");
                    break;
            }
        }
        saveData();
    }

    private static void saveData() {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new File("res/Save.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String s = "";
        for (Student student: students){
            s += student.getName()+" "+student.getId()+"\n";
        }
        writer.print(s);
        writer.close();
    }

    private static void loadData() {
        try {
            scn = new Scanner(new File("res/Save.txt"));
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Файл не найден");
            e.printStackTrace();
        }
        while (scn.hasNext()) {
            students.add(new Student(scn.next(), scn.nextInt()));
        }
    }
}