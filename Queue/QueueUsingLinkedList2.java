class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;

	}
}
public class QueueUsingLinkedList2{
    Node head,tail;
    int size;
	int capacity;

    QueueUsingLinkedList2(int capacity){
        head = tail = null;
        size = 0;
		this.capacity = capacity;
    }

    public boolean isEmpty(){
        return head == null;
    }
	
	public boolean isFull(){
		System.out.print(" Size: "+size());
		return this.size == this.capacity;
	}

    public void enQueue(int data){
		if(isFull()){
			throw new RuntimeException("Queue is full.");
		}
        Node newNode = new Node(data);
        if(isEmpty()){
            head = tail = newNode;
            return;
        }
		this.size++;
        tail.next = newNode;
        tail = newNode;
		System.out.print("Size: "+this.size);
		System.out.println("   Capacity: "+this.capacity);
    }
    public int deQueue(){
        if(isEmpty()){
            throw new RuntimeException("Queue is empty.");
        }
        int data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public int peek(){
        if (isEmpty()){
            throw new RuntimeException("Queue is empty.");
        }
        return head.data;
    }

    public int size(){
        return size;
    }

    public void display(){
        if(isEmpty()){
            throw new RuntimeException("Queue is empty.");
        }
        Node curr = head;
		System.out.print("Elements in the Queue: "); 
		int count = 0;
        while(curr!=null && count!=(capacity+1)){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
		int capacity = 3;
        QueueUsingLinkedList2 q = new QueueUsingLinkedList2(capacity);

        try{
            q.enQueue(1);
            q.enQueue(2);
            q.enQueue(3);
			//q.isFull();
			//q.size();
			q.enQueue(4);
			q.display();
			/*System.out.println("\nRemoved from queue: "+q.deQueue());
			System.out.println("\nRemoved from queue: "+q.deQueue());
			System.out.println("\nRemoved from queue: "+q.deQueue());
			System.out.println("\nRemoved from queue: "+q.deQueue());*/
			
			
        }
        catch(RuntimeException e){
            System.out.println("Runtime Expception : "+e.getMessage());

        }

    }
}
