import java.util.Scanner;

class Employee extends Person implements InOut {
    static Scanner scanner = new Scanner(System.in);
    private String idEmp;
    private String position;
    private Salary salary;
    private Department department;
    private Contract contract;

    public Employee() {
        super();
    }

    public Employee(String position) {
        this.position = position;
    }

    public Employee(String name, int age, String gender, String email, String address, String phone, String idEmp,
            String position) {
        super(name, age, gender, email, address, phone);
        this.idEmp = idEmp;
        this.position = position;
    }

    public Employee(String name, int age, String gender, String email, String address, String phone, String idEmp,
            String position, Salary salary, Department department, Contract contract) {
        super(name, age, gender, email, address, phone);
        this.idEmp = idEmp;
        this.position = position;
        this.salary = salary;
        this.department = department;
        this.contract = contract;
    }

    public String getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(String idEmp) {
        System.out.print("     - Enter id of employee: ");
        idEmp = sc.nextLine();
        while (idEmp.isEmpty()) {
            System.out.print("\n    Id of employee must not be left blank! Enter again:  ");
            idEmp = sc.nextLine();
            idEmp = idEmp.toUpperCase();
        }
        while (!idEmp.startsWith("E")) {
            System.out.print("\n     Employee code starting from E(Ex:E001). Enter again: ");
            idEmp = sc.nextLine();
            idEmp = idEmp.toUpperCase();
        }
        this.idEmp = idEmp;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    @Override
    public String toString() {
        return idEmp + "-" + position + "-" + super.toString();
    }

    @Override
    public void input() {
        super.input();
        setIdEmp(idEmp);
    }

    @Override
    public void output() {
        System.out.printf("|  %-10s|  %-20s|", idEmp, position);
        super.output();
    }
}