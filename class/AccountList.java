import java.util.Scanner;

public class AccountList implements RoleOfManager {
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void inputList() {
        // Input new list account
        Handle.m = 0;
        int i = 0;
        System.out.print(" ==> Enter amount: ");
        Handle.m = scanner.nextInt();
        while (i < Handle.m) {
            Handle.listAccount[i].setIdEmp(null);
            if (Handle.checkIdEmployee(Handle.listAccount[i].getIdEmp())) {
                Handle.listAccount[i].input();
            } else {
                Handle.listAccount[i] = null;
                System.err.println("Don't have data with id " + Handle.listAccount[i].getIdEmp());
            }
        }
    }

    @Override
    public void outputList() {
        // Output new list account
        for (int i = 0; i < Handle.listAccount.length; i++) {
            Handle.listAccount[i].output();
        }

    }

    @Override
    public void add() {
        int amount;// add new account
        System.out.println(" ==> Enter amount to add account: ");
        amount = scanner.nextInt();
        Handle.m += amount;
        for (int i = Handle.m; i < (Handle.m + amount); i++) {
            Handle.listAccount[i].setIdEmp(null);
            if (Handle.checkIdEmployee(Handle.listAccount[i].getIdEmp())) {
                Handle.listAccount[i].input();
            } else {
                Handle.listAccount[i] = null;
                System.err.println("Don't have data with id " + Handle.listAccount[i].getIdEmp());
            }
        }
    }

    @Override
    public void remove() {
        // remove account

    }

    @Override
    public void edit() {
        // edit username or password

    }

    @Override
    public void find() {
        // find information of the account
        String idSearch;
        System.out.println(" ==> Enter id of employee to search: ");
        idSearch = scanner.nextLine();

        for (int i = 0; i < Handle.m; i++) {
            if (idSearch.equalsIgnoreCase(Handle.listAccount[i].getIdEmp())) {
                Handle.listAccount[i].output();
            }
        }
    }

}
