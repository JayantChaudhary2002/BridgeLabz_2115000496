import java.time.LocalDate;

class Order {
    protected String orderId;
    protected LocalDate orderDate;
    
    public Order(String orderId, LocalDate orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }
    
    public String getOrderStatus() {
        return "Order placed";
    }
    
    public void printStatus() {
        System.out.println(getOrderStatus());
    }
}

class ShippedOrder extends Order {
    protected String trackingNumber;
    
    public ShippedOrder(String orderId, LocalDate orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }
    
    @Override
    public String getOrderStatus() {
        return super.getOrderStatus() + " | Order shipped with tracking number: " + trackingNumber;
    }
    
    @Override
    public void printStatus() {
        super.printStatus();
        System.out.println(getOrderStatus());
    }
}

class DeliveredOrder extends ShippedOrder {
    private LocalDate deliveryDate;
    
    public DeliveredOrder(String orderId, LocalDate orderDate, String trackingNumber, LocalDate deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }
    
    @Override
    public String getOrderStatus() {
        return super.getOrderStatus() + " | Order delivered on: " + deliveryDate;
    }
    
    @Override
    public void printStatus() {
        super.printStatus();
        System.out.println(getOrderStatus());
    }
}

public class Q6_RetailManagement {
    public static void main(String[] args) {
        Order order = new Order("O1001", LocalDate.of(2025, 2, 7));
        ShippedOrder shippedOrder = new ShippedOrder("O1002", LocalDate.of(2025, 2, 6), "TRK12345");
        DeliveredOrder deliveredOrder = new DeliveredOrder("O1003", LocalDate.of(2025, 2, 5), "TRK67890", LocalDate.of(2025, 2, 7));
        
        System.out.println("--- Order Status ---");
        order.printStatus();
        
        System.out.println("\n--- Shipped Order Status ---");
        shippedOrder.printStatus();
        
        System.out.println("\n--- Delivered Order Status ---");
        deliveredOrder.printStatus();
    }
}
