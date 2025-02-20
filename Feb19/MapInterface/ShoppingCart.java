import java.util.*;

public class ShoppingCart {
    private static Map<String, Double> productPrices = new HashMap<>();
    private static Map<String, Double> cart = new LinkedHashMap<>();
    private static Map<String, Double> sortedCart = new TreeMap<>(Comparator.comparing(cart::get));

    public static void addProduct(String productName, double price) {
        productPrices.put(productName, price);
        cart.put(productName, price);
        sortedCart.put(productName, price);
    }

    public static void removeProduct(String productName) {
        cart.remove(productName);
        sortedCart.remove(productName);
    }

    public static void displayCart() {
        System.out.println("Items in cart (in order of addition):");
        for (Map.Entry<String, Double> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public static void displaySortedCart() {
        System.out.println("\nItems in cart sorted by price:");
        for (Map.Entry<String, Double> entry : sortedCart.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public static void displayProductPrices() {
        System.out.println("\nAvailable products and their prices:");
        for (Map.Entry<String, Double> entry : productPrices.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        addProduct("Laptop", 1500.00);
        addProduct("Headphones", 200.00);
        addProduct("Smartphone", 700.00);
        addProduct("Smartwatch", 250.00);

        displayProductPrices();
        
        displayCart();

        displaySortedCart();

        System.out.println("\nRemoving Smartwatch...");
        removeProduct("Smartwatch");

        displayCart();
        displaySortedCart();
    }
}
