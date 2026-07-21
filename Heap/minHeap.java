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

    int leftChild(int index){
        return (index * 2) + 1;
    }

    int rightChild(int index){
        return (index * 2) + 2;
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

    int extractMin(){
        if(size == 0){
            System.out.println("Heap is empty.");
            return -1;
        }
        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        shiftDown(0);
        return min;
    }

    void shiftDown(int index){
        while(leftChild(index) < size){
            int smallerChild = leftChild(index);
            if(rightChild(index) < size && heap[rightChild(index)] < heap[smallerChild]){
                smallerChild = rightChild(index);
            }

            if(heap[index] < heap[smallerChild]){
                break;
            }
            int temp = heap[index];
            heap[index] = heap[smallerChild];
            heap[smallerChild] = temp;
            index = smallerChild;
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

    public static void main(String[] args) {
        minHeap heap = new minHeap(6);

        heap.insert(5);
        heap.insert(10);
        heap.insert(3);
        heap.insert(4);
        heap.insert(2);
        heap.insert(0);
        heap.print();
        System.out.println(heap.extractMin());
        heap.print();
    }
}