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
        while(index > 0){
            int child = index;
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
}