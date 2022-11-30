public class MenuContent {

    public static void option(String title) {
        String capital = title.toUpperCase();
        System.out.println("\n     --------------------------------------------");
        System.out.printf("     |   %20s %s           |", capital, "MANAGER");
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
        System.out.println("--------------------------------------------------------------------");
        System.out.println("|                  Hello, Welcome to Employee Manager              |");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("     ---------------------------------");
        System.out.println("     | 1. Account Employee Manager   |");
        System.out.println("     ---------------------------------");
        System.out.println("     | 2. Contract Manager           |");
        System.out.println("     ---------------------------------");
        System.out.println("     | 3. Salary Manager             |");
        System.out.println("     ---------------------------------");
        System.out.println("     | 4. Department Manager         |");
        System.out.println("     ---------------------------------");
        System.out.println("     | 5. Exit                       |");
        System.out.println("     ---------------------------------");
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

    public static void choiceWrong() {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("|                      <<<<ERROR !!!!!                             |");
        System.out.println("--------------------------------------------------------------------");
    }

    public static void noteChangeSuccess() {
        System.out.println("-------------------------------------------------");
        System.out.println("|         Change Information Successful!        |");
        System.out.println("-------------------------------------------------");
    }

    public static void noteSuccess(String title) {
        System.out.println("-------------------------------------------------");
        System.out.printf("|%15s %-15s|", title, "successful!              |");
        System.out.println("\n-------------------------------------------------");
    }

    public static void noteFailure(String title) {
        System.out.println("-------------------------------------------------");
        System.out.printf("|%-15s %-15s|", title, "failure!              ");
        System.out.println("-------------------------------------------------");
    }

    public static void noteAddSuccess() {
        System.out.println("----------------------------------------");
        System.out.println("|            Add Successful!!          |");
        System.out.println("----------------------------------------");
    }

    public static void optionEdit() {
        System.out.println("-------------------------------------------------");
        System.out.println("|                Select edit                    |");
        System.out.println("-------------------------------------------------");
        System.out.println("| 1.Change Each One                             |");
        System.out.println("| 2.Change All Information                      |");
        System.out.println("-------------------------------------------------");
        System.out.print(" ==> Input option: ");
    }

    public static void printNoData() {
        System.out.println("\t\t--------------------------------------------");
        System.out.println("\t\t|           No data in the list            |");
        System.out.println("\t\t--------------------------------------------");
    }

    public static void noteBye() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("|                           Good Bye!                          |");
        System.out.println("----------------------------------------------------------------");
    }

    public static void quantityCount(String any,int quantity) {

        System.out.println("-------------------------------------------------------");
        System.out.printf("| %s %s|", any.toUpperCase(), "QUANTITY");
        System.out.println("-------------------------------------------------------");
        System.out.printf("At the moment we all have %2d %2s",quantity,any);
    }

    public static void menuIForEmployee() {
        System.out.println("     ----------------------------------");
        System.out.println("     | 1. View personal information   |");
        System.out.println("     ----------------------------------");
        System.out.println("     | 2. Edit information            |");
        System.out.println("     ----------------------------------");
        System.out.println("     | 3. Exit                        |");
        System.out.println("     ----------------------------------");
        System.out.println(" ==> Input choice: ");
    }

    public static void menuIForChief() {
        Handle.clearScreen();
        System.out.println("     ----------------------------------------------");
        System.out.println("     | 1. View Employee List Of Department        |");
        System.out.println("     ----------------------------------------------");
        System.out.println("     | 2. View personal information               |");
        System.out.println("     ----------------------------------------------");
        System.out.println("     | 3. Edit information                        |");
        System.out.println("     ----------------------------------------------");
        System.out.println("     | 4. Edit information of department          |");
        System.out.println("     ----------------------------------------------");
        System.out.println("     | 5. Exit                                    |");
        System.out.println("     ----------------------------------------------");
        System.out.println(" ==> Input choice: ");
    }
}
