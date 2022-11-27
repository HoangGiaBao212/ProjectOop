import java.util.Scanner;
import java.util.regex.Pattern;

public class Account implements InOut {
    private String idEmp;
    private String username;
    private String password;

    static Scanner scanner = new Scanner(System.in);

    public Account() {

    }

    public Account(String idEmp, String username, String password) {
        this.idEmp = idEmp;
        this.username = username;
        this.password = password;
    }

    public String getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(String idEmp) {
        System.out.print("     - Enter id of employee: ");
        idEmp = scanner.nextLine();
        while (idEmp.isEmpty()) {
            System.out.print("\n    Id of employee must not be left blank! Enter again:  ");
            idEmp = scanner.nextLine();
            idEmp = idEmp.toUpperCase();
        }
        while (!idEmp.startsWith("E")) {
            System.out.print("\n     Employee code starting from E(Ex:E001). Enter again: ");
            idEmp = scanner.nextLine();
            idEmp = idEmp.toUpperCase();
        }
        this.idEmp = idEmp;
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
                System.err.println("Invalid username, input again: ");
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
                System.err.print("Invalid password, input again: ");
        }
        this.password = password;
    }

    @Override
    public void input() {
        setIdEmp(idEmp);
        setUsername(username);
        setPassword(password);
    }

    @Override
    public void output() {

    }

    @Override
    public String toString() {
        return idEmp + "-" + username + "-" + password;
    }

}
