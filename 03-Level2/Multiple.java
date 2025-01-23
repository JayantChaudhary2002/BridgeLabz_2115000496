import java.util.Scanner;
class Multiple{
        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                int num=sc.nextInt();
		if(num<=100){
                	for(int i=100;i>0;i--){
                        	if(num%i==0){
                                	System.out.println(i);
					continue;
                        	}
                	}
        	}
		else{
			System.out.println("Enter number under 100");
		}
	}
}
