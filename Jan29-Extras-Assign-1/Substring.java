import java.util.*;
class Substring {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the main string: ");
		String mainString=sc.nextLine();
		System.out.print("Enter the substring to count: ");
		String subString=sc.nextLine();
		int count=countOccurrences(mainString, subString);
		System.out.println("Occurrences: "+count);
	}
	public static int countOccurrences(String str, String sub) {
		int count=0,index=0;
		while((index=str.indexOf(sub,index))!=-1) {
			count++;
			index+=sub.length();
		}
		return count;
	}
}

