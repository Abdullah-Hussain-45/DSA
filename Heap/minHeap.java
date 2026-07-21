class minHeap{
    int[] heap;
    int size;
    int capacity;

    minHeap(int capacity){
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    void insert(int value){
        if(size == capacity){
            System.out.println("Heap is full.");
            return;
        }
        heap[size] = value;
        int current = size;
        size++;

        shiftUp(current);
    }

    void shiftUp(int index){
        int child = index;
        while(child > 0){
            int parent = (child - 1) / 2;
            if(heap[parent] > heap[child]){
                int temp = heap[parent];
                heap[parent] = heap[child];
                heap[child] = temp;
                child = parent;
            }else{
                break;
            }
        }
    }
    int getMin(){
        if(size == 0){
            System.out.println("Heap is empty.");
            return -1;
        }
        int min = heap[0];
        return min;
    }

    void print(){
        if(size == 0){
            System.out.println("Heap is empty.");
            return;
        }
        for(int i=0;i<size;i++){
            System.out.print(heap[i]+" ");
        }

    }

    public static void main(String[] args) {
        minHeap heap = new minHeap(5);

        heap.insert(5);
        heap.insert(10);
        heap.insert(3);
        heap.insert(4);
        heap.insert(2);
        System.out.println(heap.getMin());
        heap.print();
    }
}