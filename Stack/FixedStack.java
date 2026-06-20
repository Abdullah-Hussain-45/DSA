class myStack{
	int[] arr;
	int capacity;
	int top;
	myStack(int cap){
		capacity = cap;
		arr = new int[capacity];
		top = -1;
	}
	
	public void push(int data){
		if(top == capacity-1){
			System.out.println("Stack overflow(full).");
			return;
		}
		arr[++top] = data;
	}
	
	public int pop(){
		if(isEmpty()){
			System.out.println("Stack underflow(empty).");
			return -1;
		}
		return arr[top--];
	}
	
	public int peek(){
		if(isEmpty()){
			System.out.println("Stack underflow(empty).");
			return -1;
		}
		return arr[top];
	}
	
	public boolean isEmpty(){
		return top == -1;
	}
	
	public void display(){
		if(isEmpty()){
			System.out.println("Stack underflow(empty).");
			return;
		}
		for(int i=top;i>=0;i--){
			System.out.println(arr[i]);
		}
	}
	
}
public class FixedStack{
	public static void main(String[] args){
		myStack stack = new myStack(5);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println("Elements in the stack");
		stack.display();
		
		while(!stack.isEmpty()){
		System.out.println("Peek Element: "+stack.peek());
		System.out.println("Poped Element: "+stack.pop());
		System.out.println("Is Stack empty? "+(stack.isEmpty() ? "Yes" : "No"));
		System.out.println("Elements in the stack");
		stack.display();
		}
		
	}
}