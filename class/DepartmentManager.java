import java.util.Arrays;
import java.util.Scanner;

public class DepartmentManager implements RoleOfManager {
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void inputList() {
        MenuHandle.n = 0;
        System.out.print(" ==> Enter amount department: ");
        MenuHandle.m = MenuHandle.getInputNumber();
        MenuHandle.listDepartments = new Department[MenuHandle.m];
        for (int i = 0; i < MenuHandle.m; i++) {
            System.out.println("==> Enter information for department number " + (i + 1));
            MenuHandle.listDepartments[i] = new Department();
            MenuHandle.listDepartments[i].input();
            MenuHandle.n += MenuHandle.listDepartments[i].getMembers() + 1;
        }
    }

    @Override
    public void outputList() {
        // TODO Auto-generated method stub
        if (MenuHandle.m < 0)
            MenuContent.printNoData();
        else {
            System.out.println(
                    "\n--------------------------------------------------------------------------------------------------------------");
            System.out.printf("|     %-20s|     %-20s|     %-20s|     %-25s|", "Department Id", "Department Name",
                    "Id ChiefDepartment",
                    "Number of employee codes");
            for (int i = 0; i < MenuHandle.m; i++) {
                MenuHandle.listDepartments[i].output();
            }
        }
    }

    @Override
    public void add() {
        // TODO Auto-generated method stub
        if (MenuHandle.m < 0)
            MenuContent.printNoData();
        else {
            int amountAdd;
            System.out.print(" ==> Enter amount for department to add: ");
            amountAdd = MenuHandle.getInputNumber();
            int currentAmount = MenuHandle.m;
            for (int i = currentAmount; i < (currentAmount + amountAdd); i++) {
                System.out.println("-----Enter information for department");
                Department department = new Department();
                department.input();
                MenuHandle.n += department.getMembers() + 1;

                MenuHandle.listDepartments = Arrays.copyOf(MenuHandle.listDepartments, MenuHandle.m + 1);
                MenuHandle.listDepartments[MenuHandle.m] = department;
                MenuHandle.m++;
            }
        }
    }

    @Override
    public void remove(String idRemove) {
        // TODO Auto-generated method stub
        Boolean check = false;
        if (MenuHandle.m < 0)
            System.out.println("Don't have data for department");
        else {
            if (idRemove == null) {
                System.out.print(" ==> Input id department to remove: ");
                idRemove = MenuHandle.inputId("D0");
            }
            for (int i = 0; i < MenuHandle.m; i++) {
                if (MenuHandle.listDepartments[i].getDepartmentId().equalsIgnoreCase(idRemove)) {
                    if (MenuHandle.listDepartments[i].getMembers() >= 0)
                        System.out.println(" <<<< Can't remove because department has employee!!!");
                    else {
                        for (int j = i; j < MenuHandle.m - 1; j++) {
                            MenuHandle.listDepartments[j] = MenuHandle.listDepartments[j + 1];
                            check = true;
                        }
                        MenuHandle.listDepartments = Arrays.copyOf(MenuHandle.listDepartments, MenuHandle.m - 1);
                        MenuHandle.m--;
                    }
                }
            }
        }
        if (!check)
            MenuContent.noteFailure("Remove");
    }

    @Override
    public void edit(String idDepEdit) {
        // TODO Auto-generated method stub
        System.out.println(5);
        if (MenuHandle.m < 0)
            System.out.println("Don't have data for department");
        else {
            if (idDepEdit == null) {
                System.out.print(" ==> Input id of department to edit: ");
                idDepEdit = scanner.nextLine();
            }
            for (int i = 0; i < MenuHandle.m; i++) {
                if (MenuHandle.listDepartments[i].getDepartmentId().equalsIgnoreCase(idDepEdit)) {
                    int option;
                    MenuContent.optionEdit();
                    option = scanner.nextInt();
                    switch (option) {
                        case 1 -> {
                            MenuHandle.listDepartments[i].input();
                        }
                        case 2 -> {
                            int optionEditEachOne;
                            System.out.println("--------------------------------------------------");
                            System.out.println("| 1.Edit id department                           |");
                            System.out.println("| 2.Edit name department                         |");
                            System.out.println("| 3.Edit amount employee of department           |");
                            System.out.println("--------------------------------------------------");
                            optionEditEachOne = scanner.nextInt();
                            switch (optionEditEachOne) {
                                case 1 -> MenuHandle.listDepartments[i].setDepartmentId(null);
                                case 2 -> MenuHandle.listDepartments[i].setDepartmentName(null);
                                case 3 -> {
                                    MenuHandle.listDepartments[i].setMembers(i);
                                    MenuHandle.listDepartments[i]
                                            .setIdEmployee(new String[MenuHandle.listDepartments[i].getMembers()]);
                                    break;
                                }
                                default -> {
                                    MenuContent.choiceWrong();
                                    break;
                                }
                            }
                        }
                        default -> {
                            MenuContent.choiceWrong();
                            break;
                        }
                    }
                }
            }
        }
    }

    @Override
    public void find(String idSearch) {
        // TODO Auto-generated method stub
        if (MenuHandle.m < 0)
            System.out.println("Don't have data for department");
        else {
            if (idSearch == null) {
                System.out.print(" ==> Input id department to search: ");
                idSearch = scanner.nextLine();
            }
            System.out.printf("|%-15s|%-15s|%-15s|%-15s", "Department Id", "Department Name", "Amount Members",
                    "Number of employee codes");
            for (int i = 0; i < MenuHandle.m; i++) {
                if (MenuHandle.listDepartments[i].getDepartmentId().equalsIgnoreCase(idSearch)) {
                    MenuHandle.listDepartments[i].output();
                }
            }
        }
    }

    @Override
    public void statistics() {
        MenuContent.quantityCount();
        System.out.printf("Currently we have %s department",MenuHandle.m);
    }
}
