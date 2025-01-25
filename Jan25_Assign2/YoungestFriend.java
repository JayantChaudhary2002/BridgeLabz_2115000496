import java.util.*;
class YoungestFriend {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        	int[] age = new int[3];
        	int[] height = new int[3];
        	int maxHeight = 0;
        	int minAge = Integer.MAX_VALUE;
        	String tallest = "";
        	String youngest = "";
		for (int i = 0; i < 3; i++) {
            		age[i] = sc.nextInt();
            		if(minAge > age[i]) {
                		minAge = age[i];
                	if(i == 0)
                    		youngest = "Amar";
                	else if(i == 1)
                    		youngest = "Akbar";
                	else
                    		youngest = "Anthony";
            		}
        	}
		System.out.println("Enter the heights of Amar, Akbar, and Anthony:");
        	for (int i = 0; i < 3; i++) {
            		height[i] = sc.nextInt();
            		if (maxHeight < height[i]) {
                		maxHeight = height[i];
                	if (i == 0)
                    		tallest = "Amar";
                	else if (i == 1)
                    		tallest = "Akbar";
                	else
                    		tallest = "Anthony";
            		}
        	}
		System.out.println("Youngest in all: " + youngest + " (Age: " + minAge + ")");
        	System.out.println("Tallest in all: " + tallest + " (Height: " + maxHeight + ")");
    	}
}
