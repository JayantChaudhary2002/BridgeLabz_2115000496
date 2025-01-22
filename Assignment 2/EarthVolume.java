class EarthVolume{
	public static void main(String args[]){
		int earthRadius=6378;
		double pi=3.14;
		//Create variable to find volume of earth in km by using 4/3*pi*r*r*r
		double volumeKm=(4/3)*pi*(double)(earthRadius*earthRadius*earthRadius);
		double volumeMiles=volumeKm/1.6;
		//Displaying the result
		System.out.println("The volume of earth in cubic kilometers is "+volumeKm+" and cubic miles is "+volumeMiles);
	}
}
