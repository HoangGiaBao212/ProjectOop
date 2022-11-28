public class MenuContent {

    public static void menuIForEmployee() {
        Handle.clearScreen();
        System.out.println("     ----------------------------------");
        System.out.println("     | 1. View Employee List          |");
        System.out.println("     ----------------------------------");
        System.out.println("     | 2. View personal information   |");
        System.out.println("     ----------------------------------");
        System.out.println("     | 3. Edit view                   |");
        System.out.println("     ----------------------------------");
        System.out.println("     | 4. Exit                        |");
        System.out.println("     ----------------------------------");
        System.out.println(" ==> Input choice: ");
    }

    public static void option(String title) {
        String capital = title.toUpperCase();
        System.out.println("\n     --------------------------------------------");
        System.out.printf("     |       %15s %-15s    |", capital, "MANAGER");
        System.out.println("\n     --------------------------------------------");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Fail to sleep!");
        }
        System.out.println("     --------------------------------------------");
        System.out.printf("     | %-16s %-23s|", " 1. Input List Of", title);
        System.out.printf("\n     | %-17s %-22s|", " 2. Output List Of", title);
        System.out.printf("\n     | %10s %-29s|", " 3. Add new", title);
        System.out.printf("\n     | %19s %-20s|", " 4. Edit Information", title);
        System.out.printf("\n     | %9s %-30s|", " 5. Delete", title);
        System.out.printf("\n     | %21s %-18s|", " 6. Search Information", title);
        System.out.println("\n     |  8. Back to previous menu                |");
        System.out.println("     |  9. Exit                                 |");
        System.out.println("     --------------------------------------------");
    }

    public static void menu() {
        Handle.clearScreen();
        System.out.println("--------------------------------------------------------------------");
        System.out.println("|                  Hello, Welcome to Employee Manager              |");
        System.out.println("--------------------------------------------------------------------");

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Fail to sleep!");
        }
        Handle.clearScreen();
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
    }

    public static void menuOptionTypeEmployee() {
        System.out.println("Select employee type: ");
        System.out.println("----------------------------------------------");
        System.out.println("|  1.Chief Department                        |");
        System.out.println("|  2.Official Employee                       |");
        System.out.println("|  3.Intern Employee                         |");
        System.out.println("----------------------------------------------");
        System.out.print("==> Enter choice: ");
    }

    public static void noteBye() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("|                           Good Bye!                          |");
        System.out.println("----------------------------------------------------------------");
    }

    public static void choiceWrong() {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("|                      <Choice does not exist!>                    |");
        System.out.println("--------------------------------------------------------------------");
    }

    public static void noteRemoveSuccess() {
        System.out.println("-------------------------------------------------");
        System.out.println("|               Remove successful!              |");
        System.out.println("-------------------------------------------------");
    }

    public static void noteRemoveFailure() {
        System.out.println("-------------------------------------------------");
        System.out.println("|               Remove Failure!                 |");
        System.out.println("-------------------------------------------------");
    }

    public static void optionEdit() {
        System.out.println("-------------------------------------------------");
        System.out.println("|                Select edit                    |");
        System.out.println("-------------------------------------------------");
        System.out.println("| 1.Full edit                                   |");
        System.out.println("| 2.Edit each one                               |");
        System.out.println("-------------------------------------------------");
        System.out.print(" ==> Input option: ");
    }

}
