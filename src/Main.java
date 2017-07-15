import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scn;
    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        openfile();
        readfile();
        writerfile();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String s = "";
            if (scanner.hasNext()) {
                s = scanner.next();
            }
            if (s.toUpperCase().contentEquals("EXIT")) {
                break;
            } else if (s.toUpperCase().contentEquals("ADD")) {
                students.add(new Student(scanner.next(), scanner.nextInt()));
            } else if (s.toUpperCase().contentEquals("REMOVE")) {
                System.out.println("ready to remove student");
                students.remove(find(scanner.nextInt()));
            } else if (s.toUpperCase().contentEquals("PRINT")) {
                for (Student student : students) {
                    System.out.println(student);
                }
            } else if (s.toUpperCase().contentEquals("EDIT")) {
                System.out.println("ready to edit student");
                find(scanner.nextInt()).setName(scanner.next());
            } else {
                System.out.println("UNKNOWN COMMAND!");
            }
        }
    }

    //Идентификация
    private static Student find(int id) {
        Student r_student = null;
        for (Student student : students) {
            if (id == student.getId()) {
                r_student = student;
                break;
            }
        }
        return r_student;
    }

    private static void openfile() {
        try {
            scn = new Scanner(new File("res//Save.txt"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "файл не найден");
        }
    }


    //чтение файла
    private static void readfile() {
        while (scn.hasNext()) {
            for (int row = 0; row < students.length; row++) {
                for (int col = 0; col < students[row].lenght; col++) {
                    students[row][col] = scn.hasNext();
                }
            }
        }
    }

    private static void writerfile() {
        try (FileWriter writer = new FileWriter("res//Save.txt", false)) {
            // запись всей строки
            //String text = "Мама мыла раму, раму мыла мама";
            writer.write(students);
            // запись по символам
            writer.append('\n');
            writer.append('E');

            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}