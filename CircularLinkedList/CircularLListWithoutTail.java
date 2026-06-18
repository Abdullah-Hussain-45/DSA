class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class CircularLListWithoutTail{
    Node head;

    public CircularLListWithoutTail() {
        this.head = null;
    }

    public void addFront(int data) { // adding to front 0(1)
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }
        Node curr = head;
        while (curr.next != head) {
            curr = curr.next;
        }
        newNode.next = head;
        curr.next = newNode;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }
        Node curr = head;
        while(curr.next!=head){
            curr = curr.next;
        }
        curr.next = newNode;
        newNode.next = head;
    }

    public void deleteFront(){ //removing from front - 0(n)
        if(head == null){
            System.out.println("List is empty.");
            return;
        }
        if(head.next == head){
            head = null;
            return;
        }
        Node curr = head;
        while(curr.next!=head){
            curr = curr.next;
        }
        head = head.next;
        curr.next = head;
    }

    public void deleteBack(){// removing from back - 0(n)
        if(head == null){
            System.out.println("List is empty.");
            return;
        }
        if(head.next == head){
            head = null;
            return;
        }
        Node curr = head;
        while(curr.next.next!=head){
            curr = curr.next;
        }
        curr.next = head;
    }

    public void deleteNode(int key){// deleting Node by 
        if(head == null){
            System.out.println("List is empty.");
            return;
        }
        if(head.data ==key){
            deleteFront();
            return;
        }
        Node curr = head;
        Node prev = null;
        while(curr.next!=head){
            if(curr.data == key){
                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        if(curr.data == key){
            deleteBack();
            return;
        }
        
    }

    public void addBefore(int key,int data){
        if(head == null){
            System.out.println("List is empty.");
            return;
        }
        if(head.data == key){
            addFront(data);
            return;
        }
        Node newNode = new Node(data);
        Node curr = head;
        while(curr.next!=head){
            if(curr.next.data == key){
                newNode.next = curr.next;
                curr.next = newNode;
                return;
            }
            curr = curr.next;
        }
        System.out.println("Node not found.");
    }

    public void addAfter(int key,int data){
        if(head == null){
            System.out.println("List is empty.");
            return;
        }
        Node newNode = new Node(data);
        if(head.data == key){
            newNode.next = head.next;
            head.next = newNode;
            return;
        }
        Node curr = head;
        while(curr.next!=head){
            if(curr.data == key){
                
                newNode.next = curr.next;
                curr.next = newNode;
                return;
            }
            curr = curr.next;
        }
        if(curr.next==head){
            curr.next = newNode;
            newNode.next = head;
            return;
        }
        System.out.println("Node not found.");
    }

    public void updateNode(int oldData,int newData){ // updating Node - 0(n)
        if(head == null){
            System.out.println("List is empty.");
            return;
        }
        Node curr = head;
        while(curr.next!=head){
            if(curr.data  == oldData){
                curr.data = newData;
                return;
            }
            curr = curr.next;
        }
        if(curr.data == oldData){
            curr.data = newData;
            return;
        }
        System.out.println(" Node not found.");
    }

    public void searchNode(int key){ // searching node - 0(n)
        if(head == null){
            System.out.println("List is empty.");
            return;
        }
        Node curr = head;
        while(curr!=null){
            if(curr.data == key){
                System.out.println("Node found: "+curr.data);
                return;
            }
            curr = curr.next;
        }
        System.out.println("Node not found.");
    }

    public void getHead(){
        System.out.println("Head Node:"+head.data);
        return;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node curr = head;
        do {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        } while (curr != head);
        System.out.println(head.data);
    }

    public static void main(String args[]) {
        CircularLListWithoutTail circular = new CircularLListWithoutTail();
        circular.addFront(10);
        circular.addFront(20);
        circular.addFront(30);
        circular.display();
        circular.addBefore(20,12);
        circular.display();
    }

}
