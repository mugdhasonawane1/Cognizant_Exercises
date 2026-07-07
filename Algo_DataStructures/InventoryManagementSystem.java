import java.util.HashMap;
import java.util.Map;

class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setPrice(double price) { this.price = price; }
    public void setProductName(String productName) { this.productName = productName; }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}

public class InventoryManagementSystem {
    private Map<String, Product> inventory;

    public InventoryManagementSystem() {
        // Using HashMap for O(1) average time complexity for add, update, and delete
        inventory = new HashMap<>();
    }

    // Add a new product
    public void addProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            System.out.println("Product with ID " + product.getProductId() + " already exists.");
        } else {
            inventory.put(product.getProductId(), product);
            System.out.println("Product added successfully: " + product.getProductName());
        }
    }

    // Update an existing product
    public void updateProduct(String productId, Integer newQuantity, Double newPrice) {
        if (inventory.containsKey(productId)) {
            Product product = inventory.get(productId);
            if (newQuantity != null) {
                product.setQuantity(newQuantity);
            }
            if (newPrice != null) {
                product.setPrice(newPrice);
            }
            System.out.println("Product updated successfully: " + product.getProductName());
        } else {
            System.out.println("Product not found.");
        }
    }

    // Delete a product
    public void deleteProduct(String productId) {
        if (inventory.containsKey(productId)) {
            Product removed = inventory.remove(productId);
            System.out.println("Product deleted: " + removed.getProductName());
        } else {
            System.out.println("Product not found.");
        }
    }

    // Display all products
    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Product p : inventory.values()) {
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        Product p1 = new Product("P001", "Laptop", 10, 999.99);
        Product p2 = new Product("P002", "Smartphone", 20, 599.99);

        ims.addProduct(p1);
        ims.addProduct(p2);

        System.out.println("\nCurrent Inventory:");
        ims.displayInventory();

        System.out.println("\nUpdating Product P001...");
        ims.updateProduct("P001", 15, null);
        ims.displayInventory();

        System.out.println("\nDeleting Product P002...");
        ims.deleteProduct("P002");
        ims.displayInventory();
    }
}
