import java.util.Scanner;
class Multiplication2{
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number between 6 and 9");
		int number=sc.nextInt();
		int []table=new int [10];
		for(int i=0; i<10; i++){
			table[i]=number*(i+1);
		}
		for(int i=0;i<10;i++){
			System.out.println(number+" * "+(i+1)+" = "+table[i]);
		}
	}
}
