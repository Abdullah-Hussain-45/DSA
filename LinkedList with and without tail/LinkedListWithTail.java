import java.net.SocketPermission;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class LinkedListWithTail{
    Node head,tail;

    public void addToFront(int data){ // adding to front - 0(1)
        Node newNode = new Node(data);
        if(head == null && tail == null){
            head=tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addToBack(int data){// adding to back - 0(1)
        Node newNode = new Node(data);
        if(head == null && tail == null){
            head =tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void deleteFront(){ // removing front element(head)- 0(1)
        if(head==null && tail == null){
            System.out.println("List is empty.");
            return;
        }
        head = head.next;
    }

    public void deleteBack(){ // deleting from back - 0(n)
        if(tail == null && head == null){ // case 1
            System.out.println("List is empty.");
            return;
        }
         if(head==tail){ // case 2
            head = tail = null;
            return;
         }
         Node currNode = head;
         while (currNode.next.next!=null){
                currNode = currNode.next;
         }
         currNode.next = null;
         tail = currNode;
    }
	
	public void searchNode(int key){
		if(tail == null && head == null){ // case 1
            System.out.println("List is empty.");
            return;
        }
		if(head.data == key){
			System.out.println("Node found: "+head.data);
			return;
		}
		if(tail.data == key){
			System.out.println("Node found: "+tail.data);
			return;
		}
		Node currNode = head;
		while(currNode!=null){
			if(currNode.data==key){
                System.out.println("Node found: "+currNode.data);
                return;
			}
            currNode = currNode.next;
        }
		System.out.println("Node not found.");
	}
	
	public void deleteNode(int key){
		if(tail == null && head == null){ // case 1
            System.out.println("List is empty.");
            return;
        }
		if(head.data==key){
			deleteFront();
			return;
		}
		if(tail.data == key){
			deleteBack();
			return;
		}
		Node currNode = head;
		while(currNode!=null){
			if(currNode.next.data == key){
				currNode.next = currNode.next.next;
				return;
			}
			currNode = currNode.next;
		}
		System.out.println("Node not found");
	}
	
	public void addBefore(int targetData,int newData){ // adding before targetData
		Node newNode = new Node(newData);
		if(tail == null && head == null){
			head = tail = newNode;
			return;
		}
		if(head.data == targetData){
			addToFront(newData);
			return;
		}
		Node currNode = head;
		Node prevNode = null;
		while(currNode!=null){
			if(currNode.data == targetData){
				newNode.next = currNode;
				prevNode.next = newNode;
				return;
			}
			prevNode = currNode;
			currNode = currNode.next;
		}
		System.out.println("Not Found.");
	}
	
	public void addAfter(int targetData,int newData){ // adding after targetData
		Node newNode = new Node(newData);
		if(tail == null && head == null){
			head = tail = newNode;
			return;
		}
		if(tail.data == targetData){
			addToBack(newData);
			return;
		}
		Node currNode = head;
		while(currNode!=null){
			if(currNode.data == targetData){
				newNode.next = currNode.next;
				currNode.next = newNode;
				return;
		}
		currNode = currNode.next;
		}	
	}
	
    public void display(){// traversing and displaying the nodes
        if(head == null && tail == null){
            System.out.println("List is empty.");
            return;
        }
        Node currNode = head;
        while (currNode!=null){
            System.out.print(currNode.data+" -> ");
            currNode = currNode.next;
        }
        System.out.println(" Null");
    }
	
	public void updateNode(int oldData,int newData){ // updating Node
		if(head == null && tail == null){
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
		Node currNode = head;
		while(currNode!=null){
			if(currNode.data == oldData){
				currNode.data = newData;
				return;
			}
			currNode = currNode.next;
		}
		System.out.println("Not found");
	}
	

    public static void main(String[] args){
        LinkedListWithTail list = new LinkedListWithTail();
        list.addToFront(1);
		list.addToBack(2);
		list.addToBack(10);
		list.addToFront(5);
		list.addToFront(9);
		list.addToFront(3);
		list.display();
    } 
}