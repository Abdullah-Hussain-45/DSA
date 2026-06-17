 class Node{
			int data;
			Node next;		
		public Node(int d){
				data = d;
				next = null;
			}
		}
public class LinkedListWithoutTail{
    Node head;

    public void addFront(int data){	//InsertAtFirst
			Node newNode = new Node(data);
			if(head==null){
				head = newNode;
				return;
			}
			newNode.next = head;
			head = newNode;
			
	}

    public void addBack(int data){ //InsertAtEnd
			Node newNode = new Node(data);
			if(head == null){
				head = newNode;
                return;
		    }
		Node currNode = head;
		while(currNode.next!=null){
			currNode = currNode.next;
		}
		currNode.next = newNode;
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

    public boolean searchingByKey(int key){ //Searching node by key
		if(head==null){
			System.out.println("LinkedList is empty.");
			return false;
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

    public void insertBeforeNode(int key,int data){ //InsertBeforeNode
		Node newNode = new Node(data);
		if(head==null){
			System.out.println("List is Empty");
			return;
		}
		if(head.data==(key)){
			addFront(data);
			return;
		}
		Node currNode = head;
		Node prevNode = null;
		while(currNode!=null){
		    if(currNode.data == (key)){
				newNode.next = currNode;
				prevNode.next = newNode;
				System.out.println("Inserted Successfully before Node");
				return;
			}
			prevNode = currNode;
			currNode = currNode.next;
		}
		System.out.println("Node not found");
	}

    public void insertAfterNode(int key,int data){ //InsertAfterNode
	    Node newNode = new Node(data);
		if(head==null){
			System.out.println("List is Empty");
			return;
		}
		Node currNode = head;
		while(currNode!=null){
		    if(currNode.data == (key)){
				newNode.next = currNode.next;
				currNode.next = newNode;
				System.out.println("Inserted Successfully after Node");
				return;
			}
			currNode = currNode.next;
		}
        System.out.println("Node not found");
	}

    public void removeNode(int key){ //removing node
		if(head==null){
			System.out.println("LinkedList is empty.");
			return;
		}
        if (head.data == key){
            removeFront();
            return;
        }
		Node currNode = head;
		while(currNode.next!=null){
			if(currNode.next.data == key){
				currNode.next = currNode.next.next;
				System.out.println("Node with data " + key + " is removed.");
				printAll();
				return;	
			}
			currNode = currNode.next;
		}
		System.out.println("Node not found.");
	}

    public void updateNode(int key,int data){ // updating any value in Node
		if(head==null){
			System.out.println("LinkedList is empty. ");
			return;
		}
		if (key == data){
			System.out.println("Node data is already exists. ");
			return;
		}
		Node currNode = head;
		while(currNode!=null){
			if(currNode.data == (key)){
				currNode.data = data;
				System.out.println("Node is updated. ");
				return;
			}
			currNode = currNode.next;
		}
		System.out.println("Node is not found.");
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


    public static void main(String[] args) {

		LinkedListWithoutTail list = new LinkedListWithoutTail();
		list.addFront(1);
		list.addFront(2);
		list.addFront(3);
		list.printAll();
		list.updateNode(1,5);
		list.printAll();
        
    }
    
}
