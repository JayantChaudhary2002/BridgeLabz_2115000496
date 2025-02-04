class Product{
        static double discount=10;
        String productName;
	double price;
	int quantity;
        final int productId=1233;
        Product(String productName, double price, int quantity){
                this.productName=productName;
		this.price=price;
		this.quantity=quantity;
        }
        public static void updateDiscount(double modifiedDiscount){
                discount=modifiedDiscount;
		System.out.println("The modified discount is:"+discount);
        }
        public static void main(String args[]){
                Product object=new Product("Soap", 35.00,2);
                new Product("Shampoo", 87.23,1);
                if(object instanceof Product){
                        System.out.println("object is an instance of the Product");
                }
                Product.updateDiscount(15.00);
        }
}
