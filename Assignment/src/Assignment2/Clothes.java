package Assignment2;

public class Clothes extends Product{
    private String size;
    private String color;

    public Clothes(int productId, String productName, double price, String size, String color) {
        super(productId, productName, price);
        this.size = size;
        this.color = color;
    }

    @Override
    public String getCategory() {
        return "Clothes";
    }
}
