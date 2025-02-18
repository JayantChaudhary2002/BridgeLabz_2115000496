abstract class ProductCategory {
    private String category;

    public ProductCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}

class BookCategory extends ProductCategory {
    public BookCategory() {
        super("Books");
    }
}

class ClothingCategory extends ProductCategory {
    public ClothingCategory() {
        super("Clothing");
    }
}

class GadgetCategory extends ProductCategory {
    public GadgetCategory() {
        super("Gadgets");
    }
}

class Product<T extends ProductCategory> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void applyDiscount(double percentage) {
        if (percentage > 0 && percentage <= 100) {
            price -= price * (percentage / 100);
        } else {
            System.out.println("Invalid discount percentage");
        }
    }

    @Override
    public String toString() {
        return "Product: " + name + ", Category: " + category.getCategory() + ", Price: $" + price;
    }
}

public class MarketPlace {

    public static <T extends ProductCategory> void applyDiscountToProduct(Product<T> product, double percentage) {
        product.applyDiscount(percentage);
    }

    public static void main(String[] args) {

        Product<BookCategory> book = new Product<>("The Great Gatsby", 15.99, new BookCategory());
        Product<ClothingCategory> tShirt = new Product<>("Graphic T-shirt", 19.99, new ClothingCategory());
        Product<GadgetCategory> phone = new Product<>("Smartphone", 799.99, new GadgetCategory());

        System.out.println("Before Discount:");
        System.out.println(book);
        System.out.println(tShirt);
        System.out.println(phone);

        applyDiscountToProduct(book, 10);
        applyDiscountToProduct(tShirt, 15);
        applyDiscountToProduct(phone, 5);

        System.out.println("\nAfter Discount:");
        System.out.println(book);
        System.out.println(tShirt);
        System.out.println(phone);
    }
}
