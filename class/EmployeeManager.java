import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class EmployeeManager implements RoleOfManager {

    static Scanner scanner = new Scanner(System.in);

    @Override
    public void inputList() {
        int option;
        System.out.println("\n---------------------------------------------------------------");
        System.out.println("\n     Input List Employee");
        System.out.print("     *Input amount of employee: ");
        Handle.n = Integer.parseInt(scanner.nextLine());
        while (Handle.n <= 0) {
            System.out.println("Amount must be greater than 0");
            Handle.n = Integer.parseInt(scanner.nextLine());
        }
        Handle.listEmployees = new Employee[Handle.n];
        for (int i = 0; i < Handle.n; i++) {
            do {
                MenuContent.menuOptionTypeEmployee();
                option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        Handle.listEmployees[i] = new Employee();
                        Handle.listEmployees[i].setPosition("Chief Of Department");
                        Handle.listEmployees[i].input();
                        break;
                    case 2:
                        Handle.listEmployees[i] = new Employee();
                        Handle.listEmployees[i].setPosition("Official Employee");
                        Handle.listEmployees[i].input();
                        break;
                    case 3:
                        Handle.listEmployees[i] = new Employee();
                        Handle.listEmployees[i].setPosition("Intern Employee");
                        Handle.listEmployees[i].input();
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
        for (int i = 0; i < Handle.n; i++) {
            Handle.listEmployees[i].output();
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
                MenuContent.menuOptionTypeEmployee();
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
        System.out.println(Handle.n);
        for (int i = 0; i < Handle.n; i++) {
            if (Handle.listEmployees[i].getIdEmp().equalsIgnoreCase(idRemove)) {
                for (int j = i; j < Handle.n - 1; j++) {
                    Handle.listEmployees[j] = Handle.listEmployees[j + 1];
                }
                Handle.listEmployees[Handle.n - 1] = null;
                Handle.n--;
                MenuContent.noteRemoveSuccess();
                check = true;
                break;
            }
        }
        if (!check) {
            MenuContent.noteRemoveFailure();
        }
    }

    @Override
    public void edit() {
        String idEmpEdit;
        int option;
        Boolean check = false;
        System.out.print(" ==> Enter id employee to edit: ");
        idEmpEdit = scanner.nextLine();
        MenuContent.optionEdit();
        option = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < Handle.n; i++) {
            switch (option) {
                case 1 -> {
                    if (Handle.listEmployees[i].getIdEmp().equalsIgnoreCase(idEmpEdit)) {
                        int optionEdit;
                        System.out.println("1.Enter id employee");
                        System.out.println("2.Edit name");
                        System.out.println("3.Edit age");
                        System.out.println("4.Edit gender");
                        System.out.println("5.Edit email");
                        System.out.println("6.Edit address");
                        System.out.println("7.Edit phone");
                        System.out.println("8.Exit");
                        System.out.print(" ==> Input option: ");
                        optionEdit = Integer.parseInt(scanner.nextLine());
                        switch (optionEdit) {
                            case 1 -> {
                                Handle.listEmployees[i].setIdEmp(null);
                            }
                            case 2 -> {
                                Handle.listEmployees[i].setName(null);
                            }
                            case 3 -> {
                                Handle.listEmployees[i].setAge(0);
                            }
                            case 4 -> {
                                Handle.listEmployees[i].setGender(null);
                            }
                            case 5 -> {
                                Handle.listEmployees[i].setEmail(null);
                            }
                            case 6 -> {
                                Handle.listEmployees[i].setAddress(null);
                            }
                            case 7 -> {
                                Handle.listEmployees[i].setPhone(null);
                            }
                            case 8 -> {
                                break;
                            }
                            default -> {

                            }
                        }
                    }
                }
                case 2 -> {
                    if (Handle.listEmployees[i].getIdEmp().equalsIgnoreCase(idEmpEdit)) {
                        Handle.listEmployees[i].input();
                        check = true;
                    }
                }
                default -> {

                }
            }
        }
        if (!check)
            System.err.println("Don't have id for this employee!");
    }

    @Override
    public void find() {
        String idFind;
        System.out.print("Enter id of employee to search(Ex:E001): ");
        idFind = scanner.nextLine();
        for (int i = 0; i < Handle.n; i++) {
            if (idFind.equals(Handle.listEmployees[i].getIdEmp())) {
                System.out.println(
                        "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("|  %-10s  |  %-20s  |  %-20s  |  %-10s  |  %-10s  |  %-30s  |   %-20s  |  %-20s  |",
                        "ID",
                        "Position", "Name", "Age", "Gender", "Email", "Address", "Phone");

                System.out.println(
                        "\n--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                Handle.listEmployees[i].output();
                System.out.println(
                        "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            }
        }
    }
}
