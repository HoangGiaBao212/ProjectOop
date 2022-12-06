import java.util.Arrays;
import java.util.Scanner;

public class AccountList implements RoleOfManager {
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void inputList() {
        // Input new list account
        int option;
        for (int i = 0; i < MenuHandle.m; i++) {
            Account account = new Account();
            System.out.println("Input info Chief");
            account.input();
            account.setEmployee(new ChiefDepartment(MenuHandle.listDepartments[i].getIdChief(), "Chief Of Department"));
            MenuHandle.listAccount = Arrays.copyOf(MenuHandle.listAccount, MenuHandle.n + 1);
            MenuHandle.listAccount[MenuHandle.n++] = account;
            for (int j = 0; j < MenuHandle.listDepartments[i].getMembers(); j++) {
                MenuContent.menuOptionTypeEmployee();
                option = scanner.nextInt();
                String idEmp = MenuHandle.listDepartments[i].getIdEmployee()[j];
                System.out.println(idEmp);
                do {
                    switch (option) {
                        case 1:
                            Account account1 = new Account();
                            account1.input();
                            account1.setEmployee(
                                    new OfficialEmployee(MenuHandle.listDepartments[i].getIdEmployee()[j],
                                            "Official Employee"));
                            MenuHandle.listAccount = Arrays.copyOf(MenuHandle.listAccount, MenuHandle.n + 1);
                            MenuHandle.listAccount[MenuHandle.n++] = account1;
                            break;
                        case 2:
                            Account account2 = new Account();
                            account2.input();
                            account2.setEmployee(
                                    new InternEmployee(MenuHandle.listDepartments[i].getIdEmployee()[j],
                                            "Intern Employee"));
                            MenuHandle.listAccount = Arrays.copyOf(MenuHandle.listAccount, MenuHandle.n + 1);
                            MenuHandle.listAccount[MenuHandle.n++] = account2;
                            break;
                        default:
                            System.out.println("Choice does not exist!");
                            System.out.println("Option from 1 to 2, please re-enter: ");
                            break;
                    }
                } while (option < 1 || option > 2);
            }
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
        for (int i = 0; i < MenuHandle.n; i++) {
            MenuHandle.listAccount[i].output();
        }

    }

    @Override
    public void add() {
        int option;
        String idDep;
        String idEmpAdd;
        System.out.print("(Ex:D001).");
        idDep = MenuHandle.inputId("D");
        System.out.print("Enter id employee to add > ");
        idEmpAdd = MenuHandle.inputId("E");
        while (MenuHandle.checkIdEmployee(idEmpAdd)) {
            System.out.print(" ==> Id is exist!!!, input again > ");
            idEmpAdd = MenuHandle.inputId("E");
        }
        for (int j = 0; j < MenuHandle.m; j++) {
            int temp = MenuHandle.listDepartments[j].getMembers();
            if (MenuHandle.listDepartments[j].getDepartmentId().equalsIgnoreCase(idDep)) {
                MenuContent.menuOptionTypeEmployee();
                option = MenuHandle.getInputNumber();
                if (temp > 10) {
                    System.out.println("==> Too much");
                    break;
                }
                do {
                    switch (option) {
                        case 1:
                            Account account1 = new Account();
                            account1.input();
                            account1.setEmployee(
                                    new OfficialEmployee(idEmpAdd, "Official Employee"));
                            MenuHandle.listAccount = Arrays.copyOf(MenuHandle.listAccount, MenuHandle.n + 1);
                            MenuHandle.listAccount[MenuHandle.n++] = account1;
                            MenuHandle.listDepartments[j].idEmployee = Arrays
                                    .copyOf(MenuHandle.listDepartments[j].getIdEmployee(), temp + 1);
                            MenuHandle.listDepartments[j].getIdEmployee()[temp] = idEmpAdd;
                            MenuHandle.listDepartments[j].setMembers(temp++);
                            // MenuHandle.listDepartments[j].getIdEmployee()[temp] = new String
                            // (account1.getEmployee().getIdEmp());
                            break;
                        case 2:
                            Account account2 = new Account();
                            account2.input();
                            account2.setEmployee(
                                    new InternEmployee(idEmpAdd, "Intern Employee"));
                            MenuHandle.listAccount = Arrays.copyOf(MenuHandle.listAccount, MenuHandle.n + 1);
                            MenuHandle.listAccount[MenuHandle.n++] = account2;
                            MenuHandle.listDepartments[j].idEmployee = Arrays
                                    .copyOf(MenuHandle.listDepartments[j].getIdEmployee(), temp + 1);
                            MenuHandle.listDepartments[j].getIdEmployee()[temp] = idEmpAdd;
                            // MenuHandle.listDepartments[j].getIdEmployee()[temp] = new String
                            // (account2.getEmployee().getIdEmp());
                            MenuHandle.listDepartments[j].setMembers(temp++);
                            break;
                        default:
                            System.out.println("choice does not exist!");
                            System.out.println("Option from 1 to ,2 please re-enter: ");
                            break;
                    }
                } while (option < 1 || option > 2);
            }
        }
    }

    @Override
    public void remove(String idRemove) {
        boolean flag = false;
        // remove account
        System.out.println("-------------------------------------------------");
        System.out.println("|              REMOVE ACCOUNT                   |");
        System.out.println("-------------------------------------------------");
        if (idRemove == null) {
            System.out.println("Enter id of employee to remove(Ex:E001): ");
            idRemove = MenuHandle.inputId("E");
        }
        for (int i = 0; i < MenuHandle.n; i++) {
            if (MenuHandle.listAccount[i].getEmployee().getIdEmp().equalsIgnoreCase(idRemove)) {
                for (int j = i; j < MenuHandle.n - 1; j++) {
                    MenuHandle.listAccount[j] = MenuHandle.listAccount[j + 1];
                }
                MenuHandle.listAccount = Arrays.copyOf(MenuHandle.listAccount, MenuHandle.n - 1);
                MenuHandle.n--;
                flag = true;
                break;
            }
        }
        if (!flag) {
            MenuContent.noteFailure("Remove");
        } else
            MenuContent.noteSuccess("Remove");
    }

    @Override
    public void edit(String idEdit) {
        // edit username or password
        boolean flag = false;
        int key, temp;
        if (idEdit == null) {
            System.out.println("----------------------------------------------------");
            System.out.println("|           EDIT INFORMATION IN EMPLOYEE           |");
            System.out.println("----------------------------------------------------");
            System.out.print("Enter an employee ID to edit: ");
            idEdit = scanner.nextLine();
        }
        int count = 0;
        for (int i = 0; i < MenuHandle.n; i++) {
            if (MenuHandle.listAccount[i].getEmployee().getIdEmp().equalsIgnoreCase(idEdit)) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Employee don't exist!");
        } else {
            MenuContent.optionEdit();
            temp = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < MenuHandle.n; i++) {
                switch (temp) {
                    case 1:
                        if (idEdit.equals(MenuHandle.listAccount[i].getEmployee().getIdEmp())) {
                            System.out.println();
                            System.out.println("----------------------------------------------");
                            System.out.println("| 1.Change Position                          |");
                            System.out.println("| 2.Change Name                              |");
                            System.out.println("| 3.Change Age                               |");
                            System.out.println("| 4.Change Gender                            |");
                            System.out.println("| 5.Change Email                             |");
                            System.out.println("| 6.Change Address                           |");
                            System.out.println("| 7.Change Phone Number                      |");
                            System.out.println("| 8.Change Username                          |");
                            System.out.println("| 9.Change password                          |");
                            System.out.println("| 10.Exit to menu                            |");
                            System.out.println("----------------------------------------------");
                            System.out.print("==> Input option:");
                            key = Integer.parseInt(scanner.nextLine());
                            System.out.println();
                            switch (key) {
                                case 1:
                                    MenuContent.menuOptionTypeEmployee();
                                    key = Integer.parseInt(scanner.nextLine());
                                    if (MenuHandle.listAccount[i].getEmployee().getPosition().equals("admin")) {
                                        System.out.println(
                                                "----------------Admin cannot be change position----------------");
                                        flag = true;
                                        break;
                                    }
                                    switch (key) {
                                        case 1:
                                            ((ChiefDepartment) MenuHandle.listAccount[i].getEmployee())
                                                    .setPosition("Chief Of Department");
                                            break;
                                        case 2:
                                            ((OfficialEmployee) MenuHandle.listAccount[i].getEmployee())
                                                    .setPosition("Official Employee");
                                            break;
                                        case 3:
                                            if (MenuHandle.listAccount[i].getEmployee().getPosition()
                                                    .equals("Chief Of Department")) {
                                                System.out.println("You can't change into this position");
                                                flag = true;
                                                break;
                                            } else {
                                                MenuHandle.listAccount[i].getEmployee().setPosition("Intern Employee");
                                                // Account account = new Account();
                                                // account = MenuHandle.listAccount[i];
                                                // account.setEmployee(new InternEmployee("CD001","Intern Employee"));
                                                // MenuHandle.listAccount[i] = account;
                                                break;
                                            }

                                        default:
                                            MenuContent.choiceWrong();
                                            break;
                                    }
                                    break;
                                case 2:
                                    MenuHandle.listAccount[i].getEmployee().setName(null);
                                    break;
                                case 3:
                                    MenuHandle.listAccount[i].getEmployee().setAge(0);
                                    break;
                                case 4:
                                    MenuHandle.listAccount[i].getEmployee().setGender(null);
                                    break;
                                case 5:
                                    MenuHandle.listAccount[i].getEmployee().setEmail(null);
                                    break;
                                case 6:
                                    MenuHandle.listAccount[i].getEmployee().setAddress(null);
                                    break;
                                case 7:
                                    MenuHandle.listAccount[i].getEmployee().setPhone(null);
                                    break;
                                case 8:
                                    MenuHandle.listAccount[i].setUsername(null);
                                    break;
                                case 9:
                                    MenuHandle.listAccount[i].setPassword(null);
                                    break;
                                case 10:
                                    MenuContent.option("Employee");
                                    break;
                                default:
                                    MenuContent.choiceWrong();
                                    break;
                            }
                        }
                        break;
                    case 2:
                        if (MenuHandle.listAccount[i].getEmployee().getIdEmp().equalsIgnoreCase(idEdit))
                            MenuHandle.listAccount[i].getEmployee().input();
                        break;
                    default:
                        MenuContent.choiceWrong();
                        break;
                }
            }
            if (!flag) {
                MenuContent.noteChangeSuccess();
            } else {
                MenuContent.noteChangeFailure();
            }

        }

    }

    @Override
    public void find(String idSearch) {
        // find information of the account
        if (idSearch == null) {
            System.out.println(" ==> Enter id of employee to search: ");
            idSearch = scanner.nextLine();
        }
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("|     %-15s|     %-15s|  %-10s|  %-20s|  %-20s|  %-10s|  %-10s|  %-30s|  %-20s|  %-20s|",
                "Username",
                "Password", "ID",
                "Position", "Name", "Age", "Gender", "Email", "Address", "Phone");
        System.out.println(
                "\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < MenuHandle.n; i++) {
            if (idSearch.equalsIgnoreCase(MenuHandle.listAccount[i].getEmployee().getIdEmp())) {
                MenuHandle.listAccount[i].output();
            }
        }
    }

    @Override
    public void statistics() {
        MenuContent.quantityCount();
        int count = 0, cnt = 0;
        for (int i = 0; i < MenuHandle.n; i++) {
            if (MenuHandle.listAccount[i].getEmployee().getContract().getStatus().equals("Out of Date")) {
                count++;
            } else {
                cnt++;
            }
        } // System.out.printf("Current we have %-5s employee working",MenuHandle.);
        System.out.printf("We have %s employee is working now!!!", cnt);
        System.out.printf("\nWe have %s employee is no longer working!!!", count);
    }
}
