class BankAccount{
	static String bankName;
	String accountHolderName;
	final int accountNumber;
	static int count=0;
	BankAccount(String accountHolderName, int accountNumber){
		this.accountHolderName=accountHolderName;
		this.accountNumber=accountNumber;
		++count;
	}
	public static void getTotalAccounts(){
		System.out.println("Total accounts are:" +count);
	}
	public static void main(String args[]){
		BankAccount account=new BankAccount("Raj",456281);
		new BankAccount("Priya",127193);
		new BankAccount("Prathistha",987812);
		new BankAccount("Ajay",129871);
		if(account instanceof BankAccount){
			System.out.println("account object is an instance of the BankAccount");
		}
		BankAccount.getTotalAccounts();
	}
}
