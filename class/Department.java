import java.util.Scanner;

//Thuộc tính: Mã phòng ban,tên phòng ban,tên trưởng phòng,số lượng nhân viên,
public class Department implements InOut {
    private static Scanner sc = new Scanner(System.in);
    private String DepartmentID;
    private String DepartmentName;
    private String Chiefname;
    private int members;

    public Department() {

    }
    public Department(String DepartmentID,String DepartmentName,String Chiefname,int members){
        this.DepartmentID = DepartmentID;
        this.DepartmentName = DepartmentName;
        this.Chiefname = Chiefname;
        this.members = members;
    }

    public String getDepartmentID() {
        return this.DepartmentID;
    }

    public void setDepartmentID(String DepartmentID) {
        System.out.print("Enter the Department ID: ");
        DepartmentID = sc.nextLine();
        while (DepartmentID.isEmpty()) {
            System.out.print("Don't leave it empty.Please enter: ");
            DepartmentID = sc.nextLine();
        }
        while(DepartmentID.startsWith("D")){
            System.out.print("Department must start with letter D(Ex:D001).Please enter again: ");
            DepartmentID = sc.nextLine();
        }
        this.DepartmentID = DepartmentID;
    }

    public String getDepartmentName() {
        return this.DepartmentName;
    }

    public void setDepartmentName(String DepartmentName) {
        System.out.print("Enter the Department's name: ");
        DepartmentName = sc.nextLine();
        while (DepartmentName.isEmpty()) {
            System.out.print("Don't leave it empty.Please enter: ");
            DepartmentName = sc.nextLine();
        }
        this.DepartmentName = DepartmentName;
    }

    public String getChiefname() {
        return this.Chiefname;
    }

    public void setChiefname(String Chiefname) {
        System.out.print("Enter the Chief of Department: ");
        Chiefname = sc.nextLine();
        while (Chiefname.isEmpty()) {
            System.out.print("Don't leave it empty.Please enter: ");
            Chiefname = sc.nextLine();
        }
        this.Chiefname = Chiefname;
    }

    public int getMembers() {
        return this.members;
    }

    public void setMembers(int members) {
        System.out.print("Enter the amount of members: ");
        members = sc.nextInt();
        while (members < 0 && members >= 5) {
            System.out.print("Members must greater than 0 and less or equal to 5.Please enter again: ");
            members = sc.nextInt();
        }
        this.members = members;
    }

    @Override
    public void input() {
        setDepartmentID(DepartmentID);
        setDepartmentName(DepartmentName);
        setChiefname(Chiefname);
        setMembers(members);
    }
    @Override
    public void output() {
        System.out.printf("     %-15s|     %-15s|     %-15s|",DepartmentID,DepartmentName,Chiefname);
        System.out.printf("     %-15s|",members);


    }

}
