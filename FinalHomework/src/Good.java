public class Good extends Entity{
    private int idGood;
    private String name;

    public Good(int idGood, String name) {
        this.idGood = idGood;
        this.name = name;
    }

    public Good() {
    }

    public int getIdGood() {
        return idGood;
    }

    public void setIdGood(int idGood) {
        this.idGood = idGood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
