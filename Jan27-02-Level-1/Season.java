import java.util.*;
class Season{
        public boolean springSeason(int month,int day){
                if((month>=3 && day>=20) && (month<=6 && day<=20))
                        return true;
                else
                        return false;
        }
        public static void main(String args[]){
                Scanner sc=new Scanner(System.in);
                int month=sc.nextInt();
		int day=sc.nextInt();
                Season obj=new Season();
                boolean result=obj.springSeason(month,day);
                if(result==true){
			System.out.println("It's a Spring Season");
		}
		else{
			System.out.println("Not a Spring Season");
		}
        }
}
