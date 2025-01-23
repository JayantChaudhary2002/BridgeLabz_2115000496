import java.util.*;
class Calculator{
        public static void main(String args[]){
                Scanner sc=new Scanner(System.in);
		String op=sc.nextLine();
                double first=sc.nextDouble();
		double second=sc.nextDouble();
		double result=0.0;
		switch(op){
			case "+":
				result=first+second;
				System.out.println("Result for + is "+result);
				break;
			case "-":
                                result=first-second;
                                System.out.println("Result for - is "+result);
                                break;
			case "*":
                                result=first*second;
                                System.out.println("Result for * is "+result);
                                break;
			case "/":
                                result=first/second;
                                System.out.println("Result for / is "+result);
                                break;
			default:
				System.out.println("Invalid Operator");
				break;
		}
        }
}
