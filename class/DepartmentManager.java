import java.util.Scanner;

public class DepartmentManager implements RoleOfManager {
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void inputList() {
        System.out.print(" ==> Enter amount department: ");
        Handle.m = scanner.nextInt();
        for (int i = 0; i < Handle.m; i++) {
            System.out.println("-------- Enter information for department number " + (i + 1));
            Handle.listDepartments[i] = new Department();
            Handle.listDepartments[i].input();
        }
    }

    @Override
    public void outputList() {
        // TODO Auto-generated method stub
        if (Handle.m < 0)
            Handle.noteNoHaveId("department");
        else {
            System.out.printf("|%-15s|%-15s|%-15s|%-15s", "Department Id", "Department Name", "Amount Members",
                    "Number of employee codes");
            for (int i = 0; i < Handle.m; i++) {
                Handle.listDepartments[i].output();
            }
        }

    }

    @Override
    public void add() {
        // TODO Auto-generated method stub
        if (Handle.m < 0)
            Handle.noteNoHaveId("department");
        else {
            int amountAdd;
            System.out.print(" ==> Enter amount for department to add: ");
            amountAdd = scanner.nextInt();
            for (int i = Handle.m; i < (Handle.m + amountAdd); i++) {
                System.out.println("-----Enter information for department");
                Handle.listDepartments[i] = new Department();
                Handle.listDepartments[i].input();
            }
        }
    }

    @Override
    public void remove(String idRemove) {
        // TODO Auto-generated method stub
        Boolean check = false;
        if (Handle.m < 0)
            System.out.println("Don't have data for department");
        else {
            if (idRemove == null) {
                System.out.print(" ==> Input id department to remove: ");
                idRemove = scanner.nextLine();
            }
            for (int i = 0; i < Handle.m; i++) {
                if (Handle.listDepartments[i].getDepartmentId().equalsIgnoreCase(idRemove)) {
                    for (int j = i; j < Handle.m - 1; j++) {
                        Handle.listDepartments[j] = Handle.listDepartments[j + 1];
                        check = true;
                    }
                }
            }
            Handle.listDepartments[Handle.m - 1] = null;
            Handle.m--;
        }
        if (!check)
            MenuContent.noteFailure("Remove");
    }

    @Override
    public void edit(String idDepEdit) {
        // TODO Auto-generated method stub
        if (Handle.m < 0)
            System.out.println("Don't have data for department");
        else {
            if (idDepEdit == null) {
                System.out.print(" ==> Input id of department to edit: ");
                idDepEdit = scanner.nextLine();
            }
            for (int i = 0; i < Handle.m; i++) {
                if (Handle.listDepartments[i].getDepartmentId().equalsIgnoreCase(idDepEdit)) {
                    int option;
                    System.out.println("------------------------------");
                    System.out.println("| 1.Edit full     |");
                    System.out.println("| 2.Edit each one |");
                    System.out.print("Input option: ");
                    option = scanner.nextInt();
                    switch (option) {
                        case 1 -> {
                            Handle.listDepartments[i].input();
                        }
                        case 2 -> {
                            int optionEditEachOne;
                            System.out.println("1.Edit id department");
                            System.out.println("2.Edit name department");
                            System.out.println("3.Edit amount employee of department");
                            optionEditEachOne = scanner.nextInt();
                            switch (optionEditEachOne) {
                                case 1 -> Handle.listDepartments[i].setDepartmentId(null);
                                case 2 -> Handle.listDepartments[i].setDepartmentName(null);

                                case 3 -> {
                                    Handle.listDepartments[i].setMembers(i);
                                    Handle.listDepartments[i]
                                            .setIdEmployee(new String[Handle.listDepartments[i].getMembers()]);
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
        if (Handle.m < 0)
            System.out.println("Don't have data for department");
        else {
            if (idSearch == null) {
                System.out.print(" ==> Input id department to search: ");
                idSearch = scanner.nextLine();
            }
            System.out.printf("|%-15s|%-15s|%-15s|%-15s", "Department Id", "Department Name", "Amount Members",
                    "Number of employee codes");
            for (int i = 0; i < Handle.m; i++) {
                if (Handle.listDepartments[i].getDepartmentId().equalsIgnoreCase(idSearch)) {
                    Handle.listDepartments[i].output();
                }
            }
        }
    }
    @Override
    public void statistics(){
        MenuContent.quantityCount("Department", Handle.n);
    }
}
