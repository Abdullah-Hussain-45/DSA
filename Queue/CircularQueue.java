//Circular Queue is more flexible than Normal Queue
//it follows the f(rear,size) =  (rear +1 ) % size function

class Queue{
	int[] arr;
	int size;
	static int rear;
	static int front;
	
	Queue(int s){ // Constructor to initialize the objects 
		size = s;
		arr = new int[size];
		rear = -1;
		front = -1;
	}
	
	public boolean isEmpty(){
		return rear == -1 && front == -1;
	}
	
	public boolean isFull(){
		return rear+1 % size == front;
	}
	
	public void enQueue(int data){ //adding elements - Time Complexity->0(1)
		if(isFull()){
			System.out.println("Queue is full.");
			return;
			
		}
		//if first element then front must be  0
		if(front == -1){
			front = 0;
		}
		rear = (rear + 1)  % size;
		arr[rear] = data;
	}
	
	public int deQueue(){// removing elements from Queue - Time Complexity->0(1)
		if(isEmpty()){
			System.out.println("Queue is empty.");
			return -1;
		}
		
		int result = arr[front];
	
		/*if there is only single element which means rear and front
		are in same location then both must be = -1 */
		if(rear == front){
			rear = front = -1;
		}
		else{
			front = (front + 1) % size;
		}
		return result;
	}
	
	public int peek(){// front element in the queue - Time Complexity->0(1)
		if(isEmpty()){
			System.out.println("Queue is empty.");
			return -1;
		}
		return arr[front];	
	}
	public void display(){ //displaying the queue elements
		if(isEmpty()){
			System.out.println("Queue is empty.");
			return;
		}
		System.out.print("Elements in the queue: ");
		for(int i=front;i<=rear;i++){
			System.out.print(arr[i]+" ");
		}
	}
	
}
public class CircularQueue{
	public static void main(String args[]){
		int size = 5;
		Queue q = new Queue(size);
		q.enQueue(1);
		q.enQueue(13);
		q.enQueue(19);
		
		

		while(!q.isEmpty()){
		q.display();
		System.out.println("\nPeek Element: "+q.peek());
		System.out.println("\nElement removed: "+q.deQueue());
		}
		q.deQueue();
		System.out.println("Values of front and rear respectively: "+q.front+" "+q.rear);
	}
}