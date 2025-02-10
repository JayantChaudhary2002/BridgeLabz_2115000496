import java.util.*;
abstract class Product{
	private int productId;
	private String name;
	private double price;

	public Product(int productId, String name, double price){
		this.productId=productId;
		this.name=name;
		this.price=price;
	}
	public int getProductId(){
		return productId;
	}
	public void setProductId(int productId){
		this.productId=productId;
	}
	public String getName(){
                return name;
        }
        public void setName(String name){
                this.name=name;
        }
	public double getPrice(){
                return price;
        }
        public void setPrice(double price){
                this.price=price;
        }
	public abstract double calculateDiscount();
	
	public double calculateFinalPrice(Taxable taxService){
		double discount=calculateDiscount();
		double tax=taxService.calculateTax();
		return price+tax-discount;
	}
}

interface Taxable{
	double calculateTax();
	String getTaxDetails();
}

class Electronics extends Product implements Taxable{
	private double discountRate=0.10;
	public Electronics(int productId, String name, double price){
		super(productId, name, price);
	}
	
	@Override
	public double calculateDiscount(){
		return getPrice()*discountRate;
	}
	
	@Override
	public double calculateTax(){
		return getPrice()*0.15;
	}

	@Override
	public String getTaxDetails(){
		return "Electronics Tax Rate: 15%";
	}
}

class Clothing extends Product implements Taxable{
	private double discountRate=0.20;
	public Clothing(int productId, String name, double price){
                super(productId, name, price);
        }

        @Override
        public double calculateDiscount(){
                return getPrice()*discountRate;
        }

        @Override
        public double calculateTax(){
                return getPrice()*0.10;
        }

        @Override
        public String getTaxDetails(){
                return "Clothing Tax Rate: 10%";
        }

}

class Groceries extends Product implements Taxable{
	private double discountRate=0.05;
	public Groceries(int productId, String name, double price){
                super(productId, name, price);
        }

        @Override
        public double calculateDiscount(){
                return getPrice()*discountRate;
        }

	@Override
        public double calculateTax(){
                return 0;
        }

        @Override
        public String getTaxDetails(){
                return "Groceries are tax free.";
        }

}

class ECommerce{
	public static void main(String args[]){
		Product product1=new Electronics(001,"Laptop",45000);
		Product product2=new Clothing(015,"Jacket",8000);
		Product product3=new Groceries(141,"Milk",70);

		List<Product> products=new ArrayList<>();
		products.add(product1);
		products.add(product2);
		products.add(product3);

		for(Product product:products){
			if(product instanceof Taxable){
				Taxable taxableProduct=(Taxable)product;
				double finalPrice=product.calculateFinalPrice(taxableProduct);
				System.out.println(product.getName()+" Final Price: "+finalPrice);
				System.out.println(taxableProduct.getTaxDetails());
			}
			else{
				double finalPrice=product.calculateFinalPrice(new Taxable(){
				@Override
				public double calculateTax(){
					return 0;
				}

				@Override
				public String getTaxDetails(){
					return "Groceries are tax-free.";
				}
			});
			System.out.println(product.getName()+" Final Price: "+finalPrice);
			}
		}
	}
}
