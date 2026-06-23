class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;

	}
}
public class QueueUsingLinkedList {
    Node head,tail;
    int size;

    QueueUsingLinkedList(){
        head = tail = null;
        size = 0;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void enQueue(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            head = tail = newNode;
            size++;
            return;
        }
        tail.next = newNode;
        tail = newNode;
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
            throw new RuntimeException("Queue");
        }
        Node curr = head;
		System.out.print("Elements in the Queue: "); 
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        QueueUsingLinkedList q = new QueueUsingLinkedList();

        try{
            q.enQueue(1);
            q.enQueue(2);
            q.enQueue(3);
            q.display();
			
			System.out.println("\nRemoved from queue: "+q.deQueue());
			System.out.println("\nRemoved from queue: "+q.deQueue());
			System.out.println("\nRemoved from queue: "+q.deQueue());
			System.out.println("\nRemoved from queue: "+q.deQueue());
			
			
        }
        catch(RuntimeException e){
            System.out.println("Runtime : "+e.getMessage());

        }

    }
}
