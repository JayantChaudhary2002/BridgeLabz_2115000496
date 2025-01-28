import java.util.Random;
class MatrixOperations{
	public static void main(String[] args){
		Random random=new Random();
		int rows=3,cols=3;
		int[][] matrix1=createRandomMatrix(rows,cols);
		int[][] matrix2=createRandomMatrix(rows,cols);
		System.out.println("Matrix 1:");
		displayMatrix(matrix1);
		System.out.println("Matrix 2:");
		displayMatrix(matrix2);
		int[][] sum=addMatrices(matrix1,matrix2);
		System.out.println("Sum of matrices:");
		displayMatrix(sum);
		int[][] diff=subtractMatrices(matrix1,matrix2);
		System.out.println("Difference of matrices:");
		displayMatrix(diff);
		int[][] product=multiplyMatrices(matrix1,matrix2);
		System.out.println("Product of matrices:");
		displayMatrix(product);
		int[][] transpose=transposeMatrix(matrix1);
		System.out.println("Transpose of Matrix 1:");
		displayMatrix(transpose);
		System.out.println("Determinant of Matrix 1:");
		System.out.println(determinant2x2(matrix1));
		System.out.println("Inverse of Matrix 1:");
		displayMatrix(inverse2x2(matrix1));
	}
	public static int[][] createRandomMatrix(int rows,int cols){
		Random random=new Random();
		int[][] matrix=new int[rows][cols];
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				matrix[i][j]=random.nextInt(10)+1;
			}
		}
		return matrix;
	}
	public static int[][] addMatrices(int[][] matrix1,int[][] matrix2){
		int[][] result=new int[matrix1.length][matrix1[0].length];
		for(int i=0;i<matrix1.length;i++){
			for(int j=0;j<matrix1[0].length;j++){
				result[i][j]=matrix1[i][j]+matrix2[i][j];
			}
		}
		return result;
	}
	public static int[][] subtractMatrices(int[][] matrix1,int[][] matrix2){	
		int[][] result=new int[matrix1.length][matrix1[0].length];
		for(int i=0;i<matrix1.length;i++){
			for(int j=0;j<matrix1[0].length;j++){
				result[i][j]=matrix1[i][j]-matrix2[i][j];
			}
		}
		return result;
	}
	public static int[][] multiplyMatrices(int[][] matrix1,int[][] matrix2){
		int[][] result=new int[matrix1.length][matrix2[0].length];
		for(int i=0;i<matrix1.length;i++){
			for(int j=0;j<matrix2[0].length;j++){
				for(int k=0;k<matrix1[0].length;k++){
					result[i][j]+=matrix1[i][k]*matrix2[k][j];
				}
			}
		}
		return result;
	}
	public static int[][] transposeMatrix(int[][] matrix){
		int[][] result=new int[matrix[0].length][matrix.length];
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				result[j][i]=matrix[i][j];
			}
		}
		return result;
	}
	public static int determinant2x2(int[][] matrix){
		return matrix[0][0]*matrix[1][1]-matrix[0][1]*matrix[1][0];
	}
	public static int determinant3x3(int[][] matrix){
		int determinant=matrix[0][0]*(matrix[1][1]*matrix[2][2]-matrix[1][2]*matrix[2][1])-
		matrix[0][1]*(matrix[1][0]*matrix[2][2]-matrix[1][2]*matrix[2][0])+
		matrix[0][2]*(matrix[1][0]*matrix[2][1]-matrix[1][1]*matrix[2][0]);
		return determinant;
	}
	public static int[][] inverse2x2(int[][] matrix){
		int determinant=determinant2x2(matrix);
		if(determinant==0){
			System.out.println("Matrix is not invertible");
			return null;
		}
		int[][] inverse=new int[2][2];
		inverse[0][0]=matrix[1][1];
		inverse[0][1]=-matrix[0][1];
		inverse[1][0]=-matrix[1][0];
		inverse[1][1]=matrix[0][0];
		for(int i=0;i<2;i++){
			for(int j=0;j<2;j++){
				inverse[i][j]=inverse[i][j]/determinant;
			}
		}
		return inverse;
	}
	public static int[][] inverse3x3(int[][] matrix){
		int determinant=determinant3x3(matrix);
		if(determinant==0){
			System.out.println("Matrix is not invertible");
			return null;
		}
		return null;
	}
	public static void displayMatrix(int[][] matrix){
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				System.out.print(matrix[i][j]+"\t");
			}
		System.out.println();
		}
	}
}
