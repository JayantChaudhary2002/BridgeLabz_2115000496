import java.util.*;
class CarRental {
	private String customerName;
    	private String carModel;
    	private int rentalDays;
    	private final int costPerDay = 50;

    	public CarRental(String customerName, String carModel, int rentalDays) {
        	this.customerName = customerName;
        	this.carModel = carModel;
        	this.rentalDays = rentalDays;
    	}

    	public String getCustomerName() {
        	return customerName;
    	}

    	public void setCustomerName(String customerName) {
        	this.customerName = customerName;
    	}

    	public String getCarModel() {
        	return carModel;
    	}

    	public void setCarModel(String carModel) {
        	this.carModel = carModel;
    	}

    	public int getRentalDays() {
        	return rentalDays;
    	}

    	public void setRentalDays(int rentalDays) {
 		this.rentalDays = rentalDays;
    	}

    	protected int calculateTotalCost() {
        	return rentalDays * costPerDay;
    	}

    	public int getTotalCost() {
        	return calculateTotalCost();
    	}

    	public void display() {
	    	System.out.println("Customer Name: " + customerName);
	    	System.out.println("Car Model: " + carModel);
	    	System.out.println("Rental Days: " + rentalDays);
	    	System.out.println("Total Cost: $" + getTotalCost());
	}


    	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String customerName=sc.nextLine();
		String carModel=sc.nextLine();
		int rentalDays=sc.nextInt();
        	CarRental rental = new CarRental(customerName, carModel, rentalDays);
        	rental.display();
        
        	rental.setRentalDays(10);
        	System.out.println("\nUpdated Rental Details:");
        	rental.display();
    	}
}
