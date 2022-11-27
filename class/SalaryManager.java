import java.util.Scanner;

public class SalaryManager implements RoleOfManager {

    static Scanner scanner = new Scanner(System.in);

    long[] salaryTotal = new long[100];
    long baseSalary;

    public boolean checkIdEmployee(String IdEmp) {
        for (Employee employee : Handle.listEmployees) {
            if (employee == null)
                break;
            if ((employee.getIdEmp().equals(IdEmp)) && employee.getSalary() == null)
                return true;
        }
        return false;
    }

    @Override
    public void inputList() {
        System.out.println(Handle.n);
        System.out.println("------Enter base salary this month:---- ");
        baseSalary = Long.parseLong(scanner.nextLine());

        for (int i = 0; i < Handle.n; i++) {
            System.out.println("Enter information about employee with id: " + Handle.listEmployees[i].getIdEmp());
            int indexSalary = 1;
            Salary salary = new Salary();
            salary.input();
            if (Handle.listEmployees[i].getPosition().equalsIgnoreCase("Chief of department")) {
                indexSalary = ChiefDepartment.getCoefficientsSalary();
                salary.setIndexSalary(indexSalary);
            } else if (Handle.listEmployees[i].getPosition().equalsIgnoreCase("Official Employee")) {
                indexSalary = OfficialEmployee.getCoefficientsSalary();
                salary.setIndexSalary(indexSalary);
            } else {
                indexSalary = InternEmployee.getCoefficientsSalary();
                salary.setIndexSalary(indexSalary);
            }
            salary.payRoll(baseSalary, indexSalary);
            Handle.listEmployees[i].setSalary(salary);
        }
    }

    @Override
    public void outputList() {
        System.out.println(Handle.n);
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("|  %-10s|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|", "ID",
                "Name", "Position", "Coefficients Salary", "Some Holidays", "Salary");
        System.out.println(
                "\n---------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < Handle.n; i++) {
            if (Handle.listEmployees[i].getSalary() == null) {
                continue;
            }
            System.out.printf("|  %-10s|  %-20s|  %-20s", Handle.listEmployees[i].getIdEmp(),
                    Handle.listEmployees[i].getName(),
                    Handle.listEmployees[i].getPosition());
            Handle.listEmployees[i].getSalary().output();
            System.out.println(
                    "---------------------------------------------------------------------------------------------------------------------------------");
        }
    }

    @Override
    public void add() {
        String idEmpAdd;
        System.out.print("==> Enter id of employee to add list salary: ");
        idEmpAdd = scanner.nextLine();
        if (checkIdEmployee(idEmpAdd)) {
            for (Employee employee : Handle.listEmployees) {
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
    }

    @Override
    public void remove() {
        String idRemove;
        boolean check = false;
        do {
            System.out.print("Enter id of employee to remove: ");
            idRemove = scanner.nextLine();
            for (Employee employee : Handle.listEmployees) {
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
    }

    @Override
    public void edit() {

    }

    @Override
    public void find() {
        String idSearch;
        System.out.print("Enter id of employee to search: ");
        idSearch = scanner.nextLine();

        for (int i = 0; i <= Handle.n; i++) {
            if (Handle.listEmployees[i].getSalary() == null) {
                continue;
            }
            if (Handle.listEmployees[i].getIdEmp().equalsIgnoreCase(idSearch)) {
                System.out.println(
                        "---------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("|  %-10s|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|", "ID",
                        "Name", "Position", "Coefficients Salary", "Some Holidays", "Salary");
                System.out.println(
                        "\n---------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("|  %-10s|  %-20s|  %-20s", Handle.listEmployees[i].getIdEmp(),
                        Handle.listEmployees[i].getName(),
                        Handle.listEmployees[i].getPosition());
                Handle.listEmployees[i].getSalary().output();
                System.out.println(
                        "---------------------------------------------------------------------------------------------------------------------------------");
            }
        }
    }
}