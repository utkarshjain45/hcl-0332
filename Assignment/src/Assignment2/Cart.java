package Assignment2;

import java.util.*;

public class Cart {
    private Map<Integer, CartItem> cart = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        if (product == null) {
            System.out.println("Invalid Product");
            return;
        }

        if (quantity <= 0) {
            System.out.println("Invalid Quantity");
            return;
        }

        int productId = product.getProductId();
        if (cart.containsKey(productId)) {
            CartItem item = cart.get(productId);
            item.setQuantity(item.getQuantity() + quantity);
            System.out.println("Product quantity increased to: " + item.getQuantity());
        } else {
            CartItem item = new CartItem(product, quantity);
            cart.put(productId, item);
            System.out.println("Product Added.");
        }
    }

    public void removeProduct(int productId) {
        if (!cart.containsKey(productId)) {
            System.out.println("Product not present in the cart");
        } else {
            cart.remove(productId);
            System.out.println("Product Removed.");
        }
    }

    public void updateProduct(int productId, int quantity) {
        if (!cart.containsKey(productId)) {
            System.out.println("Product not present in the cart");
            return;
        }

        if (quantity <= 0) {
            System.out.println("Quantity must be greater than zero.");
            return;
        }

        cart.get(productId).setQuantity(quantity);
        System.out.println("Product quantity updated to: " + quantity);
    }

    public void showCart() {

        if (cart.isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }

        List<CartItem> items = new ArrayList<>(cart.values());

        items.sort(Comparator.comparingInt(
                item -> item.getProduct().getProductId()));

        double total = 0;

        System.out.println("\n----- Shopping Cart -----");

        for (CartItem item : items) {

            Product product = item.getProduct();

            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Name: " + product.getProductName());
            System.out.println("Category: " + product.getCategory());
            System.out.println("Price: " + product.getPrice());
            System.out.println("Quantity: " + item.getQuantity());
            System.out.println("Total: " + item.getTotalPrice());
            System.out.println("-------------------------");

            total += item.getTotalPrice();
        }

        System.out.println("Grand Total: " + total);
    }
}
