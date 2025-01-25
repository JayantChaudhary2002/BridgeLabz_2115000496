import java.util.*;
class MeanHeight{
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		double []height=new double[11];
		double total=0;
		for(int i=0; i<10; i++){
			height[i]=sc.nextDouble();
			total=total+height[i];
		}
		double mean = total/11;
		System.out.println("Mean of all heights is "+mean);
	}
}
