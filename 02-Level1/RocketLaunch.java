import java.util.*;
class RocketLaunch{
        public static void main(String args[]){
                Scanner sc=new Scanner(System.in);
                int countdown = sc.nextInt();
        	while (countdown > 0) {
            		System.out.println(countdown);
            		countdown--;
        	}
        }
}
