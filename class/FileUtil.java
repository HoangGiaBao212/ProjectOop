import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FileUtil {

    static String listEmployeeTxt = "./File/employee.txt";
    private static String listSalaryTxt = "./File/salary.txt";
    private static String listContractTxt = "./File/contract.txt";
    private static String listDepartmentTxt = "./File/department.txt";
    private static String listProjectTxt = "./File/project.txt";
    private static String listAccountTxt = "./File/account.txt";

    private FileUtil() {
    }

    public static void getData() {
        readFileEmployee();
        readFileSalary();
        readFileContract();
        readFileAccount();
    }

    public static void setData() {
        writeFileEmployee();
        writeFileSalary();
        writeFileContract();
        writeFileAccount();
    }

    private static void readFileEmployee() {
        Handle.n = -1;
        try {
            FileReader fr = new FileReader(listEmployeeTxt);
            try (BufferedReader br = new BufferedReader(fr)) {
                String line = "";
                while (true) {
                    Handle.n++; // 5
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
                    Employee employee = new Employee(name, age, gender, email, address, phone,
                            idEmp, position);
                    Handle.listEmployees[Handle.n] = employee;
                }
            }
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
                        if (Handle.listEmployees[i].getIdEmp().equalsIgnoreCase(idEmp)) {
                            Handle.listEmployees[i].setSalary(salary);
                            break;
                        }
                        i++;
                    }
                }
            }
        } catch (Exception e) {
            // System.out.println("Don't have data for salary! ");
        }
    }

    // write file

    private static void writeFileEmployee() {

        try {
            FileWriter fw = new FileWriter(listEmployeeTxt);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < Handle.n; i++) {
                bw.write(Handle.listEmployees[i].toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }

    public static void writeFileSalary() {
        try {
            FileWriter fw = new FileWriter(listSalaryTxt);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Employee employee : Handle.listEmployees) {
                if (employee == null) {
                    break;
                }
                if (employee.getSalary() != null) {
                    bw.write(employee.getIdEmp() + "-" + employee.getName() + "-" + employee.getPosition() + "-"
                            + employee.getSalary().toString());
                    bw.newLine();
                }
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("Don't have data for salary! ");
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
                    Handle.n++;
                    String[] txt = line.split("-");
                    String idEmp = txt[0];
                    String contractId = txt[2];
                    String timeStart = txt[3];
                    String timeEnd = txt[4];
                    Contract contract = new Contract(contractId, timeStart, timeEnd);

                    while (true) {
                        if (Handle.listEmployees[i].getIdEmp().equalsIgnoreCase(idEmp)) {
                            Handle.listEmployees[i].setContract(contract);
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
                if (Handle.listEmployees[i].getContract() != null) {
                    bw.write(Handle.listEmployees[i].getIdEmp() + "-" + Handle.listEmployees[i].getName() + "-"
                            + Handle.listEmployees[i].getContract().toString());
                    bw.newLine();
                }
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("Don't have data for salary! ");
        }
    }

    private static void readFileAccount() {
        Handle.m = -1;
        try {
            FileReader fr = new FileReader(listAccountTxt);
            try (BufferedReader br = new BufferedReader(fr)) {
                String line = "";
                while (true) {
                    Handle.m++;
                    line = br.readLine();
                    if (line == null) {
                        break;
                    }
                    String[] txt = line.split("-");
                    String idEmp = txt[0];
                    String username = txt[1];
                    String password = txt[2];
                    Account account = new Account(idEmp, username, password);
                    Handle.listAccount[Handle.m] = account;
                    System.out.println(Handle.m);
                }
            }
        } catch (Exception e) {
        }
    }

    private static void writeFileAccount() {
        try {
            FileWriter fw = new FileWriter(listAccountTxt);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < Handle.m; i++) {
                bw.write(Handle.listAccount[i].toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }

    // static void DeleteFromFile(String id) {
    //     try {
    //         FileWriter fw = new FileWriter(listEmployeeTxt);
    //         BufferedWriter bw = new BufferedWriter(fw);
    //         for (int i = 0; i < Handle.n; i++) {
    //             if (Handle.listEmployees[i].getIdEmp().equalsIgnoreCase(id)) {
    //                 Handle.listEmployees[i] = Handle.listEmployees[i + 1];
    //             }
    //             Handle.listEmployees[i] = null; 
    //             bw.write(Handle.listEmployees[i].toString());
    //             bw.newLine();
    //         }
    //         bw.close();
    //         fw.close();
    //     } catch (Exception e) {
    //     }
    // }

}
