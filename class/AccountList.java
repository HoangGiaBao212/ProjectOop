import java.util.Scanner;

public class AccountList implements RoleOfManager {
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void inputList() {
        // Input new list account
        Handle.n = 0;
        System.out.print(" ==> Enter amount: ");
        Handle.n = scanner.nextInt();
        for(int i=0;i<Handle.n;i++){
            Handle.listAccount[i] = new Account();
            Handle.listAccount[i].input();
        }
       
    }

    @Override
    public void outputList() {
        // Output new list account
        System.out.printf("|%-15s|%15s|","Username","Password");
        for (int i = 0; i < Handle.n; i++) {
            Handle.listAccount[i].output();
        }

    }

    @Override
    public void add() {
        int amount;// add new account
        System.out.println(" ==> Enter amount to add account: ");
        amount = scanner.nextInt();
        Handle.n += amount;
        for (int i = Handle.n; i < (Handle.n + amount); i++) {
            Handle.listAccount[i].getEmployee().setIdEmp(null);
            if (Handle.checkIdEmployee(Handle.listAccount[i].getEmployee().getIdEmp())) {
                Handle.listAccount[i].input();
            } else {
                Handle.listAccount[i] = null;
                System.err.println("Don't have data with id " + Handle.listAccount[i].getEmployee().getIdEmp());
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

        for (int i = 0; i < Handle.n; i++) {
            if (idSearch.equalsIgnoreCase(Handle.listAccount[i].getEmployee().getIdEmp())) {
                Handle.listAccount[i].output();
            }
        }
    }

}
