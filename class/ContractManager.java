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
        for (int i = 0; i < Handle.n; i++) {
            System.out.println(Handle.n);
            System.out.println("Enter information contract of employee with id: "
                    + Handle.listAccount[i].getEmployee().getIdEmp());
            Contract contract = new Contract();
            contract.input();
            Handle.listAccount[i].getEmployee().setContract(contract);
        }

        System.out.println("---------------------------------------");
        System.out.println("|          Add list successful!       |");
        System.out.println("---------------------------------------");
    }

    @Override
    public void outputList() {
        Handle.clearScreen();
        System.out.println("Output the List of Contract\n");
        // System.out.println(Handle.n);
        if (Handle.n == 0) {
            MenuContent.printNoData();
        } else {
            System.out.println(
                    "-------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("|    %-15s|   %-20s|   %-10s|   %-10s|   %-15s|    %-25s|   %-10s|    %-10s|",
                    "Contract ID", "Name", "Gender", "Age", "Phone number", "Email", "Time start", "Time end");
            System.out.println();
            System.out.println(
                    "-------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < Handle.n; i++) {
                System.out.printf("|    %-15s|   %-20s|   %-10s|   %-10s|   %-15s|    %-25s|   %-10s|    %-10s|\n",
                        Handle.listAccount[i].getEmployee().getContract().getContractID(),
                        Handle.listAccount[i].getEmployee().getName(),
                        Handle.listAccount[i].getEmployee().getGender(),
                        Handle.listAccount[i].getEmployee().getAge(),
                        Handle.listAccount[i].getEmployee().getPhone(),
                        Handle.listAccount[i].getEmployee().getEmail(),
                        Handle.listAccount[i].getEmployee().getContract().getTimeStart(),
                        Handle.listAccount[i].getEmployee().getContract().getTimeEnd());
                System.out.println(
                        "-------------------------------------------------------------------------------------------------------------------------------------------------------");
            }
        }
    }

    @Override
    public void add() {
        System.out.println("---------------------------------------");
        System.out.println("|             ADD CONTRACT            |");
        System.out.println("---------------------------------------\n");
        System.out.print("Enter Employee ID to add: ");
        String idEmpAdd;
        idEmpAdd = scanner.nextLine();
        if (Handle.checkIdEmployee(idEmpAdd)) {
            for (int i = 0; i < Handle.n; i++) {
                if (Handle.listAccount[i].getEmployee().getIdEmp().equals(idEmpAdd)) {
                    if (Handle.listAccount[i].getEmployee().getContract() == null) {
                        Contract contract = new Contract();
                        contract.input();
                        Handle.listAccount[i].getEmployee().setContract(contract);
                    }
                }
            }
        } else {
            System.out.println("Employee is exits or don't have employee with id: " + idEmpAdd);
        }

        System.out.println("---------------------------------------------------------");
        System.out.println("|               Add Contract Successful!                |");
        System.out.println("---------------------------------------------------------");
    }

    @Override
    public void edit(String idEdit) {
        if (idEdit == null) {
            System.out.println("----------------------------------------------------");
            System.out.println("|            EDIT INFORMATION IN CONTRACT          |");
            System.out.println("----------------------------------------------------");
            System.out.print("Enter an contract ID to edit: ");
            idEdit = scanner.nextLine();
        }
        int key, option;
        int count = 0;
        for (int i = 0; i < Handle.n; i++) {
            if (Handle.listAccount[i].getEmployee().getContract().getContractID().equalsIgnoreCase(idEdit)) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Contract don't exist!");
        } else {
            MenuContent.optionEdit();
            option = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < Handle.n; i++) {
                switch (option) {
                    case 1:
                        if (Handle.listAccount[i].getEmployee().getContract().getContractID()
                                .equalsIgnoreCase(idEdit)) {
                            System.out.println("\n ----------------------------------------------");
                            System.out.println(" | 1.Change time start                        |");
                            System.out.println(" | 2.Change time end                          |");
                            System.out.println(" ----------------------------------------------");
                            System.out.print("==> Input option:");
                            key = Integer.parseInt(scanner.nextLine());
                            System.out.println();
                            switch (key) {
                                case 1:
                                    Handle.listAccount[i].getEmployee().getContract().setTimeStart(null);
                                    break;
                                case 2:
                                    Handle.listAccount[i].getEmployee().getContract().setTimeEnd(null);
                                    break;
                                default:
                                    MenuContent.noteBye();
                                    break;
                            }
                        }
                        break;
                    case 2:
                        if (Handle.listAccount[i].getEmployee().getContract().getContractID()
                                .equalsIgnoreCase(idEdit)) {
                            Handle.listAccount[i].getEmployee().getContract().input();
                        }
                        break;
                    default:
                        MenuContent.choiceWrong();
                        break;
                }
                // MenuContent.noteChangeSuccess();
            }
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
        for (int i = 0; i < Handle.n; i++) {
            if (Handle.listAccount[i].getEmployee().getContract().getContractID().equalsIgnoreCase(idRemove)) {
                for (int j = i; j < Handle.n - 1; j++) {
                    Handle.listAccount[j] = Handle.listAccount[j + 1];

                }
                Handle.listAccount[Handle.n - 1] = null;
                Handle.n--;
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

        for (int i = 0; i < Handle.n; i++) {
            if (Handle.listAccount[i].getEmployee().getContract() == null) {
                continue;
            }
            if (idSearch.equals(Handle.listAccount[i].getEmployee().getIdEmp())) {
                System.out.println(
                        "     -------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf(
                        "    %-15s|   %-15s|   %-15s|   %-15s|   %-15s|    %-15s|   %-15s|    %-15s|",
                        "ID Contract", "Name", "Gender", "Age", "Phone number", "Email",
                        "Time start",
                        "Time end");
                System.out.println();
                System.out.println(
                        "     -------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("    %-15s|   %-15s|   %-15s|   %-15s|   %-15s|    %-15s|   %-15s|    %-15s|",
                        Handle.listAccount[i].getEmployee().getContract().getContractID(),
                        Handle.listAccount[i].getEmployee().getName(),
                        Handle.listAccount[i].getEmployee().getGender(),
                        Handle.listAccount[i].getEmployee().getAge(),
                        Handle.listAccount[i].getEmployee().getPhone(),
                        Handle.listAccount[i].getEmployee().getEmail(),
                        Handle.listAccount[i].getEmployee().getContract().getTimeStart(),
                        Handle.listAccount[i].getEmployee().getContract().getTimeEnd());
                System.out.println(
                        "---------------------------------------------------------------------------------------------------------------------------------");
                check = true;
                break;
            }
        }
        if (!check)
            System.out.println("------------ Don't have data for contract ---------------");
    }

    @Override
    public void statistics() {
        MenuContent.quantityCount("Contract",Handle.n);
    }

    public static void statistical() {
    }
}
