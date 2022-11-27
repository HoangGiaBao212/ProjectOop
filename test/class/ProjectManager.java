import java.util.Arrays;
import java.util.Scanner;

public class ProjectManager implements RoleOfManager {
    private static int n = 0;
    private Project projectManager[] = new Project[0];
    private Scanner sc = new Scanner(System.in);

    @Override
    public void inputList() {
        System.out.println("-----------------------------------------");
        System.out.println("|           ADD PROJECT'S LIST          |");
        System.out.println("-----------------------------------------");
        System.out.print("Enter amount of project: ");
        while (true) {
            try {
                n = Integer.parseInt(sc.nextLine());
                if (n > 0) {
                    break;
                } else {
                    System.out.println("The amount must greater than 0.Please enter again: ");
                }
            } catch (Exception e) {
                System.out.println("Wrong input.Enter again: ");
            }
        }
        projectManager = new Project[n];
        for (int i = 0; i < n; i++) {
            // System.out.println("So luong hop dong: " + n);
            System.out.println("Enter the project  " + (i + 1 + ":"));
            projectManager[i] = new Project();
            projectManager[i].input();
        }
        System.out.println("-------------------------------------------------");
        System.out.println("|         ADD PROJECT'S LIST SUCCESSFUL!        |");
        System.out.println("-------------------------------------------------");

    }

    @Override
    public void outputList() {
        System.out.println("");
        if (projectManager.length == 0) {
            System.out.println("-----------------------------------");
            System.out.println("        No data in the list         ");
        } else {
            System.out.println(
                    "     ----------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf(
                    "    %-15s|   %-15s|   %-15s|   %-15s|   %-15s|    %-15s|   %-15s|    %-15s|",
                    "Project ID", "Project name", "Project header", "Name", "Gender", "Date of birth", "Phone number","Participants");
            System.out.println();
            System.out.println(
                    "     ----------------------------------------------------------------------------------------------------------------------------------");
            for (Project p : projectManager) {
                p.output();
                System.out.println();
            }
        }
    }

    @Override
    public void add() {
        System.out.println("---------------------------------------");
        System.out.println("|             ADD PROJECT             |");
        System.out.println("---------------------------------------");
        int count = 0;

        Project x = new Project();
        x.setIdProject(null);
        for (Project p : projectManager) {
            if (p.getIdProject().equalsIgnoreCase(x.getIdProject())) {
                count++;
            }
        }
        if (count != 0) {
            System.out.println("Project has exist!");
        } else {
            // System.out.println("So luong hop dong dang co: " + n);
            projectManager = Arrays.copyOf(projectManager, n + 1);
            projectManager[n] = x;
            n++;
            System.out.println("---------------------------------------------------------");
            System.out.println("|               Add Project Successful!                 |");
            System.out.println("---------------------------------------------------------");
        }
    }

    @Override
    public void edit() {
        System.out.println("----------------------------------------------------");
        System.out.println("|           EDIT INFORMATION IN PROJECT            |");
        System.out.println("----------------------------------------------------");
        String idTemp;
        int key;
        System.out.print("Enter project ID to edit: ");
        idTemp = sc.nextLine();
        int count = 0;
        for (Project p : projectManager) {
            if (p.getIdProject().equalsIgnoreCase(idTemp)) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("--------------------------------------");
            System.out.println("        Project ID don't exist!       ");
        } else {
            for (Project p : projectManager) {
                if (p.getIdProject().equalsIgnoreCase(idTemp)) {
                    System.out.println("------------------------------------------");
                    System.out.println("| 1.Change Project Name                  |");
                    System.out.println("| 2.Change the header's Project ID       |");
                    System.out.println("| 3.Change the amount of participants    |");
                    System.out.println("------------------------------------------");
                    System.out.print("==> Input option: ");
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
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println("|                      <Choice does not exist!>                    |");
                            System.out.println("--------------------------------------------------------------------");
                            break;
                    }
                }
            }
            System.out.println("Sua thanh cong!!");
        }
    }

    @Override
    public void remove() {
        System.out.println("----------------------------------------------------");
        System.out.println("|                   REMOVE PROJECT                 |");
        System.out.println("----------------------------------------------------");
        String idTemp;
        System.out.print("Enter Project ID to remove: ");
        idTemp = sc.nextLine();
        int count = 0;
        for (Project e : projectManager) {
            if (e.getIdProject().equalsIgnoreCase(idTemp)) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("--------------------------------------");
            System.out.println("        Project ID don't exist!       ");
        } else {
            for (int i = 0; i < n; i++) {
                if (projectManager[i].getIdProject().equalsIgnoreCase(idTemp)) {
                    projectManager[i] = projectManager[i + 1];
                }
                projectManager = Arrays.copyOf(projectManager, n - 1);
                n--;
            }
        }
        System.out.println("-------------------------------------------------");
        System.out.println("|               Remove successful!              |");
        System.out.println("-------------------------------------------------");
    }

    @Override
    public void find() {
        System.out.println("-------------------------------------------------");
        System.out.println("|                SEARCH CONTRACT                |");
        System.out.println("-------------------------------------------------");
        String idFind;
        System.out.println("Enter Project ID to search: ");
        idFind = sc.nextLine();
        int count = 0;
        for (Project p : projectManager) {
            if (p.getIdProject().equalsIgnoreCase(idFind)) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("--------------------------------------");
            System.out.println("        Project ID don't exist!       ");
        } else {
            for (Project p : projectManager) {
                if (p.getIdProject().equalsIgnoreCase(idFind)) {
                    System.out.println("-------------------------------------------------");
                    System.out.println("|                 Find Successful!              |");
                    System.out.println("-------------------------------------------------");
                    p.output();
                }
            }
        }
    }

}
