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
public class CircularDoublyLListWithoutTail{
    Node head;
    CircularDoublyLListWithoutTail(){
        this.head = null;
    }

    public void addFront(int data){ // adding to front - 0(1)
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            head.next = head;
            head.prev = head;
            return;
        }
		if(head.next==head){
			newNode.next = head;
			newNode.prev = head;
			head.next = newNode;
			head.prev = newNode;
			head = newNode;
			return;
		}
		Node curr = head;
		while(curr.next!=head){
			curr = curr.next;
		}
		newNode.next = head;
		newNode.prev = curr;
		curr.next = newNode;
		head.prev = newNode;
		head = newNode;
    }
	
	public void addBack(int data){ //adding to back - 0(n)
		Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            newNode.next = head;
            head.prev = newNode;
            return;
        }
		Node curr = head;
		while(curr.next!=head){
			curr = curr.next;
		}
		curr.next = newNode;
		newNode.prev = curr;
		newNode.next = head;
		head.prev = newNode;
	}
	
	public void deleteFront(){ //deleting from front-0(1)
		if(head == null){
			System.out.println("List is empty.");
			return;
		}
		if(head.next == head){
			head = null;
			return;
		}
		Node last = head.prev;
		head = head.next;
		last.next = head;
		head.prev = last;
	}
	
	public void deleteBack(){ //deleting from back - 0(1)
		if(head == null){
			System.out.println("List is empty.");
			return;
		}
		if(head.next == head){
			head = null;
			return;
		}
		Node last = head.prev;
		Node secondLast = last.prev;
		secondLast.next = head;
		head.prev = secondLast;
	}
	
	public void searchNode(int key){ //searching node by value - 0(n)
		if(head == null){
			System.out.println("List is empty.");
			return;
		}
		if(head.data == key){
			getHead();
			return;
		}
		Node curr = head;
		do{
			if(curr.data == key){
				System.out.println("Node found: "+curr.data);
				return;
			}
			curr = curr.next;
		}while(curr!=head);
		System.out.println("Node not found.");
	}
	
	public void deleteNode(int key){ //deleting node by key - 0(n)
		if(head == null){
			System.out.println("List is empty.");
			return;
		}
		if(head.data == key){
			deleteFront();
			return;
		}
		Node curr = head;
		while(curr.next!=head){
			if(curr.next.data == key){
				curr.next = curr.next.next;
				curr.next.prev = curr;
				return;
			}
			curr = curr.next;
		}
		System.out.println("Node not found.");
	}
	
	public void addAfter(int key,int data){ // adding after the key - 0(n)
		Node newNode = new Node(data);
		if(head == null){
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
				return;
			}
			curr = curr.next;
		}while(curr!=head);
		System.out.println("Node not found.");
	}
	
	public void addBefore(int key,int data){ // adding before targetData
		Node newNode = new Node(data);
		if(head == null){
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
	
	public void updateNode(int oldData,int newData){ //updating node - 0(n)
		if(head == null){
			System.out.println("List is empty.");
			return;
		}
		if(head.data == oldData){
			head.data = newData;
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
	
	public void getHead(){// getting Head - 0(1)
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
        CircularDoublyLListWithoutTail circular = new CircularDoublyLListWithoutTail();
		circular.addFront(10);
		circular.addBack(20);
		circular.display();
		circular.addAfter(10,300);
		circular.display();
		
		
		
    }
}