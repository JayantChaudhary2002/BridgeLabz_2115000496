import java.util.*;
class FrequentCharacter{
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int [] freq=new int[256];
		char maxChar=' ';
		int maxFreq=0;
		for(char c:str.toCharArray()){
			freq[c]++;
			if(freq[c]>maxFreq){
				maxFreq=freq[c];
				maxChar=c;
			}
		}
	System.out.println("Most Frequent character :'"+maxChar+"'");
	}
}
