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
        for (Employee employee : FileUtil.listEmployees) {
            if (employee == null)
                break;
            if ((employee.getIdEmp().equals(IdEmp)) && employee.getSalary() == null)
                return true;
        }
        return false;
    }

    // public static void updateDataEmployee() {
    // n = -1;
    // try {
    // FileReader fr = new FileReader(listEmployeeTxt);
    // try (BufferedReader br = new BufferedReader(fr)) {
    // String line = "";
    // while (true) {
    // n++;
    // line = br.readLine();
    // if (line == null) {
    // break;
    // }
    // String[] txt = line.split("-");
    // String idEmp = txt[0];
    // String position = txt[1];
    // String name = txt[2];
    // int age = Integer.parseInt(txt[3]);
    // String gender = txt[4];
    // String email = txt[5];
    // String address = txt[6];
    // String phone = txt[7];
    // Employee x = new Employee(name, age, gender, email, address, phone, idEmp,
    // position);
    // listEmployees[n] = x;
    // }
    // }
    // } catch (Exception e) {
    // System.out.println("--------------------------------------------------");
    // System.out.println("| Hello World |");
    // System.out.println("--------------------------------------------------");

    // }
    // }

    @Override
    public void inputList() {
        System.out.println("-------------------------------------------------");
        System.out.println("|              ADD LIST OF CONTRACT             |");
        System.out.println("-------------------------------------------------");

        for (int i = 0; i < FileUtil.n; i++) {
            System.out.println(FileUtil.n);
            System.out
                    .println("Enter information contract of employee with id: " + FileUtil.listEmployees[i].getIdEmp());
            Contract contract = new Contract();
            contract.input();
            FileUtil.listEmployees[i].setContract(contract);
        }

        System.out.println("---------------------------------------");
        System.out.println("|          Add list successful!       |");
        System.out.println("---------------------------------------");
    }

    @Override
    public void outputList() {
        System.out.println("Output the List of Contract");
        if (FileUtil.n < 0) {
            System.out.println("No data in the list");
        } else {
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
        }
        for (int i = 0; i < FileUtil.n; i++) {
            System.out.printf("    %-15s|   %-15s|   %-15s|   %-15s|   %-15s|    %-15s|   %-15s|    %-15s|",
                    FileUtil.listEmployees[i].getContract().getContractID(),
                    FileUtil.listEmployees[i].getName(),
                    FileUtil.listEmployees[i].getGender(),
                    FileUtil.listEmployees[i].getAge(),
                    FileUtil.listEmployees[i].getPhone(),
                    FileUtil.listEmployees[i].getEmail(),
                    FileUtil.listEmployees[i].getContract().getTimeStart(),
                    FileUtil.listEmployees[i].getContract().getTimeEnd());
            System.out.println(
                    "---------------------------------------------------------------------------------------------------------------------------------");
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
            for (int i = 0; i < FileUtil.n; i++) {
                if (FileUtil.listEmployees[i].getIdEmp().equals(idEmpAdd)) {
                    if (FileUtil.listEmployees[i].getContract() == null) {
                        Contract contract = new Contract();
                        contract.input();
                        FileUtil.listEmployees[i].setContract(contract);
                    }
                }
            }
        } else
            System.out.println("Employee is exits or don't have employee with id: " + idEmpAdd);

        System.out.println("---------------------------------------------------------");
        System.out.println("|               Add Contract Successful!                |");
        System.out.println("---------------------------------------------------------");
    }

    // @Override
    // public void edit() {
    // System.out.println("----------------------------------------------------");
    // System.out.println("| EDIT INFORMATION IN CONTRACT |");
    // System.out.println("----------------------------------------------------");
    // String idTemp;
    // int key;
    // System.out.print("Enter an contract ID to edit: ");
    // idTemp = sc.nextLine();
    // int count = 0;
    // for (Contract e : ContractManager) {
    // if (e.getContractID().equalsIgnoreCase(idTemp)) {
    // count++;
    // }
    // }
    // if (count == 0) {
    // System.out.println("Contract don't exist!");
    // } else {
    // for (Contract e : ContractManager) {
    // if (e.getContractID().equalsIgnoreCase(idTemp)) {
    // System.out.println("\n---------------------------------------------");
    // System.out.println(" | 1.Change time start |");
    // System.out.println(" | 2.Change time end |");
    // System.out.println(" ---------------------------------------------");
    // System.out.print("==> Nhap lua chon:");
    // key = Integer.parseInt(sc.nextLine());
    // System.out.println();
    // switch (key) {
    // case 1:
    // e.setTimeStart(null);
    // break;
    // case 2:
    // e.setTimeEnd(null);
    // break;
    // default:
    // System.out.println("--------------------------------------------");
    // System.out.println("| Choice don't exist |");
    // System.out.println("--------------------------------------------");
    // break;
    // }
    // }
    // }
    // System.out.println("------------------------------------------------------");
    // System.out.println("| Edit Information Successful! |");
    // System.out.println("------------------------------------------------------");
    // }
    // }

    // @Override
    // public void remove() {
    // System.out.println("-------------------------------------------------");
    // System.out.println("| REMOVE CONTRACT |");
    // System.out.println("-------------------------------------------------");
    // String idTemp;
    // System.out.print("Enter contract ID to remove: ");
    // idTemp = sc.nextLine();
    // int count = 0;
    // for (Contract e : ContractManager) {
    // if (e.getContractID().equalsIgnoreCase(idTemp)) {
    // count++;
    // }
    // }
    // if (count == 0) {
    // System.out.println("The contract don't exist");
    // } else {
    // for (int i = 0; i < n; i++) {
    // if (ContractManager[i].getContractID().equalsIgnoreCase(idTemp)) {
    // ContractManager[i] = ContractManager[i + 1];
    // }
    // ContractManager = Arrays.copyOf(ContractManager, n - 1);
    // n--;
    // }
    // }
    // System.out.println("-------------------------------------------------");
    // System.out.println("| Remove successful! |");
    // System.out.println("-------------------------------------------------");
    // }

    @Override
    public void remove() {
        System.out.println("-------------------------------------------------");
        System.out.println("|              REMOVE EMPLOYEE                  |");
        System.out.println("-------------------------------------------------");
        System.out.println("Enter id of employee to remove(Ex:E001): ");
        String idRemove = scanner.nextLine();
        boolean check = false;
        System.out.println(FileUtil.n);
        for (int i = 0; i < FileUtil.n; i++) {
            if (FileUtil.listEmployees[i].getIdEmp().equalsIgnoreCase(idRemove)) {
                for (int j = i; j < FileUtil.n - 1; j++) {
                    FileUtil.listEmployees[j] = FileUtil.listEmployees[j + 1];
                }
                FileUtil.listEmployees[FileUtil.n - 1] = null;
                FileUtil.n--;
                System.out.println("-------------------------------------------------");
                System.out.println("|               Remove successful!              |");
                System.out.println("-------------------------------------------------");
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("-------------------------------------------------");
            System.out.println("|               Remove successful!              |");
            System.out.println("-------------------------------------------------");
        }
    }

    // @Override
    // public void find() {
    // System.out.println("-------------------------------------------------");
    // System.out.println("| SEARCH CONTRACT |");
    // System.out.println("-------------------------------------------------");
    // String idFind;
    // System.out.print("Enter contract ID to find: ");
    // idFind = sc.nextLine();
    // int count = 0;
    // for (Contract e : ContractManager) {
    // if (e.getContractID().equalsIgnoreCase(idFind)) {
    // count++;
    // }
    // }
    // if (count == 0) {
    // System.out.println("The contract don't exist!");
    // } else {
    // for (Contract e : ContractManager) {
    // if (e.getContractID().equalsIgnoreCase(idFind)) {
    // System.out.println("-------------------------------------------------");
    // System.out.println("| Find Successful! |");
    // System.out.println("-------------------------------------------------");
    // e.output();
    // }
    // }
    // }
    // }

    @Override
    public void find() {
        String idFind;
        System.out.print("Enter id of employee to search(Ex:E001): ");
        idFind = scanner.nextLine();

        for (int i = 0; i < FileUtil.n; i++) {
            if (idFind.equals(FileUtil.listEmployees[i].getIdEmp())) {
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
                        FileUtil.listEmployees[i].getContract().getContractID(),
                        FileUtil.listEmployees[i].getName(),
                        FileUtil.listEmployees[i].getGender(),
                        FileUtil.listEmployees[i].getAge(),
                        FileUtil.listEmployees[i].getPhone(),
                        FileUtil.listEmployees[i].getEmail(),
                        FileUtil.listEmployees[i].getContract().getTimeStart(),
                        FileUtil.listEmployees[i].getContract().getTimeEnd());
                System.out.println(
                        "---------------------------------------------------------------------------------------------------------------------------------");

                break;
            }
        }
    }

    public static void thongKe() {
        // ContractManager dshd = new ContractManager();
        System.out.println("\n-----------------------------------------------");
        System.out.println("  |             THONG KE KHACH HANG|            |");
        System.out.println("-----------------------------------------------");

        // System.out.println(" - So luong khach hang: "
        // +ContractManager.ContractManager.length);
    }

    @Override
    public void edit() {
        // TODO Auto-generated method stub

    }
}
