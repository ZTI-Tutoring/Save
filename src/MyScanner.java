import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyScanner {
    public static List<Cmd> cmds = new ArrayList<>();

    public static void scan() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        for(Cmd cmd: cmds){
            if(s.contentEquals(cmd.getName())){execute(cmd);}
        }
    }

    private static void execute(Cmd cmd){
        cmd.getExec().execute();
    }
}
