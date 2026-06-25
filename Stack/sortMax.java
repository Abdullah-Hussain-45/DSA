
class myStack {
    int[] arr;
    int capacity;
    int top;
    int size;

    myStack(int capacity) {
        this.capacity = capacity;
        arr = new int[this.capacity];
        top = -1;
        size = 0;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public void push(int data) { // adding element - Time Complexity - 0(1)
        if (isFull()) {
            throw new RuntimeException("Stack is Full.");
        }
        size++;
        arr[++top] = data;
    }

    public int pop() { // removing element - Time Complexity - 0(1)
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty.");
        }
        size--;
        return arr[top--];
    }

    public int peek() { // top element in the stack - Time Complexity - 0(1)
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty.");
        }
        return arr[top];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void display() { // traversing - Time Complexity - 0(1)
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i]);
            System.out.println("_");
        }
    }

}

public class sortMax {
    public static void main(String[] args) {
        myStack s1 = new myStack(5);
        myStack s2 = new myStack(5);
        try {
            s1.push(7);
            s1.push(2);
            s1.push(4);
            s1.push(8);
            s1.push(3);
            int max = s1.pop();
            while (!s1.isEmpty()) {
                int poped = s1.pop();
                if (poped > max) {
                    int temp = max;
                    max = poped;
                    s2.push(temp);
                } else {
                    s2.push(poped);
                }
            }
            while (!s2.isEmpty()) {
                s1.push(s2.pop());

            }
            System.out.println("Max element in the stack: " + max);
            s1.display();
            s2.display();
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

    }
}