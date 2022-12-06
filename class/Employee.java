import java.util.Scanner;

class Employee extends Worker {

    static Scanner scanner = new Scanner(System.in);
    private String idEmp;
    private String position;
    private Contract contract;

    public Employee() {
        super();
    }

    public Employee(long[] salaryDiary) {
        super(salaryDiary);
    }

    public Employee(String idEmp, String position) {
        this.idEmp = idEmp;
        this.position = position;
    }

    public Employee(String idEmp, String position, String name, int age, String gender, String email, String address,
            String phone) {
        super(name, age, gender, email, address, phone);
        this.idEmp = idEmp;
        this.position = position;
    }

    public Employee(String name, int age, String gender, String email, String address, String phone,
            String idEmp, String position, Contract contract) {
        super(name, age, gender, email, address, phone);
        this.idEmp = idEmp;
        this.position = position;
        this.contract = contract;
    }

    public String getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(String idEmp) {
        idEmp = MenuHandle.inputId(idEmp);
        this.idEmp = idEmp;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    @Override
    public String toString() {
        return "admin" + "-" + idEmp + "-" + position + "-" + super.toString();
    }

    @Override
    public void input() {
        super.input();
    }

    @Override
    public void output() {
        System.out.printf("|  %-10s|  %-20s|", idEmp, position);
        super.output();
    }

    @Override
    public void outputSalary() {
        // System.out.println("----------- Info salaryDiary of employee is " + idEmp);
        // for (int i = 0; i < salaryDiary.length; i++) {
        // if (salaryDiary[i] == 0 && i % 13 == 0 && i != 0)
        // break;
        // System.out.println("Year: " + salaryDiary[i]);
        // for (int j = 1; j <= 12; j++) {
        // i++;
        // System.out.println("Month " + j + ": " + salaryDiary[i]);
        // }
        // }
    }

    public String toStringSalary(String idEmp) {
        String str = "";
        for (int i = 1; i <= 12; i++) {
            str += "-" + "0";
        }
        return getIdEmp() + str;
    }

    @Override
    public void netSalary(Account account, Float indexSalary, int someHolidays, int overtime, int year, int month) {
    }
}