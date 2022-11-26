import java.util.Scanner;

public class ChiefDepartment extends Employee {

    static Scanner scanner = new Scanner(System.in);
    private static int coefficientsSalary = 3;

    public ChiefDepartment() {
    }

    public ChiefDepartment(String position, String name, int age, String gender, String email, String address,
            String phone, Salary salary, Project project, Department department, int coefficientsSalary) {
        super(position, name, age, gender, email, address, phone, salary, project, department);
        ChiefDepartment.coefficientsSalary = coefficientsSalary;
    }

    public static int getCoefficientsSalary() {
        return coefficientsSalary;
    }

    public void setCoefficientsSalary(int coefficientsSalary) {
        System.out.println("Enter coefficientsSalary: ");
        coefficientsSalary = scanner.nextInt();
        ChiefDepartment.coefficientsSalary = coefficientsSalary;
    }

    public void input() {
        super.input();
    }

    @Override
    public void output() {
        super.output();
    }
}
