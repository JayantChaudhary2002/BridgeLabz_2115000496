public class CircularTour{
	public static int circularTour(int[] petrol, int[] distance){
		int n=petrol.length;

		int current_petrol=0;
		int total_petrol=0;
		int start=0;

		for(int i=0;i<n;i++){
			current_petrol+=petrol[i]-distance[i];
			total_petrol+=petrol[i]-distance[i];

			if(current_petrol<0){
				start=i+1;
				current_petrol=0;
			}
		}
		return (total_petrol>=0)?start:-1;
	}
	public static void main(String args[]){
		int[] petrol={4,6,7,4};
		int[] distance={6,5,3,5};

		int start=circularTour(petrol,distance);

		if(start!=-1){
			System.out.println("Starting pump: "+start);
		}
		else{
			System.out.println("No solution");
		}
	}
}
