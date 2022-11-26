import java.util.Scanner;

class Project implements InOut {
    Scanner sc = new Scanner(System.in);
    private String idProject;
    private String nameProject;
    private String idLeader;
    private int participants;

    public Project() {

    }

    public Project(String idProject, String nameProject, String idLeader, int participants) {
        this.idProject = idProject;
        this.nameProject = nameProject;
        this.idLeader = idLeader;
        this.participants = participants;
    }

    public String getIdProject() {
        return idProject;
    }

    public void setIdProject(String idProject) {
        System.out.print("Input project id(Ex: P001): ");
        idProject = sc.nextLine();
        while (idProject.isEmpty()) {
            System.out.print("Khong duoc de trong.Vui long nhap lai: ");
            idProject = sc.nextLine();
        }
        this.idProject = idProject;
    }

    public String getNameProject() {
        return nameProject;
    }

    public void setNameProject(String nameProject) {
        System.out.print("Input project's name: ");
        nameProject = sc.nextLine();
        while (nameProject.isEmpty()) {
            System.out.print("Khong duoc de trong.Vui long nhap lai: ");
            nameProject = sc.nextLine();
        }
        this.nameProject = nameProject;
    }

    public String getIdLeader() {
        return idLeader;
    }

    public void setIdLeader(String idLeader) {
        System.out.print("Input Id's Leader: ");
        idLeader = sc.nextLine();
        while (idLeader.isEmpty()) {
            System.out.print("\n     Khong duoc de trong! Nhap lai: ");
            idLeader = sc.nextLine();
        }
        this.idLeader = idLeader;
    }
    public int getParticipants() {
        return participants;
    }
    public void setParticipants(int participants) {
        System.out.print("Enter the amount of participants: ");
        participants = sc.nextInt();
        while (participants <= 2) {
            System.out.println("The amount must greater or equal than 2.Please enter again: ");
            participants = sc.nextInt();
        }
        this.participants = participants;
    }
    public boolean isEmpty() {
        return false;
    }
    @Override
    public void input() {
        setIdProject(idProject);
        setParticipants(participants);
        setIdLeader(idLeader);

    }
    @Override
    public void output() {
        System.out.printf("    %-15s|",idProject);
        System.out.printf("    %-15s|    %-15s|,    %-15s|",nameProject,idLeader,participants);

    }

}