import java.time.LocalDateTime;

public class Contract extends Entity{
    private int idContract;
    private int idSeller;
    private int idGood;
    private int quantityGood;
    private LocalDateTime dateTime;

    public Contract(int idContract,
                    int idSeller,
                    int idGood,
                    int quantityGood) {
        this.idContract = idContract;
        this.idSeller = idSeller;
        this.idGood = idGood;
        this.quantityGood = quantityGood;
        this.dateTime = LocalDateTime.now();
    }

    public Contract() {
    }

    public int getIdContract() {
        return idContract;
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }

    public int getIdSeller() {
        return idSeller;
    }

    public void setIdSeller(int idSeller) {
        this.idSeller = idSeller;
    }

    public int getIdGood() {
        return idGood;
    }

    public void setIdGood(int idGood) {
        this.idGood = idGood;
    }

    public int getQuantityGood() {
        return quantityGood;
    }

    public void setQuantityGood(int quantityGood) {
        this.quantityGood = quantityGood;
    }

    public LocalDateTime getDateTime() { return dateTime; }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
