import java.util.Scanner;

class Employee extends Person implements InOut {
    static Scanner scanner = new Scanner(System.in);
    private String idEmp;
    private String position;
    private Salary salary;
    private Project project;
    private Department department;

    public Employee() {
        super();
    }

    public Employee(String position, String name, int age, String gender, String email, String address, String phone,
            Salary salary, Project project, Department department) {
        super(name, age, gender, email, address, phone);
        this.position = position;
        this.salary = salary;
        this.project = project;
        this.department = department;
    }

    public Employee(String name, int age, String gender, String email, String address, String phone, String idEmp,
            String position) {
        super(name, age, gender, email, address, phone);
        this.idEmp = idEmp;
        this.position = position;
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

    public int getCoefficientsSalary(int coefficientsSalary) {
        return coefficientsSalary;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        project.input();
        this.project = project;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return idEmp + "-" + position + "-" + super.toString();
    }

    @Override
    public void input() {
        super.input();
        setIdEmp(idEmp);
        // setPosition(position);
        // setSalary(salary);
        // setDepartment(department);
        // setProject(project);
    }

    @Override
    public void output() {
        System.out.printf("|  %-10s|  %-20s|", idEmp, position);
        super.output();
        System.out.println();
    }
}