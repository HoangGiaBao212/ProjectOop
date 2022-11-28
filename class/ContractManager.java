import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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
        System.out.println("Output the List of Contract");
        if (Handle.n < 0 || Handle.listEmployees[0].getContract() == null) {
            System.out.println("\t\t--------------------------------------------");
            System.out.println("\t\t|           No data in the list            |");
            System.out.println("\t\t--------------------------------------------");
        } else {
            System.out.println(
                    "-------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("    %-15s|   %-20s|   %-15s|   %-15s|   %-15s|    %-20s|   %-20s|    %-20s|",
                    "Contrac ID", "Name", "Gender", "Age", "Phone number", "Email", "Time start", "Time end");
            System.out.println();
            System.out.println(
                    "-------------------------------------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < Handle.n; i++) {
                System.out.printf("    %-15s|   %-20s|   %-15s|   %-15s|   %-15s|    %-20s|   %-20s|    %-20s|\n",
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
            }
        }
    }

    @Override
    public void add() {
        System.out.println("---------------------------------------");
        System.out.println("|             ADD CONTRACT            |");
        System.out.println("---------------------------------------");

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
        System.out.println("| EDIT INFORMATION IN CONTRACT |");
        System.out.println("----------------------------------------------------");
        String idTemp;
        int key;
        System.out.print("Enter an contract ID to edit: ");
        idTemp = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < Handle.n; i++) {
            if (Handle.listContracts[i].getContractID().equalsIgnoreCase(idTemp)) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Contract don't exist!");
        } else {
            for (int i = 0; i < Handle.n; i++) {
                if (Handle.listContracts[i].getContractID().equalsIgnoreCase(idTemp)) {
                    System.out.println("\n---------------------------------------------");
                    System.out.println(" | 1.Change time start                        |");
                    System.out.println(" | 2.Change time end                          |");
                    System.out.println(" ---------------------------------------------");
                    System.out.print("==> Nhap lua chon:");
                    key = Integer.parseInt(scanner.nextLine());
                    System.out.println();
                    switch (key) {
                        case 1:
                            Handle.listContracts[i].setTimeStart(null);
                            break;
                        case 2:
                            Handle.listContracts[i].setTimeEnd(null);
                            break;
                        default:
                            System.out.println("--------------------------------------------");
                            System.out.println("|            Choice don't exist            |");
                            System.out.println("--------------------------------------------");
                            break;
                    }
                }
            }
            System.out.println("------------------------------------------------------");
            System.out.println("| Edit Information Successful! |");
            System.out.println("------------------------------------------------------");
        }
    }

    // @Override
    // public void remove() {
    // System.out.println("-------------------------------------------------");
    // System.out.println("| REMOVE EMPLOYEE |");
    // System.out.println("-------------------------------------------------");
    // System.out.println("Enter id of employee to remove(Ex:E001): ");
    // String idRemove = scanner.nextLine();
    // boolean check = false;
    // System.out.println(Handle.n);
    // for (int i = 0; i < Handle.n; i++) {
    // if (Handle.listEmployees[i].getIdEmp().equalsIgnoreCase(idRemove)) {
    // for (int j = i; j < Handle.n - 1; j++) {
    // Handle.listEmployees[j] = Handle.listEmployees[j + 1];
    // }
    // Handle.listEmployees[Handle.n - 1] = null;
    // Handle.n--;
    // System.out.println("-------------------------------------------------");
    // System.out.println("| Remove successful! |");
    // System.out.println("-------------------------------------------------");
    // check = true;
    // break;
    // }
    // }
    // if (!check) {
    // System.out.println("-------------------------------------------------");
    // System.out.println("| Remove successful! |");
    // System.out.println("-------------------------------------------------");
    // }
    // }

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
        System.out.println("\n-----------------------------------------------");
        System.out.println("  |             THONG KE KHACH HANG|            |");
        System.out.println("-----------------------------------------------");
    }

    @Override
    public void remove() {

    }
}
