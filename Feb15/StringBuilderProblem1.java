import java.util.*;
class StringBuilderProblem1{
	public static String reverseString(String input){
		StringBuilder sb=new StringBuilder(input);
		sb.reverse();
		return sb.toString();
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		String reversed=reverseString(str);
		System.out.println(reversed);
	}
}
