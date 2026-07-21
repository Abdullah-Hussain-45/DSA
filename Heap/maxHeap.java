class maxHeap{
    int[] heap;
    int capacity;
    int size;

    maxHeap(int capacity){
        this.capacity = capacity;
        heap = new int[this.capacity];
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
        int current = index;
        while(current > 0){
            int parent = (current - 1) / 2;
            if(heap[current] > heap[parent]){
                int temp  = heap[current];
                heap[current] = heap[parent];
                heap[parent] = temp;
                current = parent;
            }else{
                break;
            }
        }
    }
    int getMax(){
        if(size == 0){
            System.out.println("Heap is empty.");
            return -1;
        }
        int max = heap[0];

        return max;
    }

    void extractMax(){
        if(size == 0){
            System.out.println("Heap is empty.");
            return;
        }
        int index = 0
        heap[size] = heap[index];
        int min = heap[size];
        size--;

        shiftDown(index);
    }

    void shiftDown(){
        
    }


    public static void main(String[] args) {
        
    }
}