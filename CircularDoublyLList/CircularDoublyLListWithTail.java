class Node{
    int data;
    Node next;
    Node prev;
    Node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
public class CircularDoublyLListWithTail {
    Node head,tail;

    CircularDoublyLListWithTail(){
        this.head = null;
        this.tail = null;
    }

    public void addFront(int data){ // adding to Front - 0(1)
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            tail.next = head;
            head.prev = tail;
            return;
        }
        newNode.next = head;
		newNode.prev = tail;
        head.prev = newNode;
		head = newNode;
        tail.next = head;
    }

    public void addBack(int data){// adding to Back - 0(1)
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            tail.next = head;
            head.prev = tail;
            return;
        }
        tail.next = newNode;
		newNode.prev = tail;
		tail = newNode;
		tail.next = head;
		head.prev = tail;
    }
	
	public void deleteFront(){// deleting from Front - 0(1)
		if(head == null){
			System.out.println("List is empty.");
			return;
		}
		if(head == tail){
			head = null;
			return;
		}
		head = head.next;
		head.prev = tail;
		tail.next = head;
	}
		
	public void deleteBack(){ // deleting from back - 0(1)
		if(head == null || tail == null){
			System.out.println("List is empty.");
			return;
		}
		if(head == tail){
			head = tail = null;
			return;
		}
		tail = tail.prev;
		tail.next = head;
		head.prev = tail;
	}
	
	public void searchNode(int key){
		if(head == null){
			System.out.println("List is empty.");
			return;
		}
		if(head.data == key){
			getHead();
			return;
		}
		if(tail.data == key){
			getTail();
			return;
		}
		Node curr = head;
		while(curr.next!=head){
			if(curr.data == key){
				System.out.println("Node found: "+curr.data);
				return;
			}
			curr = curr.next;
		}
		System.out.println("Node not found.");
	}
	
	public void deleteNode(int key){
		if(head == null || tail == null){
			System.out.println("List is empty.");
			return;
		}
		if(head.data == key){
			deleteFront();
			return;
		}
		if(tail.data == key){
			deleteBack();
			return;
		}
		Node curr = head;
		do{
			if(curr.next.data == key){
				curr.next.prev = null;
				curr.next = curr.next.next;
				curr.next.prev = curr;
				return;
			}
			curr = curr.next;
		}while(curr!=head);
		System.out.println("Node not found.");
	}
	
	
	public void addAfter(int key,int data){
		Node newNode = new Node(data);
		if(head == null && tail == null){
			System.out.println("List is empty.");
			return;
		}
		if(head.data == key){
			newNode.next = head.next;
			head.next.prev = newNode;
			head.next = newNode;
			newNode.prev = head;
			return;
		}
		Node curr = head;
		do{
			if(curr.data == key){
				newNode.next = curr.next;
				curr.next.prev = newNode;
				curr.next = newNode;
				newNode.prev = curr;
				curr.next = newNode;
				if(curr == tail){
					tail = newNode;
				}
				return;
			}
			curr = curr.next;
		}while(curr!=head);
		System.out.println("Node not found.");
	}
	
	public void addBefore(int key,int data){ // adding before targetData
		Node newNode = new Node(data);
		if(head == null && tail == null){
			System.out.println("List is empty.");
			return;
		}
		if(head.data == key){
			addFront(data);
			return;
		}
		Node currNode = head;
		do{
			if(currNode.data==key){
				newNode.prev = currNode.prev;
				newNode.next = currNode;
				currNode.prev.next = newNode;
				currNode.prev = newNode;
				return;
			}
			currNode = currNode.next;
		}while(currNode!=head);
		System.out.println("Node not found.");
	}
	
	
	
	public void updateNode(int oldData,int newData){
		if(head == null){
			System.out.println("List is empty.");
			return;
		}
		if(head.data == oldData){
			head.data = newData;
			return;
		}
		if(tail.data == oldData){
			tail.data = newData;
			return;
		}
		Node curr = head;
		do{
			if(curr.data == oldData){
				curr.data = newData;
				return;
			}
			curr = curr.next;
		}while(curr!=head);
		System.out.println("Node not found.");
	}
	
	public void getTail(){
		if(tail == null){
			System.out.println("List is empty.");
			return;
		}
		System.out.println("\nTail Node: "+tail.data);
	}
	
	public void getHead(){
		if(head == null){
			System.out.println("List is empty.");
			return;
		}
		System.out.println("\nHead Node: "+head.data);
	}


    public void display(){// traversing forward
        if(head == null){
            System.out.println("List is empty.");
            return;
        }
		//System.out.print(head.prev.data+" <-> ");
        Node curr = head;
        do{
            System.out.print(curr.data+" <-> ");
            curr = curr.next;

        }while(curr!=head);
        System.out.print(head.data);
		System.out.println();
    }


    public static void main(String args[]){
        CircularDoublyLListWithTail circular = new CircularDoublyLListWithTail();
        circular.addFront(10);
		circular.addBack(20);
		circular.addFront(30);
		circular.addBack(40);
        circular.display();
		circular.getTail();
		circular.getHead();
		circular.deleteNode(30);
		circular.display();
		circular.getTail();
		circular.getHead();
		

    }
    
}
