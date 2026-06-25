class Node{
    String data;
    Node next;
    
    Node(String d){
        data = d;
        next = null;
    }
}
public class LinkedListWithTail {
	Node head,tail;
	
	
	public void addToFront(String data){ // adding Node to front - O(1) 
		Node newNode = new Node(data);
		if(head== null){
			head = tail = newNode;
			return;
		}
		newNode.next = head;
		head = newNode;
	}
	
	public void addToBack(String data){ // adding to tail - O(1)
		Node newNode = new Node(data);
		if(head == null){
			head = tail = newNode;
			return;
		}
		tail.next = newNode;
		tail = newNode;
	}
	
	public void getTail(){
		if(tail ==null){
			System.out.println("List is empty.");
			return;
		}
		System.out.println("Tail Node: "+tail.data);
	}
	
	public void getHead(){
		if(head==null){
			System.out.println("List is empty.");
			return;
		}
		System.out.println("Head Node: "+head.data);
	}
	
	
	
	public void printAll(){ // Traversing all Nodes and printing each node
		if(head==null){
		System.out.print("Linked List is empty.");
		return;
	}
		Node temp = head;
		while(temp!=null){
			System.out.print(temp.data+"->");
			temp = temp.next;
		}
		System.out.print("Null");
		
		System.out.println();
	}
	
	public static void main(String args[]){
		LinkedListWithTail list = new LinkedListWithTail();
		
		list.addToBack("A");
		list.addToFront("B");
		list.printAll();
		list.getHead();
		list.getTail();
		
		
	}
	
    
}
