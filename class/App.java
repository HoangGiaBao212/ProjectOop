
import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);

    public static void init() {
        FileUtil.getData();
    }

    public static void start() {
        MenuHandle.clearScreen();
        MenuHandle.login();
    }

    public static void end() {
        FileUtil.setData();
    }

    public static void main(String[] args) {
        init();
        // start();
        SalaryManager salaryManager = new SalaryManager();
        salaryManager.inputList();

        end();
    }
}
