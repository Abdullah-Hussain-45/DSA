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

    int extractMax(){
        if(size == 0){
            System.out.println("Heap is empty.");
            return -1;
        }
        int index = 0
        heap[size] = heap[index];
        int max = heap[size];
        size--;

        shiftDown(index);

        return max;
    }

    void shiftDown(int index){
        if(size == 0){
            System.out.println("Heap is empty.");
            return;
        }
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
        maxHeap heap = new maxHeap(5);

        heap.insert(5);
        heap.insert(10);
        heap.insert(3);
        heap.insert(4);
        heap.insert(2);
        System.out.println(heap.getMax());
        heap.print();
        
    }
}