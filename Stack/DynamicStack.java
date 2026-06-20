class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
		this.next = null;
	}
}
public class DynamicStack{
	Node top; //top element in the stack
	int count;
	DynamicStack(){
		top = null;
		count = 0; //to store the size of the Stack
	}
	public void push(int data){
		Node element = new Node(data);
		element.next = top;
		top = element;
		count++;
	}
	
	public int pop(){
		if(isEmpty()){
			System.out.println("Stack is underflow.");
			return -1;
		}
		Node temp = top;
		top = top.next;
		int val = temp.data;
		temp = null;
		count--;
		return val;
	}
	
	public int peek(){
		if(isEmpty()){
			System.out.println("Stack is underflow.");
			return -1;
		}
		return top.data;
	}
	
	public boolean isEmpty(){
		return top == null;
	}
	
	public int size(){
		return count;
	}
	
	public void display(){
		if(isEmpty()){
			System.out.println("Stack is underflow.");
			return;
		}
		Node temp = top;
		while(temp!=null){
			System.out.println("\n"+temp.data);
			System.out.println("_");
			temp = temp.next;
		}
	}
	
	
	public static void main(String args[]){
		DynamicStack stack = new DynamicStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.display();
		
		//while(!stack.isEmpty()){
		//Poping Elements from Stack
		System.out.println("\nPoped Element: "+stack.pop());
		
		stack.display();
		//Peek Element from Stack
		System.out.println("Peek Element: "+stack.peek());
		
		//Checking stack is empty or not
		System.out.println("Is Stack empty: "+(stack.isEmpty() ? "Yes" : "No"));
		
		//Size of Elements
		System.out.println("Size of the Stack: "+stack.size());
		//}
		
	}
}