class LinearSearchProblem1{
	public static int linear(int[] arr){
		for(int i=0;i<arr.length;i++){
			if(arr[i]<0){
				return i;
			}
		}
		return -1;
	}	
	public static void main(String args[]){
		int[] arr={12,431,234,112,3,-312,1231,14,-12,123};
		int index=linear(arr);
		if(index!=-1){
			System.out.println("The negative number is at index:"+index);
		}
		else{
			System.out.println("No negative number.");
		}
	}
}
