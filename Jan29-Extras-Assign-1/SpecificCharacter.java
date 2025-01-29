import java.util.*;
class SpecificCharacter{
	public static void main(String []args){
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		char ch=sc.next().charAt(0);
		String result=" ";
		for(char c:str.toCharArray()){
			if(c!=ch){
			result+=c;
			}
			System.out.println("Modified String:" +result);
		}
	}
}
