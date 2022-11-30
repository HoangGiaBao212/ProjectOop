import java.util.Scanner;

public class Handle {
    static Scanner scanner = new Scanner(System.in);

    static int n = -1;
    static int m = -1;
    static Account[] listAccount = new Account[100];
    static Department[] listDepartments = new Department[100];

    static ContractManager listContract = new ContractManager();
    static SalaryManager listSalary = new SalaryManager();
    static DepartmentManager listDepartment = new DepartmentManager();
    static AccountList listAccounts = new AccountList();

    private Handle() {
    }

    public static int getInputNumber() {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(getInput());
                return choice;
            } catch (Exception e) {
                MenuContent.choiceWrong();
            }
        }
    }

    private static String getInput() {
        return scanner.nextLine();
    }

    public static boolean checkIdEmployee(String IdEmp) {
        for (int i = 0; i < Handle.n; i++) {
            if ((Handle.listAccount[i].getEmployee().getIdEmp().equals(IdEmp))
                    && Handle.listAccount[i].getEmployee().getSalary() == null)
                return true;
        }
        return false;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void menu() {
        int option;
        // try {
        // Thread.sleep(1000);
        // } catch (Exception e) {
        // System.out.println("Fail to sleep!");
        // }
        MenuContent.menu();
        do {
            System.out.print("==> Input option : ");
            option = getInputNumber();
            switch (option) {
                case 1 -> option("Account Employee");
                case 2 -> option("Contract");
                case 3 -> option("Salary");
                case 4 -> option("Department");
                case 5 -> {
                    MenuContent.noteBye();
                    break;
                }
                default -> {
                    MenuContent.choiceWrong();
                    break;
                }
            }
        } while (option < 1 || option > 5);
    }

    public static void option(String title) {
        int option;
        MenuContent.option(title);
        do {
            System.out.print("     ==> Input option: ");
            option = getInputNumber();
            switch (option) {
                case 1 -> {
                    if (title.equals("Account Employee"))
                        listAccounts.inputList();
                    else if (title.equals("Contract"))
                        listContract.inputList();
                    else if (title.equals("Salary"))
                        listSalary.inputList();
                    else
                        listDepartment.inputList();
                    option(title);
                }
                case 2 -> {
                    if (title.equals("Account Employee"))
                        listAccounts.outputList();
                    else if (title.equals("Contract"))
                        listContract.outputList();
                    else if (title.equals("Salary"))
                        listSalary.outputList();
                    else
                        listDepartment.outputList();
                    option(title);
                }
                case 3 -> {
                    if (title.equals("Account Employee"))
                        listAccounts.add();
                    else if (title.equals("Contract"))
                        listContract.add();
                    else if (title.equals("Salary"))
                        listSalary.add();
                    else
                        listDepartment.add();
                    option(title);
                }
                case 4 -> {
                    if (title.equals("Account Employee"))
                        listAccounts.edit(null);
                    else if (title.equals("Contract"))
                        listContract.edit(null);
                    else if (title.equals("Salary"))
                        listSalary.edit(null);
                    else
                        listDepartment.edit(null);
                    option(title);
                }
                case 5 -> {
                    if (title.equals("Account Employee"))
                        listAccounts.remove(null);
                    else if (title.equals("Contract"))
                        listContract.remove(null);
                    else if (title.equals("Salary"))
                        listSalary.remove(null);
                    else
                        listDepartment.remove(null);
                    option(title);
                }
                case 6 -> {
                    if (title.equals("Account Employee"))
                        listAccounts.find(null);
                    else if (title.equals("Contract"))
                        listContract.find(null);
                    else if (title.equals("Salary"))
                        listSalary.find(null);
                    else
                        listDepartment.find(null);
                    option(title);
                }
                case 7 -> {
                    // Thống kê
                }
                case 8 -> {
                    menu();
                    break;
                }
                case 9 -> {
                    MenuContent.noteBye();
                    break;
                }
                default -> {
                    MenuContent.choiceWrong();
                    break;
                }
            }
        } while (option < 1 || option > 9);
    }

    // Login
    public static void login() {
        String username;
        String password;
        System.out.println("--------------------------------------------------------------------");
        System.out.println("|                                Login                             |");
        System.out.println("--------------------------------------------------------------------");
        System.out.print("  ==> Enter username: ");
        username = scanner.nextLine();
        System.out.print("  ==> Enter password: ");
        password = scanner.nextLine();
        for (int i = 0; i < n; i++) {
            if (username.equals(listAccount[i].getUsername()) && password.equals(listAccount[i].getPassword())) {
                if (listAccount[i].getEmployee().getPosition().equals("admin")) {
                    iForManager();
                    break;
                } else {
                    permission(listAccount[i]);
                    break;
                }
            } else {
                MenuContent.choiceWrong();
                login();
                break;
            }
            // System.out.print(" ==> Enter username: ");
            // username = scanner.nextLine();
            // System.out.print(" ==> Enter password: ");
            // password = scanner.nextLine();
        }

    }

    private static void permission(Account account) {
        for (int i = 0; i < n; i++) {
            if (account.getEmployee().getIdEmp().equals(listAccount[i].getEmployee().getIdEmp())) {
                if (listAccount[i].getEmployee().getPosition().equals("Chief Of Department")) {
                    iForChiefDepartment(listAccount[i].getEmployee().getIdEmp());
                } else if (listAccount[i].getEmployee().getPosition().equals("Intern Employee")
                        || listAccount[i].getEmployee().getPosition().equals("Official Employee")) {
                    iForEmployee(listAccount[i].getEmployee().getIdEmp());
                }
            }
        }
    }

    public static void iForEmployee(String idEmp) {
        int choice;
        MenuContent.menuIForEmployee();
        do {
            choice = getInputNumber();
            switch (choice) {
                case 1 -> {
                    listAccounts.find(idEmp);
                    listSalary.find(idEmp);
                    listContract.find(idEmp);
                    iForEmployee(idEmp);
                }
                case 2 -> {
                    listAccounts.edit(idEmp);
                    iForEmployee(idEmp);
                }
                case 3 -> MenuContent.noteBye();
                default -> {
                    MenuContent.choiceWrong();
                    break;
                }
            }
        } while (choice < 1 || choice > 3);
    }

    public static void iForChiefDepartment(String idEmp) {
        int choice;
        MenuContent.menuIForChief();
        do {
            choice = getInputNumber();
            switch (choice) {
                case 1 -> {
                    listAccounts.find(idEmp);
                    listSalary.find(idEmp);
                    listContract.find(idEmp);
                    iForChiefDepartment(idEmp);
                }
                case 2 -> {
                    listAccounts.edit(idEmp);
                    iForChiefDepartment(idEmp);
                }
                case 3 -> {
                    for (int i = 0; i < Handle.m; i++) {
                        for (int j = 0; j < Handle.listDepartments[i].getMembers(); j++) {
                            if (Handle.listDepartments[i].getIdEmployee()[j].equalsIgnoreCase(idEmp)) {
                                listDepartment.edit(Handle.listDepartments[i].getDepartmentId());
                            }
                        }
                    }
                    iForChiefDepartment(idEmp);
                }
                case 4 -> {
                    MenuContent.noteBye();
                    break;
                }
                default -> {
                    MenuContent.choiceWrong();
                    break;
                }
            }
        } while (choice < 1 || choice > 4);
    }

    public static void iForManager() {
        clearScreen();
        System.out.println("--------------------------------------------------------");
        System.out.println("|                 Welcome back,Manager                 |");
        System.out.println("--------------------------------------------------------");
        menu();
    }

    public static void noteNoHaveId(String id) {
        System.out.printf("%s-20s %-10s", " <<<<< Don't have id for ", id);
    }
}

// Đăng nhập với tư cách nhân viên xem thông tin cá nhân,xem ds nhân viên,xem ds
// dự án,xem ds phòng ban