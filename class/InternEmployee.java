import java.util.Scanner;

public class InternEmployee extends Employee implements InOut {
    static Scanner scanner = new Scanner(System.in);
    private static int coefficientsSalary = 1;

    public InternEmployee() {
    }

    public InternEmployee(String name, int age, String gender, String email, String address, String phone, String idEmp,
            String position, Salary salary, Project project, Department department, Contract contract) {
        super(name, age, gender, email, address, phone, idEmp, position, salary, project, department, contract);
    }

    public static int getCoefficientsSalary() {
        return coefficientsSalary;
    }

    public void setCoefficientsSalary(int coefficientsSalary) {
        System.out.println("Enter coefficientsSalary: ");
        coefficientsSalary = scanner.nextInt();
        InternEmployee.coefficientsSalary = coefficientsSalary;
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
