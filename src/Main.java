import by.zti.main.scanner.Command;
import by.zti.main.scanner.ConsoleScanner;
import by.zti.main.serializer.Serializer;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scn;
    private static boolean running = true;
    private static ArrayList<Student> students = new ArrayList<>();
    private static Serializer<ArrayList<Student>> serializer = new Serializer<ArrayList<Student>>(new File("test"));

    public static void main(String[] args) {
        loadData();
        ConsoleScanner scanner = new ConsoleScanner("/", "-", false);
        scanner.addCommand(new Command("exit", "").setConsumer(map -> {scanner.stop(); saveData();}));
        scanner.addCommand(new Command("add", "").setConsumer(map -> {
            if (!map.containsKey("n")||!map.containsKey("id")){return;}
            if (map.get("n").size()==0||map.get("id").size()==0){return;}
            try {map.get("id").forEach(s -> Integer.valueOf(s)); } catch (Exception e) {return;}
            students.add(new Student(map.get("n").get(0), Integer.valueOf(map.get("id").get(0))));
        }));
        scanner.addCommand(new Command("print", "").setConsumer(map -> students.forEach(System.out::println)));
        scanner.start();
    }

    private static void saveData() {
        serializer.serialize(students);
    }

    private static void loadData() {
        if (!serializer.getFile().exists()) {serializer.serialize(students);}
        students = serializer.deserialize();
    }
}