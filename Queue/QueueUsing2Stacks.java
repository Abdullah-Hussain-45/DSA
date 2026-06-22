/* In this Approach we will make DeQueue operation costly Time Complexity-0(n) */

import java.util.*;
public class QueueUsing2Stacks {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    

    public void enQueue(int data){//adding elements in s2 -Time Complexity(1)
        s1.push(data);
    }

    public int deQueue(){ //removing elements from s2 -Time Complexity - 0(n)
        if(s2.isEmpty() && s1.isEmpty()){
            return -1;
        }
        if(s2.isEmpty()){
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    //end method enQueue
    
    public int front(){
        if(!s2.isEmpty()){
            return s2.peek();
        }
        if(!s1.isEmpty()){
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
           return s2.peek();
        }
        return -1;
    }
    //end method deQueue

    public int size(){// return size
        return s1.size() + s2.size();
    }
    //end method size

    public static void main(String args[]){
        QueueUsing2Stacks queue = new QueueUsing2Stacks();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);

        System.out.println("Front: "+queue.front());
        System.out.println("Size: "+queue.size());
        System.out.println("Removed :"+queue.deQueue());

    }
}