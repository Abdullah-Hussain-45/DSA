class Queue{
	int[] arr;
	int size;
	int rear;
	
	Queue(int s){ // Constructor to initialize the objects 
		size = s;
		arr = new int[size];
		rear = -1;
	}
	
	public boolean isEmpty(){
		return rear == -1;
	}
	
	public void enQueue(int data){ //adding elements - Time Complexity->0(1)
		if(rear == size -1){
			System.out.println("Queue is full.");
			return;
			
		}
		rear++;
		arr[rear] = data;
	}
	
	public int deQueue(){// removing elements from Queue - Time Complexity->0(n)
		if(isEmpty()){
			System.out.println("Queue is empty.");
			return -1;
		}
		rear--;
		int front = arr[0];
		for(int i=0;i<=rear;i++){
			arr[i] = arr[i+1];
		}			
		return front;
	}
	
	public int peek(){// front element in the queue - Time Complexity->0(1)
		if(isEmpty()){
			System.out.println("Queue is empty.");
			return -1;
		}
		
		return arr[0];	
	}
	public void display(){ //displaying the queue elements
		if(isEmpty()){
			System.out.println("Queue is empty.");
			return;
		}
		System.out.print("Elements in the queue: ");
		for(int i=0;i<=rear;i++){
			System.out.print(arr[i]+" ");
		}
	}
	
}

public class NormalQueue{
	public static void main(String args[]){
		int size = 5;
		Queue q = new Queue(size);
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(10);
		q.enQueue(5);
		q.enQueue(15);
		while(!q.isEmpty()){
		q.display();
		System.out.println("\nPeek Element: "+q.peek());
		System.out.println("\nElement removed: "+q.deQueue());
		}
		q.deQueue();
		
	}
}