public class MenuContent {

    public static void menuIForEmployee() {

    }

    public static void option(String title) {
        System.out.println(title);
        String capital = title.toUpperCase();
        System.out.println("\n     --------------------------------------------");
        System.out.printf("     |            %-15s %-15s          |", title, "MANAGER");
        System.out.println("\n     --------------------------------------------");
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
    }

}
