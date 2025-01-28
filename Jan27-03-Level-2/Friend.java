import java.util.*; 
class Friend{ 
	static Scanner sc=new Scanner(System.in);
	public static void main(String [] args){ 
	int [] ages=new int [3]; 
	int [] heights=new int[3]; 
	height(heights);
	age(ages);
	}
	public static void age(int [] ages){
		int minAge=Integer.MAX_VALUE;
		String youngest="";
		System.out.println("Enter the ages"); 
		for(int i=0;i<3;i++){
			ages[i]=sc.nextInt();
			if(minAge>ages[i]){
				minAge=ages[i]; 
				if(i==0)
					youngest="Amar";
				else if(i==1)
					youngest="Akbar";
				else
					youngest="Anthony";
			}
		}
		System.out.println("Youngest of all with age "+minAge+" is "+youngest);
	}
	public static void height(int [] heights){
		int maxHeight=0;
		String tallest="";
		System.out.println("Enter the heights");
		for(int i=0;i<3;i++){
			heights[i]=sc.nextInt();
			if(maxHeight<heights[i]){
				maxHeight=heights[i];
				if(i==0)
					tallest="Amar";
				else if(i==1)
					tallest="Akbar";
				else
					tallest="Anthony";
			}
		}
		System.out.println("Tallest of all with height "+maxHeight+" is "+tallest);
	}
}
