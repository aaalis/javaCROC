public class Seller extends Entity{
    private int idSeller;
    private String firstName;
    private String lastName;

    public Seller(int idSeller, String firstName, String lastName) {
        this.idSeller = idSeller;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Seller() {

    }

    public int getIdSeller() {
        return idSeller;
    }

    public void setIdSeller(int idSeller) {
        this.idSeller = idSeller;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
