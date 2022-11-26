public class Department implements InOut {
    private int idDep;
    private String nameDep;

    public void Department() {
    }

    public Department(int idDep, String nameDep) {
        this.idDep = idDep;
        this.nameDep = nameDep;
    }

    public int getIdDep() {
        return idDep;
    }

    public void setIdDep(int idDep) {
        this.idDep = idDep;
    }

    public String getNameDep() {
        return nameDep;
    }

    public void setNameDep(String nameDep) {
        this.nameDep = nameDep;
    }

    public boolean isEmpty() {
        return false;
    }

    @Override
    public void input() {
        // TODO Auto-generated method stub

    }

    @Override
    public void output() {
        // TODO Auto-generated method stub

    }

}
