class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class CircularLListWithTail {
    Node head,tail;

    public CircularLListWithTail() {
        this.head = null;
        this.tail = null;
    }

    public void addFront(int data) { // adding to front 0(1)
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            tail.next = head;
            return;
        }
        newNode.next = head;
        tail.next = newNode;
        head = newNode;
    }

    public void addBack(int data){ // adding to back - 0(1)
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            tail.next = head;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        tail.next = head;
    }

    public void deleteFront(){ //removing from front - 0(1)
        if(head == null){
            System.out.println("List is empty.");
            return;
        }
        if(head == tail){
            head = tail = null;
            return;
        }
        head = head.next;
        tail.next = head;
    }

    public void deleteBack(){
        if(head == null){
            System.out.println("List is empty.");
            return;
        }
        if(head == tail){
            head = tail =  null;
            return;
        }
        Node curr = head;
        while(curr.next.next!=head){
            curr = curr.next;
        }
        curr.next = curr.next.next;
        tail = curr;
        tail.next = head;
        
    }

    public void deleteNode(int key){
        if(head == null){
            System.out.println("List is empty.");
            return;
        }
        if(head.data ==key){
            deleteFront();
            return;
        }
        Node curr = head;
        while(curr.next.next!=head){
            if(curr.next.data == key){
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
        if(curr.next.data == key && curr.next == tail){
            curr.next = curr.next.next;
            tail = curr;
            tail.next = head;
            return;
        }
        System.out.println("Node not found.");
        
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
        Node newNode = new Node(data);
        if(head == null){
            System.out.println("List is empty.");
            return;
        }
        if(head.data == key){
            if(tail == head ){
                head.next = newNode;
                newNode.next = head;
                tail = newNode;
                return;
            }
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
        if(curr == tail && curr.data == key){
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
            return;
        }
        System.out.println("Node not found.");


    }

    public void updateNode(int oldData,int newData){ // updating Node - 0(n)
        if(head == null){
            System.out.println("List is empty.");
            return;
        }
        if(head.data == oldData && tail.data == oldData){
            head.data = newData;
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
        if(head.data == key && tail.data == key){
            System.out.println("Node found: "+head.data);
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
        if(curr.data == key){
            System.out.println("Node found: "+curr.data);
            return;
        }
        System.out.println("Node not found.");
    }

    public void getHead(){
        System.out.println("Head Node:"+head.data);
        return;
    }

    public void getTail(){
        System.out.println("Tail found: "+tail.data);
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
        CircularLListWithTail circular = new CircularLListWithTail();
        circular.addFront(10);
        circular.addBack(20);
		circular.addBack(30);
        circular.display();
        circular.updateNode(10,15);
        circular.display();
        circular.getTail();
        circular.getHead();
    }

}
