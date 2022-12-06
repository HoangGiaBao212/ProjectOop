import java.util.Scanner;
// import java.util.logging.Handler;
// import javax.management.modelmbean.ModelMBean;

public class SalaryManager implements RoleOfManager {

    static Scanner scanner = new Scanner(System.in);

    float indexSalary = 0;
    int someHolidays = 0;
    int overtime = 0;
    int year = 0;
    int month = 0;

    @Override
    public void inputList() {
        // Input new list account
        if (MenuHandle.m < 0 && MenuHandle.n < 0) {
            MenuContent.printNoData();
        } else {
            for (int i = 0; i < MenuHandle.m; i++) {
                for (Account o : MenuHandle.listAccount) {
                    if (o.getEmployee().getIdEmp().equals(MenuHandle.listDepartments[i].getIdChief())) {
                        System.out.println("--------------------------------------------------------------");
                        System.out.printf("|%-30s %-5s       |", "  ==> Input info salary of Chief Of Department ",
                                MenuHandle.listDepartments[i].getIdChief());
                        System.out.println("\n--------------------------------------------------------------");
                        System.out.print(" ==> Input year > ");
                        year = MenuHandle.getInputNumber();
                        System.out.print(" ==> Input month > ");
                        month = MenuHandle.getInputNumber();
                        while (!MenuHandle.checkStatus(o, year, month)) {
                            System.out.println(" <<<<< Month and year not under contract!!!");
                            System.out.print(" ==> Input year > ");
                            year = MenuHandle.getInputNumber();
                            System.out.print(" ==> Input month > ");
                            month = MenuHandle.getInputNumber();
                        }
                        System.out.print(" ==> Input indexSalary > ");
                        indexSalary = MenuHandle.getInputNumber();
                        System.out.print(" ==> Input daysOff > ");
                        someHolidays = MenuHandle.getInputNumber();
                        System.out.print(" ==> Input Overtime > ");
                        overtime = MenuHandle.getInputNumber();
                        o.getEmployee().netSalary(o, indexSalary, someHolidays, overtime, year, month);
                    }
                }

                for (int j = 0; j < MenuHandle.listDepartments[i].getMembers(); j++) {
                    String idEmp = MenuHandle.listDepartments[i].getIdEmployee()[j];
                    for (Account o : MenuHandle.listAccount) {
                        if (o.getEmployee().getIdEmp().equals(idEmp)) {
                            System.out.println("--------------------------------------------------------------");
                            System.out.print("|  ==> Input info salary of employee                          |\n");
                            System.out.println("--------------------------------------------------------------");
                            System.out.print(" ==> Input year > ");
                            year = MenuHandle.getInputNumber();
                            System.out.print(" ==> Input month > ");
                            while (!MenuHandle.checkStatus(o, year, month)) {
                                System.out.println(" <<<<< Month and year not under contract!!!");
                                System.out.print(" ==> Input year > ");
                                year = MenuHandle.getInputNumber();
                                System.out.print(" ==> Input month > ");
                                month = MenuHandle.getInputNumber();
                            }
                            month = MenuHandle.getInputNumber();
                            System.out.print(" ==> Input indexSalary > ");
                            indexSalary = MenuHandle.getInputNumber();
                            System.out.print(" ==> Input someHolidays > ");
                            someHolidays = MenuHandle.getInputNumber();
                            System.out.print(" ==> Input overtime > ");
                            overtime = MenuHandle.getInputNumber();
                            o.getEmployee().netSalary(o, indexSalary, someHolidays, overtime, year, month);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void outputList() {
        for (Department d : MenuHandle.listDepartments) {
            System.out.print(
                    "\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf(
                    "\n|                                                                               %-144s|",
                    "List salary for employee of department " + d.getDepartmentName());
            System.out.println(
                    "\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf(
                    "|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|",
                    "Id Employee", "Year", "January",
                    "February", "March", "April", "May", "June", "July", "August", "September", "October", "November",
                    "December");
            System.out.print(
                    "\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (Account account : MenuHandle.listAccount) {
                if (d.getIdChief().equalsIgnoreCase(account.getEmployee().getIdEmp())) {
                    account.getEmployee().outputSalary();
                }
            }
            for (Account account : MenuHandle.listAccount) {
                if (MenuHandle.checkIdOfDep(account.getEmployee().getIdEmp(), d.getDepartmentId()))
                    account.getEmployee().outputSalary();
            }
        }
    }

    @Override
    public void add() {
        String idEmpAdd;
        System.out.println("Enter idEmpAdd to add salary");
        idEmpAdd = MenuHandle.inputId("E");
        if (MenuHandle.m < 0 && MenuHandle.n < 0) {
            MenuContent.printNoData();
        } else {
            for (Account account : MenuHandle.listAccount) {
                if (account.getEmployee().getIdEmp().equalsIgnoreCase(idEmpAdd)) {
                    System.out.println("--------------------------------------------------------------");
                    System.out.print("|  ==> Input info salary of employee                          |\n");
                    System.out.println("--------------------------------------------------------------");
                    System.out.print(" ==> Input year > ");
                    year = MenuHandle.getInputNumber();
                    System.out.print(" ==> Input month > ");
                    month = MenuHandle.getInputNumber();
                    System.out.print(" ==> Input indexSalary > ");
                    indexSalary = MenuHandle.getInputNumberFloat();
                    System.out.print(" ==> Input someHolidays > ");
                    someHolidays = MenuHandle.getInputNumber();
                    System.out.print(" ==> Input overtime > ");
                    overtime = MenuHandle.getInputNumber();
                    account.getEmployee().netSalary(account, indexSalary, someHolidays, overtime, year, month);
                }
            }
        }
    }

    @Override
    public void remove(String idEmpRemove) {
        System.out.println("Enter idEmpAdd to add salary");
        idEmpRemove = MenuHandle.inputId("E");
        if (MenuHandle.m < 0 && MenuHandle.n < 0) {
            MenuContent.printNoData();
        } else {
            for (int i = 0; i < MenuHandle.n; i++) {
                if (MenuHandle.listAccount[i].getEmployee().getIdEmp().equalsIgnoreCase(idEmpRemove)) {
                    System.out.println("--------------------------------------------------------------");
                    System.out.print("|  ==> Input info salary of employee                          |\n");
                    System.out.println("--------------------------------------------------------------");
                    System.out.print(" ==> Input year > ");
                    year = MenuHandle.getInputNumber();
                    System.out.print(" ==> Input month > ");
                    month = MenuHandle.getInputNumber();
                    // System.out.print(" ==> Input indexSalary > ");
                    // indexSalary = MenuHandle.getInputNumberFloat();
                    // System.out.print(" ==> Input someHolidays > ");
                    // someHolidays = MenuHandle.getInputNumber();
                    // System.out.print(" ==> Input overtime > ");
                    // overtime = MenuHandle.getInputNumber();
                    MenuHandle.listAccount[i].getEmployee().netSalary(MenuHandle.listAccount[i], indexSalary,
                            someHolidays, overtime, year, month);
                }
            }
        }
    }

    @Override
    public void edit(String idEdit) {
        if (MenuHandle.n < 0)
            MenuContent.printNoData();
        else {
            System.out.print(" ==> Enter if employee to edit  ");
            idEdit = scanner.nextLine();
            for (Account o : MenuHandle.listAccount) {
                if (o.getEmployee().getIdEmp().equalsIgnoreCase(idEdit)) {
                    System.out.println("--------------------------------------------------------------");
                    System.out.print("|  ==> Input info salary of employee                          |\n");
                    System.out.println("--------------------------------------------------------------");
                    System.out.print(" ==> Input year > ");
                    year = MenuHandle.getInputNumber();
                    System.out.print(" ==> Input month > ");
                    month = MenuHandle.getInputNumber();
                    System.out.print(" ==> Input indexSalary > ");
                    indexSalary = MenuHandle.getInputNumberFloat();
                    System.out.print(" ==> Input someHolidays > ");
                    someHolidays = MenuHandle.getInputNumber();
                    System.out.print(" ==> Input overtime > ");
                    overtime = MenuHandle.getInputNumber();
                    o.getEmployee().netSalary(o, indexSalary, someHolidays, overtime, year, month);
                }
            }
        }
    }

    @Override
    public void statistics() {
        MenuContent.quantityCount();
    }

    @Override
    public void find(String idFind) {
        if (MenuHandle.n < 0)
            MenuContent.printNoData();
        else {
            System.out.println(
                    "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf(
                    "|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|  %-13s|",
                    "Id Employee", "Year", "January",
                    "February", "March", "April", "May", "June", "July", "August", "September", "October", "November",
                    "December");
            System.out.print(
                    "\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.print("Enter if employee to find: ");
            idFind = scanner.nextLine();
            for (Account o : MenuHandle.listAccount) {
                if (o.getEmployee().getIdEmp().equalsIgnoreCase(idFind)) {
                    o.getEmployee().outputSalary();
                }
            }
        }
    }
}