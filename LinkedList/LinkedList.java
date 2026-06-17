	class Node{
			String data;
			Node next;		
		public Node(String d){
				data = d;
				next = null;
			}
		}
public class LinkedList{
	Node head;
	
	public void insertAtFront(String data){	//InsertAtFirst
			Node newNode = new Node(data);
			newNode.next = head;
			head = newNode;
			
		}
	
	public void insertAtEnd(String data){ //InsertAtEnd
			Node newNode = new Node(data);
			if(head == null){
				head = newNode;
		}else{
		Node currNode = head;
		while(currNode.next!=null){
			currNode = currNode.next;
		}
		currNode.next = newNode;
		}
	}
	
	public void insertAtPosition(int index,String data){ //InsertAtPosition
		if(index==0){
			insertAtFront(data);
			return;
		}
		Node newNode = new Node(data);
		int count = 1;
		Node currNode = head;
		while(currNode!=null){
			if(count==index){
				newNode.next = currNode.next;
				currNode.next = newNode;
				System.out.println("Node is inserted at position "+index);
				break;
			}
			currNode = currNode.next;
			count++;
		}
	}
	
	public void removeFront(){ //removing Node from Front
		if(head == null){
			System.out.println("LinkedList is empty.");
			return;
		}
		head = head.next;
		System.out.println("Head Node is removed.");
		printAll();
		return;
	}
	
	public void removeEnd(){  //removing Node from End
		if(head==null){
			System.out.println("LinkedList is empty.");
		return;
		}
		Node currNode = head;
		while(currNode.next.next!=null){
			currNode = currNode.next;
		}
		currNode.next = null;
		System.out.println("Last Node is removed.");
		printAll();
		return;
	}
	public void removeByPosition(int index){ //removing node by position
		if(head==null){
			System.out.println("LinkedList is empty.");
			return;
		}
		if(index==0){
			head = head.next;
			System.out.println("Node is removed from position "+(index+1));
			printAll();
			return;
		}
		
		Node currNode = head;
		int count=1;
		while(currNode!=null){
			if(count==index){
				currNode.next = currNode.next.next;
				System.out.println("Node is removed from position "+(index+1));
				printAll();
				return;	
			}
			currNode = currNode.next;
			count++;
		}
		System.out.println("Index is out of Bounds");
	}
	
	public boolean searchingByKey(String key){ //Searching by key
		if(head==null){
			System.out.println("LinkedList is empty.");
			return true;
		}
		Node currNode = head;
		boolean isFound = false;
		while(currNode!=null){
			if(currNode.data==key){
				isFound = true;
				System.out.println("Node is found "+ currNode.data );
				return isFound;
			}
			currNode = currNode.next;
		}
		System.out.println("Node is not found.");
		return isFound;
	}
		
	public void getHead(){	// getting head	
		if(head==null){
			System.out.println("LinkedList is empty. ");
			return;
		}
		System.out.println("Head Node is "+head.data);
		return;
	}
	
	public void getTail(){	//getting Tail
		if(head==null){
			System.out.println("LinkedList is empty. ");
			return;
		}
		Node currNode=head;
		while(currNode.next!=null){
			currNode = currNode.next;
		}
		System.out.println("Last Node is "+currNode.data);
		return;
	}
	
	public void reverseLinkedList(){ //reversing LinkedList
		Node currNode = head,nextNode = null,prevNode = null;
		while(currNode!=null){
			nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;
		}
		head = prevNode;
		System.out.println("LinkedList is reversed. ");
		printAll();
	}
	
	public void printAll(){ // Traversing all Nodes and printing each node
		Node temp = head;
		while(temp!=null){
			System.out.print(temp.data+"->");
			temp = temp.next;
		}
		if(head!=null){
		System.out.print("Null");}
		System.out.println();
	}
	
public static void main(String arg[]){
	LinkedList list = new LinkedList();
	
	list.insertAtEnd("A");
	list.insertAtEnd("B");
	list.insertAtEnd("C");
	list.insertAtEnd("D");
	list.insertAtEnd("E");
	list.reverseLinkedList();
	list.searchingByKey("E");


	
	
	
}
}	
	
	