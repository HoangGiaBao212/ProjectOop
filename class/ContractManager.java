import java.text.SimpleDateFormat;
import java.util.*;

public class ContractManager implements RoleOfManager {
    // new list ContractManager
    Scanner scanner = new Scanner(System.in);

    public ContractManager() {
    }

    @Override
    public void inputList() {
        System.out.println("-------------------------------------------------");
        System.out.println("|              ADD LIST OF CONTRACT             |");
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < MenuHandle.n; i++) {
            System.out.println(MenuHandle.n);
            System.out.println("Enter information contract of employee with id: "
                    + MenuHandle.listAccount[i].getEmployee().getIdEmp());
            Contract contract = new Contract();
            contract.input();
            MenuHandle.listAccount[i].getEmployee().setContract(contract);
        }

        System.out.println("---------------------------------------");
        System.out.println("|          Add list successful!       |");
        System.out.println("---------------------------------------");
    }

    @Override
    public void outputList() {
        MenuHandle.clearScreen();
        System.out.println("Output the List of Contract\n");
        // System.out.println(Handle.n);
        if (MenuHandle.n < 0 || MenuHandle.listAccount[0].getEmployee().getContract() == null) {
            MenuContent.printNoData();
        } else {
            System.out.println(
                    "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf(
                    "|    %-15s|    %-20s|   %-15s|   %-10s|   %-5s|   %-15s|    %-25s|   %-15s|    %-15s|    %-15s|",
                    "Contract ID", "Name", "Employee ID", "Gender", "Age", "Phone number", "Email", "Time start",
                    "Time end", "Status");
            System.out.println();
            System.out.println(
                    "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < MenuHandle.n; i++) {
                System.out.printf(
                        "|    %-15s|    %-20s|   %-15s|   %-10s|   %-5s|   %-15s|    %-25s|   %-15s|    %-15s|    %-15s|\n",
                        MenuHandle.listAccount[i].getEmployee().getContract().getContractID(),
                        MenuHandle.listAccount[i].getEmployee().getName(),
                        MenuHandle.listAccount[i].getEmployee().getIdEmp(),
                        MenuHandle.listAccount[i].getEmployee().getGender(),
                        MenuHandle.listAccount[i].getEmployee().getAge(),
                        MenuHandle.listAccount[i].getEmployee().getPhone(),
                        MenuHandle.listAccount[i].getEmployee().getEmail(),
                        new SimpleDateFormat("dd/MM/yyyy")
                                .format(MenuHandle.listAccount[i].getEmployee().getContract().getTimeStart()),
                        new SimpleDateFormat("dd/MM/yyyy")
                                .format(MenuHandle.listAccount[i].getEmployee().getContract().getTimeEnd()),
                        MenuHandle.listAccount[i].getEmployee().getContract().getStatus());
                System.out.println(
                        "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            }
        }
    }

    @Override
    public void add() {
        boolean flag = false;
        System.out.println("---------------------------------------");
        System.out.println("|             ADD CONTRACT            |");
        System.out.println("---------------------------------------\n");
        System.out.print("Enter Employee ID to add: ");
        String idEmpAdd;
        idEmpAdd = scanner.nextLine();
        if (MenuHandle.checkIdEmployee(idEmpAdd)) {
            for (int i = 0; i < MenuHandle.n; i++) {
                if (MenuHandle.listAccount[i].getEmployee().getIdEmp().equals(idEmpAdd)) {
                    if (MenuHandle.listAccount[i].getEmployee().getContract() == null) {
                        Contract contract = new Contract();
                        contract.input();
                        MenuHandle.listAccount[i].getEmployee().setContract(contract);
                        flag = true;

                    }
                }
            }
        } else {
            System.out.println("Employee is exits or don't have employee with id: " + idEmpAdd);
        }   
        if(!flag){
            MenuContent.noteAddSuccess();
        }else{
            MenuContent.noteAddFailure();
        }
    }

    @Override
    public void edit(String idEdit) {
        boolean flag = false;
        if (idEdit == null) {
            System.out.println("----------------------------------------------------");
            System.out.println("|            EDIT INFORMATION IN CONTRACT          |");
            System.out.println("----------------------------------------------------");
            System.out.print("Enter an contract ID to edit: ");
            idEdit = scanner.nextLine();
        }
        int key, option;
        int count = 0;
        for (int i = 0; i < MenuHandle.n; i++) {
            if (MenuHandle.listAccount[i].getEmployee().getContract().getContractID().equalsIgnoreCase(idEdit)) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Contract don't exist!");
        } else {
            MenuContent.optionEdit();
            option = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < MenuHandle.n; i++) {
                switch (option) {
                    case 1:
                        if (MenuHandle.listAccount[i].getEmployee().getContract().getContractID()
                                .equalsIgnoreCase(idEdit)) {
                            System.out.println("\n ----------------------------------------------");
                            System.out.println(" | 1.Change time end                          |");
                            System.out.println(" ----------------------------------------------");
                            System.out.print("==> Input option:");
                            key = Integer.parseInt(scanner.nextLine());
                            System.out.println();
                            switch (key) {
                                case 1:
                                    System.out.print("Enter time end: ");
                                    Date input = MenuHandle.getInputDate();
                                    MenuHandle.listAccount[i].getEmployee().getContract().setTimeEnd(input);
                                    if (MenuHandle.isExpire(new SimpleDateFormat("dd/MM/yyyy").format(input))) {
                                        MenuHandle.listAccount[i].getEmployee().getContract().setStatus("Out of Date");
                                    } else {
                                        MenuHandle.listAccount[i].getEmployee().getContract()
                                                .setStatus("Still Working");
                                    }
                                    flag = true;
                                    break;
                                default:
                                    MenuContent.noteBye();
                                    break;
                            }
                        }
                        flag = true;
                        break;
                    case 2:
                        if (MenuHandle.listAccount[i].getEmployee().getContract().getContractID()
                                .equalsIgnoreCase(idEdit)) {
                            MenuHandle.listAccount[i].getEmployee().getContract().input();
                        }
                        flag = true;
                        break;
                    default:
                        MenuContent.choiceWrong();
                        break;
                }
            }
        }
        if(!flag){
            MenuContent.noteChangeSuccess();
        }else{
            MenuContent.noteChangeFailure();
        }
        
    }

    @Override
    public void remove(String idRemove) {
        System.out.println("-----------------------------------------------");
        System.out.println("|               REMOVE CONTRACT               |");
        System.out.println("-----------------------------------------------");
        if (idRemove == null) {
            System.out.print("Enter id of contract to remove(Ex:C001): ");
            idRemove = scanner.nextLine();
        }
        boolean check = false;
        for (int i = 0; i < MenuHandle.n; i++) {
            if (MenuHandle.listAccount[i].getEmployee().getContract().getContractID().equalsIgnoreCase(idRemove)) {
                for (int j = i; j < MenuHandle.n - 1; j++) {
                    MenuHandle.listAccount[j] = MenuHandle.listAccount[j + 1];

                }
                MenuHandle.listAccount[MenuHandle.n - 1] = null;
                MenuHandle.n--;
                check = true;
                break;
            }
        }
        if (!check) {
            MenuContent.noteFailure("Remove");
        }
        MenuContent.noteSuccess("Remove");
    }

    @Override
    public void find(String idSearch) {
        Boolean check = false;
        if (idSearch == null) {
            System.out.print("Enter id of employee to search(Ex:E001): ");
            idSearch = scanner.nextLine();
        }

        for (int i = 0; i < MenuHandle.n; i++) {
            if (MenuHandle.listAccount[i].getEmployee().getContract() == null) {
                continue;
            }
            if (idSearch.equals(MenuHandle.listAccount[i].getEmployee().getIdEmp())) {
                System.out.println(
                        "-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf(
                        "|    %-15s|    %-15s|   %-15s|   %-10s|   %-5s|   %-15s|    %-25s|   %-15s|    %-15s|    %-15s|",
                        "Contract ID", "Name", "Employee ID", "Gender", "Age", "Phone number", "Email", "Time start",
                        "Time end", "Status");
                System.out.println();
                System.out.println(
                        "-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf(
                        "|    %-15s|    %-15s|   %-15s|   %-10s|   %-5s|   %-15s|    %-25s|   %-15s|    %-15s|    %-15s|\n",
                        MenuHandle.listAccount[i].getEmployee().getContract().getContractID(),
                        MenuHandle.listAccount[i].getEmployee().getName(),
                        MenuHandle.listAccount[i].getEmployee().getIdEmp(),
                        MenuHandle.listAccount[i].getEmployee().getGender(),
                        MenuHandle.listAccount[i].getEmployee().getAge(),
                        MenuHandle.listAccount[i].getEmployee().getPhone(),
                        MenuHandle.listAccount[i].getEmployee().getEmail(),
                        new SimpleDateFormat("dd/MM/yyyy")
                                .format(MenuHandle.listAccount[i].getEmployee().getContract().getTimeStart()),
                        new SimpleDateFormat("dd/MM/yyyy")
                                .format(MenuHandle.listAccount[i].getEmployee().getContract().getTimeEnd()),
                        MenuHandle.listAccount[i].getEmployee().getContract().getStatus());
                System.out.println(
                        "-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                check = true;
                break;
            }
        }
        if (!check)
            System.out.println("------------ Don't have data for contract ---------------");
    }

    @Override
    public void statistics() {
        int count = 0,cnt = 0;
        MenuContent.quantityCount();
        for (int i = 0; i < MenuHandle.n; i++) {
            if(MenuHandle.listAccount[i].getEmployee().getContract().getStatus().equals("Out of Date")){
                count++;
            }else{
                cnt++;
            }
        } 
        // System.out.printf("Current we have %-5s employee working",MenuHandle.);
        System.out.printf("We have %s contract is working now!!!",cnt);
        System.out.printf("\nWe have %s contract is out of date!!!",count);
    }
}
