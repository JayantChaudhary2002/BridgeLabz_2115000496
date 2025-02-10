abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getItemDetails() {
        return "Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity;
    }

    public abstract double calculateTotalPrice();
}

class VegItem extends FoodItem {
    private static final double DISCOUNT = 0.1;  // 10% discount for veg items

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity() * (1 - DISCOUNT);
    }
}

class NonVegItem extends FoodItem {
    private static final double NON_VEG_CHARGE = 2.0;  // Extra charge for non-veg items

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity() + NON_VEG_CHARGE;
    }
}

interface Discountable {
    void applyDiscount();
    String getDiscountDetails();
}

class DiscountableVegItem extends VegItem implements Discountable {
    public DiscountableVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public void applyDiscount() {
        System.out.println("Applied a 10% discount on " + getItemName());
    }

    @Override
    public String getDiscountDetails() {
        return "10% discount applied to " + getItemName();
    }
}

class DiscountableNonVegItem extends NonVegItem implements Discountable {
    public DiscountableNonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public void applyDiscount() {
        System.out.println("Applied a 5% discount on " + getItemName());
    }

    @Override
    public String getDiscountDetails() {
        return "5% discount applied to " + getItemName();
    }
}

class OrderProcessing {
    public static void processOrder(FoodItem foodItem) {
        System.out.println(foodItem.getItemDetails());
        System.out.println("Total Price: " + foodItem.calculateTotalPrice());
        if (foodItem instanceof Discountable) {
            Discountable discountableItem = (Discountable) foodItem;
            discountableItem.applyDiscount();
            System.out.println(discountableItem.getDiscountDetails());
        }
        System.out.println("------");
    }
}

public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        FoodItem vegPizza = new DiscountableVegItem("Veg Pizza", 300, 2);
        FoodItem nonVegBurger = new DiscountableNonVegItem("Non-Veg Burger", 150, 3);
        FoodItem vegPasta = new VegItem("Veg Pasta", 200, 1);
        FoodItem nonVegPizza = new NonVegItem("Non-Veg Pizza", 350, 2);

        OrderProcessing.processOrder(vegPizza);
        OrderProcessing.processOrder(nonVegBurger);
        OrderProcessing.processOrder(vegPasta);
        OrderProcessing.processOrder(nonVegPizza);
    }
}
