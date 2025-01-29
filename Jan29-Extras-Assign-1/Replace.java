import java.util.*;
class Replace{
	public static void main(String []args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the sentence");
		String sentence=sc.nextLine();
		System.out.println("Enter the word to be replaced");
		String oldSentence=sc.nextLine();
		System.out.println("Enter the word that replce with");
		String newSentence=sc.nextLine();
		String updatedSentence=sentence.replace(oldSentence,newSentence);
		System.out.println("updatedSentence"+updatedSentence);
	}
}
