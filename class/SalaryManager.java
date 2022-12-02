import java.util.Scanner;

import javax.management.modelmbean.ModelMBean;

public class SalaryManager implements RoleOfManager {
    double indexSalary;
    static Scanner scanner = new Scanner(System.in);

    

    @Override
    public void inputList() {
        
        
        for (int i = 0; i < Handle.n; i++) {
            System.out.println("Enter information about employee with id: " + Handle.listAccount[i].getEmployee().getIdEmp());
            
            Salary salary = new Salary();
            salary.input();
            
            salary.payRoll();
            Handle.listAccount[i].getEmployee().setSalary(salary);
        }
    }

    @Override
    public void outputList() {
        System.out.println(Handle.n);
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("|  %-10s|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|", "ID",
                "Name", "Position", "Coefficients Salary", "Some Holidays", "Salary");
        System.out.println(
                "\n---------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < Handle.n; i++) {
            if (Handle.listAccount[i].getEmployee().getSalary() == null) {
                continue;
            }
            System.out.printf("|  %-10s|  %-20s|  %-20s", Handle.listAccount[i].getEmployee().getIdEmp(),
                    Handle.listAccount[i].getEmployee().getName(),
                    Handle.listAccount[i].getEmployee().getPosition());
            Handle.listAccount[i].getEmployee().getSalary().output();
            System.out.println(
                    "---------------------------------------------------------------------------------------------------------------------------------");
        }
    }

    @Override
    public void add() {
        String idEmpAdd;
        System.out.print("==> Enter id of employee to add list salary: ");
        idEmpAdd = scanner.nextLine();
        if (Handle.checkIdEmployee(idEmpAdd)) {
            for (int i = 0; i < Handle.n; i++) {
                if (Handle.listAccount[i].getEmployee().getIdEmp().equals(idEmpAdd)) {
                   
                    Salary salary = new Salary();
                    
                    salary.payRoll();
                    Handle.listAccount[i].getEmployee().setSalary(salary);
                }
            }
        } else {
            System.out.println("Employee is exits or don't have employee with id: " + idEmpAdd);
        }
    }

    @Override
    public void remove(String idRemove) {
        System.out.println("-------------------------------------------------");
        System.out.println("|           REMOVE EMPLOYEE'S SALARY            |");
        System.out.println("-------------------------------------------------");
        if (idRemove == null) {
            System.out.print("Enter id of employee to remove: ");
            idRemove = scanner.nextLine();
        }
        for (int i = 0; i < Handle.n; i++) {
            if (Handle.listAccount[i].getEmployee().getIdEmp().equals(idRemove)) {
                Handle.listAccount[i].getEmployee().setSalary(null);
            }
        }
        if (!Handle.checkIdEmployee(idRemove)) {
            System.out.println("Not find id is: " + idRemove);
        } else
            MenuContent.noteSuccess("Remove");
    }

    @Override
    public void edit(String idEdit) {
        int option = 0;
        if (idEdit == null) {
            System.out.println("--------------------------------------------------------------");
            System.out.println("|                  EDIT SALARY INFORMATION                   |");
            System.out.println("--------------------------------------------------------------\n\n");
            System.out.print("==> Enter employee ID to edit:");
            idEdit = scanner.nextLine();
        }
        MenuContent.optionEdit();
        option = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < Handle.n; i++) {
            switch (option) {
                case 1:
                    if (Handle.listAccount[i].getEmployee().getIdEmp().equalsIgnoreCase(idEdit)) {
                        System.out.println();
                        System.out.println("--------------------------------------------------");
                        System.out.println("| 1.Change index salary                          |");
                        System.out.println("| 2.Change Day-Off                               |");
                        System.out.println("| 3.Overtime                               |");
                        System.out.println("--------------------------------------------------");
                        System.out.print("==> Input Option: ");
                        option = Integer.parseInt(scanner.nextLine());
                        switch (option) {
                            case 1:{
                                System.out.print("==>Enter index salary this month: ");
                                Handle.listAccount[i].getEmployee().getSalary().setIndexSalary();
                                break;
                            }
                            case 2:{
                                System.out.print("==>Enter holidays this month: ");
                                Handle.listAccount[i].getEmployee().getSalary().setSomeHolidays(0);
                                break;
                            }
                            case 3:{
                                System.out.print("==>Enter overtime this month: ");
                                Handle.listAccount[i].getEmployee().getSalary().setOvertime(i);
                                break;
                            }
                            default:{
                                MenuContent.choiceWrong();
                                break;
                            }
                        }
                    }
                    break;
                case 2:
                    if (Handle.listAccount[i].getEmployee().getIdEmp().equalsIgnoreCase(idEdit)) {
                        Handle.listAccount[i].getEmployee().setSalary(null);
                    }
                    break;
                default:
                    MenuContent.choiceWrong();
                    break;
            }
        }
        if (!Handle.checkIdEmployee(idEdit)) {
            System.out.println("Not find id is: " + idEdit);
        } else
            MenuContent.noteSuccess("Edit");
    }

    @Override
    public void find(String idSearch) {
        if (idSearch == null) {
            System.out.println("---------------------------------------");
            System.out.println("|         FIND EMPLOYEE'S SALARY      |");
            System.out.println("---------------------------------------");
            System.out.print("Enter id of employee to search: ");
            idSearch = scanner.nextLine();
        }

        for (int i = 0; i < Handle.n; i++) {
            if (Handle.listAccount[i].getEmployee().getSalary() == null) {
                continue;
            }
            if (Handle.listAccount[i].getEmployee().getIdEmp().equalsIgnoreCase(idSearch)) {
                System.out.println(
                        "---------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("|  %-10s|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|", "ID",
                        "Name", "Position", "Coefficients Salary", "Some Holidays", "Salary");
                System.out.println(
                        "\n---------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("|  %-10s|  %-20s|  %-20s", Handle.listAccount[i].getEmployee().getIdEmp(),
                        Handle.listAccount[i].getEmployee().getName(),
                        Handle.listAccount[i].getEmployee().getPosition());
                Handle.listAccount[i].getEmployee().getSalary().output();
                System.out.println(
                        "---------------------------------------------------------------------------------------------------------------------------------");

            }
        }
        if (!Handle.checkIdEmployee(idSearch)) {
            System.out.println("Not find id is: " + idSearch);
        }
    }
    @Override 
    public void statistics(){
        MenuContent.quantityCount("Salary", Handle.n);
    }
}