import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class FileUtil {

    /*
     * private static String listSalaryTxt =
     * "C:\\Users\\khang\\OneDrive\\Tài
     * liệu\\GitHub\\ProjectOop\\File\\salary.txt"
     * ;
     * private static String listContractTxt =
     * "C:\\Users\\khang\\OneDrive\\Tài
     * liệu\\GitHub\\ProjectOop\\File\\contract.txt"
     * ;
     * private static String listDepartmentTxt =
     * "C:\\Users\\khang\\OneDrive\\Tài
     * liệu\\GitHub\\ProjectOop\\File\\department.txt"
     * ;
     * private static String listAccountTxt =
     * "C:\\Users\\khang\\OneDrive\\Tài
     * liệu\\GitHub\\ProjectOop\\File\\account.txt"
     * ;
     */
    private static String listSalaryTxt = "./File/salary.txt";
    private static String listContractTxt = "./File/contract.txt";
    private static String listDepartmentTxt = "./File/department.txt";
    private static String listAccountTxt = "./File/account.txt";

    private FileUtil() {
    }

    public static void getData() {
        readFileAccount();
        readFileDepartment();
        readFileContract();
        readFileSalary();
    }

    public static void setData() {
        writeFileAccount();
        writeFileDepartment();
        writeFileContract();
        writeFileSalary();
    }

    private static void readFileAccount() {
        MenuHandle.n = -1;
        try {
            FileReader fr = new FileReader(listAccountTxt);
            try (BufferedReader br = new BufferedReader(fr)) {
                String line = "";
                while (true) {
                    MenuHandle.n++;
                    line = br.readLine();
                    if (line == null) {
                        break;
                    }
                    String[] txt = line.split("-");
                    String username = txt[0];
                    String password = txt[1];
                    // String user = txt[2];
                    String idEmp = txt[3];
                    String position = txt[4];
                    String name = txt[5];
                    int age = Integer.parseInt(txt[6]);
                    String gender = txt[7];
                    String email = txt[8];
                    String address = txt[9];
                    String phone = txt[10];
                    if (position.equals("Chief Of Department")) {
                        Employee employee = new ChiefDepartment(idEmp, position, name, age, gender, email, address,
                                phone);
                        MenuHandle.listAccount = Arrays.copyOf(MenuHandle.listAccount, MenuHandle.n + 1);
                        MenuHandle.listAccount[MenuHandle.n] = new Account(username, password, employee);
                    } else if (position.equals("Official Employee")) {
                        Employee employee = new OfficialEmployee(idEmp, position, name, age, gender, email, address,
                                phone);
                        MenuHandle.listAccount = Arrays.copyOf(MenuHandle.listAccount, MenuHandle.n + 1);
                        MenuHandle.listAccount[MenuHandle.n] = new Account(username, password, employee);
                    } else if (position.equals("Intern Employee")) {
                        Employee employee = new InternEmployee(idEmp, position, name, age, gender, email, address,
                                phone);
                        MenuHandle.listAccount = Arrays.copyOf(MenuHandle.listAccount, MenuHandle.n + 1);
                        MenuHandle.listAccount[MenuHandle.n] = new Account(username, password, employee);
                    } else {
                        Employee employee = new Employee(idEmp, position, name, age, gender, email, address, phone);
                        MenuHandle.listAccount = Arrays.copyOf(MenuHandle.listAccount, MenuHandle.n + 1);
                        MenuHandle.listAccount[MenuHandle.n] = new Account(username, password, employee);

                    }
                }
            }
        } catch (Exception e) {
        }
    }

    private static void writeFileAccount() {
        try {
            FileWriter fw = new FileWriter(listAccountTxt);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < MenuHandle.n; i++) {
                bw.write(MenuHandle.listAccount[i].toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }

    static void readFileSalary() {
        int i = -1;
        try {
            FileReader fr = new FileReader(listSalaryTxt);
            try (BufferedReader br = new BufferedReader(fr)) {
                String line = "";
                while (true) {
                    i++;
                    line = br.readLine();
                    if (line == null) {
                        break;
                    }
                    String[] txt = line.split("-");
                    int len = txt.length;
                    String idEmp = txt[0];
                    int j = 1;
                    while (true) {
                        if (MenuHandle.listAccount[i].getEmployee().getIdEmp().equalsIgnoreCase(idEmp)) {
                            // if (j == len || (Long.parseLong(txt[j]) == 0 && j % 14 == 0))
                            if (j == len)
                                break;
                            MenuHandle.listAccount[i].getEmployee().salaryDiary = Arrays
                                    .copyOf(MenuHandle.listAccount[i].getEmployee().salaryDiary, j + 1);
                            MenuHandle.listAccount[i].getEmployee().getSalaryDiary()[j - 1] = Long.parseLong(txt[j]);
                            j++;
                        } else {
                            i++;
                            j = 1;
                        }
                    }
                }
                br.close();
                fr.close();
            }

        } catch (Exception e) {
        }
    }

    public static void writeFileSalary() {
        try {
            FileWriter fw = new FileWriter(listSalaryTxt);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Account o : MenuHandle.listAccount) {
                if (o.getEmployee().getSalaryDiary()[0] == 0)
                    continue;
                bw.write(o.getEmployee().toStringSalary(o.getEmployee().getIdEmp()));
                bw.newLine();
            }
            bw.close();
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void readFileContract() {
        int i = -1;
        try {
            FileReader fr = new FileReader(listContractTxt);
            try (BufferedReader br = new BufferedReader(fr)) {
                String line = "";
                while (true) {
                    i++;
                    line = br.readLine();
                    if (line == null) {
                        break;
                    }
                    String[] txt = line.split("-");
                    String idEmp = txt[0];
                    String contractId = txt[2];
                    SimpleDateFormat dateInput = new SimpleDateFormat("dd/MM/yyyy");
                    Date timeStart = null;
                    Date timeEnd = null;
                    try {
                        timeStart = dateInput.parse(txt[3]);
                        timeEnd = dateInput.parse(txt[4]);
                    } catch (Exception e) {

                    }
                    String status = txt[5];
                    Contract contract = new Contract(contractId, timeStart, timeEnd, status);
                    while (true) {
                        if (MenuHandle.listAccount[i].getEmployee().getIdEmp().equalsIgnoreCase(idEmp)) {
                            MenuHandle.listAccount[i].getEmployee().setContract(contract);
                            break;
                        }
                        i++;
                    }
                }
            }
        } catch (Exception e) {

        }
    }

    public static void writeFileContract() {
        try {
            FileWriter fw = new FileWriter(listContractTxt);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < MenuHandle.n; i++) {
                if (MenuHandle.listAccount[i].getEmployee().getContract() != null) {
                    bw.write(MenuHandle.listAccount[i].getEmployee().getIdEmp() + "-"
                            + MenuHandle.listAccount[i].getEmployee().getName() + "-"
                            + MenuHandle.listAccount[i].getEmployee().getContract().toString());
                    bw.newLine();
                }
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }

    private static void readFileDepartment() {
        MenuHandle.m = -1;
        try {
            FileReader fr = new FileReader(listDepartmentTxt);
            try (BufferedReader br = new BufferedReader(fr)) {
                String line = "";
                while (true) {
                    MenuHandle.m++;
                    line = br.readLine();
                    if (line == null) {
                        break;
                    }
                    String[] txt = line.split("-");
                    String departmentId = txt[0];
                    String departmentName = txt[1];
                    String idChief = txt[2];
                    int members = Integer.parseInt(txt[3]);
                    String[] idEmployee = new String[members];
                    for (int i = 0; i < members; i++) {
                        idEmployee[i] = txt[i + 4];
                    }
                    MenuHandle.listDepartments = Arrays.copyOf(MenuHandle.listDepartments, MenuHandle.m + 1);
                    MenuHandle.listDepartments[MenuHandle.m] = new Department(departmentId,
                            departmentName, idChief, members,
                            idEmployee);
                }
            }
        } catch (Exception e) {
        }
    }

    private static void writeFileDepartment() {
        try {
            FileWriter fw = new FileWriter(listDepartmentTxt);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < MenuHandle.m; i++) {
                bw.write(MenuHandle.listDepartments[i].toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }

}