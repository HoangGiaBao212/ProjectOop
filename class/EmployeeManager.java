import java.lang.management.MemoryUsage;
import java.util.Scanner;

public class EmployeeManager implements RoleOfManager {

    static Scanner scanner = new Scanner(System.in);

    @Override
    public void inputList() {
        int option;
        System.out.println("\n     - - - - - - - - - - - - - - - - - - - - - - - - - - -");
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
                        Handle.listEmployees[i].setPosition("Chief of department");
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
        FileUtil.setData();
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
        for (int i = Handle.n; i < (Handle.n + amount); i++) {
            do {
                MenuContent.menuOptionTypeEmployee();
                option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        Handle.listEmployees[i] = new Employee();
                        Handle.listEmployees[i].setPosition("Chief of department");
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
                        System.out.println("------------------------------------------------");
                        System.out.println("|             Choice don't not exist!          |");
                        System.out.println("------------------------------------------------");
                        System.out.println("\t Option from 1 to 3, please re-enter:   ");

                }
            } while (option < 1 || option > 3);
        }
        MenuContent.noteAddSuccess();
        Handle.n += amount;
    }

    @Override
    public void remove() {
        System.out.println("-------------------------------------------------");
        System.out.println("|              REMOVE EMPLOYEE                  |");
        System.out.println("-------------------------------------------------");
        System.out.println("Enter id of employee to remove(Ex:E001): ");
        String idRemove = scanner.nextLine();
        boolean check = false;
        for (int i = 0; i < Handle.n; i++) {
            if (Handle.listEmployees[i].getIdEmp().equalsIgnoreCase(idRemove)) {
                for (int j = i; j < Handle.n - 1; j++) {
                    Handle.listEmployees[j] = Handle.listEmployees[j + 1];

                }
                Handle.listEmployees[Handle.n - 1] = null;
                Handle.n--;
                check = true;
                break;
            }
        }
        if (!check) {
            MenuContent.noteRemoveFailure();
        }
        MenuContent.noteRemoveSuccess();
    }

    @Override
    public void edit() {
        System.out.println("----------------------------------------------------");
        System.out.println("|           EDIT INFORMATION IN EMPLOYEE           |");
        System.out.println("----------------------------------------------------");
        String idTemp;
        int key, temp;
        System.out.print("Enter an employee ID to edit: ");
        idTemp = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < Handle.n; i++) {
            if (Handle.listEmployees[i].getIdEmp().equalsIgnoreCase(idTemp)) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Employee don't exist!");
        } else {
            MenuContent.optionEdit();
            temp = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < Handle.n; i++) {
                switch(temp) {
                    case 1:
                        if (idTemp.equals(Handle.listEmployees[i].getIdEmp())) {
                            System.out.println();
                            System.out.println("----------------------------------------------");
                            System.out.println("| 1.Change Position                          |");
                            System.out.println("| 2.Change Name                              |");
                            System.out.println("| 3.Change Age                               |");
                            System.out.println("| 4.Change Gender                            |");
                            System.out.println("| 5.Change Email                             |");
                            System.out.println("| 6.Change Address                           |");
                            System.out.println("| 7.Change Phone Number                      |");
                            System.out.println("| 8.Exit to menu                             |");
                            System.out.println("----------------------------------------------");
                            System.out.print("==> Input option:");
                            key = Integer.parseInt(scanner.nextLine());
                            System.out.println();
                            switch (key) {
                                case 1:
                                    MenuContent.menuOptionTypeEmployee();
                                    key = Integer.parseInt(scanner.nextLine());
                                    switch(key){
                                        case 1:
                                        Handle.listEmployees[i].setPosition("Chief Department");
                                            break;
                                        case 2:
                                        Handle.listEmployees[i].setPosition("Official Employee");
                                            break;
                                        case 3:
                                        Handle.listEmployees[i].setPosition("Intern Employee");
                                            break;
                                        default:
                                            MenuContent.choiceWrong();
                                            break;
                                    }
                                    break;
                                case 2:
                                    Handle.listEmployees[i].setName(null);
                                    break;
                                case 3:
                                    Handle.listEmployees[i].setAge(0);
                                    break;
                                case 4:
                                    Handle.listEmployees[i].setGender(null);
                                    break;
                                case 5:
                                    Handle.listEmployees[i].setEmail(null);
                                    break;
                                case 6:
                                    Handle.listEmployees[i].setAddress(null);
                                    break;
                                case 7:
                                    Handle.listEmployees[i].setPhone(null);
                                    break;
                                case 8:
                                    MenuContent.option("Employee");
                                    break;
                                default:
                                    MenuContent.choiceWrong();
                                    break;
                            }
                        }
                        break;
                    case 2:
                        if(Handle.listEmployees[i].getIdEmp().equalsIgnoreCase(idTemp))
                            Handle.listEmployees[i].input();
                        break;
                    default:
                        MenuContent.choiceWrong();
                        break;
                }
            }
            MenuContent.noteChangeSuccess();
            // MenuContent.noteChangeSuccess();
        }
    }

    @Override
    public void find() {
        String idFind;
        System.out.print("Enter id of employee to search(Ex:E001): ");
        idFind = scanner.nextLine();
        for (int i = 0; i < Handle.n; i++) {
            if (idFind.equals(Handle.listEmployees[i].getIdEmp())) {
                System.out.println(
                        "---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("|  %-10s|  %-20s|  %-20s|  %-10s|  %-10s|  %-30s|  %-20s|  %-20s|", "ID",
                        "Position", "Name", "Age", "Gender", "Email", "Address", "Phone");
                System.out.println(
                        "\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                Handle.listEmployees[i].output();
                System.out.println(
                        "---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            }
        }
    }
}
