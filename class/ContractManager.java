
// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.FileReader;
// import java.io.FileWriter;
import java.util.*;

public class ContractManager implements RoleOfManager {
    // new list ContractManager
    Scanner scanner = new Scanner(System.in);

    public ContractManager() {
    }

    public boolean checkIdEmployee(String IdEmp) {
        for (Employee employee : Handle.listEmployees) {
            if (employee == null)
                break;
            if ((employee.getIdEmp().equals(IdEmp)) && employee.getSalary() == null)
                return true;
        }
        return false;
    }

    @Override
    public void inputList() {
        System.out.println("-------------------------------------------------");
        System.out.println("|              ADD LIST OF CONTRACT             |");
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < Handle.n; i++) {
            System.out.println(Handle.n);
            System.out.println("Enter information contract of employee with id: " + Handle.listEmployees[i].getIdEmp());
            Contract contract = new Contract();
            contract.input();
            Handle.listEmployees[i].setContract(contract);
        }

        System.out.println("---------------------------------------");
        System.out.println("|          Add list successful!       |");
        System.out.println("---------------------------------------");
    }

    @Override
    public void outputList() {
        Handle.clearScreen();
        System.out.println("Output the List of Contract\n");
        System.out.println(Handle.n);
        System.out.println(
                "-------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("|    %-15s|   %-20s|   %-10s|   %-10s|   %-15s|    %-25s|   %-10s|    %-10s|",
                "Contract ID", "Name", "Gender", "Age", "Phone number", "Email", "Time start", "Time end");
        System.out.println();
        System.out.println(
                "-------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < Handle.n; i++) {
            System.out.printf("|    %-15s|   %-20s|   %-10s|   %-10s|   %-15s|    %-25s|   %-10s|    %-10s|\n",
                    Handle.listEmployees[i].getContract().getContractID(),
                    Handle.listEmployees[i].getName(),
                    Handle.listEmployees[i].getGender(),
                    Handle.listEmployees[i].getAge(),
                    Handle.listEmployees[i].getPhone(),
                    Handle.listEmployees[i].getEmail(),
                    Handle.listEmployees[i].getContract().getTimeStart(),
                    Handle.listEmployees[i].getContract().getTimeEnd());
            System.out.println(
                    "-------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }

    @Override
    public void add() {
        System.out.println("---------------------------------------");
        System.out.println("|             ADD CONTRACT            |");
        System.out.println("---------------------------------------\n");
        System.out.println("Enter Employee ID to find: ");
        String idEmpAdd;
        idEmpAdd = scanner.nextLine();
        if (checkIdEmployee(idEmpAdd)) {
            for (int i = 0; i < Handle.n; i++) {
                if (Handle.listEmployees[i].getIdEmp().equals(idEmpAdd)) {
                    if (Handle.listEmployees[i].getContract() == null) {
                        Contract contract = new Contract();
                        contract.input();
                        Handle.listEmployees[i].setContract(contract);
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
    public void edit() {
        System.out.println("----------------------------------------------------");
        System.out.println("|            EDIT INFORMATION IN CONTRACT          |");
        System.out.println("----------------------------------------------------");
        String idTemp;
        int key,option;
        System.out.print("Enter an contract ID to edit: ");
        idTemp = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < Handle.n; i++) {
            if (Handle.listEmployees[i].getContract().getContractID().equalsIgnoreCase(idTemp)) {
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
                        if (Handle.listEmployees[i].getContract().getContractID().equalsIgnoreCase(idTemp)) {
                            System.out.println("\n ----------------------------------------------");
                            System.out.println(" | 1.Change time start                        |");
                            System.out.println(" | 2.Change time end                          |");
                            System.out.println(" ----------------------------------------------");
                            System.out.print("==> Input option:");
                            key = Integer.parseInt(scanner.nextLine());
                            System.out.println();
                            switch (key) {
                                case 1:
                                    Handle.listEmployees[i].getContract().setTimeStart(null);
                                    break;
                                case 2:
                                    Handle.listEmployees[i].getContract().setTimeEnd(null);
                                    break;
                                default:
                                    MenuContent.noteBye();
                                    break;
                            }
                        }
                        break;
                    case 2:
                        if(Handle.listEmployees[i].getContract().getContractID().equalsIgnoreCase(idTemp)){
                            Handle.listEmployees[i].getContract().input();
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
    public void remove() {
        System.out.println("-----------------------------------------------");
        System.out.println("|               REMOVE CONTRACT               |");
        System.out.println("-----------------------------------------------");
        System.out.println("Enter id of contract to remove(Ex:C001): ");
        String idRemove = scanner.nextLine();
        boolean check = false;
        for (int i = 0; i < Handle.n; i++) {
            if (Handle.listEmployees[i].getContract().getContractID().equalsIgnoreCase(idRemove)) {
                for (int j = i; j < Handle.n - 1; j++) {
                    Handle.listEmployees[j] = Handle.listEmployees[j + 1];

                }
                Handle.listEmployees[Handle.n - 1] = null;
                Handle.n--;
                check = true;
                break;
            }
        }
        if (!check) {
            MenuContent.noteRemoveFailure();
        }
        MenuContent.noteRemoveSuccess();
    }

    @Override
    public void find() {
        String idFind;
        System.out.print("Enter id of employee to search(Ex:E001): ");
        idFind = scanner.nextLine();

        for (int i = 0; i < Handle.n; i++) {
            if (idFind.equals(Handle.listEmployees[i].getIdEmp())) {
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
                        Handle.listEmployees[i].getContract().getContractID(),
                        Handle.listEmployees[i].getName(),
                        Handle.listEmployees[i].getGender(),
                        Handle.listEmployees[i].getAge(),
                        Handle.listEmployees[i].getPhone(),
                        Handle.listEmployees[i].getEmail(),
                        Handle.listEmployees[i].getContract().getTimeStart(),
                        Handle.listEmployees[i].getContract().getTimeEnd());
                System.out.println(
                        "---------------------------------------------------------------------------------------------------------------------------------");

                break;
            }
        }
    }

    public static void thongKe() {
    }
}
