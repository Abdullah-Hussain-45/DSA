//Implementation 3
//Queue using LinkedList
class Node{
	int data;
	Node next;
	Node(int d){
		data = d;
		next = null;
	}
}
public class QueueUsingLinkedList{
	Node head,tail;
	
	QueueUsingLinkedList(){
		head = tail = null;
	}
	
	public boolean isEmpty(){
		 return head == null;
	}
	
	public void enQueue(int data){ //adding element in queue - Time Complexity -> 0(1) 
		Node element = new Node(data);
		if(isEmpty()){
			head = tail = element;
			return;
		}
		tail.next = element;
		tail = element;
	}
	
	public int deQueue(){ //removing element from queue - Time Complexity -> 0(1)
		if(isEmpty()){
			System.out.println("Queue is empty.");
			return -1;
		}
		int result = head.data;
		head = head.next;
		return result;
		
	}
		
	
	public void peek(){
		if(isEmpty()){
			System.out.println("Queue is empty.");
			return;
		}
		System.out.println("\nPeek Element: "+head.data);
	}
	
	public void display(){
		if(isEmpty()){
			System.out.println("Queue is empty.");
			return;
		}
		Node curr = head;
		System.out.print("Elements in the Queue: ");
		while(curr!=null){
			System.out.print(curr.data+" ");
			curr = curr.next;
		}
		
	}
	
	
	
	public static void main(String args[]){
		QueueUsingLinkedList q = new QueueUsingLinkedList();
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		
		while(!q.isEmpty()){
		q.display();
		q.peek();
		System.out.println("\nElement removed: "+q.deQueue());
		}
		q.deQueue();
		
		
	}
}