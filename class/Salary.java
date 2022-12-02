import java.text.DecimalFormat;
import java.util.Scanner;

public class Salary implements InOut {
    static Scanner scanner = new Scanner(System.in);
    private double indexSalary;
    private int someHolidays;
    private double overtime;
    private long totalSalary;
    protected long baseSalary = 200000;

    public Salary() {
    }

    public Salary(double indexSalary,double overtime, int someHolidays, long totalSalary) {
        this.indexSalary = indexSalary;
        this.overtime = overtime;
        this.someHolidays = someHolidays;
        this.totalSalary = totalSalary;
    }

    public double getIndexSalary() {
        return indexSalary;
    }

   
    public void setIndexSalary(double indexSalary) {
        
        this.indexSalary = indexSalary;
    }

    public void setIndexSalary() {
        System.out.print("==> Enter a number of index salary: ");
        indexSalary = scanner.nextDouble();
        this.indexSalary = indexSalary;
    }
    public double getOvertime() {
        return overtime;
    }

    public void setOvertime(double overtime) {
       
        this.overtime = overtime;
    }

    public void setOvertime() {
        System.out.print("==> Enter a number of overtime: ");
        overtime = scanner.nextDouble();
        this.overtime = overtime;
    }

    
    public int getSomeHolidays() {
        return someHolidays;
    }

    public void setSomeHolidays(int someHolidays) {
        this.someHolidays = someHolidays;
    }
    
    public void setSomeHolidays() {
        System.out.print("==> Enter a number of day-off: ");
        someHolidays = scanner.nextInt();
        this.someHolidays = someHolidays;
    }

    public long getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(long totalSalary) {
        this.totalSalary = totalSalary;
    }

    @Override
    public void input() {
        setIndexSalary();
        setOvertime();
        setSomeHolidays();
        
    }

    @Override
    public void output() {
        DecimalFormat formatter = new DecimalFormat("###,###,###,###,###");
        System.out.printf("|  %-20s|  %-20s|  %-20s| %-20s| %-20s|",baseSalary, indexSalary, overtime, someHolidays,
                formatter.format(totalSalary) + " VND");
        System.out.println();
    }

    public Long payRoll() {
        totalSalary = (long) (baseSalary * indexSalary * 26 - someHolidays * baseSalary + (long) (overtime*25000));
        return totalSalary;
    }

    @Override
    public String toString() {
        return indexSalary + "-" + someHolidays + "-" + totalSalary;
    }

}
