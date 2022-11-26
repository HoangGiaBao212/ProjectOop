import java.util.Arrays;
import java.util.Scanner;

public class ProjectManager implements RoleOfManager {
    private static int n = 0;
    private Project projectManager[] = new Project[0];
    private Scanner sc = new Scanner(System.in);

    @Override
    public void inputList() {
        System.out.println("ADD PROJECT'S LIST");
        System.out.println("Enter amount of project: ");
        while (true) {
            try {
                n = Integer.parseInt(sc.nextLine());
                if (n > 0) {
                    break;
                } else {
                    System.out.println("So luong phai lon hon 0.Vui long nhap lai: ");
                }
            } catch (Exception e) {
                System.out.println("Nhap sai.Nhap lai: ");
            }
        }
        projectManager = new Project[n];
        for (int i = 0; i < n; i++) {
            System.out.println("So luong hop dong: " + n);
            System.out.println("Nhap hop dong thu " + (i + 1 + ":"));
            projectManager[i] = new Project();
            projectManager[i].input();
        }
        System.out.println("\nNhap danh sach thanh cong!");
    }

    @Override
    public void outputList() {
        System.out.println("");
        if (projectManager.length == 0) {
            System.out.println("Chua co du lieu");
        } else {
            System.out.println(
                    "     ----------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf(
                    "    %-15s|   %-15s|   %-15s|   %-15s|   %-15s|    %-15s|   %-15s|    %-15s|",
                    "Ma du an", "Ten du an", "Nguoi chu tri du an", "Ho ten", "Gioi tinh", "Ngay sinh", "So dien thoai",
                    "So luong thanh vien");
            System.out.println();
            System.out.println(
                    "     ----------------------------------------------------------------------------------------------------------------------------------");
            for (Project p : projectManager) {
                p.output();
                System.out.println();
            }
        }
        // System.out.println("----------------------------------------------------");
    }

    @Override
    public void add() {
        System.out.println("THEM DU LIEU");
        int count = 0;

        Project x = new Project();
        x.setIdProject(null);
        for (Project p : projectManager) {
            if (p.getIdProject().equalsIgnoreCase(x.getIdProject())) {
                count++;
            }
        }
        if (count != 0) {
            System.out.println("Hop dong da ton tai");
        } else {
            System.out.println("So luong hop dong dang co: " + n);
            projectManager = Arrays.copyOf(projectManager, n + 1);
            projectManager[n] = x;
            n++;
            System.out.println("Da them thanh cong!");
        }
    }

    @Override
    public void edit() {
        System.out.println("SUA THONG TIN DU AN");
        String idTemp;
        int key;
        System.out.println("Nhap ma du an can sua");
        idTemp = sc.nextLine();
        int count = 0;
        for (Project p : projectManager) {
            if (p.getIdProject().equalsIgnoreCase(idTemp)) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Ma du an khong ton tai");
        } else {
            for (Project p : projectManager) {
                if (p.getIdProject().equalsIgnoreCase(idTemp)) {
                    System.out.println("1.Sua ten du an");
                    System.out.println("2.Sua id chu du an");
                    System.out.println("3.Sua so luong thanh vien");
                    System.out.print("==> Nhap lua chon: ");
                    key = Integer.parseInt(sc.nextLine());
                    switch (key) {
                        case 1:
                            p.setNameProject(null);
                            break;
                        case 2:
                            p.setIdLeader(null);
                            break;
                        case 3:
                            p.setParticipants(0);
                            break;
                        default:
                            System.out.println("\nLua chon khong ton tai!\n");
                            break;
                    }
                }
            }
            System.out.println("Sua thanh cong!!");
        }
    }

    @Override
    public void remove() {
        System.out.println("SUA THONG TIN");
        String idTemp;
        System.out.print("Nhap ma hop dong can xoa: ");
        idTemp = sc.nextLine();
        int count = 0;
        for (Project e : projectManager) {
            if (e.getIdProject().equalsIgnoreCase(idTemp)) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Ma hop dong khong ton tai");
        } else {
            for (int i = 0; i < n; i++) {
                if (projectManager[i].getIdProject().equalsIgnoreCase(idTemp)) {
                    projectManager[i] = projectManager[i + 1];
                }
                projectManager = Arrays.copyOf(projectManager, n - 1);
                n--;
            }
        }
        System.out.println("Xoa thanh cong!!!");
    }

    @Override
    public void find() {
        System.out.println("TIM KIEM DU LIEU");
        String idFind;
        System.out.println("Nhap ma hop dong can tim: ");
        idFind = sc.nextLine();
        int count = 0;
        for (Project p : projectManager) {
            if (p.getIdProject().equalsIgnoreCase(idFind)) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Ma hop dong khong ton tai!");
        } else {
            for (Project p : projectManager) {
                if (p.getIdProject().equalsIgnoreCase(idFind)) {
                    p.output();
                }
            }
        }
    }

}
