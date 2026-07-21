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
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        shiftDown(0);
        return max;
    }
    int leftChild(int index){
        return (index * 2) + 1;
    }

    int rightChild(int index){
        return (index * 2) + 2;
    }

    void shiftDown(int index){
        while(leftChild(index) < size){
            int largerChild = leftChild(index);
            if(rightChild(index) < size && heap[rightChild(index)] > heap[largerChild]){
                largerChild = rightChild(index);
            }

            if(heap[index] > heap[largerChild]){
                break;
            }
            int temp = heap[index];
            heap[index] = heap[largerChild];
            heap[largerChild] = temp;
            index = largerChild;
        }
    }
    void remove(int index){
        if(index == -1){
            System.out.println("Invalid index!");
            return;
        }
        heap[index] = heap[size - 1];
        size--;
        int parent = index - 1 / 2;
        if(index > 0 && heap[index] > heap[parent]){
            shiftUp(index);
        }else{
            shiftDown(index);
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
        heap.print();
        System.out.println("\n"+heap.extractMax());
        heap.print();
        
    }
}