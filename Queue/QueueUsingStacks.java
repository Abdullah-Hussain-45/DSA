import java.util.Stack; // importing collection interfaces
public class QueueUsingStacks{
	//In this implementation we make Enqueue operation costly
	Stack<Integer> s1 = new Stack<>();
	Stack<Integer> s2 = new Stack<>();

	public void enQueue(int data){ //adding elements- Time Complexity- 0(n)
		while(!s1.isEmpty()){
			s2.push(s1.pop());
		}
		s1.push(data);

		while(!s2.isEmpty()){
			s1.push(s2.pop());
		}
	}
	
	public int deQueue(){//removing elements -Time Complexity 0(1)
		if(s1.isEmpty()){
			System.out.println("Underflow");
			return -1;
		}
		return s1.pop();
	}

	public int front(){
		if(s1.isEmpty()){
			System.out.println("Underflow");
			return -1;
		}
		return s1.peek();
	}
	public int size(){
		return s1.size();
	}

	public void display(){
		if(s1.isEmpty()){
			System.out.println("Underflow");
			return;
		}
		for(int i=size()-1;i>=0;i--){

			System.out.print(s1.get(i)+" ");
		}

	}



	public static void main(String[] args) {	
		QueueUsingStacks q = new QueueUsingStacks();
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		q.enQueue(4);

		q.display();
		while(q.front()!=-1){
		System.out.println("\nFront: "+q.front());
		System.out.println("Size: "+q.size());
		System.out.println("Removed: "+q.deQueue());
		q.display();
		}
	}
}