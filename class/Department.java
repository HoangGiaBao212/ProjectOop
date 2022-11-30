import java.util.Arrays;
import java.util.Scanner;

//Thuộc tính: Mã phòng ban,tên phòng ban,tên trưởng phòng,số lượng nhân viên,
public class Department implements InOut {
    private static Scanner scanner = new Scanner(System.in);
    private String departmentId;
    private String departmentName;
    private int members;
    private Boolean status = false;
    private String[] idEmployee;

    public Department() {

    }

    public Department(String departmentId, String departmentName, int members, Boolean status, String[] idEmployee) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.members = members;
        this.status = status;
        this.idEmployee = idEmployee;
    }

    public Department(String departmentId, String departmentName, int members, String[] idEmployee) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.members = members;
        this.idEmployee = idEmployee;
    }

    public String getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(String departmentId) {
        System.out.print("Enter the Department Id: ");
        departmentId = scanner.nextLine();
        while (departmentId.isEmpty()) {
            System.out.print("Don't leave it empty.Please enter: ");
            departmentId = scanner.nextLine();
        }
        while (!departmentId.startsWith("D")) {
            System.out.print("Department must start with letter D(Ex:D001).Please enter again: ");
            departmentId = scanner.nextLine();
        }
        this.departmentId = departmentId;
    }

    public String departmentName() {
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
        System.out.print("Enter the amount of members: ");
        members = Integer.parseInt(scanner.nextLine());
        while (members < 0 && members >= 5) {
            System.out.print("Members must greater than 0 and less or equal to 5.Please enter again: ");
            members = Integer.parseInt(scanner.nextLine());
        }
        this.members = members;
    }

    public String[] getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String[] idEmployee) {
        idEmployee = new String[members];
        System.out.println(" ------ Enter id for employee ----------- ");
        for (int i = 0; i < members; i++) {
            System.out.print(" ==> Enter id of employee number: " + i);
            idEmployee[i] = new String(scanner.nextLine());
            while (!Handle.checkIdEmployee(idEmployee[i])) {
                Handle.noteNoHaveId(idEmployee[i]);
                idEmployee[i] = scanner.nextLine();
            }
        }
        this.idEmployee = idEmployee;
    }

    @Override
    public void input() {
        setDepartmentId(departmentId);
        setDepartmentName(departmentName);
        setMembers(members);
        setIdEmployee(idEmployee);
    }

    @Override
    public void output() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.printf("\n     %-15s|     %-15s|     %-15s", departmentId, departmentName, members);
        System.out.println("--------------------------------------------------------------------------------");

        for (int i = 0; i < members; i++) {
            System.out.println("\n" + idEmployee[i]);
        }
        System.out.println("\n-------------------------------------------------------------------------------");
    }

    @Override
    public String toString() {
        return departmentId + "-" + departmentName + "-" + members + toStringArray();
    }

    public String toStringArray() {
        String str = "";
        for (int i = 0; i < members; i++) {
            str += "-" + idEmployee[i];
        }
        return str;
    }
}
