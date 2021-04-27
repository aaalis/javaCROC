import java.time.LocalDate;

public class Task2 implements Comparable<Task2>{
    private LocalDate date;
    private Integer quantity;

    public Task2(LocalDate date, int quantity) {
        this.date = date;
        this.quantity = quantity;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int compareTo(Task2 o) {
        return o.getQuantity().compareTo(this.quantity);
    }

}
