import java.io.File;
import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);

    public static void init() {
        FileUtil.readFile();
    }

    public static void start() {
        MenuContent.menu();
    }

    public static void end() {
        FileUtil.writeFile();
    }

    public static void main(String[] args) {
        init();
        start();
        end();
        // Account account = new Account();
        // account.input();
    }
}
