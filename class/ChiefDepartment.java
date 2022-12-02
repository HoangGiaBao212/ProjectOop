import java.util.Scanner;

public class ChiefDepartment extends Employee {

    static Scanner scanner = new Scanner(System.in);


    public ChiefDepartment() {
    }

    public ChiefDepartment(String name, int age, String gender, String email, String address, String phone,
            String idEmp, String position, Salary salary, Department department, Contract contract) {
        super(name, age, gender, email, address, phone, idEmp, position, salary, department, contract);
    }

    

    public void input() {
        super.input();
    }

    @Override
    public void output() {
        super.output();
    }
}
