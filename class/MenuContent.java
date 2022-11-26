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
        clearScreen();
        System.out.println("Hello, Welcome to Employee Manager");
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
        System.out.println("     | 3. Salary Manager    |");
        System.out.println("     -------------------------");
        System.out.println("     | 4. Project Manager    |");
        System.out.println("     -------------------------");
        System.out.println("     | 5. Department Manager |");
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
                default -> {
                    System.out.println("      <Choice does not exist!>");
                    System.out.println(
                            "     -----------------------------------------------------------------------------------");
                }
            }
        } while (option < 1 || option > 5);
        MenuContent.clearScreen();
    }

    public static void showMenuEmployee() {
        System.out.println("Select employee type: ");
        System.out.println("-----1.Chief Department");
        System.out.println("-----2.Official Employee");
        System.out.println("-----3.Intern Employee");
        System.out.print("Enter choice: ");
    }

    public static void optionEmployee() {
        int option;
        System.out.println("     -----------------------");
        System.out.println("    |   Employee Manager   |");
        System.out.println("     -----------------------");
        System.out.println("     1. Input new list of employees");
        System.out.println("     2. Output list of employees");
        System.out.println("     3. Add new employee");
        System.out.println("     4. Edit employee");
        System.out.println("     5. Remove employee");
        System.out.println("     6. Find employee");
        System.out.println("     7. Back to menu");
        System.out.println("     8. Exit");
        do {
            System.out.print("     ==> Input option: ");
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:
                    listEmployee.inputList();
                    optionEmployee();
                    break;
                case 2:
                    listEmployee.outputList();
                    optionEmployee();
                    break;
                case 3:
                    listEmployee.add();
                    optionEmployee();
                    break;
                case 4:
                    listEmployee.edit();
                    optionEmployee();
                    break;
                case 5:
                    listEmployee.remove();
                    optionEmployee();
                    break;
                case 6:
                    listEmployee.find();
                    optionEmployee();
                    break;
                case 7:
                    menu();
                    break;
                case 8:
                    System.out.println(
                            "\n----------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("\nGood bye!");
                    break;
                default:
                    System.out.println("\n---------------------\n     <Choice does not exist!>");
            }
        } while (option < 1 || option > 8);
    }

    public static void optionSalary() {
        listSalary.updateDataEmployee();
        int option;
        System.out.println(
                "\n-----------------------------------------");
        System.out.printf("|%-40s|", "              Salary Manager ");
        System.out.println("\n-----------------------------------------");
        try {
            Thread.sleep(1000);

        } catch (Exception e) {
            System.out.println("Fail to sleep!");
        }
        System.out.printf("|%-40s|", " 1. Input list salary of employees ");
        System.out.printf("\n|%-40s|", " 2. Output list salary of employees ");
        System.out.printf("\n|%-40s|", " 3. Add salary of one employee ");
        System.out.printf("\n|%-40s|", " 4. Remove salary of one employee ");
        System.out.printf("\n|%-40s|", " 5. Find salary of one employee ");
        System.out.printf("\n|%-40s|", " 6. Remove salary of one employee ");
        System.out.printf("\n|%-40s|", " 7. Back to menu");
        System.out.printf("\n|%-40s|", " 8. Exit");
        System.out.println(
                "\n-----------------------------------------");
        do {
            System.out.print(" ==> Input option: ");
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:
                    listSalary.inputList();
                    optionSalary();
                    break;
                case 2:
                    listSalary.outputList();
                    optionSalary();
                    break;
                case 3:
                    listContract.add();
                    optionSalary();
                    break;
                case 4:
                    listSalary.remove();
                    optionSalary();
                    break;
                case 5:
                case 6:
                case 7:
                    menu();
                case 8:
                    System.out.println(
                            "\n---------------------------------------------------------------------------------------------");
                    System.out.println("\n Say Goodbye!");
                    break;
                default:
                    System.out.println("\n - - - - - - - - - - -\n Choice is not exist!");
            }
        } while (option < 1 || option > 5);
    }

    private static void optionContract() {

        int option;
        System.out.println(
                "\n--------------------------------------------------------------------------------------------");
        System.out.println("\n     ───────────────────────");
        System.out.println("     |   QUAN LY HOP DONG   |");
        System.out.println("     -----------------------\n");
        System.out.println("     1. Nhap hop dong");
        System.out.println("     2. Xuat hop dong");
        System.out.println("     3. Them");
        System.out.println("     4. Sua");
        System.out.println("     5. Xoa");
        System.out.println("     6. Tim kiem");
        System.out.println("     7. Quay lai menu chinh");
        System.out.println("     8. Thoat");
        do {
            System.out.println("==> Nhap lua chon: ");
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
                    System.out.println(
                            "\n----------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("\n      Good Bye!");
                    break;
                default:
                    System.out.println("Lua chon khong phu hop!!!!!!");
            }

        } while (option < 1 || option > 10);
    }

    public static void optionProject() {
        int option;
        System.out.println(
                "\n--------------------------------------------------------------------------------------------");
        System.out.println("\n     ───────────────────────");
        System.out.println("     |   MANAGE PROJECT      |");
        System.out.println("     -----------------------\n");
        System.out.println("     1. Add List of Project");
        System.out.println("     2. Print List of Project");
        System.out.println("     3. Add Project");
        System.out.println("     4. Edit Project");
        System.out.println("     5. Remove Project");
        System.out.println("     6. Find Project By Id");
        System.out.println("     7. Read file");
        System.out.println("     8. Write file");
        System.out.println("     9. Back to main menu");
        System.out.println("     10. Exit");
        do {
            System.out.println("==> Nhap lua chon: ");
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
                    break;
                case 8:
                    System.out.println(
                            "\n----------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("\n      Good Bye!");
                    break;
                default:
                    System.out.println("Lua chon khong phu hop!!!!!!");
            }

        } while (option < 1 || option > 10);
    }

    public static void optionDepartment() {
        listSalary.updateDataEmployee();
        int option;
        System.out.println(
                "\n-----------------------------------------");
        System.out.printf("|%-40s|", "              Depart Manager ");
        System.out.println("\n-----------------------------------------");
        try {
            Thread.sleep(1000);

        } catch (Exception e) {
            System.out.println("Fail to sleep!");
        }
        System.out.printf("|%-40s|", " 1. Input list salary of employees ");
        System.out.printf("\n|%-40s|", " 2. Output list salary of employees ");
        System.out.printf("\n|%-40s|", " 3. Add salary of one employee ");
        System.out.printf("\n|%-40s|", " 4. Remove salary of one employee ");
        System.out.printf("\n|%-40s|", " 5. Find salary of one employee ");
        System.out.printf("\n|%-40s|", " 6. Remove salary of one employee ");
        System.out.printf("\n|%-40s|", " 7. Back to menu");
        System.out.printf("\n|%-40s|", " 8. Exit");
        System.out.println(
                "\n-----------------------------------------");
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
                    System.out.println(
                            "\n---------------------------------------------------------------------------------------------");
                    System.out.println("\n Say Goodbye!");
                    break;
                default:
                    System.out.println("\n - - - - - - - - - - -\n Choice is not exist!");
            }
        } while (option < 1 || option > 5);
    }

}
