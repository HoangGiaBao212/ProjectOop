import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class EmployeeManager implements RoleOfManager {

    static Scanner scanner = new Scanner(System.in);

    @Override
    public void inputList() {
        int option;
        System.out.println("\n     - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("\n     Input List Employee");
        System.out.print("     *Input amount of employee: ");
        FileUtil.n = Integer.parseInt(scanner.nextLine());
        while (FileUtil.n <= 0) {
            System.out.println("Amount must be greater than 0");
            FileUtil.n = Integer.parseInt(scanner.nextLine());
        }
        FileUtil.listEmployees = new Employee[FileUtil.n];
        for (int i = 0; i < FileUtil.n; i++) {
            do {
                MenuContent.showMenuEmployee();
                option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        FileUtil.listEmployees[i] = new Employee();
                        FileUtil.listEmployees[i].setPosition("Chief of department");
                        FileUtil.listEmployees[i].input();
                        break;
                    case 2:
                        FileUtil.listEmployees[i] = new Employee();
                        FileUtil.listEmployees[i].setPosition("Official Employee");
                        FileUtil.listEmployees[i].input();
                        break;
                    case 3:
                        FileUtil.listEmployees[i] = new Employee();
                        FileUtil.listEmployees[i].setPosition("Intern Employee");
                        FileUtil.listEmployees[i].input();
                        break;
                    default:
                        System.out.println("choice does not exist!");
                        System.out.println("Option from 1 to 3, please re-enter: ");
                }
            } while (option < 1 || option > 3);
        }
        System.out.println("----------------------------------------");
        System.out.println("|     Add Employee's List Successful   |");
        System.out.println("----------------------------------------");
    }

    @Override
    public void outputList() {

        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("|  %-10s|  %-20s|  %-20s|  %-10s|  %-10s|  %-30s|  %-20s|  %-20s|", "ID",
                "Position", "Name", "Age", "Gender", "Email", "Address", "Phone");
        System.out.println(
                "\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Employee employee : FileUtil.listEmployees) {
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
        System.out.println("---------------------------------------");
        System.out.println("|           ADD NEW EMPLOYEE          |");
        System.out.println("---------------------------------------");
        System.out.print("\n *Input amount of employee to add: ");
        amount = Integer.parseInt(scanner.nextLine());
        while (amount <= 0) {
            System.out.print("Amount must be greater than 0");
            amount = Integer.parseInt(scanner.nextLine());
        }
        addListEmployee = new Employee[amount];
        for (int i = 0; i < amount; i++) {
            do {
                System.out.println("Select employee type: ");
                System.out.println("-------------------------------");
                System.out.println("| ->1.Chief Department        |");
                System.out.println("| -->2.Official Employee      |");
                System.out.println("| --->3.Intern Employee       |");
                System.out.println("-------------------------------");

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
                        addListEmployee[i].input();
                        break;
                    case 3:
                        addListEmployee[i] = new Employee();
                        addListEmployee[i].setPosition("Intern Employee");
                        addListEmployee[i].input();
                        break;
                    default:
                        System.out.println("choice does not exist!");
                        System.out.println("Option from 1 to 3, please re-enter: ");
                }
            } while (option < 1 || option > 3);
        }
        try {
            FileWriter fw = new FileWriter(FileUtil.listEmployeeTxt, true);
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
        System.out.println("-------------------------------------------------");
        System.out.println("|              REMOVE EMPLOYEE                  |");
        System.out.println("-------------------------------------------------");
        System.out.println("Enter id of employee to remove(Ex:E001): ");
        String idRemove = scanner.nextLine();
        boolean check = false;
        System.out.println(FileUtil.n);
        for (int i = 0; i < FileUtil.n; i++) {
            if (FileUtil.listEmployees[i].getIdEmp().equalsIgnoreCase(idRemove)) {
                for (int j = i; j < FileUtil.n - 1; j++) {
                    FileUtil.listEmployees[j] = FileUtil.listEmployees[j + 1];
                }
                FileUtil.listEmployees[FileUtil.n - 1] = null;
                FileUtil.n--;
                System.out.println("-------------------------------------------------");
                System.out.println("|               Remove successful!              |");
                System.out.println("-------------------------------------------------");
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("-------------------------------------------------");
            System.out.println("|               Remove successful!              |");
            System.out.println("-------------------------------------------------");
        }
    }

    @Override
    public void edit() {
        // TODO Auto-generated method stub

    }

    @Override
    public void find() {
        // readFile();
        String idFind;
        System.out.print("Enter id of employee to search(Ex:E001): ");
        idFind = scanner.nextLine();

        for (Employee employee : FileUtil.listEmployees) {
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

    // private void readFile() {
    // n = -1;
    // try {
    // FileReader fr = new FileReader(listEmployeeTxt);
    // try (BufferedReader br = new BufferedReader(fr)) {
    // String line = "";
    // while (true) {
    // n++;
    // line = br.readLine();
    // if (line == null) {
    // break;
    // }
    // String[] txt = line.split("-");
    // String idEmp = txt[0];
    // String position = txt[1];
    // String name = txt[2];
    // int age = Integer.parseInt(txt[3]);
    // String gender = txt[4];
    // String email = txt[5];
    // String address = txt[6];
    // String phone = txt[7];
    // Employee employee = new Employee(name, age, gender, email, address, phone,
    // idEmp, position);
    // FileUtil.listEmployees[n] = employee;
    // }
    // }
    // } catch (Exception e) {
    // // TODO: handle exception
    // }
    // }
}
