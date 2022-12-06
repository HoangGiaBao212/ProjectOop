import java.io.Console;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MenuHandle {
    static Scanner scanner = new Scanner(System.in);

    static int n = -1;
    static int m = -1;
    static Account[] listAccount = new Account[0];
    static Department[] listDepartments = new Department[0];

    static ContractManager listContract = new ContractManager();
    static SalaryManager listSalary = new SalaryManager();
    static DepartmentManager listDepartment = new DepartmentManager();
    static AccountList listAccounts = new AccountList();

    private MenuHandle() {
    }

    // lấy id từ department
    public String getId(String idDep) {
        return idDep;
    }

    // public Boolean get

    public static boolean checkIdEmployee(String id) {
        for (int i = 0; i < MenuHandle.n; i++) {
            if (listAccount[i].getEmployee().getIdEmp().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkIdOfDep(String idEmp, String idDep) {
        for (Department d : listDepartments) {
            if (d.getDepartmentId().equalsIgnoreCase(idDep)) {
                for (int i = 0; i < d.getMembers(); i++) {
                    if (d.getIdEmployee()[i].equalsIgnoreCase(idEmp)) {
                        return true;
                    }
                }
            }
        }
        return false;
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

    public static Float getInputNumberFloat() {
        Float choice;
        while (true) {
            try {
                choice = Float.parseFloat(getInput());
                return choice;
            } catch (Exception e) {
                MenuContent.choiceWrong();
            }
        }
    }

    private static String getInput() {
        return scanner.nextLine();
    }

    public static String getUsername() {
        String username;
        while (true) {
            System.out.print("==> Enter username: ");
            username = scanner.nextLine();
            Pattern pattern = Pattern.compile("^[a-z]+[0-9]*{8,50}$");
            if (pattern.matcher(username).find())
                break;
            else
                System.err.print("<<<<< Invalid username, input again: ");
        }
        return username;
    }

    public static String hidePassword() {
        Console console = System.console();
        String password = "";
        for (char element : console.readPassword()) {
            password += element;
        }
        return password;
    }

    public static String getPassword() {
        String password;
        while (true) {
            System.out.print("==> Password: ");
            password = scanner.nextLine();
            Pattern pCheck1 = Pattern.compile("^[a-zA-Z]+[0-9]+{4,25}$");
            Pattern pCheck2 = Pattern.compile("^'//d'+[a-zA-Z]+$");
            if (pCheck1.matcher(password).find() || pCheck2.matcher(password).find())
                break;
            else
                System.err.print("<<<<< Invalid password, input again: ");
        }
        return password;
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
            clearScreen();
            switch (option) {
                case 1 -> option("Account Employee");
                case 2 -> option("Contract");
                case 3 -> option("Salary");
                case 4 -> option("Department");
                case 5 -> {
                    clearScreen();
                    login();
                }
                case 6 -> {
                    MenuContent.noteBye();
                    break;
                }
                default -> {
                    MenuContent.choiceWrong();
                    break;
                }
            }
        } while (option < 1 || option > 6);
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
                    if (title.equals("Account Employee"))
                        listAccounts.statistics();
                    else if (title.equals("Contract"))
                        listContract.statistics();
                    else if (title.equals("Salary"))
                        listSalary.statistics();
                    else
                        listDepartment.statistics();
                    option(title);
                    // Thống kê
                    break;
                }
                case 8 -> {
                    menu();
                    break;
                }
                case 9 -> {
                    clearScreen();
                    login();
                    break;
                }
                case 10 -> {
                    MenuContent.noteBye();
                    break;
                }
                default -> {
                    MenuContent.choiceWrong();
                    break;
                }
            }
        } while (option < 1 || option > 10);
    }

    // Login
    public static void login() {
        Boolean check = false;
        String username;
        String password;
        System.out.println("--------------------------------------------------------------------");
        System.out.println("|                              LOGIN                               |");
        System.out.println("--------------------------------------------------------------------");
        username = getUsername();
        System.out.print("==> Enter password: ");
        password = hidePassword();
        for (int i = 0; i < n; i++) {
            if (username.equals(listAccount[i].getUsername()) && password.equals(listAccount[i].getPassword())) {
                check = true;
                if (listAccount[i].getEmployee().getPosition().equals("admin")) {
                    iForManager();
                    break;
                } else {
                    if (listAccount[i].getEmployee().getPosition().equals("Chief Of Department")) {
                        iForChiefDepartment(listAccount[i].getEmployee().getIdEmp());
                        break;
                    } else
                        iForEmployee(listAccount[i].getEmployee().getIdEmp());
                    break;
                }
            }
        }
        if (!check) {
            MenuContent.choiceWrong();
            login();
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
                    break;
                }
                case 2 -> {
                    listAccounts.edit(idEmp);
                    iForEmployee(idEmp);
                    break;
                }
                case 3 -> {
                    MenuContent.noteBye();
                    break;
                }
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
                    if (MenuHandle.m < 0) {
                        for (int i = 0; i < MenuHandle.m; i++) {
                            for (int j = 0; j < MenuHandle.listDepartments[i].getMembers(); j++) {
                                if (MenuHandle.listDepartments[i].getIdEmployee()[j].equalsIgnoreCase(idEmp)) {
                                    listDepartment.edit(MenuHandle.listDepartments[i].getDepartmentId());
                                }
                            }
                        }
                    } else {
                        MenuContent.printNoData();
                        iForChiefDepartment(idEmp);
                    }
                }
                case 4 -> {
                    listDepartment.edit(idEmp);
                    MenuContent.noteBye();
                    break;
                }
                case 5 -> {
                    MenuContent.noteBye();
                    break;
                }
                default -> {
                    MenuContent.choiceWrong();
                }
            }
        } while (choice < 1 || choice > 5);
    }

    public static void iForManager() {
        clearScreen();
        System.out.println("--------------------------------------------------------------------");
        System.out.println("|                        Welcome back,Manager                      |");
        System.out.println("--------------------------------------------------------------------");
        menu();
    }

    public static void noteNoHaveId(String id) {
        System.out.printf("%s-20s %-10s", " <<<<< Don't have id for ", id);
    }

    public static String inputId(String id) {
        String inputId;
        System.out.print("==> Enter Id: ");
        inputId = scanner.nextLine();
        while (inputId.isEmpty()) {
            System.out.print("\n    Id of employee must not be left blank! Enter again:  ");
            inputId = inputId(id);
        }
        while (!inputId.startsWith(id)) {
            System.out.printf("%-20s %-5s", "     ID starting from ", id);
            System.out.println("\n     Enter again: ");
            inputId = inputId(id);
        }
        // while (!checkIdEmployee(inputId)) {
        // System.out.print("Employee ID is already exist.Enter again: ");
        // inputId = inputId(inputId);
        // }
        return inputId;
    }

    public static Date getInputDate() {
        Date date = null;
        String strDate = "";
        SimpleDateFormat dateInput = new SimpleDateFormat("dd-MM-yyyy");
        while (date == null) {
            strDate = scanner.nextLine();
            try {
                date = dateInput.parse(strDate);
                // if (!strDate.equals(new SimpleDateFormat("dd-MM-yyyy").format(date))) {
                // date = null;
                // System.out.println("Input Wrong!!!");
                // }
                // System.out.println(date);
            } catch (Exception e) {
                System.out.println("Input Wrong!!!");
            }
        }
        return date;
    }

    public static boolean isExpire(String date) {
        if (date.isEmpty() || date.trim().equals("")) {
            return false;
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // 02/12/2022
            Date d = null;
            Date d1 = null;
            String today = getToday("dd/MM/yyyy");
            try {
                // System.out.println("expdate>> "+date);
                // System.out.println("today>> "+today+"\n\n");
                d = sdf.parse(date);
                d1 = sdf.parse(today);
                if (d1.compareTo(d) < 0) {// not expired
                    return false;
                } else if (d.compareTo(d1) == 0) {// both date are same
                    if (d.getTime() < d1.getTime()) {// not expired
                        return false;
                    } else if (d.getTime() == d1.getTime()) {// expired
                        return true;
                    } else {// expired
                        return true;
                    }
                } else {// expired
                    return true;
                }
            } catch (ParseException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public static String getToday(String format) {
        Date date = new Date();
        return new SimpleDateFormat(format).format(date);
    }

    // year = 12-6-2018
    // start = 12-8-2018
    // end = 12-6-2022
    // year = 2020
    // month = 6
    public static boolean checkStatus(Account o, int year, int month) {
        String txt;
        String txt2;
        try {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // 02/12/2022
            txt = sdf.format(o.getEmployee().getContract().getTimeStart());
            txt2 = sdf.format(date);
            String[] start = txt.split("/");
            String[] end = txt2.split("/");
            if (Integer.parseInt(start[2]) < year && Integer.parseInt(end[2]) > year) {
                return true;
            } else if (Integer.parseInt(start[2]) == year) {
                if (Integer.parseInt(start[1]) <= month)
                    return true;
                return false;
            } else if (Integer.parseInt(end[2]) == year) {
                if (Integer.parseInt(end[1]) >= month)
                    return true;
                return false;
            } else {
                return false;
            }
        } finally {
            // return false;
        }
    }
}
// Đăng nhập với tư cách nhân viên xem thông tin cá nhân,xem ds nhân viên,xem ds
// dự án,xem ds phòng ban