//Circular Queue is more flexible than Normal Queue
//it follows the f(rear,size) =  (rear +1 ) % size function

class Queue{
	int[] arr;
	int capacity;
	static int rear;
	static int front;
	int size;
	
	Queue(int capacity){ // Constructor to initialize the objects 
		this.capacity = capacity;
		arr = new int[this.capacity];
		rear = -1;
		front = -1;
		size = 0;
	}
	
	public boolean isEmpty(){
		return rear == -1 && front == -1;
	}
	
	public boolean isFull(){
		return size == capacity;
	}
	public int capacity(){
		return capacity;
	}

	public int size(){
		return size;
	}	
	public void enQueue(int data){ //adding elements - Time Complexity->0(1)
		if(isFull()){
			throw new RuntimeException("Queue is full.");
		}
		//if first element then front must be  0
		if(front == -1){
			front = 0;
		}
		size++;
		rear = (rear + 1)  % capacity;
		arr[rear] = data;

	}
	
	public int deQueue(){// removing elements from Queue - Time Complexity->0(1)
		if(isEmpty()){
			throw new RuntimeException("Queue is empty!");
		}
		
		int result = arr[front];
	
		/*if there is only single element which means rear and front
		are in same location then both must be = -1 */
		if(rear == front){
			rear = front = -1;
		}
		else{
			front = (front + 1) % capacity;
		}
		size--;
		return result;
	}
	
	public int peek(){// front element in the queue - Time Complexity->0(1)
		if(isEmpty()){
			throw new RuntimeException("Queue is empty!");
		}
		return arr[front];	
	}
	public void display(){ //displaying the queue elements
		if(isEmpty()){
			throw new RuntimeException("Queue is empty!");
		}
		System.out.print("Elements in the queue: ");
		int i = front;
		for(int count = 0; count < size; count++){
			System.out.print(arr[i]+" ");
			i = (i + 1) % capacity;
		}
	}
	
}
public class CircularQueue{
	public static void main(String args[]){
		int capacity = 3;
		Queue q = new Queue(capacity);
		try{
			q.enQueue(1);
			q.enQueue(2);
			q.enQueue(3);
			q.enQueue(4);
		}
		catch(RuntimeException e){
			System.out.println("Error : "+e.getMessage());
		}

		try{
			while(q.size != -1){

				q.display();
				System.out.println("\nQueue Size: "+q.size());
				System.out.println("\nPeek Element: "+q.peek());
				System.out.println("\nElement removed: "+q.deQueue());
			}
		}
		catch(RuntimeException e){
			System.out.println("Error : "+e.getMessage());
		}
	}
}