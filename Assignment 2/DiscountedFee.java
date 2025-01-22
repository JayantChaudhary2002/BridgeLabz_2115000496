//Create class Discounted fee to compute discounted price and fee
class DiscountedFee{
	public static void main(String args[]){
		//Create variable to store university fee.
		int fee=125000;

		//Create variable to store the discounted price after calculation.
		int discountedPrice=(10*125000)/100;

		//Create variable to store the discounted fee.
		int discountedAmount=fee-discountedPrice;

		//Display the discounted price and discounted fee.
		System.out.println("The discount amount is INR "+discountedPrice+" and final discounted fee is INR "+discountedAmount);
	}
}
