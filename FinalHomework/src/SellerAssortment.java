public class SellerAssortment extends Entity{
    private int idSeller;
    private int idGood;
    private double price;
    private int quantityGoods;

    public SellerAssortment(int idSeller, int idGood, double price, int quantityGoods) {
        this.idSeller = idSeller;
        this.idGood = idGood;
        this.price = price;
        this.quantityGoods = quantityGoods;
    }
    public SellerAssortment() {

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityGoods() {
        return quantityGoods;
    }

    public void setQuantityGoods(int quantityGoods) {
        this.quantityGoods = quantityGoods;
    }
}
