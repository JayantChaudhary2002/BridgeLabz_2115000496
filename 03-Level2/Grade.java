import java.util.*;
class Grade{
        public static void main(String args[]){
                Scanner sc=new Scanner(System.in);
                int phy=sc.nextInt();
		int chem=sc.nextInt();
		int math=sc.nextInt();
                int total=phy+chem+math;
		double average=(double)total/3;
		double percent=((double)total/300)*100;
		if(percent<=39){
			System.out.println("The average marks are "+average+" the grade and the remark is Remedial Standards");
		}
		else if(percent>=40 && percent<=49){
			System.out.println("The average marks are "+average+" the grade is Level 1 and the remark is too below agency-normalized standards");
		}
		else if(percent>=50 && percent<=59){
                        System.out.println("The average marks are "+average+" the grade is Level 1 and the remark is well below agency-normalized standards");
                }
		else if(percent>=60 && percent<=69){
                        System.out.println("The average marks are "+average+" the grade is Level 2 and the remark is below, but appraoching agency-normalized standards");
                }
		else if(percent>=70 && percent<=79){
                        System.out.println("The average marks are "+average+" the grade is Level 3 and the remark is at agency-normalized standards");
                }
		else{
			System.out.println("The average marks are "+average+" the grade is Level 4 and the remark is above agency-normalized standards");
		}


        }
}

