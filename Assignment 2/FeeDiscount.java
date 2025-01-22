import java.util.*;
class FeeDiscount{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);

		//Created variables to take user input fee and percent
		double fee=sc.nextDouble();
		double discountPercent=sc.nextDouble();

		//Create variable to store the discount
		double discount=(fee*discountPercent)/100;
		double discountedFee=fee-discount;
		System.out.println("The discount amount is INR "+discount+" and the final discounted fee is INR "+discountedFee);
	}
}
