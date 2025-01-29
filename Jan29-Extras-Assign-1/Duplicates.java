import java.util.*;
class Duplicates{
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		String s=sc.nextLine();
		String result="";
		for(char c:s.toCharArray()){
			if(result.indexOf(c)==-1){
				result+=c;
			}
		}
		System.out.println("String after removing duplicates"+result);
	}
}
