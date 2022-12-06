import java.util.Scanner;

//Thuộc tính: Mã phòng ban,tên phòng ban,tên trưởng phòng,số lượng nhân viên,
public class Department {
    private static Scanner scanner = new Scanner(System.in);
    private String departmentId;
    private String departmentName;
    private String idChief;
    private int members;
    String[] idEmployee;

    public Department() {

    }

    public Department(String departmentId, String departmentName, String idChief, int members, String[] idEmployee) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.idChief = idChief;
        this.members = members;
        this.idEmployee = idEmployee;
    }

    public String getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(String departmentId) {
        departmentId = MenuHandle.inputId("D");
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        System.out.print("Enter the Department's name: ");
        departmentName = scanner.nextLine();
        while (departmentName.isEmpty()) {
            System.out.print("Don't leave it empty.Please enter: ");
            departmentName = scanner.nextLine();
        }
        this.departmentName = departmentName;
    }

    public int getMembers() {
        return this.members;
    }

    public void setMembers(int members) {
        if (members <= 0) {
            System.out.print("Enter the amount of members: ");
            members = MenuHandle.getInputNumber();
            while (members < 0 && members >= 5) {
                System.out.print("Members must greater than 0 and less or equal to 5.Please enter again: ");
                members = MenuHandle.getInputNumber();
            }
        }
        this.members = members;
    }

    public String getIdChief() {
        return idChief;
    }

    public void setIdChief(String idChief) {
        System.out.print("Input id chief :");
        idChief = MenuHandle.inputId("CD");

        this.idChief = idChief;
    }

    public String[] getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String[] idEmployee) {
        idEmployee = new String[members];
        System.out.println(" ------ Enter id for employee ----------- ");
        for (int i = 0; i < members; i++) {
            System.out.print(" ==> Enter id of employee number: " + i);
            idEmployee[i] = new String();
            idEmployee[i] = MenuHandle.inputId("E");
        }
        this.idEmployee = idEmployee;
    }

    public void input() {
        setDepartmentId(departmentId);
        setDepartmentName(departmentName);
        setIdChief(idChief);
        setMembers(members);
        setIdEmployee(idEmployee);
    }

    public void output() {
        System.out.println(
                "\n--------------------------------------------------------------------------------------------------------------");
        System.out.printf("|     %-20s|     %-20s|     %-20s|     %-25s|", departmentId, departmentName, idChief,
                idEmployee[0]);

        for (int i = 1; i < members; i++) {
            System.out.printf("\n|     %-20s|     %-20s|     %-20s|     %-25s|", "", "", "",
                    idEmployee[i]);

        }
        System.out.println(
                "\n--------------------------------------------------------------------------------------------------------------");
    }

    @Override
    public String toString() {
        return departmentId + "-" + departmentName + "-" + idChief + "-" + members + toStringArray();
    }

    public String toStringArray() {
        String str = "";
        for (int i = 0; i < members; i++) {
            str += "-" + idEmployee[i];
        }
        return str;
    }
}
