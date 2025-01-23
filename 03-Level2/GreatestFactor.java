import java.util.Scanner;
class GreatestFactor{
        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                int num=sc.nextInt();
		int greatestFactor=1;
		for(int i=num-1;i>0;i--){
			if(num%i==0){
				greatestFactor=i;
				break;
			}
		}
		System.out.println("The Greatest Factor is "+greatestFactor);
        }
}
