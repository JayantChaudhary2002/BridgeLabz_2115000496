import java.util.*; 
class Anagram{
	public static void main(String []args){
		Scanner sc=new Scanner(System.in); 
		String s1=sc.nextLine(); 
		String s2=sc.nextLine(); 
		if(s1.length()!=s2.length()){
			System.out.print("Strings are not anagram");
		}
		else{
			char []charArray1=s1.toCharArray();
			char []charArray2=s2.toCharArray();
			Arrays.sort(charArray1);
			Arrays.sort(charArray2);
			if(Arrays.equals(charArray1,charArray2)){
				System.out.println("String are anagram");
			}
			else{
				System.out.println("String are not anagram");
			}
		}
	}
}
