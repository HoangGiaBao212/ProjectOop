import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);

    public static void init() {
        FileUtil.getData();
    }

    public static void start() {
        Handle.clearScreen();
        Handle.login();
    }

    public static void end() {
        FileUtil.setData();
    }

    public static void main(String[] args) {
        init();
        start();
        end();
    }
}
