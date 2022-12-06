import java.util.Scanner;
// import java.util.regex.Pattern;

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
        username = MenuHandle.getUsername();
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        password = MenuHandle.getPassword();
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
