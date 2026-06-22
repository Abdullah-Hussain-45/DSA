class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
		this.next = null;
	}
}
public class QueueUsing2Stacks{
	Node top; //top element in the stack
	int count;
	QueueUsing2Stacks(){
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
		QueueUsing2Stacks s1 = new QueueUsing2Stacks();
		QueueUsing2Stacks s2 = new QueueUsing2Stacks();
		s1.(1);
		
		while(!s1.isEmpty()){
			s2.push(s1.pop());
		}
		s1.push(data);
		
		while(!s2.isEmpty()){
			s1.push(s1.pop());
		}
		
		
	}
}