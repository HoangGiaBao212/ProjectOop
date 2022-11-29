import java.util.Scanner;
import java.util.regex.Pattern;

public class Account implements InOut {
    static Scanner scanner = new Scanner(System.in);

    private String username;
    private String password;
    private Employee employee;

    public Account() {

    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account(String username, String password, Employee employee) {
        this.username = username;
        this.password = password;
        this.employee = employee;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        while (true) {
            System.out.print("==> Enter username: ");
            username = scanner.nextLine();
            Pattern pattern = Pattern.compile("^[a-z]+[0-9]*{8,50}$");
            if (pattern.matcher(username).find())
                break;
            else
                System.err.println("<<<<< Invalid username, input again: ");
        }
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        while (true) {
            System.out.println("==> Password: ");
            password = scanner.nextLine();
            Pattern pCheck1 = Pattern.compile("^[a-zA-Z]+[0-9]+{8,25}$");
            Pattern pCheck2 = Pattern.compile("^'//d'+[a-zA-Z]+$");
            if (pCheck1.matcher(password).find() || pCheck2.matcher(password).find())
                break;
            else
                System.err.print("<<<<< Invalid password, input again: ");
        }
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        employee.input();
        this.employee = employee;
    }

    @Override
    public void input() {
        setUsername(username);
        setPassword(password);
    }

    @Override
    public void output() {
        System.out.printf("|     %-15s|     %-15s", username, password);
        employee.output();
        System.out.println(
                "\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    @Override
    public String toString() {
        return username + "-" + password + "-" + employee.toString();
    }

}
