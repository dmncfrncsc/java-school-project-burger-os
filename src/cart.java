public class cart {
    private String name;
    private double price;
    private int qty;
    private double total;

    public cart(String name, double price, int qty, double total) {
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.total = total;
    }
    public void editCartQty(int qty){
        this.qty =qty;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
