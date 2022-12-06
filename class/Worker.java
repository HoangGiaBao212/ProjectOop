// import java.time.Year;

public abstract class Worker extends Person {
    protected long[] salaryDiary = new long[1];

    public Worker() {

    }

    public Worker(long[] salaryDiary) {
        this.salaryDiary = salaryDiary;
    }

    public Worker(String name, int age, String gender, String email, String address, String phone) {
        super(name, age, gender, email, address, phone);
    }

    public long[] getSalaryDiary() {
        return salaryDiary;
    }

    public void setSalaryDiary(long[] salaryDiary) {
        this.salaryDiary = salaryDiary;
    }

    @Override
    public void input() {
        super.input();
    }

    @Override
    public void output() {
        super.output();
    }

    public abstract void netSalary(Account account, Float indexSalary, int someHolidays, int overtime, int year,
            int month);

    public abstract void outputSalary();

}
