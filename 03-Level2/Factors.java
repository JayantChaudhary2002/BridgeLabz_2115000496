import java.util.Scanner;
class Factors{
        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                int num=sc.nextInt();
                for(int i=1;i<num;i++){
                        if(num%i==0){
				System.out.println(i);
			}
                }
        }
}
