import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class ContractManager implements RoleOfManager {
    // new list ContractManager
    Scanner sc = new Scanner(System.in);
    public static int n = 0;
    public static Contract ContractManager[] = new Contract[0];
    public static Employee listEmployees[] = new Employee[100];
    protected static String listEmployeeTxt = "./File/employee.txt";
    protected static String listContractTxt = "./File/contract.txt";

    public ContractManager() {
    }

    public ContractManager(int n, Contract[] ContractManager) {
        this.n = n;
        this.ContractManager = ContractManager;
    }

    public static void updateDataEmployee() {
        n = -1;
        try {
            FileReader fr = new FileReader(listEmployeeTxt);
            try (BufferedReader br = new BufferedReader(fr)) {
                String line = "";
                while (true) {
                    n++;
                    line = br.readLine();
                    if (line == null) {
                        break;
                    }
                    String[] txt = line.split("-");
                    String idEmp = txt[0];
                    String position = txt[1];
                    String name = txt[2];
                    int age = Integer.parseInt(txt[3]);
                    String gender = txt[4];
                    String email = txt[5];
                    String address = txt[6];
                    String phone = txt[7];
                    Employee x = new Employee(name, age, gender, email, address, phone, idEmp, position);
                    listEmployees[n] = x;
                }
            }
        } catch (Exception e) {
            System.out.println("--------------------------------------------------");
            System.out.println("|                   Hello World                  |");
            System.out.println("--------------------------------------------------");

        }
    }

    @Override
    public void inputList() {
        updateDataEmployee();
        System.out.println("-------------------------------------------------");
        System.out.println("|              ADD LIST OF CONTRACT             |");
        System.out.println("-------------------------------------------------");
        System.out.print("Enter an amount of contract to add: ");
        while (true) {
            try {
                n = Integer.parseInt(sc.nextLine());
                if (n > 0) {
                    break;
                } else {
                    System.out.println("The amount must great than 0.Please enter again: ");
                }
            } catch (Exception e) {
                System.out.println("Wrong.Please enter again: ");
            }
        }
        ContractManager = new Contract[n];
        for (int i = 0; i < n; i++) {
            // System.out.println("So luong hop dong: " + n);
            System.out.println("Enter the information of contract " + (i + 1 + ":"));
            ContractManager[i] = new Contract();
            ContractManager[i].input();
        }
        System.out.println("---------------------------------------");
        System.out.println("|          Add list successful!       |");
        System.out.println("---------------------------------------");
    }

    @Override
    public void outputList() {
        System.out.println("Output the List of Contract");
        if (ContractManager.length == 0) {
            System.out.println("No data in the list");
        } else {
            System.out.println(
                    "     -------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf(
                    "    %-15s|   %-15s|   %-15s|   %-15s|   %-15s|    %-15s|   %-15s|    %-15s|",
                    "Contract ID","Name", "Gender", "Date of Birth", "Phone number", "Email", "Time start","Time end");
            System.out.println();
            System.out.println(
                    "     -------------------------------------------------------------------------------------------------------------------------------------");
            for (Contract e : ContractManager) {
                e.output();
                System.out.println();
            }
        }
        // System.out.println("----------------------------------------------------");
    }

    @Override
    public void add() {
        System.out.println("---------------------------------------");
        System.out.println("|             ADD CONTRACT            |");
        System.out.println("---------------------------------------");
        int count = 0;
        Contract x = new Contract();
        x.setContractID(null);
        for (Contract e : ContractManager) {
            if (e.getContractID().equalsIgnoreCase(x.getContractID())) {
                count++;
            }
        }
        if (count != 0) {
            System.out.println("Contract is already in the list");
        } else {
            System.out.println("So luong hop dong dang co: " + n);
            x.setTimeStart(null);
            x.setTimeEnd(null);
            ContractManager = Arrays.copyOf(ContractManager, n + 1);
            ContractManager[n] = x;
            n++;
            System.out.println("---------------------------------------------------------");
            System.out.println("|               Add Contract Successful!                |");
            System.out.println("---------------------------------------------------------");

        }
    }

    @Override
    public void edit() {
        System.out.println("----------------------------------------------------");
        System.out.println("|           EDIT INFORMATION IN CONTRACT           |");
        System.out.println("----------------------------------------------------");
        String idTemp;
        int key;
        System.out.print("Enter an contract ID to edit: ");
        idTemp = sc.nextLine();
        int count = 0;
        for (Contract e : ContractManager) {
            if (e.getContractID().equalsIgnoreCase(idTemp)) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Contract don't exist!");
        } else {
            for (Contract e : ContractManager) {
                if (e.getContractID().equalsIgnoreCase(idTemp)) {
                    System.out.println("\n---------------------------------------------");
                    System.out.println("  |  1.Change time start                      |");
                    System.out.println("  |  2.Change time end                        |");
                    System.out.println("  ---------------------------------------------");
                    System.out.print("==> Nhap lua chon:");
                    key = Integer.parseInt(sc.nextLine());
                    System.out.println();
                    switch (key) {
                        case 1:
                            e.setTimeStart(null);
                            break;
                        case 2:
                            e.setTimeEnd(null);
                            break;
                        default:
                            System.out.println("--------------------------------------------");
                            System.out.println("|           Choice don't exist             |");
                            System.out.println("--------------------------------------------");
                            break;
                    }
                }
            }
            System.out.println("------------------------------------------------------");
            System.out.println("|           Edit Information Successful!             |");
            System.out.println("------------------------------------------------------");
        }
    }

    @Override
    public void remove() {
        System.out.println("-------------------------------------------------");
        System.out.println("|              REMOVE CONTRACT                  |");
        System.out.println("-------------------------------------------------");
        String idTemp;
        System.out.print("Enter contract ID to remove: ");
        idTemp = sc.nextLine();
        int count = 0;
        for (Contract e : ContractManager) {
            if (e.getContractID().equalsIgnoreCase(idTemp)) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("The contract don't exist");
        } else {
            for (int i = 0; i < n; i++) {
                if (ContractManager[i].getContractID().equalsIgnoreCase(idTemp)) {
                    ContractManager[i] = ContractManager[i + 1];
                }
                ContractManager = Arrays.copyOf(ContractManager, n - 1);
                n--;
            }
        }
        System.out.println("-------------------------------------------------");
        System.out.println("|               Remove successful!              |");
        System.out.println("-------------------------------------------------");
    }

    @Override
    public void find() {
        System.out.println("-------------------------------------------------");
        System.out.println("|                SEARCH CONTRACT                |");
        System.out.println("-------------------------------------------------");
        String idFind;
        System.out.print("Enter contract ID to find: ");
        idFind = sc.nextLine();
        int count = 0;
        for (Contract e : ContractManager) {
            if (e.getContractID().equalsIgnoreCase(idFind)) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("The contract don't exist!");
        } else {
            for (Contract e : ContractManager) {
                if (e.getContractID().equalsIgnoreCase(idFind)) {
                    System.out.println("-------------------------------------------------");
                    System.out.println("|                 Find Successful!              |");
                    System.out.println("-------------------------------------------------");
                    e.output();
                }
            }
        }
    }
    static void readFile() {
        n = -1;
        try {
            FileReader fr = new FileReader(listContractTxt);
            try (BufferedReader br = new BufferedReader(fr)) {
                String line = "";
                while (true) {
                    line = br.readLine();
                    if (line == null) {
                        break;
                    }
                    n++;
                    String[] txt = line.split("-");
                    String idEmp = txt[0];
                    String ContracID = txt[3];
                    String timeStart = txt[4];
                    String timeEnd = txt[5];
                    Contract contract = new Contract(ContracID, timeStart, timeEnd);
                    n++;
                    }
                    System.out.println(n);
                }
            }catch(Exception e){
                System.out.println("Hello world");
            }
        }
    public static void writeFile() {
        try {
            FileWriter fw = new FileWriter(listContractTxt);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Contract e : ContractManager) {
                if (e == null) {
                    break;
                }
                // if (C.getSalary() != null) {
                //     bw.write(employee.getIdEmp() + "-" + employee.getName() + "-" + employee.getPosition() + "-"
                //             + employee.getSalary().toString());
                //     bw.newLine();
                // }
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("Don't have data for salary! ");
        }
    }

    public static void thongKe() {
    // ContractManager dshd = new ContractManager();
    System.out.println("\n-----------------------------------------------");
    System.out.println("  |             THONG KE KHACH HANG|            |");
    System.out.println("-----------------------------------------------");

    // System.out.println(" - So luong khach hang: " +ContractManager.ContractManager.length);
    }
}
