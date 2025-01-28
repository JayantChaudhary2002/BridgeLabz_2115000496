import java.util.*;
class HandShakes{
        public int numberOfHandShakes(int num){
                int maximumNumber=(num*(num-1))/2;
                return maximumNumber;
        }
        public static void main(String args[]){
                Scanner sc=new Scanner(System.in);
                int num=sc.nextInt();
                HandShakes obj=new HandShakes();
                int result=obj.numberOfHandShakes(num);
                System.out.println("The Number of HandShakes are "+result);
        }
}
