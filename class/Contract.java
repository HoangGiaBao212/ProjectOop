import java.sql.Date;

import java.util.Scanner;

public class Contract implements InOut {
    Scanner sc = new Scanner(System.in);
    
    private String contractID;
    private String timeStart;
    private String timeEnd;
    public Contract() {
        // super();
        timeStart = "";
        timeEnd = "";
        contractID = "";
    }

    public Contract(String contractID, String name, String gender, String dob, String phone, String email,String timeStart,String timeEnd) {
        // super(name, gender, dob, phone, email);
        this.contractID = contractID;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }

    public String getContractID() {
        return this.contractID;
    }

    public void setContractID(String contractID) {
        System.out.print("Nhap ma hop dong: ");
        contractID = sc.nextLine();
        while (contractID.isEmpty()) {
            System.out.print("Khong duoc de trong.Vui long nhap lai: ");
            contractID = sc.nextLine();
        }
        if (!contractID.startsWith("HD")) {
            System.out.print("Ma hop dong phai bat dau bang ki tu HD.Vui long nhap lai: ");
            contractID = sc.nextLine();
        }
        this.contractID = contractID;
    }
    // SimpleDateFormat formatter = new SimpleDateFormat("YYYY");
    // Date date = new Date(); 
    public String getTimeStart() {
        return this.timeStart;
    }

    public void setTimeStart(String timeStart) {
        System.out.print("Nhap ngay bat dau lam viec theo dinh dang YYYY/MM/DD: ");
        timeStart = sc.nextLine();
        while (timeStart.isEmpty()) {
            System.out.print("Khong duoc de trong.Vui long nhap lai: ");
            timeStart = sc.nextLine();
        }
        // String temp[] = timeStart.split("/");
        // System.out.println(Integer.parseInt(temp[0]));
        // if(Integer.parseInt(formatter.format(date))){

        // }
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return this.timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        System.out.print("Nhap ngay ket thuc lam viec theo dinh dang YYYY/MM/DD(du kien): ");
        timeEnd = sc.nextLine();
        while (timeEnd.isEmpty()) {
            System.out.print("Khong duoc de trong.Vui long nhap lai: ");
            timeEnd = sc.nextLine();
        }
        this.timeEnd = timeEnd;
    }

    @Override
    public void input() {
        setContractID(contractID);
        // super.input();
        setTimeStart(timeStart);
        setTimeEnd(timeEnd);
    }
    @Override
    public void output(){
        System.out.printf("|   %-15s|", contractID);
		// super.output();
        System.out.printf("|   %-15s|   %-15s",timeStart,timeEnd);
    }
    // @Override
    // public String toStringContract() {
    //     return getContractID() + " " + getName() + " " + getGender() + " " + getDob() + " " + getPhone() + " " + getEmail() + " "
    //             + getTimeStart() + " " + getTimeEnd();
    // }

}
