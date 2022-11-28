import java.io.Console;
import java.util.Scanner;

public class Handle {
    static Scanner scanner = new Scanner(System.in);

    static int n = -1;
    static int m = -1;
    static Employee listEmployees[] = new Employee[100];
    static Account listAccount[] = new Account[100];
    static Contract listContracts[] = new Contract[100];
    static EmployeeManager listEmployee = new EmployeeManager();
    static ContractManager listContract = new ContractManager();
    static ProjectManager listProject = new ProjectManager();
    static SalaryManager listSalary = new SalaryManager();
    static DepartmentManager listDepartment = new DepartmentManager();

    private Handle() {
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void menu() {
        int option;
        clearScreen();
        System.out.println("--------------------------------------------------------------------");
        System.out.println("|                Hello, Welcome to Employee Manager                |");
        System.out.println("--------------------------------------------------------------------");

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Fail to sleep!");
        }
        clearScreen();
        System.out.println("     -------------------------");
        System.out.println("     | 1. Employee Manager   |");
        System.out.println("     -------------------------");
        System.out.println("     | 2. Contract Manager   |");
        System.out.println("     -------------------------");
        System.out.println("     | 3. Salary Manager     |");
        System.out.println("     -------------------------");
        System.out.println("     | 4. Project Manager    |");
        System.out.println("     -------------------------");
        System.out.println("     | 5. Department Manager |");
        System.out.println("     -------------------------");
        System.out.println("     | 6. Exit               |");
        System.out.println("     -------------------------");
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
                    option("Salary  ");
                    break;
                }
                case 4 -> {
                    option("Project ");
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
        // try {
        // Thread.sleep(1000);
        // } catch (Exception e) {
        // System.out.println("Fail to sleep!");
        // }
        // System.out.println(" --------------------------------------------");
        // System.out.println(" | 1. Input List Of Employee |");
        // System.out.println(" | 2. Output List Of Employee |");
        // System.out.println(" | 3. Add |");
        // System.out.println(" | 4. Edit |");
        // System.out.println(" | 5. Delete |");
        // System.out.println(" | 6. Search |");
        // System.out.println(" | 7. Back to previous menu |");
        // System.out.println(" | 8. Exit |");
        // System.out.println(" --------------------------------------------");
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

    // public static void login() {
    //     String username, password;
    //     System.out.println("------------------------------------------------------------");
    //     System.out.println("|                          LOGIN                           |");
    //     System.out.println("------------------------------------------------------------");
    //     System.out.print("  ==> Enter username: ");
    //     username = scanner.nextLine();
    //     System.out.print("  ==> Enter password: ");
    //     password = scanner.nextLine();
    //     System.out.println(m);
    //     for (int i = 0; i < m; i++) {
    //         System.out.println(1);
    //         if (username.equals(listAccount[i].getUsername())) {
    //             if (password.equals(listAccount[i].getPassword())) {
    //                 if (listAccount[i].getIdEmp().equals("admin"))
    //                     iForManager();
    //                 System.out.println(listAccount[i].getIdEmp());
    //                 permission(listAccount[i]);
    //             } else
    //                 System.err.println("Wrong password!!!");
    //         }
    //     }
    // }

    // private static void permission(Account account) {
    //     for (int i = 0; i < n; i++) {
    //         if (account.getIdEmp().equals(listEmployees[i].getIdEmp())) {
    //             if (listEmployees[i].getPosition().equals("Chief Of Department")) {
    //                 iForChiefDepartment();
    //             } else if (listEmployees[i].getPosition().equals("Intern Employee")
    //                     || listEmployees[i].getPosition().equals("Official Employee")) {
    //                 iForEmployee();
    //             }
    //         }
    //     }
    // }

    // public static void iForEmployee() {
    //     // System.out.println("Hello i'm employee");
    //     clearScreen();
    //     MenuContent.menuIForEmployee();
    // }

    // public static void iForChiefDepartment() {
    //     clearScreen();
    //     System.out.println("--------------------------------------------------------");
    //     System.out.println("|                  Welcome back,Boss                   |");
    //     System.out.println("--------------------------------------------------------");

    // }

    // public static void iForManager() {
    //     clearScreen();
    //     System.out.println("--------------------------------------------------------");
    //     System.out.println("|                 Welcome back,Manager                 |");
    //     System.out.println("--------------------------------------------------------");
    // }

}

// Đăng nhập với tư cách nhân viên xem thông tin cá nhân,xem ds nhân viên,xem ds
// dự án,xem ds phòng ban