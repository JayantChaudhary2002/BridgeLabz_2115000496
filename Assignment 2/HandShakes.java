import java.util.*;
class HandShakes{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int numberOfStudents=sc.nextInt();
		int combination=(numberOfStudents*(numberOfStudents-1))/2;
		System.out.println("Number of handshakes are "+combination);
	}
}
