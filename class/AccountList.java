import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class AccountList implements RoleOfManager {
    static Scanner scanner = new Scanner(System.in);

    private Employee[] listEmployees = new Employee[100];
    private int n;
    private String listEmployeeTxt = "./File/employee.txt";
    private String listAccountTxt = "./File/account.txt";

    public void updateDataEmployee() {
        n = -1;
        try {
            FileReader fr = new FileReader(listEmployeeTxt);
            try (BufferedReader br = new BufferedReader(fr)) {
                String line = "";
                while (true) {
                    n++;
                    line = br.readLine();
                    if (line == null) {
                        break;
                    }
                    String[] txt = line.split("-");
                    String idEmp = txt[0];
                    String position = txt[1];
                    String name = txt[2];
                    int age = Integer.parseInt(txt[3]);
                    String gender = txt[4];
                    String email = txt[5];
                    String address = txt[6];
                    String phone = txt[7];
                    Employee employee = new Employee(name, age, gender, email, address, phone,
                            idEmp, position);
                    listEmployees[n] = employee;
                }
            }
        } catch (Exception e) {
            System.out.println("Don't have data for employee!");
        }
    }

    @Override
    public void inputList() {
        // Input new list account
        int amount;
        System.out.println("Enter amount ");

    }

    @Override
    public void outputList() {
        // Output new list account

    }

    @Override
    public void add() {
        // add new account

    }

    @Override
    public void remove() {
        // remove account

    }

    @Override
    public void edit() {
        // edit username or password

    }

    @Override
    public void find() {
        // find information of the account

    }

    public void readFile() {

    }

    public void writeFile() {

    }

}
