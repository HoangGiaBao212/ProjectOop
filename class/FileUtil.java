import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class FileUtil {

    /*
    private static String listSalaryTxt = "C:\\Users\\khang\\OneDrive\\Tài liệu\\GitHub\\ProjectOop\\File\\salary.txt";
    private static String listContractTxt = "C:\\Users\\khang\\OneDrive\\Tài liệu\\GitHub\\ProjectOop\\File\\contract.txt";
    private static String listDepartmentTxt = "C:\\Users\\khang\\OneDrive\\Tài liệu\\GitHub\\ProjectOop\\File\\department.txt";
    private static String listAccountTxt = "C:\\Users\\khang\\OneDrive\\Tài liệu\\GitHub\\ProjectOop\\File\\account.txt";
     */
    private static String listSalaryTxt = "./ProjectOop/File/salary.txt";
    private static String listContractTxt = "./ProjectOop/File/contract.txt";
    private static String listDepartmentTxt = "./ProjectOop/File/department.txt";
    private static String listAccountTxt = "./ProjectOop/File/account.txt";

    private FileUtil() {
    }

    public static void getData() {
        readFileAccount();
        readFileSalary();
        readFileContract();
        readFileDepartment();
    }

    public static void setData() {
        writeFileAccount();
        writeFileSalary();
        writeFileContract();
        writeFileDepartment();
    }

    private static void readFileAccount() {
        Handle.n = -1;
        try {
            FileReader fr = new FileReader(listAccountTxt);
            try (BufferedReader br = new BufferedReader(fr)) {
                String line = "";
                while (true) {
                    Handle.n++;
                    line = br.readLine();
                    if (line == null) {
                        break;
                    }
                    String[] txt = line.split("-");
                    String username = txt[0];
                    String password = txt[1];
                    String idEmp = txt[2];
                    String position = txt[3];
                    String name = txt[4];
                    int age = Integer.parseInt(txt[5]);
                    String gender = txt[6];
                    String email = txt[7];
                    String address = txt[8];
                    String phone = txt[9];
                    Employee employee = new Employee(name, age, gender, email, address, phone,
                            idEmp, position);
                    Handle.listAccount[Handle.n] = new Account(username, password, employee);
                }
            }
        } catch (Exception e) {
        }
    }

    private static void writeFileAccount() {
        try {
            FileWriter fw = new FileWriter(listAccountTxt);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < Handle.n; i++) {
                bw.write(Handle.listAccount[i].toString());
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
                    String idEmp = txt[0];
                    int indexSalary = Integer.parseInt(txt[3]);
                    int someHolidays = Integer.parseInt(txt[4]);
                    Long totalSalary = Long.parseLong(txt[5]);

                    Salary salary = new Salary(indexSalary, someHolidays, totalSalary);

                    while (true) {
                        if (Handle.listAccount[i].getEmployee().getIdEmp().equalsIgnoreCase(idEmp)) {
                            Handle.listAccount[i].getEmployee().setSalary(salary);
                            break;
                        }
                        i++;
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
            for (int i = 0; i < Handle.n; i++) {

                if (Handle.listAccount[i].getEmployee().getSalary() != null) {
                    bw.write(Handle.listAccount[i].getEmployee().getIdEmp() + "-"
                            + Handle.listAccount[i].getEmployee().getName() + "-"
                            + Handle.listAccount[i].getEmployee().getPosition() + "-"
                            + Handle.listAccount[i].getEmployee().getSalary().toString());
                    bw.newLine();
                }
            }
            bw.close();
            fw.close();

        } catch (Exception e) {
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
                    String timeStart = txt[3];
                    String timeEnd = txt[4];
                    Contract contract = new Contract(contractId, timeStart, timeEnd);

                    while (true) {
                        if (Handle.listAccount[i].getEmployee().getIdEmp().equalsIgnoreCase(idEmp)) {
                            Handle.listAccount[i].getEmployee().setContract(contract);
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
            for (int i = 0; i < Handle.n; i++) {
                if (Handle.listAccount[i].getEmployee().getContract() != null) {
                    bw.write(Handle.listAccount[i].getEmployee().getIdEmp() + "-"
                            + Handle.listAccount[i].getEmployee().getName() + "-"
                            + Handle.listAccount[i].getEmployee().getContract().toString());
                    bw.newLine();
                }
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }

    private static void readFileDepartment() {
        Handle.m = -1;
        try {
            FileReader fr = new FileReader(listDepartmentTxt);
            try (BufferedReader br = new BufferedReader(fr)) {
                String line = "";
                while (true) {
                    Handle.m++;
                    line = br.readLine();
                    if (line == null) {
                        break;
                    }
                    String[] txt = line.split("-");
                    String departmentId = txt[0];
                    String departmentName = txt[1];
                    int members = Integer.parseInt(txt[2]);
                    String[] idEmployee = new String[members];
                    for (int i = 0; i < members; i++) {
                        idEmployee[i] = txt[i + 3];
                    }
                    Handle.listDepartments[Handle.m] = new Department(departmentId, departmentName, members, false,
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
            for (int i = 0; i < Handle.m; i++) {
                bw.write(Handle.listDepartments[i].toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }

}
