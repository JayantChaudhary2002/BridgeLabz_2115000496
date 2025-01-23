import java.util.Scanner;
class Bmi{
        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                int amarAge=sc.nextInt();
		int akbarAge=sc.nextInt();
		int anthonyAge=sc.nextInt();
		int amarHeight=sc.nextInt();
		int akbarHeight=sc.nextInt();
		int anthonyHeight=sc.nextInt();
		if(amarAge<=akbarAge && amarAge<=anthonyAge){
			System.out.println("The youngest friend is Amar");
		}
		else if(akbarAge<=amarAge && akbarAge<=anthonyAge){
                        System.out.println("The youngest friend is Akbar");
                }
		else{
                        System.out.println("The youngest friend is Anthony");
                }
		if(amarHeight<=akbarHeight && amarHeight<=anthonyHeight){
                        System.out.println("The tallest friend is Amar");
                }
                else if(akbarHeight<=amarHeight && akbarHeight<=anthonyHeight){
                        System.out.println("The tallest friend is Akbar");
                }
                else{
                        System.out.println("The tallest friend is Anthony");
                }

        }
}
