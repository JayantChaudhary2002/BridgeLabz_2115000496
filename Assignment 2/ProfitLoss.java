//Create class ProfitLoss to calculate profit or loss nd percentage of a product
class ProfitLoss{
	public static void main(String args[]){
		//Create variable to store cost price
		int costPrice=129;
	
		//Create variable to store selling price
		int sellingPrice=191;

		//Create variable to store profit
		int profit=sellingPrice-costPrice;

		//Create variable to store the calculated profit percentage
		double percentage=((double)profit/(double)costPrice)*100;

		//Displaying the cost price and selling price, profit and profit percentage
		System.out.println("The Cost Price is INR "+costPrice+" and Selling Price is INR "+sellingPrice)
		System.out.println("The profit is "+profit+" and the profit percentage is "+percentage);
	}
}
