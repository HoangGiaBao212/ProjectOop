import java.util.Scanner;

public class OfficialEmployee extends Employee implements InOut {

    static Scanner scanner = new Scanner(System.in);
    private static int coefficientsSalary = 2;

    public OfficialEmployee() {
    }

    public OfficialEmployee(String position, String name, int age, String gender, String email, String address,
            String phone, Salary salary, Project project, Department department, int coefficientsSalary) {
        super(position, name, age, gender, email, address, phone, salary, project, department);
        OfficialEmployee.coefficientsSalary = coefficientsSalary;
    }

    public static int getCoefficientsSalary() {
        return coefficientsSalary;
    }

    public void setCoefficientsSalary(int coefficientsSalary) {
        OfficialEmployee.coefficientsSalary = coefficientsSalary;
    }

    @Override
    public void input() {
        super.input();
    }

    @Override
    public void output() {
        super.output();
    }

}
