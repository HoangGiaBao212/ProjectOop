import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class DepartmentManager implements RoleOfManager {
    Scanner sc = new Scanner(System.in);
    public static int n = 0;
    public static Department DepartmentManager[] = new Department[0];
    public static Employee listEmployees[] = new Employee[100];
    protected static String listEmployeeTxt = "./File/employee.txt";
    protected static String listDepartmentTxt = "./File/department.txt";

    public DepartmentManager(){

    }
    public DepartmentManager(int n,Department[] DepartmentManager){
        this.n = n;
        this.DepartmentManager = DepartmentManager;
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
        System.out.println("|              ADD LIST OF DEPARTMENT           |");
        System.out.println("-------------------------------------------------");
        System.out.print("Enter an amount of department to add: ");
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
        DepartmentManager = new Department[n];
        for (int i = 0; i < n; i++) {
            // System.out.println("So luong hop dong: " + n);
            System.out.println("Enter the information of department " + (i + 1 + ":"));
            DepartmentManager[i] = new Department();
            DepartmentManager[i].input();
        }
        System.out.println("---------------------------------------");
        System.out.println("|          Add list successful!       |");
        System.out.println("---------------------------------------");
    }

    @Override
    public void outputList() {
        System.out.println("Output the List of Contract");
        if (DepartmentManager.length == 0) {
            System.out.println("No data in the list");
        } else {
            System.out.println(
                    "     -------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf(
                    "    %-15s|   %-15s|   %-15s|   %-15s|   %-15s|   %-15s|    %-15s|   %-15s|    %-15s|",
                    "Department ID","Department Name","Chief Name", "Gender", "Date of Birth", "Phone number", "Email","Amount of Members");
            System.out.println();
            System.out.println(
                    "     -------------------------------------------------------------------------------------------------------------------------------------");
            for (Department d : DepartmentManager) {
                d.output();
                System.out.println();
            }
        }
        // System.out.println("----------------------------------------------------");
    }

    @Override
    public void add() {
        System.out.println("---------------------------------------");
        System.out.println("|             ADD DEPARTMENT          |");
        System.out.println("---------------------------------------");
        int count = 0;
        Department x = new Department();
        x.setDepartmentID(null);
        for (Department e : DepartmentManager) {
            if (e.getDepartmentID().equalsIgnoreCase(x.getDepartmentID())) {
                count++;
            }
        }
        if (count != 0) {
            System.out.println("Department is already in the list");
        } else {
            // System.out.println("So luong hop dong dang co: " + n);
            x.setDepartmentName(null);
            x.setChiefname(null);
            x.setMembers(0);
            DepartmentManager = Arrays.copyOf(DepartmentManager, n + 1);
            DepartmentManager[n] = x;
            n++;
            System.out.println("---------------------------------------------------------");
            System.out.println("|               Add Department Successful!                |");
            System.out.println("---------------------------------------------------------");

        }
    }

    @Override
    public void edit() {
        System.out.println("----------------------------------------------------");
        System.out.println("|           EDIT INFORMATION IN DEPARTMENT           |");
        System.out.println("----------------------------------------------------");
        String idTemp;
        int key;
        System.out.print("Enter an Department ID to edit: ");
        idTemp = sc.nextLine();
        int count = 0;
        for (Department e : DepartmentManager) {
            if (e.getDepartmentID().equalsIgnoreCase(idTemp)) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Department don't exist!");
        } else {
            for (Department e : DepartmentManager) {
                if (e.getDepartmentID().equalsIgnoreCase(idTemp)) {
                    System.out.println("\n---------------------------------------------");
                    System.out.println("  |  1.Change Department's name               |");
                    System.out.println("  |  2.Change Chief's name                    |");
                    System.out.println("  |  3.Change the numbers of member           |");
                    System.out.println("  ---------------------------------------------");
                    System.out.print("==> Input Option:");
                    key = Integer.parseInt(sc.nextLine());
                    System.out.println();
                    switch (key) {
                        case 1:
                            e.setDepartmentName(null);
                            break;
                        case 2:
                            e.setChiefname(null);
                            break;
                        case 3:
                            e.setMembers(0);
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
        System.out.println("|              REMOVE DEPARTMENT                |");
        System.out.println("-------------------------------------------------");
        String idTemp;
        System.out.print("Enter contract ID to remove: ");
        idTemp = sc.nextLine();
        int count = 0;
        for (Department e : DepartmentManager) {
            if (e.getDepartmentID().equalsIgnoreCase(idTemp)) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("The department don't exist");
        } else {
            for (int i = 0; i < n; i++) {
                if (DepartmentManager[i].getDepartmentID().equalsIgnoreCase(idTemp)) {
                    DepartmentManager[i] = DepartmentManager[i + 1];
                }
                DepartmentManager = Arrays.copyOf(DepartmentManager, n - 1);
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
        System.out.println("|                SEARCH DEPARTMENT              |");
        System.out.println("-------------------------------------------------");
        String idFind;
        System.out.print("Enter department ID to find: ");
        idFind = sc.nextLine();
        int count = 0;
        for (Department e : DepartmentManager) {
            if (e.getDepartmentID().equalsIgnoreCase(idFind)) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("The department don't exist!");
        } else {
            for (Department e : DepartmentManager) {
                if (e.getDepartmentID().equalsIgnoreCase(idFind)) {
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
            FileReader fr = new FileReader(listDepartmentTxt);
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
            FileWriter fw = new FileWriter(listDepartmentTxt);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Department e : DepartmentManager) {
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

}
