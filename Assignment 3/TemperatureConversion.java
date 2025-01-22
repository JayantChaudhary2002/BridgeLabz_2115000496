import java.util.*;
class TemperatureConversion{
        public static void main(String args[]){
                Scanner sc=new Scanner(System.in);
                double celsius=sc.nextDouble();
                double farenheitResult=(celsius*9/5)+32
                System.out.println("The "+celsius+" celsius is "+farenheitResult+" fahrenheit");
        }
}
