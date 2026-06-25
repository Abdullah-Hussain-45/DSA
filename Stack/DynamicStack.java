import java.util.Scanner;

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
	int size;
	int capacity;
	DynamicStack(int cap){
		top = null;
		size = 0; //to store the size of the Stack
		capacity = cap; 
	}
	public void push(int data){// addFirst method of LinkedList - Time Complexity - 0(1)
		if(isFull()){
			throw new RuntimeException("Stack is full");
		}
		 
		Node element = new Node(data);
		element.next = top;
		top = element;
		size++;
	}
	
	public int pop(){ //deleteFront method of LinkedList  - Time Complexity - 0(1)
		if(isEmpty()){
			System.out.println("Stack is underflow.");
			return -1;
		}
		Node temp = top;
		top = top.next;
		int val = temp.data;
		temp = null;
		size--;
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
		return size;
	}

	public boolean isFull(){
		return size == capacity;
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
		int capacity = 5;
		DynamicStack stack = new DynamicStack(capacity);
		Scanner scan = new Scanner(System.in);
		try{
			while(stack.size != (capacity + 1)){
				System.out.print("Enter the data: ");
				int data = scan.nextInt();
				stack.push(data);
			}
		}
		catch(RuntimeException e){
			System.out.println(e.getMessage());
		}
		finally{
		stack.display();
		/*while(!stack.isFull()){
			System.out.println("Enter the data: ");
			int data = scan.nextInt();
			stack.push(data);
		}*/
		
			while(!stack.isEmpty()){
			//Poping Elements from Stack
			System.out.println("\nPoped Element: "+stack.pop());
			
			stack.display();
			//Peek Element from Stack
			System.out.println("Peek Element: "+stack.peek());
			
			//Checking stack is empty or not
			System.out.println("Is Stack empty: "+(stack.isEmpty() ? "Yes" : "No"));
			
			//Size of Elements
			System.out.println("Size of the Stack: "+stack.size());
			}
		scan.close();
		}
	}
}