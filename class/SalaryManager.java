import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class SalaryManager implements RoleOfManager {

    static Scanner scanner = new Scanner(System.in);
    public static Employee listEmployees[] = new Employee[100];
    private static int n;
    static String listEmployeeTxt = "./File/employee.txt";
    static String listSalaryTxt = "./File/salary.txt";

    long[] salaryTotal = new long[100];
    long baseSalary;

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
                    Employee employee = new Employee(name, age, gender, email, address, phone,
                            idEmp, position);
                    listEmployees[n] = employee;
                }
            }
        } catch (Exception e) {
            System.out.println("Don't have data for employee!");
        }
    }

    public boolean checkIdEmployee(String IdEmp) {
        for (Employee employee : listEmployees) {
            if (employee == null)
                break;
            if ((employee.getIdEmp().equals(IdEmp)) && employee.getSalary() == null)
                return true;
        }
        return false;
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
        }
        // writeFile();
    }

    @Override
    public void outputList() {
        // readFile();
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("|  %-10s|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|", "ID",
                "Name", "Position", "Coefficients Salary", "Some Holidays", "Salary");
        System.out.println(
                "\n---------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i <= n; i++) {
            if (listEmployees[i].getSalary() == null) {
                continue;
            }
            System.out.printf("|  %-10s|  %-20s|  %-20s", listEmployees[i].getIdEmp(), listEmployees[i].getName(),
                    listEmployees[i].getPosition());
            listEmployees[i].getSalary().output();
            System.out.println(
                    "---------------------------------------------------------------------------------------------------------------------------------");
        }
    }

    @Override
    public void add() {
        // readFile();
        String idEmpAdd;
        System.out.print("==> Enter id of employee to add list salary: ");
        idEmpAdd = scanner.nextLine();
        if (checkIdEmployee(idEmpAdd)) {
            for (Employee employee : listEmployees) {
                if (employee == null)
                    break;
                if (employee.getIdEmp().equals(idEmpAdd)) {
                    System.out.print("Enter base salary of employee: ");
                    baseSalary = scanner.nextLong();
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
        // writeFile();
    }

    @Override
    public void remove() {
        // readFile();
        String idRemove;
        boolean check = false;
        do {
            System.out.print("Enter id of employee to remove: ");
            idRemove = scanner.nextLine();
            for (Employee employee : listEmployees) {
                if (employee == null) {
                    break;
                }
                if (employee.getIdEmp().equals(idRemove)) {
                    employee.setSalary(null);
                    check = true;
                }
            }
            if (!check)
                System.out.println("Not find id is: " + idRemove + ", enter again: ");
        } while (!check);
        // writeFile();
    }

    @Override
    public void edit() {

    }

    @Override
    public void find() {
        // readFile();
        String idSearch;
        System.out.print("Enter id of employee to search: ");
        idSearch = scanner.nextLine();

        for (int i = 0; i <= n; i++) {
            if (listEmployees[i].getSalary() == null) {
                continue;
            }
            if (listEmployees[i].getIdEmp().equalsIgnoreCase(idSearch)) {
                System.out.println(
                        "---------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("|  %-10s|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|", "ID",
                        "Name", "Position", "Coefficients Salary", "Some Holidays", "Salary");
                System.out.println(
                        "\n---------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("|  %-10s|  %-20s|  %-20s", listEmployees[i].getIdEmp(), listEmployees[i].getName(),
                        listEmployees[i].getPosition());
                listEmployees[i].getSalary().output();
                System.out.println(
                        "---------------------------------------------------------------------------------------------------------------------------------");
            }
        }
    }

    static void readFile() {
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
                    String idEmp = txt[0];
                    int indexSalary = Integer.parseInt(txt[3]);
                    int someHolidays = Integer.parseInt(txt[4]);
                    Long totalSalary = Long.parseLong(txt[5]);

                    Salary salary = new Salary(indexSalary, someHolidays, totalSalary);

                    while (true) {
                        if (listEmployees[n].getIdEmp().equalsIgnoreCase(idEmp)) {
                            listEmployees[n].setSalary(salary);
                            break;
                        }
                        n++;
                    }
                    System.out.println(n);
                }
            }
        } catch (Exception e) {
            System.out.println("Don't have data for salary! ");
        }
    }

    public static void writeFile() {
        try {
            FileWriter fw = new FileWriter(listSalaryTxt);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Employee employee : listEmployees) {
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
}