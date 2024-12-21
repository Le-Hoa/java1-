import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Product> inventory = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Product Inventory Management ---");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addProduct(scanner);
                case 2 -> viewProducts();
                case 3 -> updateProduct(scanner);
                case 4 -> deleteProduct(scanner);
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void addProduct(Scanner scanner) {
        System.out.print("Enter Product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Product Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Product Quantity: ");
        int quantity = scanner.nextInt();

        inventory.add(new Product(id, name, price, quantity));
        System.out.println("Product added successfully!");
    }

    private static void viewProducts() {
        if (inventory.isEmpty()) {
            System.out.println("No products in inventory.");
        } else {
            System.out.println("\n--- Product List ---");
            for (Product product : inventory) {
                product.displayInfo();
            }
        }
    }

    private static void updateProduct(Scanner scanner) {
        System.out.print("Enter Product ID to update: ");
        int id = scanner.nextInt();
        Product productToUpdate = null;

        for (Product product : inventory) {
            if (product.getId() == id) {
                productToUpdate = product;
                break;
            }
        }

        if (productToUpdate == null) {
            System.out.println("Product not found!");
        } else {
            scanner.nextLine(); // Consume newline
            System.out.print("Enter new Product Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new Product Price: ");
            double price = scanner.nextDouble();
            System.out.print("Enter new Product Quantity: ");
            int quantity = scanner.nextInt();

            productToUpdate.setName(name);
            productToUpdate.setPrice(price);
            productToUpdate.setQuantity(quantity);

            System.out.println("Product updated successfully!");
        }
    }

    private static void deleteProduct(Scanner scanner) {
        System.out.print("Enter Product ID to delete: ");
        int id = scanner.nextInt();
        Product productToRemove = null;

        for (Product product : inventory) {
            if (product.getId() == id) {
                productToRemove = product;
                break;
            }
        }

        if (productToRemove == null) {
            System.out.println("Product not found!");
        } else {
            inventory.remove(productToRemove);
            System.out.println("Product deleted successfully!");
        }
    }
}
