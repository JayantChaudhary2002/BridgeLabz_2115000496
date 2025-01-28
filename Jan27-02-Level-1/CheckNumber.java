import java.util.*;
class CheckNumber{
        public int checkNumber(int num){
        	if(num>0)
			return 1;
		else if(num<0)
			return -1;
		else
			return 0;
        }
        public static void main(String args[]){
                Scanner sc=new Scanner(System.in);
                int num=sc.nextInt();
                CheckNumber obj=new CheckNumber();
                int result=obj.checkNumber(num);
                System.out.println("The number is "+result);
        }
}

