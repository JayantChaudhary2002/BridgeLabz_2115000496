import java.util.*;
class SortedStack{
	public void sortStack(Stack<Integer> stack){
		if(!stack.isEmpty()){
			int temp = stack.pop();
			sortStack(stack);
			insertSorted(stack,temp);
		}
	}
	public void insertSorted(Stack<Integer> stack, int element){
		if(stack.isEmpty() || stack.peek() <= element){
		stack.push(element);
		return;
		}
		int temp=stack.pop();
		insertSorted(stack,element);
		stack.push(temp);
	}
}

public class SortStackRecursion{
	public static void main(String args[]){
		Stack<Integer> stack =new Stack<>();

		stack.push(30);
		stack.push(10);
		stack.push(20);
		stack.push(40);
		stack.push(50);

		SortedStack sortedStack = new SortedStack();
		sortedStack.sortStack(stack);
	
		System.out.println("Sorted stack: "+stack);
	}
}
