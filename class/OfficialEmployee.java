import java.util.Scanner;

public class OfficialEmployee extends Employee implements InOut {

    static Scanner scanner = new Scanner(System.in);
    private static int coefficientsSalary = 2;

    public OfficialEmployee() {
    }

    public OfficialEmployee(String name, int age, String gender, String email, String address, String phone,
            String idEmp, String position, Salary salary, Department department, Contract contract) {
        super(name, age, gender, email, address, phone, idEmp, position, salary, department, contract);
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
