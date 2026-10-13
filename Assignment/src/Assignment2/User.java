package Assignment2;

public class User {
    private final int userId;
    private String name;
    private Cart cart;

    public User(int userId, String name, Cart cart) {
        this.userId = userId;
        this.name = name;
        this.cart = cart;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public Cart getCart() {
        return cart;
    }
}
