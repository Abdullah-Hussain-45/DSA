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
	//InsertAtFirst
	public void insertAtFront(String data){
			Node newNode = new Node(data);
			newNode.next = head;
			head = newNode;
		}
	//InsertAtEnd
	public void insertAtEnd(String data){
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
	//InsertAtPosition
	public void insertAtPosition(int index,String data){
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
	//removing Node from Front
	public void removeFront(){
		if(head == null){
			System.out.println("LinkedList is empty.");
			return;
		}
		head = head.next;
		System.out.println("Head Node is removed.");
		printAll();
		return;
	}
	//removing Node from End
	public void removeEnd(){
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
	public void removeByPosition(int index){
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
				break;	
			}
			currNode = currNode.next;
			count++;
		}
	}
			
		
	
	public void printAll(){
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
	list.insertAtPosition(3,"X");
	list.printAll();
	list.removeByPosition(3);

	
	
	
}
}	
	
	