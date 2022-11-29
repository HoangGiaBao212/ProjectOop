import java.util.Scanner;

public class AccountList implements RoleOfManager {
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void inputList() {
        // Input new list account
        int option;
        System.out.print(" ==> Enter amount: ");
        Handle.n = scanner.nextInt();
        for (int i = 0; i < Handle.n; i++) {
            Handle.listAccount[i] = new Account();
            MenuContent.menuOptionTypeEmployee();
            option = scanner.nextInt();
            do {
                switch (option) {
                    case 1:
                        Handle.listAccount[i].input();
                        Handle.listAccount[i].setEmployee(new Employee("Chief Of Department"));
                        break;
                    case 2:
                        Handle.listAccount[i].input();
                        Handle.listAccount[i].setEmployee(new Employee("Official Employee"));
                        break;
                    case 3:
                        Handle.listAccount[i].input();
                        Handle.listAccount[i].setEmployee(new Employee("Intern Employee"));
                        break;
                    default:
                        System.out.println("choice does not exist!");
                        System.out.println("Option from 1 to 3, please re-enter: ");
                }
            } while (option < 1 || option > 3);
        }
    }

    @Override
    public void outputList() {
        // Output new list account
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("|     %-15s|     %-15s|  %-10s|  %-20s|  %-20s|  %-10s|  %-10s|  %-30s|  %-20s|  %-20s|",
                "Username",
                "Password", "ID",
                "Position", "Name", "Age", "Gender", "Email", "Address", "Phone");
        System.out.println(
                "\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < Handle.n; i++) {
            Handle.listAccount[i].output();
        }

    }

    @Override
    public void add() {
        int amount;// add new account
        int option;
        System.out.println(" ==> Enter amount to add account: ");
        amount = scanner.nextInt();
        int temp = Handle.n;
        for (int i = temp; i < (temp + amount); i++) {
            Handle.listAccount[i] = new Account();
            MenuContent.menuOptionTypeEmployee();
            option = scanner.nextInt();
            do {
                switch (option) {
                    case 1:
                        Handle.listAccount[i].input();
                        Handle.listAccount[i].setEmployee(new Employee("Chief Of Department"));
                        break;
                    case 2:
                        Handle.listAccount[i].input();
                        Handle.listAccount[i].setEmployee(new Employee("Official Employee"));
                        break;
                    case 3:
                        Handle.listAccount[i].input();
                        Handle.listAccount[i].setEmployee(new Employee("Intern Employee"));
                        break;
                    default:
                        System.out.println("choice does not exist!");
                        System.out.println("Option from 1 to 3, please re-enter: ");
                }
            } while (option < 1 || option > 3);
        }
        Handle.n += amount;
    }

    @Override
    public void remove() {
        // remove account
        System.out.println("-------------------------------------------------");
        System.out.println("|              REMOVE ACcOUNT                   |");
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
        // edit username or password
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
        // find information of the account
        String idSearch;
        System.out.println(" ==> Enter id of employee to search: ");
        idSearch = scanner.nextLine();
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("|     %-15s|     %-15s|  %-10s|  %-20s|  %-20s|  %-10s|  %-10s|  %-30s|  %-20s|  %-20s|",
                "Username",
                "Password", "ID",
                "Position", "Name", "Age", "Gender", "Email", "Address", "Phone");
        System.out.println(
                "\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < Handle.n; i++) {
            if (idSearch.equalsIgnoreCase(Handle.listAccount[i].getEmployee().getIdEmp())) {
                Handle.listAccount[i].output();
            }
        }
    }

}
