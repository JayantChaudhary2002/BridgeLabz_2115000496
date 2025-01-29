import java.util.*; 
class CountVowelConsonant{ 
	public static void main(String []args){ 
		Scanner sc = new Scanner(System.in); 
		String input=sc.nextLine().toLowerCase(); 
		int vowel=0; 
		int consonant=0; 
		for(char c:input.toCharArray()){	 
			if(c>='a' && c<='z'){ 
				if(c=='a' || c=='e' || c=='i' || c=='o' || c=='o' || c=='u'){
					vowel++;
				}
				else{
					consonant++;
				}
			}
		}
		System.out.println("Number of vowel is "+vowel);
		System.out.println("Number of consonant is "+consonant);
	}
}
