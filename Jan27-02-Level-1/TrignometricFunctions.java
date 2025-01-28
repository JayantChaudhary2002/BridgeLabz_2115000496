import java.util.*;
class TrigonometricFunctions {
	public double[] calculateTrigonometricFunctions(double angle) {
        	double radians = Math.toRadians(angle);
        	double sinValue = Math.sin(radians);
        	double cosValue = Math.cos(radians);
        	double tanValue = Math.tan(radians);
        	return new double[]{sinValue, cosValue, tanValue};
    	}
    	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double angle=sc.nextDouble();
        	TrigonometricFunctions obj = new TrigonometricFunctions();
        	double[] results = obj.calculateTrigonometricFunctions(angle);
        	System.out.println("For angle: " + angle + " degrees");
        	System.out.println("Sine: " + results[0]);
        	System.out.println("Cosine: " + results[1]);
        	System.out.println("Tangent: " + results[2]);
    	}
}
