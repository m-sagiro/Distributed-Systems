package FundStock;

public class Stock {
    private String name;
    private float dividend;
    private int quantity;

    public Stock(String name, float dividend, int quantity){
        this.name = name;
        this.dividend = dividend;
        this.quantity =quantity;
    }

    public String getStockName() {
        return name;
    }

    public float getStockDividend() {
        return dividend;
    }

    public int getStockQuantity() {
        return quantity;
    }

    public void setStockQuantity(int quantity) {
        this.quantity = quantity;
    }
}
