import java.util.*;
class SumNatural{
        public int sumNatural(int n){
		int sum=0;
                for(int i=n;i>0;i++){
			sum=sum+i;
		}
		return sum;
        }
        public static void main(String args[]){
                Scanner sc=new Scanner(System.in);
                int n=sc.nextInt();
                SumNatural obj=new SumNatural();
                int result=obj.sumNatural(n);
                System.out.println("The sum of n natural numbers are "+result);
	}
}
