package Assignment2;

public class Electronics extends Product{
    private int warrantyPeriod;
    private String brand;

    public Electronics(int productId, String productName, double price, int warrantyPeriod, String brand) {
        super(productId, productName, price);
        this.warrantyPeriod = warrantyPeriod;
        this.brand = brand;
    }

    @Override
    public String getCategory() {
        return "Electronics";
    }
}
