import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class SalaryManager implements RoleOfManager {

    static Scanner scanner = new Scanner(System.in);
    public Employee listEmployees[] = new Employee[100];
    private int n;
    String listEmployeeTxt = "./File/employee.txt";
    String listSalaryTxt = ".File/salary.txt";

    long[] salaryTotal = new long[100];
    long baseSalary;

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
                    Employee employee = new Employee(name, age, gender, email, address, phone,
                            idEmp, position);
                    listEmployees[n] = employee;
                }
            }
        } catch (Exception e) {
            System.out.println("Don't have data for employee!");
        }
    }

    @Override
    public void inputList() {
        System.out.println("------Enter base salary this month:---- ");
        baseSalary = Long.parseLong(scanner.nextLine());

        for (Employee employee : listEmployees) {
            if (employee == null) {
                break;
            }

            int indexSalary = 1;
            Salary salary = new Salary();
            salary.input();
            if (employee.getPosition().equalsIgnoreCase("Chief of department")) {
                indexSalary = ChiefDepartment.getCoefficientsSalary();
                salary.setIndexSalary(indexSalary);
            } else if (employee.getPosition().equalsIgnoreCase("Official Employee")) {
                indexSalary = OfficialEmployee.getCoefficientsSalary();
                salary.setIndexSalary(indexSalary);
            } else {
                indexSalary = InternEmployee.getCoefficientsSalary();
                salary.setIndexSalary(indexSalary);
            }
            salary.payRoll(baseSalary, indexSalary);
            employee.setSalary(salary);
            // System.out.println(employee.getIdEmp() + "-" + employee.getName() + "-" +
            // employee.getPosition() + "-"
            // + employee.getSalary().toString());
        }
        writeFile();
    }

    @Override
    public void outputList() {
        readFile();
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("|  %-10s|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|", "ID",
                "Name", "Position", "Coefficients Salary", "Some Holidays", "Salary");
        System.out.println(
                "\n---------------------------------------------------------------------------------------------------------------------------------");
        for (Employee employee : listEmployees) {
            if (employee == null)
                break;
            System.out.printf("|  %-10s|  %-20s|  %-20s", employee.getIdEmp(), employee.getName(),
                    employee.getPosition());
            employee.getSalary().output();
        }
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------------");
    }

    public boolean checkIdEmployee(String IdEmp) {
        for (Employee employee : listEmployees) {
            if (employee == null)
                break;
            if ((employee.getIdEmp().equals(IdEmp)) && employee.getSalary() != null)
                return false;
        }
        return true;
    }

    @Override
    public void add() {
        readFile();
        String idEmpAdd;
        System.out.print("==> Enter id of employee to add list salary: ");
        idEmpAdd = scanner.nextLine();
        System.out.println(checkIdEmployee(idEmpAdd));
        if (checkIdEmployee(idEmpAdd)) {
            for (Employee employee : listEmployees) {
                if (employee == null)
                    break;
                if (employee.getIdEmp().equals(idEmpAdd)) {
                    int indexSalary = 1;
                    Salary salary = new Salary();
                    salary.input();
                    if (employee.getPosition().equalsIgnoreCase("Chief of department")) {
                        indexSalary = ChiefDepartment.getCoefficientsSalary();
                        salary.setIndexSalary(indexSalary);
                    } else if (employee.getPosition().equalsIgnoreCase("Official Employee")) {
                        indexSalary = OfficialEmployee.getCoefficientsSalary();
                        salary.setIndexSalary(indexSalary);
                    } else {
                        indexSalary = InternEmployee.getCoefficientsSalary();
                        salary.setIndexSalary(indexSalary);
                    }
                    salary.payRoll(baseSalary, indexSalary);
                    employee.setSalary(salary);
                }
            }
        } else {
            System.out.println("Employee is exits or don't have employee with id: " + idEmpAdd);
        }
    }

    @Override
    public void remove() {
        readFile();
        String idRemove;
        System.out.print("Enter id of employee to remove: ");
        idRemove = scanner.nextLine();
        try {
            FileWriter fw = new FileWriter(listSalaryTxt);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Employee employee : listEmployees) {
                if (employee == null) {
                    break;
                }
                if (employee.getSalary() != null) {
                    if (employee.getIdEmp().equals(idRemove)) {
                        continue;
                    }
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

    @Override
    public void edit() {

    }

    private void readFile() {
        n = -1;
        try {
            FileReader fr = new FileReader(listSalaryTxt);
            try (BufferedReader br = new BufferedReader(fr)) {
                String line = "";
                while (true) {
                    line = br.readLine();
                    if (line == null) {
                        break;
                    }
                    n++;
                    String[] txt = line.split("-");
                    int indexSalary = Integer.parseInt(txt[3]);
                    int someHolidays = Integer.parseInt(txt[4]);
                    Long totalSalary = Long.parseLong(txt[5]);
                    Salary salary = new Salary(indexSalary, someHolidays, totalSalary);
                    listEmployees[n].setSalary(salary);
                }
            }
        } catch (Exception e) {
            System.out.println("Don't have data for salary! ");
        }
    }

    @Override
    public void find() {

    }

    private void writeFile() {
        try {
            FileWriter fw = new FileWriter(listSalaryTxt);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Employee employee : listEmployees) {
                if (employee == null) {
                    break;
                }
                bw.write(employee.getIdEmp() + "-" + employee.getName() + "-" + employee.getPosition() + "-"
                        + employee.getSalary().toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("Don't have data for salary! ");
        }
    }

    // @Override
    // public void input() {
    // // TODO Auto-generated method stub
    // // readFileEmployee();
    // System.out.println("------Enter base salary this month:---- ");
    // baseSalary = Long.parseLong(scanner.nextLine());

    // List<Salary> listSalary = new ArrayList<Salary>();
    // try {
    // FileReader fr = new FileReader(
    // "C:/Users/Hoang Gia
    // Bao/Desktop/oop-humanresourcemanagement/Project-Oop/File/employee.txt");
    // BufferedReader br = new BufferedReader(fr);
    // String line = "";
    // while (true) {
    // line = br.readLine();
    // if (line == null) {
    // break;
    // }
    // String[] txt = line.split("-");
    // String id = txt[0];
    // int quinary = Integer.parseInt(txt[1]);
    // String name = txt[2];
    // int age = Integer.parseInt(txt[3]);
    // String gender = txt[4];
    // String email = txt[5];
    // String address = txt[6];
    // String phone = txt[7];

    // int indexSalary;
    // int someHolidays;
    // Long totalSalary;

    // System.out.print("Enter index salary(equivalent working year): ");
    // indexSalary = Integer.parseInt(scanner.nextLine());
    // System.out.print("Enter some holidays: ");
    // someHolidays = Integer.parseInt(scanner.nextLine());

    // totalSalary = (long) (baseSalary * 30 + 0.1 * baseSalary - baseSalary *
    // someHolidays);

    // System.out.println(totalSalary);

    // // listSalary.add(salary);
    // }
    // br.close();
    // fr.close();
    // } catch (Exception e) {
    // // TODO: handle exception
    // System.out.println("Don't have data for employee");
    // }

    // try {
    // FileWriter fw = new FileWriter(
    // "C:/Users/Hoang Gia
    // Bao/Desktop/oop-humanresourcemanagement/Project-Oop/File/salary.txt");
    // BufferedWriter bw = new BufferedWriter(fw);
    // String baseSalaryText = Long.toString(baseSalary);
    // bw.write(baseSalaryText);
    // bw.newLine();
    // for (Salary o : listSalary) {
    // bw.write(o.getIdEmp() + "-" + o.getIndexSalary() + "-" + o.getName() + "-" +
    // o.getSomeHolidays() + "-"
    // + o.getTotalSalary());
    // bw.newLine();
    // }
    // bw.close();
    // fw.close();
    // } catch (Exception e) {
    // // TODO: handle exception
    // }
    // }

    // @Override
    // public void output() {
    // // TODO Auto-generated method stub

    // List<Salary> listSalary = new ArrayList<>();
    // try {
    // FileReader fr = new FileReader(
    // "C:/Users/Hoang Gia
    // Bao/Desktop/oop-humanresourcemanagement/Project-Oop/File/salary.txt");
    // BufferedReader br = new BufferedReader(fr);
    // String line = "";
    // line = br.readLine();
    // if (line == null) {
    // System.out.println("Don't have data!!");
    // return;
    // } else {
    // baseSalary = Long.valueOf(line);
    // System.out.println(
    // "------------------------------------------------------------------------------------------------------");
    // System.out.printf("| %-10s | %-20s | %-20s | %-10s | %-10s |", "ID",
    // "Nhan Vien Nam thu ", "Name", "Some Holidays", "Salary");
    // System.out.println(
    // "\n------------------------------------------------------------------------------------------------------");
    // }
    // while (true) {
    // line = br.readLine();
    // if (line == null) {
    // break;
    // }
    // Locale locale = new Locale("vi", "VN");
    // NumberFormat numberFormat1 = NumberFormat.getCurrencyInstance(locale);
    // DecimalFormat numberFormat2 = (DecimalFormat)
    // DecimalFormat.getCurrencyInstance(locale);
    // DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols();
    // formatSymbols.setGroupingSeparator(',');
    // formatSymbols.setCurrencySymbol("vnd");
    // numberFormat2.setDecimalFormatSymbols(formatSymbols);
    // String[] txt = line.split("-");
    // String id = txt[0];
    // int quinary = Integer.parseInt(txt[1]);
    // String name = txt[2];
    // int someHolidays = Integer.parseInt(txt[3]);
    // long salary = Long.parseLong(txt[4]);
    // // String salary = txt[3];
    // System.out.println();
    // System.out.printf("| %-10s | %-20d | %-20s | %-10d | %-10s |",
    // id, quinary, name, someHolidays, numberFormat2.format(salary));
    // }
    // br.close();
    // fr.close();
    // } catch (Exception e) {
    // // TODO: handle exception
    // }
    // }
}