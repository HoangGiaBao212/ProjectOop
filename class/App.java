import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);

    public static void init() {
        SalaryManager.updateDataEmployee();
        SalaryManager.readFile();
    }

    public static void start() {
        MenuContent.menu();
    }

    public static void end() {
        SalaryManager.writeFile();
    }

    public static void main(String[] args) {
        init();
        start();
        end();
    }
}
