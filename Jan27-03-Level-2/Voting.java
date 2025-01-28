import java.util.*;
class VotingRights{
	public static void main(String [] args){
		Scanner sc=new Scanner(System.in);
		int [] age=new int[10];
		System.out.println("Enter the ages of students");
		for(int i=0;i<10;i++){
			age[i]=sc.nextInt();
		}
		for(int i=0;i<10;i++){
			System.out.println("Can the student vote? "+check(age[i]));
		}
	}
	public static boolean check(int age){
		return age>=18;
	}
}
