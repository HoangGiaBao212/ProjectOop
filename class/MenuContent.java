import java.util.Scanner;

public class MenuContent {
    static Scanner scanner = new Scanner(System.in);

    static EmployeeManager listEmployee = new EmployeeManager();
    static ContractManager listContract = new ContractManager();
    static ProjectManager listProject = new ProjectManager();
    static SalaryManager listSalary = new SalaryManager();
    static DepartmentManager listDepartment = new DepartmentManager();

    public MenuContent() {
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void menu() {
        int option;
        // clearScreen();
        System.out.println("--------------------------------------------------------------------");
        System.out.println("|                  Hello, Welcome to Employee Manager              |");
        System.out.println("--------------------------------------------------------------------");

        try {
            Thread.sleep(2000);
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
        do {
            System.out.print("==> Input option : ");
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1 -> {
                    optionEmployee();
                    break;
                }
                case 2 -> {
                    optionContract();
                    break;
                }
                case 3 -> {
                    optionSalary();
                    break;
                }
                case 4 -> {
                    optionProject();
                    break;
                }
                case 5 -> {
                    optionDepartment();
                    break;
                }
                case 6 -> {
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("|                           Good Bye!                          |");
                    System.out.println("----------------------------------------------------------------");
                    break;
                }
                default -> {
                    System.out.println("--------------------------------------------------------------------");
                    System.out.println("|                      <Choice does not exist!>                    |");
                    System.out.println("--------------------------------------------------------------------");
                }
            }
        } while (option < 1 || option > 6);
        MenuContent.clearScreen();
    }

    public static void showMenuEmployee() {
        System.out.println("Select employee type: ");
        System.out.println("----------------------------------------------");
        System.out.println("|  1.Chief Department                        |");
        System.out.println("|  2.Official Employee                       |");
        System.out.println("|  3.Intern Employee                         |");
        System.out.println("----------------------------------------------");
        System.out.print("==> Enter choice: ");
    }

    public static void optionEmployee() {
        int option;
        System.out.println("\n     --------------------------------------------");
        System.out.println("     |              EMPLOYEE MANAGER            |");
        System.out.println("     --------------------------------------------");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Fail to sleep!");
        }
        System.out.println("     --------------------------------------------");
        System.out.println("     |  1. Input List Of Employee               |");
        System.out.println("     |  2. Output List Of Employee              |");
        System.out.println("     |  3. Add                                  |");
        System.out.println("     |  4. Edit                                 |");
        System.out.println("     |  5. Delete                               |");
        System.out.println("     |  6. Search                               |");
        System.out.println("     |  7. Back to previous menu                |");
        System.out.println("     |  8. Exit                                 |");
        System.out.println("     --------------------------------------------");
        do {
            System.out.print("     ==> Input option: ");
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1 -> {
                    listEmployee.inputList();
                    optionEmployee();
                    break;
                }
                case 2 -> {
                    listEmployee.outputList();
                    optionEmployee();
                    break;
                }
                case 3 -> {
                    listEmployee.add();
                    optionEmployee();
                    break;
                }
                case 4 -> {
                    listEmployee.edit();
                    optionEmployee();
                    break;
                }
                case 5 -> {
                    listEmployee.remove();
                    optionEmployee();
                    break;
                }
                case 6 -> {
                    listEmployee.find();
                    optionEmployee();
                    break;
                }
                case 7 -> {
                    menu();
                    break;
                }
                case 8 -> {
                    System.out.println("----------------------------------------------------------------");
                    System.out
                            .println("|                           Good Bye!                          |");
                    System.out
                            .println("----------------------------------------------------------------");
                    break;
                }
                default -> {
                    System.out.println(
                            "--------------------------------------------------------------------");
                    System.out.println(
                            "|                      <Choice does not exist!>                    |");
                    System.out.println(
                            "--------------------------------------------------------------------");
                }
            }
        } while (option < 1 || option > 8);
    }

    public static void optionSalary() {
        int option;
        System.out.println("--------------------------------------------------------------");
        System.out.println("|                        SALARY MANAGER                      |");
        System.out.println("--------------------------------------------------------------");
        try {
            Thread.sleep(1000);

        } catch (Exception e) {
            System.out.println("Fail to sleep!");
        }
        System.out.println("--------------------------------------------------------");
        System.out.println("|  1. Input list salary of employees                   |");
        System.out.println("|  2. Output list salary of employees                  |");
        System.out.println("|  3. Add salary of one employee                       |");
        System.out.println("|  4. Remove salary of one employee                    |");
        System.out.println("|  5. Find salary of one employee                      |");
        System.out.println("|  6. Remove salary of one employee                    |");
        System.out.println("|  7. Back to menu                                     |");
        System.out.println("|  8. Exit                                             |");
        System.out.println("--------------------------------------------------------");
        System.out.println(
                "\n-----------------------------------------");
        do {
            System.out.print(" ==> Input option: ");
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1 -> {
                    listSalary.inputList();
                    optionSalary();
                    break;

                }
                case 2 -> {
                    listSalary.outputList();
                    optionSalary();
                    break;
                }
                case 3 -> {

                    listSalary.add();
                    optionSalary();
                    break;
                }
                case 4 -> {
                    listSalary.remove();
                    optionSalary();
                    break;
                }
                case 5 -> {
                    listSalary.find();
                    optionSalary();
                }
                case 6 -> {
                    listSalary.remove();
                    optionSalary();
                    break;
                }
                case 7 -> {

                    menu();
                }
                case 8 -> {
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("|                           Good Bye!                          |");
                    System.out.println("----------------------------------------------------------------");
                    break;
                }
                default -> {
                    System.out.println("--------------------------------------------------------------------");
                    System.out.println("|                      <Choice does not exist!>                    |");
                    System.out.println("--------------------------------------------------------------------");
                    break;
                }
            }
        } while (option < 1 || option > 8);
    }

    private static void optionContract() {

        int option;
        System.out.println("\n     --------------------------------------------");
        System.out.println("     |              CONTRACT MANAGER            |");
        System.out.println("     --------------------------------------------");
        try {
            Thread.sleep(1000);

        } catch (Exception e) {
            System.out.println("Fail to sleep!");
        }
        System.out.println("     --------------------------------------------");
        System.out.println("     |  1. Input List Of Contract               |");
        System.out.println("     |  2. Output List Of Contract              |");
        System.out.println("     |  3. Add                                  |");
        System.out.println("     |  4. Edit                                 |");
        System.out.println("     |  5. Delete                               |");
        System.out.println("     |  6. Search                               |");
        System.out.println("     |  7. Back to previous menu                |");
        System.out.println("     |  8. Exit                                 |");
        System.out.println("     --------------------------------------------");
        do {
            System.out.print("==> Input Option: ");
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:
                    listContract.inputList();
                    optionContract();
                    break;
                case 2:
                    listContract.outputList();
                    optionContract();
                    break;
                case 3:
                    listContract.add();
                    optionContract();
                    break;
                case 4:
                    listContract.edit();
                    optionContract();
                    break;
                case 5:
                    listContract.remove();
                    optionContract();
                    break;
                case 6:
                    listContract.find();
                    optionContract();
                    break;
                case 7:
                    menu();
                    break;
                case 8:
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("|                           Good Bye!                          |");
                    System.out.println("----------------------------------------------------------------");
                    break;
                default:
                    System.out.println("--------------------------------------------------------------------");
                    System.out.println("|                      <Choice does not exist!>                    |");
                    System.out.println("--------------------------------------------------------------------");
                    break;
            }

        } while (option < 1 || option > 10);
    }

    public static void optionProject() {
        int option;
        System.out.println("\n     --------------------------------------------");
        System.out.println("     |              PROJECT MANAGER             |");
        System.out.println("     --------------------------------------------");
        try {
            Thread.sleep(1000);

        } catch (Exception e) {
            System.out.println("Fail to sleep!");
        }
        System.out.println("     --------------------------------------------");
        System.out.println("     |  1. Input List Of Project                |");
        System.out.println("     |  2. Output List Of Project               |");
        System.out.println("     |  3. Add                                  |");
        System.out.println("     |  4. Edit                                 |");
        System.out.println("     |  5. Delete                               |");
        System.out.println("     |  6. Search                               |");
        System.out.println("     |  7. Back to previous menu                |");
        System.out.println("     |  8. Exit                                 |");
        System.out.println("     --------------------------------------------");
        do {
            System.out.print("==> Input option: ");
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:
                    listProject.inputList();
                    optionProject();
                    break;
                case 2:
                    listProject.outputList();
                    optionProject();
                    break;
                case 3:
                    listProject.add();
                    optionProject();
                    break;
                case 4:
                    listProject.edit();
                    optionProject();
                    break;
                case 5:
                    listProject.remove();
                    optionProject();
                    break;
                case 6:
                    listProject.find();
                    optionProject();
                    break;
                case 7:
                    menu();
                    break;
                case 8:
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("|                           Good Bye!                          |");
                    System.out.println("----------------------------------------------------------------");
                    break;
                default:
                    System.out.println("--------------------------------------------------------------------");
                    System.out.println("|                      <Choice does not exist!>                    |");
                    System.out.println("--------------------------------------------------------------------");
                    break;
            }

        } while (option < 1 || option > 10);
    }

    public static void optionDepartment() {
        // SalaryManager.updateDataEmployee();
        int option;
        System.out.println("\n     --------------------------------------------");
        System.out.println("     |              DEPARTMENT MANAGER          |");
        System.out.println("     --------------------------------------------");
        try {
            Thread.sleep(1000);

        } catch (Exception e) {
            System.out.println("Fail to sleep!");
        }
        System.out.println("     --------------------------------------------");
        System.out.println("     |  1. Input List Of Project                |");
        System.out.println("     |  2. Output List Of Project               |");
        System.out.println("     |  3. Add                                  |");
        System.out.println("     |  4. Edit                                 |");
        System.out.println("     |  5. Delete                               |");
        System.out.println("     |  6. Search                               |");
        System.out.println("     |  7. Back to previous menu                |");
        System.out.println("     |  8. Exit                                 |");
        System.out.println("     --------------------------------------------");
        do {
            System.out.print(" ==> Input option: ");
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:
                    listDepartment.inputList();
                    optionDepartment();
                    break;
                case 2:
                    listDepartment.outputList();
                    optionDepartment();
                    break;
                case 3:
                    listDepartment.add();
                    optionDepartment();
                    break;
                case 4:
                    listDepartment.remove();
                    optionDepartment();
                    break;
                case 5:
                case 6:
                case 7:
                    menu();
                case 8:
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("|                           Good Bye!                          |");
                    System.out.println("----------------------------------------------------------------");
                    break;
                default:
                    System.out.println("--------------------------------------------------------------------");
                    System.out.println("|                      <Choice does not exist!>                    |");
                    System.out.println("--------------------------------------------------------------------");
            }
        } while (option < 1 || option > 5);
    }

    // Account

}

// Đăng nhập với tư cách nhân viên xem thông tin cá nhân,xem ds nhân viên,xem ds
// dự án,xem ds phòng ban