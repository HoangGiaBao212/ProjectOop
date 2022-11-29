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
        Handle.listAccount = new Account[Handle.n];
        for (int i = 0; i < Handle.n; i++) {
            do {
                MenuContent.menuOptionTypeEmployee();
                option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        Handle.listAccount[i] = new Account();
                        Employee employeeChief = new Employee();
                        employeeChief.setPosition("Chief Of Department");
                        employeeChief.input();
                        Handle.listAccount[i].setEmployee(employeeChief);
                        break;
                    case 2:
                        Handle.listAccount[i] = new Account();
                        Employee employeeOfficial = new Employee();
                        employeeOfficial.setPosition("Official Employee");
                        employeeOfficial.input();
                        Handle.listAccount[i].setEmployee(employeeOfficial);
                        break;
                    case 3:
                        // Handle.listAccount[i] = new Account();
                        Employee employeeIntern = new Employee();
                        employeeIntern.setPosition("Intern Employee");
                        employeeIntern.input();
                        Handle.listAccount[i].setEmployee(employeeIntern);
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
            Handle.listAccount[i].getEmployee().output();
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
        int temp = Handle.n;
        Handle.n += amount;
        while (amount <= 0) {
            System.out.print("Amount must be greater than 0");
            amount = Integer.parseInt(scanner.nextLine());
        }
        for (int i = temp; i < Handle.n; i++) {
            do {
                MenuContent.menuOptionTypeEmployee();
                option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        Handle.listAccount[i] = new Account();
                        Handle.listAccount[i].getEmployee().setPosition("Chief of department");
                        Handle.listAccount[i].getEmployee().input();
                        break;
                    case 2:
                        Handle.listAccount[i] = new Account();
                        Handle.listAccount[i].getEmployee().setPosition("Official Employee");
                        Handle.listAccount[i].getEmployee().input();
                        break;
                    case 3:
                        Handle.listAccount[i] = new Account();
                        Handle.listAccount[i].getEmployee().setPosition("Intern Employee");
                        Handle.listAccount[i].getEmployee().input();
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
            if (Handle.listAccount[i].getEmployee().getIdEmp().equalsIgnoreCase(idRemove)) {
                for (int j = i; j < Handle.n - 1; j++) {
                    Handle.listAccount[j] = Handle.listAccount[j + 1];

                }
                Handle.listAccount[Handle.n - 1] = null;
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
            if (Handle.listAccount[i].getEmployee().getIdEmp().equalsIgnoreCase(idTemp)) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Employee don't exist!");
        } else {
            MenuContent.optionEdit();
            temp = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < Handle.n; i++) {
                switch (temp) {
                    case 1:
                        if (idTemp.equals(Handle.listAccount[i].getEmployee().getIdEmp())) {
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
                                    switch (key) {
                                        case 1:
                                            Handle.listAccount[i].getEmployee().setPosition("Chief Department");
                                            break;
                                        case 2:
                                            Handle.listAccount[i].getEmployee().setPosition("Official Employee");
                                            break;
                                        case 3:
                                            Handle.listAccount[i].getEmployee().setPosition("Intern Employee");
                                            break;
                                        default:
                                            MenuContent.choiceWrong();
                                            break;
                                    }
                                    break;
                                case 2:
                                    Handle.listAccount[i].getEmployee().setName(null);
                                    break;
                                case 3:
                                    Handle.listAccount[i].getEmployee().setAge(0);
                                    break;
                                case 4:
                                    Handle.listAccount[i].getEmployee().setGender(null);
                                    break;
                                case 5:
                                    Handle.listAccount[i].getEmployee().setEmail(null);
                                    break;
                                case 6:
                                    Handle.listAccount[i].getEmployee().setAddress(null);
                                    break;
                                case 7:
                                    Handle.listAccount[i].getEmployee().setPhone(null);
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
                        if (Handle.listAccount[i].getEmployee().getIdEmp().equalsIgnoreCase(idTemp))
                            Handle.listAccount[i].getEmployee().input();
                        break;
                    default:
                        MenuContent.choiceWrong();
                        break;
                }
            }
            MenuContent.noteChangeSuccess();
        }
    }

    @Override
    public void find() {
        String idFind;
        System.out.print("Enter id of employee to search(Ex:E001): ");
        idFind = scanner.nextLine();
        for (int i = 0; i < Handle.n; i++) {
            if (idFind.equals(Handle.listAccount[i].getEmployee().getIdEmp())) {
                System.out.println(
                        "---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("|  %-10s|  %-20s|  %-20s|  %-10s|  %-10s|  %-30s|  %-20s|  %-20s|", "ID",
                        "Position", "Name", "Age", "Gender", "Email", "Address", "Phone");
                System.out.println(
                        "\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                Handle.listAccount[i].getEmployee().output();
                System.out.println(
                        "---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            }
        }
    }
}
