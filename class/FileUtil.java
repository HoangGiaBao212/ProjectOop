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
        readFileAccount();
        // readFileSalary();
        // readFileContract();
    }
    
    public static void setData() {
        writeFileAccount();
        // writeFileSalary();
        // writeFileContract();
    }
    private static void readFileAccount() {
        Handle.n = -1;
        try {
            FileReader fr = new FileReader("./File/account.txt");
            // Handle.n+=2;
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
                    Account account = new Account(username, password,employee);
                    Handle.listAccount[Handle.n] = new Account();
                    Handle.listAccount[Handle.n] = account;
                }
            }
                // if(!check) MenuContent.printNoData();
        } catch (Exception e) {
        }
    }
    
    // private static void readFileEmployee() {
        //     Handle.n = -1;
    //     try {
    //         FileReader fr = new FileReader(listEmployeeTxt);
    //         try (BufferedReader br = new BufferedReader(fr)) {
    //             String line = "";
    //             while (true) {
    //                 Handle.n++; // 5
    //                 line = br.readLine();
    //                 if (line == null) {
    //                     break;
    //                 }
    //                 String[] txt = line.split("-");
    //                 String idEmp = txt[0];
    //                 String position = txt[1];
    //                 String name = txt[2];
    //                 int age = Integer.parseInt(txt[3]);
    //                 String gender = txt[4];
    //                 String email = txt[5];
    //                 String address = txt[6];
    //                 String phone = txt[7];
    //                 Employee employee = new Employee(name, age, gender, email, address, phone,
    //                         idEmp, position);
    //                 Handle.listAccount[Handle.n].setEmployee(employee); 
    //             }
    //         }
    //     } catch (Exception e) {
    //     }
    // }

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
            // System.out.println("Don't have data for salary! ");
        }
    }

    // write file

    // private static void writeFileEmployee() {

    //     try {
    //         FileWriter fw = new FileWriter(listEmployeeTxt);
    //         BufferedWriter bw = new BufferedWriter(fw);
    //         for (int i = 0; i < Handle.n; i++) {
    //             bw.write(Handle.listEmployees[i].toString());
    //             bw.newLine();
    //         }
    //         bw.close();
    //         fw.close();
    //     } catch (Exception e) {
    //     }
    // }

    public static void writeFileSalary() {
        try {
            FileWriter fw = new FileWriter(listSalaryTxt);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i <Handle.n ; i++) {
              
                if (Handle.listAccount[i].getEmployee().getSalary() != null) {
                    bw.write(Handle.listAccount[i].getEmployee().getIdEmp() + "-" + Handle.listAccount[i].getEmployee().getName() + "-" + Handle.listAccount[i].getEmployee().getPosition() + "-"
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
                    // Handle.n++;
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
                    bw.write(Handle.listAccount[i].getEmployee().getIdEmp() + "-" + Handle.listAccount[i].getEmployee().getName() + "-"
                            + Handle.listAccount[i].getEmployee().getContract().toString());
                    bw.newLine();
                }
            }
            bw.close();
            fw.close();
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
}
