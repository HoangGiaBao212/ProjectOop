import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FileUtil {
    public static int n=-1;
    public static Employee listEmployees[] = new Employee[100];
    public static String listEmployeeTxt = "./File/employee.txt";
    public static String listSalaryTxt = "./File/salary.txt";
    public static String listContractTxt = "./File/contract.txt";

    public static void readFile() {
        readFileEmployee();
        readFileSalary();
        readFileContract();
    }

    public static void writeFile() {
        writeFileEmployee();
        writeFileSalary();
        writeFileContract();
    }

    private static void readFileEmployee() {
        n = -1;
        try {
            FileReader fr = new FileReader(listEmployeeTxt);
            try (BufferedReader br = new BufferedReader(fr)) {
                String line = "";
                while (true) {
                    n++; // 5
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
                    listEmployees[n] = employee;
                    System.out.println(n);
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
                        if (FileUtil.listEmployees[i].getIdEmp().equalsIgnoreCase(idEmp)) {
                            FileUtil.listEmployees[i].setSalary(salary);
                            break;
                        }
                        i++;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Don't have data for salary! ");
        }
    }

    // write file

    private static void writeFileEmployee() {

        try {
            FileWriter fw = new FileWriter(listEmployeeTxt);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < n; i++) {
                bw.write(listEmployees[i].toString());
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
            for (Employee employee : FileUtil.listEmployees) {
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
                    n++;
                    String[] txt = line.split("-");
                    String idEmp = txt[0];
                    String nameEmp = txt[1];
                    String contracId = txt[2];
                    String timeStart = txt[3];
                    String timeEnd = txt[4];
                    Contract contract = new Contract(contracId, timeStart, timeEnd);

                    while (true) {
                        if (FileUtil.listEmployees[i].getIdEmp().equalsIgnoreCase(idEmp)) {
                            FileUtil.listEmployees[i].setContract(contract);
                            break;
                        }
                        i++;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Don't have data for contract!");
        }
    }

    public static void writeFileContract() {
        try {
            FileWriter fw = new FileWriter(listContractTxt);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < n; i++) {
                if (listEmployees[i].getContract() != null) {
                    bw.write(listEmployees[i].getIdEmp() + "-" + listEmployees[i].getName() + "-"
                            + listEmployees[i].getContract().toString());
                    bw.newLine();
                }
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("Don't have data for salary! ");
        }
    }
}
