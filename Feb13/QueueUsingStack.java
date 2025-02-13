import java.util.*;

class QueueUsingStacks{
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;

	public QueueUsingStacks(){
		stack1 =new Stack<>();
		stack2 =new Stack<>();
	}

	public void enqueue(int x){
		stack1.push(x);
	}
	
	public int dequeue(){
		if(stack2.isEmpty()){
			if(stack1.isEmpty()){
				System.out.println("Queue is Empty");
			}
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}

	public int peek(){
		if(stack2.isEmpty()){
			if(stack1.isEmpty()){
				System.out.println("Queue is empty");
			}
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
		}
		return stack2.peek();
	}

	public boolean isEmpty(){
		return stack1.isEmpty() && stack2.isEmpty();
	}

	public int size(){
		return stack1.size() + stack2.size();
	}
}

public class QueueUsingStack{
	public static void main(String args[]){
		QueueUsingStacks queue=new QueueUsingStacks();
		
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);

		System.out.println("Dequeued: "+queue.dequeue());
	
		queue.enqueue(40);
		queue.enqueue(50);

		System.out.println("Front element: "+queue.peek());
		System.out.println("Dequeued: "+queue.dequeue());
		System.out.println("Is queue empty? "+queue.isEmpty());
		System.out.println("Queue size: "+queue.size());
	}
}
