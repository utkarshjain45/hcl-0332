
package Assignment2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        User user1 = new User(1, "Aman", new Cart());
        User user2 = new User(2, "Riya", new Cart());

        User currentUser = null;

        while (true) {

            System.out.println("\n===== Shopping Cart Application =====");
            System.out.println("1. Select User");
            System.out.println("2. Add Product");
            System.out.println("3. Remove Product");
            System.out.println("4. Update Product");
            System.out.println("5. Show Cart");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.println("1. Aman");
                    System.out.println("2. Riya");
                    System.out.print("Select user: ");

                    try {
                        int userChoice = Integer.parseInt(sc.nextLine());

                        if (userChoice == 1) {
                            currentUser = user1;
                        } else if (userChoice == 2) {
                            currentUser = user2;
                        } else {
                            System.out.println("Invalid user choice.");
                            break;
                        }

                        System.out.println("Logged in as "
                                + currentUser.getName());

                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number.");
                    }
                    break;

                case 2:
                    if (currentUser == null) {
                        System.out.println("Please select a user first.");
                        break;
                    }

                    try {
                        System.out.println("1. Clothes");
                        System.out.println("2. Electronics");
                        System.out.println("3. Toys");
                        System.out.print("Select product category: ");

                        int category = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter product ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter product name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter product price: ");
                        double price = Double.parseDouble(sc.nextLine());

                        if (id <= 0 || name.trim().isEmpty()
                                || !Double.isFinite(price) || price < 0) {
                            System.out.println("Invalid product details.");
                            break;
                        }

                        Product product = null;

                        switch (category) {

                            case 1:
                                System.out.print("Enter size: ");
                                String size = sc.nextLine();

                                System.out.print("Enter color: ");
                                String color = sc.nextLine();

                                product = new Clothes(
                                        id, name, price, size, color);
                                break;

                            case 2:
                                System.out.print("Enter warranty in months: ");
                                int warranty = Integer.parseInt(sc.nextLine());

                                System.out.print("Enter brand: ");
                                String brand = sc.nextLine();

                                if (warranty < 0 || brand.trim().isEmpty()) {
                                    System.out.println("Invalid details.");
                                    break;
                                }

                                product = new Electronics(
                                        id, name, price, warranty, brand);
                                break;

                            case 3:
                                System.out.print("Enter material: ");
                                String material = sc.nextLine();

                                System.out.print("Enter suitable age: ");
                                int age = Integer.parseInt(sc.nextLine());

                                if (age <= 0 || material.trim().isEmpty()) {
                                    System.out.println("Invalid details.");
                                    break;
                                }

                                product = new Toys(
                                        id, name, price, material, age);
                                break;

                            default:
                                System.out.println("Invalid category.");
                                continue;
                        }

                        System.out.print("Enter quantity: ");
                        int quantity = Integer.parseInt(sc.nextLine());

                        currentUser.getCart().addProduct(product, quantity);

                    } catch (NumberFormatException e) {
                        System.out.println("Please enter valid numeric values.");
                    }
                    break;

                case 3:
                    if (currentUser == null) {
                        System.out.println("Please select a user first.");
                        break;
                    }

                    try {
                        System.out.print("Enter product ID to remove: ");
                        int removeId = Integer.parseInt(sc.nextLine());

                        currentUser.getCart().removeProduct(removeId);

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid product ID.");
                    }
                    break;

                case 4:
                    if (currentUser == null) {
                        System.out.println("Please select a user first.");
                        break;
                    }

                    try {
                        System.out.print("Enter product ID to update: ");
                        int updateId = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter new quantity: ");
                        int quantity = Integer.parseInt(sc.nextLine());

                        currentUser.getCart().updateProduct(
                                updateId, quantity);

                    } catch (NumberFormatException e) {
                        System.out.println("Please enter valid numbers.");
                    }
                    break;

                case 5:
                    if (currentUser == null) {
                        System.out.println("Please select a user first.");
                    } else {
                        System.out.println("Cart of "
                                + currentUser.getName());
                        currentUser.getCart().showCart();
                    }
                    break;

                case 6:
                    System.out.println("Thank you for shopping!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
