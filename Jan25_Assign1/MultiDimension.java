import java.util.*;
class MultiDimension{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int row=sc.nextInt();
		int column=sc.nextInt();
		int [] array=new int[row*column];
		int k=0;
		int [][]matrix=new int[row][column];
		for(int i=0;i<row;i++){
			for(int j=0;j<column;j++){
				matrix[i][j]=sc.nextInt();
				array[k]=matrix[i][j];
				k++;
			}
		}
		System.out.println("Array elements are");
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}
}
