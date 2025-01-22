//Create class to compute the number of pens distributed and remaining
class PenDistribution{
	public static void main(String args[]){
		//Create variable to store total pens.
		int pens=14;

		//Create variable to store total number of students.
		int students=3;

		//Create variable to store pens distributed to each student.
		int penPerStudent=14/3;

		//Create variable to store pens left undistributed.
		int remainingPen=14%3;

		//Displaying the result.
		System.out.println("The Pen Per Student is "+penPerStudent+" and the remaining pen not distributed is "+remainingPen);
	}
}
