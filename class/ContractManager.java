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
    public Employee listEmployees[] = new Employee[100];
    protected String listEmployeeTxt = "C:/Users/ADMIN/Documents/DoAnOOP/OOP/OOP/Đồ án oop/File/employee.txt";

    public ContractManager() {

    }

    public ContractManager(int n, Contract[] ContractManager) {
        this.n = n;
        this.ContractManager = ContractManager;
    }

    public void updateDataEmployee() {
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
            // TODO: handle exception
        }
    }

    @Override
    public void inputList() {
        updateDataEmployee();
        System.out.println("NHAP HOP DONG");
        System.out.println("Nhap so luong hop dong: ");
        while (true) {
            try {
                n = Integer.parseInt(sc.nextLine());
                if (n > 0) {
                    break;
                } else {
                    System.out.println("So luong phai lon hon 0.Vui long nhap lai: ");
                }
            } catch (Exception e) {
                System.out.println("Nhap sai.Nhap lai: ");
            }
        }
        ContractManager = new Contract[n];
        for (int i = 0; i < n; i++) {
            System.out.println("So luong hop dong: " + n);
            System.out.println("Nhap hop dong thu " + (i + 1 + ":"));
            ContractManager[i] = new Contract();
            ContractManager[i].input();
        }
        System.out.println("\nNhap danh sach thanh cong!");
    }

    @Override
    public void outputList() {
        System.out.println("XUAT HOP DONG");
        if (ContractManager.length == 0) {
            System.out.println("Chua co du lieu");
        } else {
            System.out.println(
                    "     ----------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf(
                    "    %-15s|   %-15s|   %-15s|   %-15s|   %-15s|    %-15s|   %-15s|    %-15s|",
                    "Ma hop dong", "Ho ten", "Gioi tinh", "Ngay sinh", "So dien thoai", "Email", "Ngay bat dau",
                    "Ngay ket thuc");
            System.out.println();
            System.out.println(
                    "     ----------------------------------------------------------------------------------------------------------------------------------");
            for (Contract e : ContractManager) {

                e.output();

                System.out.println();
            }
        }
        // System.out.println("----------------------------------------------------");
    }

    @Override
    public void add() {
        System.out.println("THEM DU LIEU");
        int count = 0;

        Contract x = new Contract();
        x.setContractID(null);
        for (Contract e : ContractManager) {
            if (e.getContractID().equalsIgnoreCase(x.getContractID())) {
                count++;
            }
        }
        if (count != 0) {
            System.out.println("Hop dong da ton tai");
        } else {
            System.out.println("So luong hop dong dang co: " + n);
            x.setTimeStart(null);
            x.setTimeEnd(null);
            ContractManager = Arrays.copyOf(ContractManager, n + 1);
            ContractManager[n] = x;
            n++;
            System.out.println("Da them thanh cong!");
        }
    }

    @Override
    public void edit() {
        System.out.println("SUA THONG TIN");
        String idTemp;
        int key;
        System.out.println("Nhap ma hop dong can sua");
        idTemp = sc.nextLine();
        int count = 0;
        for (Contract e : ContractManager) {
            if (e.getContractID().equalsIgnoreCase(idTemp)) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Ma hop dong khong ton tai");
        } else {
            for (Contract e : ContractManager) {
                if (e.getContractID().equalsIgnoreCase(idTemp)) {
                    System.out.println("\n---------------------------------------------");
                    System.out.println("  |  1.Sua ngay bat dau                       |");
                    System.out.println("  |  2.Sua ngay ket thuc                      |");
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
                            System.out.println("\nLua chon khong ton tai!\n");
                            break;
                    }
                }
            }
            System.out.println("Sua thanh cong!!");
        }
    }

    @Override
    public void remove() {
        System.out.println("SUA THONG TIN");
        String idTemp;
        System.out.print("Nhap ma hop dong can xoa: ");
        idTemp = sc.nextLine();
        int count = 0;
        for (Contract e : ContractManager) {
            if (e.getContractID().equalsIgnoreCase(idTemp)) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Ma hop dong khong ton tai");
        } else {
            for (int i = 0; i < n; i++) {
                if (ContractManager[i].getContractID().equalsIgnoreCase(idTemp)) {
                    ContractManager[i] = ContractManager[i + 1];
                }
                ContractManager = Arrays.copyOf(ContractManager, n - 1);
                n--;
            }
        }
        System.out.println("Xoa thanh cong!!!");
    }

    @Override
    public void find() {
        System.out.println("TIM KIEM DU LIEU");
        String idFind;
        System.out.println("Nhap ma hop dong can tim: ");
        idFind = sc.nextLine();
        int count = 0;
        for (Contract e : ContractManager) {
            if (e.getContractID().equalsIgnoreCase(idFind)) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Ma hop dong khong ton tai!");
        } else {
            for (Contract e : ContractManager) {
                if (e.getContractID().equalsIgnoreCase(idFind)) {
                    e.output();
                }
            }
        }
    }

    // @Override
    // public void readFile() {
    // try {
    // FileReader fr = new FileReader(
    // "C:/Users/ADMIN/eclipse-workspace/ProjectOOP/src/projectOOP/text/contract.txt");
    // BufferedReader br = new BufferedReader(fr);
    // String line = "";
    // while (true) {
    // line = br.readLine();
    // if (line == null) {
    // break;
    // }
    // String s[] = line.split(", ");
    // String contractid = s[0];
    // String name = s[1];
    // // int s2 = Integer.parseInt(s[2]);
    // // int tuoi = s2;
    // String gender = s[2];
    // String dob = s[3];
    // String phone = s[4];
    // String email = s[5];
    // String timestart = s[6];
    // String timeend = s[7];
    // ContractManager = Arrays.copyOf(ContractManager, n + 1);
    // ContractManager[n] = new contract(contractid, name, gender, dob, phone,
    // email, timestart, timeend);
    // n++;
    // }
    // br.close();
    // fr.close();
    // } catch (Exception e) {

    // }
    // }

    // @Override
    // public void WriteFile() {
    // try {
    // FileWriter fw = new FileWriter("./text/contract.txt");
    // BufferedWriter bw = new BufferedWriter(fw);
    // for (contract e : ContractManager) {
    // bw.write(e.toStringContract());
    // // bw.write(e.toStringNguoi());
    // bw.newLine();
    // }
    // bw.close();
    // fw.close();
    // } catch (Exception e) {

    // }
    // }

    // public static void thongKe() {
    // contractmanager dshd = new contractmanager();
    // dshd.ReadFile();
    // System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - - - - -
    // -");
    // System.out.println("\n THONG KE KHACH HANG");
    // System.out.println(" - So luong khach hang: " +
    // ContractManager.ContractManager.length);
    // }

}
