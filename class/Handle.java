import java.util.Scanner;

public class Handle {
    static Scanner scanner = new Scanner(System.in);

    static int n = -1;
    static int m = -1;
    static Employee listEmployees[] = new Employee[100];
    static Account listAccount[] = new Account[100];

    static EmployeeManager listEmployee = new EmployeeManager();
    static ContractManager listContract = new ContractManager();
    static ProjectManager listProject = new ProjectManager();
    static SalaryManager listSalary = new SalaryManager();
    static DepartmentManager listDepartment = new DepartmentManager();

    private Handle() {
    }

    public static boolean checkIdEmployee(String IdEmp) {
        for (Employee employee : Handle.listEmployees) {
            if (employee == null)
                break;
            if ((employee.getIdEmp().equals(IdEmp)) && employee.getSalary() == null)
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
        MenuContent.menu();
        do {
            System.out.print("==> Input option : ");
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1 -> {
                    option("Employee");
                    break;
                }
                case 2 -> {
                    option("Contract");
                    break;
                }
                case 3 -> {
                    option("Salary");
                    break;
                }
                case 4 -> {
                    option("Project");
                    break;
                }
                case 5 -> {
                    option("Department");
                    break;
                }
                case 6 -> {
                    MenuContent.noteBye();
                    break;
                }
                default -> {
                    MenuContent.choiceWrong();
                }
            }
        } while (option < 1 || option > 6);
        Handle.clearScreen();
    }

    public static void option(String title) {
        int option;
        MenuContent.option(title);
        do {
            System.out.print("     ==> Input option: ");
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1 -> {
                    if (title.equals("Employee"))
                        listEmployee.inputList();
                    else if (title.equals("Contract"))
                        listContract.inputList();
                    else if (title.equals("Salary"))
                        listSalary.inputList();
                    else if (title.equals("Project"))
                        listSalary.inputList();
                    else
                        listDepartment.inputList();
                    option(title);
                    break;
                }
                case 2 -> {
                    if (title.equals("Employee"))
                        listEmployee.outputList();
                    else if (title.equals("Contract"))
                        listContract.outputList();
                    else if (title.equals("Salary"))
                        listSalary.outputList();
                    else if (title.equals("Project"))
                        listSalary.outputList();
                    else
                        listDepartment.outputList();
                    option(title);
                    break;
                }
                case 3 -> {
                    if (title.equals("Employee"))
                        listEmployee.add();
                    else if (title.equals("Contract"))
                        listContract.add();
                    else if (title.equals("Salary"))
                        listSalary.add();
                    else if (title.equals("Project"))
                        listSalary.add();
                    else
                        listDepartment.add();
                    option(title);
                    break;
                }
                case 4 -> {
                    if (title.equals("Employee"))
                        listEmployee.edit();
                    else if (title.equals("Contract"))
                        listContract.edit();
                    else if (title.equals("Salary"))
                        listSalary.edit();
                    else if (title.equals("Project"))
                        listSalary.edit();
                    else
                        listDepartment.edit();
                    option(title);
                    break;
                }
                case 5 -> {
                    if (title.equals("Employee"))
                        listEmployee.remove();
                    else if (title.equals("Contract"))
                        listContract.remove();
                    else if (title.equals("Salary"))
                        listSalary.remove();
                    else if (title.equals("Project"))
                        listSalary.remove();
                    else
                        listDepartment.remove();
                    option(title);
                    break;
                }
                case 6 -> {
                    if (title.equals("Employee"))
                        listEmployee.find();
                    else if (title.equals("Contract"))
                        listContract.find();
                    else if (title.equals("Salary"))
                        listSalary.find();
                    else if (title.equals("Project"))
                        listSalary.find();
                    else
                        listDepartment.find();
                    option(title);
                    break;
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
        // System.out.println(m);
        for (int i = 0; i < m; i++) {
            // System.out.println(1);
            if (username.equals(listAccount[i].getUsername())) {
                if (password.equals(listAccount[i].getPassword())) {
                    if (listAccount[i].getIdEmp().equals("admin"))
                        iForManager();
                    System.out.println(listAccount[i].getIdEmp());
                    permission(listAccount[i]);
                } else
                    System.err.println("Wrong password!!!");
            }
        }
    }

    private static void permission(Account account) {
        for (int i = 0; i < n; i++) {
            if (account.getIdEmp().equals(listEmployees[i].getIdEmp())) {
                if (listEmployees[i].getPosition().equals("Chief Of Department")) {
                    iForChiefDepartment();
                } else if (listEmployees[i].getPosition().equals("Intern Employee")
                        || listEmployees[i].getPosition().equals("Official Employee")) {
                    iForEmployee();
                }
            }
        }
    }

    public static void iForEmployee() {
        int choice;
        MenuContent.menuIForEmployee();
        choice = scanner.nextInt();
        do {

            switch (choice) {
                case 1 -> {
                    listEmployee.outputList();
                }
                case 2 -> {

                }

                case 3 -> {

                }

                case 4 -> {
                    MenuContent.noteBye();
                    break;
                }
                default -> {
                    MenuContent.choiceWrong();
                }
            }
        } while (choice < 1 || choice > 4);
    }

    public static void iForChiefDepartment() {
        System.out.println("Hello i'm chief department");
    }

    public static void iForManager() {
        System.out.println("Hello I'm manager");
    }

}

// Đăng nhập với tư cách nhân viên xem thông tin cá nhân,xem ds nhân viên,xem ds
// dự án,xem ds phòng ban