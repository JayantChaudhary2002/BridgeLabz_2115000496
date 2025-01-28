import java.util.*;
class WindChill{
        public void windChill(double temp, double windSpeed){
                double result=35.74+(0.6215*temp)+((0.4275*temp)-35.75)*Math.pow(windSpeed,0.16);
                System.out.println("The wind chill temperature is "+result);
        }
        public static void main(String args[]){
                Scanner sc=new Scanner(System.in);
                double temp=sc.nextDouble();
                double windSpeed=sc.nextDouble();
                WindChill obj=new WindChill();
                obj.windChill(temp, windSpeed);
        }
}
