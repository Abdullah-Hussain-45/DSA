class Node{
	int data;
	Node next;
	Node prev;
	Node(int d){
		data = d;
		next = null;
		prev = null;
	}
}
public class DoublyLinkedListWithoutTail{
	Node head;
	
	public void addToFront(int data){ // adding newNode to Front -0(1)
		Node newNode = new Node(data);
		if(head == null){
			head = newNode;
			return;
		}
		head.prev = newNode;
		newNode.next = head;
		head = newNode;
		return;
	}
	
	public void addToLast(int data){ // adding newNode to last- 0(n)
		Node newNode = new Node(data);
		if(head==null){
			head = newNode;
			return;
		}
		Node currNode = head;
		while(currNode.next!=null){
			currNode = currNode.next;
		}
		currNode.next = newNode;
		newNode.prev = currNode;
	}

	public void addBefore(int key,int data){ // adding before targetData
		Node newNode = new Node(data);
		if(head == null){
			System.out.println("List is empty.");
			return;
		}
		if(head.data == key){
			addToFront(data);
			return;
		}
		Node currNode = head;
		while(currNode!=null){
			if(currNode.data==key){
				newNode.prev = currNode.prev;
				newNode.next = currNode;
				currNode.prev.next = newNode;
				currNode.prev = newNode;
				return;
			}
			currNode = currNode.next;
		}
		System.out.println("Node not found.");
	}
	
	public void addAfter(int key,int data){
		Node newNode = new Node(data);
		if(head == null){
			System.out.println("List is empty.");
			return;
		}
		if(head.data == key){
			newNode.next = head.next;
			newNode.prev = head;
			head.next.prev = newNode;
			head.next = newNode;
			return;
		}
		Node currNode = head.next;
		while(currNode!=null){
			if(currNode.data == key){
				if(currNode.next==null){
					addToLast(data);
					return;
				}
				newNode.next = currNode.next;
				currNode.next.prev = newNode;
				newNode.prev = currNode;
				currNode.next = newNode;
				return;
			}
			currNode = currNode.next;
		}
		System.out.println("Node not found");
	}
	
	public void removeFront(){ //removing from front - 0(1)
		if(head == null){
			System.out.println("List is empty.");
			return;
		}
		if(head.next==null){
			head = null;
			return;
		}
		head = head.next;
		head.prev = null;
	}
	
	public void deleteNode(int targetData){
		if(head == null){
			System.out.println("List is empty.");
			return;
		}
		if(head.data == targetData){
			removeFront();
			return;
		}
		Node currNode = head;
		while(currNode!=null){
			if(currNode.data == targetData){
				if(currNode.next == null){
					removeBack();
					return;
				}
				currNode.prev.next = currNode.next;
				currNode.next.prev = currNode.prev;
				return;
			}
			currNode = currNode.next;
		}
	}
	
	public void searchNode(int key){// searching node by key
		if(head == null){
			System.out.println("\nList is empty.");
			return;
		}
		if(head.data == key){
			System.out.println("\nNode found: "+head.data);
			return;
		}
		Node currNode = head.next;
		while(currNode!=null){
			if(currNode.data == key){
				System.out.println("\nNode found: "+currNode.data);
				return;
			}
			currNode = currNode.next;
		}
		System.out.println("\nNode not found.");		
	}
	
	public void updateNode(int oldData,int newData){ // updating Node 
		if(head == null){
			System.out.println("List is empty.");
			return;
		}
		if(head.data == oldData){
			head.data  = newData;
			return;
		}
		Node currNode = head.next;
		while(currNode!=null){
			if(currNode.data == oldData){
				currNode.data = newData;
				return;
			}
			currNode = currNode.next;
		}
		System.out.println("Node not found.");	
	}

	public void removeBack(){
		if(head == null){
			System.out.println("List is empty.");
			return;
		}
		if(head.next == null){
			head = null;
			return;
		}
		Node currNode = head;
		while(currNode.next.next!=null){
			currNode = currNode.next;
		}
		currNode.next = null;
	}
		
	public void display(){ //traversing forward and printing them all
		if(head == null){
			System.out.println("\nList is empty.");
			return;
		}
		Node currNode = head;
		System.out.print("\nNull <- ");
		while(currNode!=null){
			if(currNode.next==null){
				System.out.print(currNode.data+" -> Null");
				return;
			}
			System.out.print(currNode.data+ " <-> " );
			currNode = currNode.next;
		}
		System.out.print(" Null");
		System.out.println();
	}
	
	
	
	public static void main(String args[]){
		DoublyLinkedListWithoutTail list = new DoublyLinkedListWithoutTail();
		list.addToFront(1);
		list.addToFront(0);
		list.addToLast(5);
		list.addBefore(0,3);
		list.display();
		
	}
}
