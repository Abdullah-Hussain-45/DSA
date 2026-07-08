public class PriorityQueue{
    private int[] arr;
    private int size;
    PriorityQueue(int capacity){
        arr = new int[capacity];
        size = 0;
    }
    public int getSize(){
        if(size == 0){
            throw new RuntimeException("QueueEmpty Exception.");
        }
        return size;
    }// end getSize() method

    public void insert(int value){
        int i = size - 1;
        while(i >= 0 && arr[i] > value ){
            arr[i+1] = arr[i];
            i--;
        }
        arr[i+1] = value;
        size++;

    }// end insert() method

    public int getMax(){
        if(size == 0){
            throw new RuntimeException("QueueEmpty Exception.");
        }
        return arr[--size];
    }

    public static void main(String[] args) {
        PriorityQueue q = new PriorityQueue(5);
        q.insert(10);
        q.insert(5);
        q.insert(2);
        System.out.println("Max ELement: "+q.getMax());
        
    }
}