import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class EmployeeManager implements RoleOfManager {

    static Scanner scanner = new Scanner(System.in);
    public Employee listEmployees[] = new Employee[100];
    private int n = -1;
    String listEmployeeTxt = "./File/employee.txt";

    @Override
    public void inputList() {
        int option;
        System.out.println("\n     - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("\n     Input List Employee");
        System.out.println("     *Input amount of employee: ");
        n = Integer.parseInt(scanner.nextLine());
        while (n <= 0) {
            System.out.println("Amount must be greater than 0");
            n = Integer.parseInt(scanner.nextLine());
        }
        listEmployees = new Employee[n];
        for (int i = 0; i < n; i++) {
            do {
                MenuContent.showMenuEmployee();
                option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        listEmployees[i] = new ChiefDepartment();
                        listEmployees[i].setPosition("Chief of department");
                        ((ChiefDepartment) listEmployees[i]).input();
                        break;
                    case 2:
                        listEmployees[i] = new OfficialEmployee();
                        listEmployees[i].setPosition("Official Employee");
                        ((OfficialEmployee) listEmployees[i]).input();
                        break;
                    case 3:
                        listEmployees[i] = new InternEmployee();
                        listEmployees[i].setPosition("Intern Employee");
                        ((InternEmployee) listEmployees[i]).input();
                        break;
                    default:
                        System.out.println("choice does not exist!");
                        System.out.println("Option from 1 to 3, please re-enter: ");
                }
            } while (option < 1 || option > 3);
        }
        try {
            FileWriter fw = new FileWriter(listEmployeeTxt);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Employee employee : listEmployees) {
                bw.write(employee.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }

    @Override
    public void outputList() {
        readFile();

        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("|  %-10s|  %-20s|  %-20s|  %-10s|  %-10s|  %-30s|  %-20s|  %-20s|", "ID",
                "Position", "Name", "Age", "Gender", "Email", "Address", "Phone");
        System.out.println(
                "\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Employee employee : listEmployees) {
            if (employee == null) {
                break;
            }
            employee.output();
            System.out.println(
                    "---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }

    @Override
    public void add() {
        Employee addListEmployee[];
        int amount, option;
        System.out.println("\n ---------------------------------------------------------");
        System.out.println("\n Add new employee");
        System.out.println(" *Input amount of employee to add: ");
        amount = Integer.parseInt(scanner.nextLine());
        while (amount <= 0) {
            System.out.println("Amount must be greater than 0");
            amount = Integer.parseInt(scanner.nextLine());
        }
        addListEmployee = new Employee[amount];
        for (int i = 0; i < amount; i++) {
            do {
                System.out.println("Select employee type: ");
                System.out.println("-----1.Chief Department");
                System.out.println("-----2.Official Employee");
                System.out.println("-----3.Intern Employee");
                System.out.print("Enter choice: ");
                option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        addListEmployee[i] = new Employee();
                        addListEmployee[i].setPosition("Chief of department");
                        addListEmployee[i].input();
                        break;
                    case 2:
                        addListEmployee[i] = new Employee();
                        addListEmployee[i].setPosition("Official Employee");
                        ((OfficialEmployee) addListEmployee[i]).input();
                        break;
                    case 3:
                        addListEmployee[i] = new Employee();
                        addListEmployee[i].setPosition("Intern Employee");
                        ((InternEmployee) addListEmployee[i]).input();
                        break;
                    default:
                        System.out.println("choice does not exist!");
                        System.out.println("Option from 1 to 3, please re-enter: ");
                }
            } while (option < 1 || option > 3);
        }
        try {
            FileWriter fw = new FileWriter(listEmployeeTxt, true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Employee o : addListEmployee) {
                bw.write(o.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {

        }

    }

    @Override
    public void remove() {
        readFile();
        System.out.println("Enter id of employee to remove(Ex:E001): ");
        String idRemove = scanner.nextLine();

        for (int i = 0; i < n; i++) {
            if (listEmployees[i].getIdEmp().equalsIgnoreCase(idRemove)) {
                for (int j = i; j < n - 1; j++) {
                    listEmployees[j] = listEmployees[j + 1];
                }
                listEmployees[n - 1] = null;
                n--;
                break;
            }
        }

        for (Employee employee : listEmployees) {
            if (employee == null)
                break;
            System.out.println(employee.toString());
        }

        System.out.println("Remove success");

        try {
            FileWriter fw = new FileWriter(listEmployeeTxt);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Employee employee : listEmployees) {
                if (employee == null)
                    break;
                bw.write(employee.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public void edit() {
        // TODO Auto-generated method stub

    }

    @Override
    public void find() {
        readFile();
        String idFind;
        System.out.print("Enter id of employee to search(Ex:E001): ");
        idFind = scanner.nextLine();

        for (Employee employee : listEmployees) {
            if (idFind.equals(employee.getIdEmp())) {
                System.out.println(
                        "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("|  %-10s  |  %-20s  |  %-20s  |  %-10s  |  %-10s  |  %-30s  |   %-20s  |  %-20s  |",
                        "ID",
                        "Position", "Name", "Age", "Gender", "Email", "Address", "Phone");

                System.out.println(
                        "\n--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                employee.output();
                System.out.println(
                        "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                break;
            }
        }

    }

    private void readFile() {
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
            // TODO: handle exception
        }
    }
}
