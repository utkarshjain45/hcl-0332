package Assignment2;

public class Toys extends Product{
    private String material;
    private int ageGroup;

    public Toys(int productId, String productName, double price, String material, int ageGroup) {
        super(productId, productName, price);
        this.material = material;
        this.ageGroup = ageGroup;
    }

    @Override
    public String getCategory() {
        return "Toys";
    }
}
