import java.util.*;
class Node{
			String data;
			Node next;		
		public Node(String d){
				data = d;
				next = null;
			}
		}
public class LinkedListWithoutTail{
	Node head;
	
	public void insertAtFront(String data){	//InsertAtFirst
			Node newNode = new Node(data);
			if(head==null){
				head = newNode;
				return;
			}
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

	public void insertBeforeNode(String key,String data){ //InsertBeforeNode
		Node newNode = new Node(data);
		if(head==null){
			System.out.println("List is Empty");
			return;
		}
		if(head.data.equals(key)){
			insertAtFront(data);
			return;
		}
		Node currNode = head;
		Node prevNode = null;
		while(currNode!=null){
		    if(currNode.data.equals(key)){
				newNode.next = currNode;
				prevNode.next = newNode;
				System.out.println("Inserted Successfully before Node");
				return;
			}
			prevNode = currNode;
			currNode = currNode.next;
		}
		System.out.println("Index not found");
		}
	public void insertAfterNode(String key,String data){ //InsertAfterNode
	    Node newNode = new Node(data);
		if(head==null){
			System.out.println("List is Empty");
			return;
		}
		Node currNode = head;
		while(currNode!=null){
		    if(currNode.data.equals(key)){
				newNode.next = currNode.next;
				currNode.next = newNode;
				System.out.println("Inserted Successfully after Node");
				return;
			}
			currNode = currNode.next;
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
		if(head.next==null){
			head = null;
			System.out.println("Head Node is removed.");
			printAll();
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
		if(index<0){
			System.out.println("Invalid index.");
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
		while(currNode!=null && currNode.next!=null){
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
		if(head == null){
			System.out.println("LinkedList is empty.");
			return;
		}
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

	public void updateNode(String key,String data){ // updating any value in Node
		if(head==null){
			System.out.println("LinkedList is empty. ");
			return;
		}
		Node currNode = head;
		while(currNode!=null){
			if(currNode.data.equals(key)){
				if(currNode.data.equals(data)){
					System.out.println("Node data is already exists. ");
					return;
				}
				currNode.data = data;
				System.out.println("Node is updated. ");
				return;
			}
			currNode = currNode.next;
		}
		System.out.println("Node is not found.");
	}

	public void size(){ // finding size of LinkedList
		if(head==null){
			System.out.println("LinkedList is empty. ");
			return;
		}
		Node currNode = head;
		int count = 0;
		while(currNode!=null){
			count++;
			currNode = currNode.next;
		}
		System.out.println("Size of LinkedList is "+count);
	}

	public  void countDuplicates(){
		if(head==null){
			System.out.println("LinkedList is empty. ");
			return;
		}
		Node currNode = head;
		while(currNode!=null){
		    int count = 0;
			Node temp = currNode;
			while(temp!=null){
				if(currNode.data.equals(temp.data)){
					count++;
				}
				temp = temp.next;
			}
			if(count>1){
				System.out.println(currNode.data+" is repeated "+count+" times. ");
			}
			currNode = currNode.next;
		}
	}

	public void updateBeforeNode(String key,String data ){ 
		Node newNode = new Node(data);//updating node before given node
		if(head==null){
			System.out.println("LinkedList is empty. ");
			return;
		}
		if(head.data.equals(key)){
			System.out.println("Node is not found. ");
			return;
		}
		Node currNode = head;
		while(currNode.next!=null){
			if(currNode.next.data.equals(key)){
				
				newNode.data = data;
				newNode.next = currNode.next;
				currNode.next = newNode;
				System.out.println("Node is updated. ");
				return;
			}
			currNode = currNode.next;

		}

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
	
public static void main(String arg[]){
	LinkedList list = new LinkedList();
	Scanner sc = new Scanner(System.in);

	while (true) {
		System.out.println("\n1. Insert Node at end. ");
		System.out.println("2. Insert Node at start. ");
		System.out.println("3. Insert Node at any position. ");
		System.out.println("4. Delete Node at end. ");
		System.out.println("5. Delete Node at start. ");
		System.out.println("6. Delete Node at any position. ");
		System.out.println("7. Reverse the LinkedList. ");
		System.out.println("8. Update any Node. ");
		System.out.println("9. Print all Nodes. ");
		System.out.println("10. Count Duplicates. ");
		System.out.println("11. Size of Linked List. ");
		System.out.println("12. Insert before Specific Node. ");
		System.out.println("13. Insert after Specific Node. ");
		System.out.println("14. Exit. ");
		System.out.print("Enter your choice: ");
		int choice = sc.nextInt();
		if (choice==1){
				sc.nextLine();
				System.out.print("Enter the String: ");
				String str1 = sc.nextLine();
				list.insertAtEnd(str1);
		}
		else if (choice==2){
				sc.nextLine();
				System.out.print("Enter the String: ");
				String str2 = sc.nextLine();
				list.insertAtFront(str2);
		}
		else if (choice==3){
				sc.nextLine();
				System.out.print("Enter the String: ");
				String str3 = sc.nextLine();
				System.err.print("Enter the index: ");
				int index = sc.nextInt();
				list.insertAtPosition(index, str3);
		}
		else if (choice == 4){
			list.removeEnd();

		}
		else if(choice==5){
			list.removeFront();

		}
		else if (choice==6){
				sc.nextLine();
				System.out.print("Enter the index to remove the node: ");
				int index = sc.nextInt();
				list.removeByPosition(index);
		}
		else if(choice==7){
			list.reverseLinkedList();
		}
		else if(choice==8){
			sc.nextLine();
			System.out.print("Enter the key to update the node: ");
			String key = sc.nextLine();
			System.out.print("Enter the new String: ");
			String str = sc.nextLine();
			list.updateNode(key, str);
		}
		else if(choice==9){
			sc.nextLine();
			list.printAll();
		}
		else if (choice==10){
				list.countDuplicates();
		}
		else if (choice==11){
			list.size();
		}
		else if (choice == 12){
			sc.nextLine();
			System.out.print("Enter the String to find Node: ");
			String key = sc.nextLine();
			System.out.print("Enter the String to insert before: ");
			String data = sc.nextLine();
			list.insertBeforeNode(key,data);
		}
		else if (choice==13){
			sc.nextLine();
			System.out.print("Enter the String to find Node: ");
			String key = sc.nextLine();
			System.out.print("Enter the String to insert after: ");
			String data = sc.nextLine();
			list.insertAfterNode(key,data);
		}
		else if (choice == 14){
			System.out.println("You have successfully exited.");
			break;
		}
		else if (choice == 15){
			System.out.println("Invalid choice. Please try again.");
		}		
		}
		sc.close();
	}
	
	
	
}	
	
	