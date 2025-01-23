import java.util.Scanner;
class Power{
        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                int num=sc.nextInt();
                int power=sc.nextInt();
		int result=1;
		for(int i=1;i<=power;i++){
			result=result*num;
		}
		System.out.println("The result is "+result);
        }
}
