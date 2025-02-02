class Product {
    private String productName;
    private double price;
    private static int totalProduct = 0;

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProduct++;
    }

    public void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Product Price: " + price);
    }

    public static void displayTotalProduct() {
        System.out.println("Total Products: " + totalProduct);
    }

    public static void main(String[] args) {
        Product product1 = new Product("TV", 999.99);
        Product product2 = new Product("Phone", 799.99);

        product1.displayProductDetails();
        System.out.println();
        product2.displayProductDetails();
        System.out.println();
        
        Product.displayTotalProduct();
    }
}
