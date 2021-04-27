public class Task1 {
    private Good good;
    private Seller seller;
    private double price;

    public Task1(Good good, Seller seller, double price) {
        this.good = good;
        this.seller = seller;
        this.price = price;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
