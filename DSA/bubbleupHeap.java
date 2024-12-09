package DSA;

public class bubbleupHeap {
    private int heap[];
    private int size;
    private int capacity;

    public bubbleupHeap(int capacity){
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.size = 0;
    }
    public void insert(int value){
        if(size == capacity){
            System.out.println("Heap is full");
            return;
        }
        heap[size] = value;
        size++;

        bubbleUp(size-1);
        
    }
    private void bubbleDown(int index){
        while(index< size){
            int left = 2 *index+1;
            int right = 2 * index + 2;
            int min = index;

            // Check if the left child is smaller than the current element
            if (left< size && heap[left]< heap[min])
            {
                min = left;
            }

            // Check if the right child is smaller than the smallest so far
            if (right< size && heap[right]< heap[min]){
                min = right;
            }
            // If the current element is smaller than both children, stop

            if(min == index){
                break;
            }
            swap(index, min);
             // Continue bubbling down from the smallest child

            index = min;
        }
    }
    public int removemin(){
        if(size == 0){
            System.out.println("Heap is empty");
            return -1;
        }
        int min = heap[0];
        //	•	Replacing the root with the last element (at heap[size - 1]) ensures the heap remains a complete binary tree:
        heap[0]= heap[size-1];
        size--;

        //After placing the last element at the root, we perform a bubble down operation to restore the heap property.
        bubbleDown(0);
        return min;

    }
    private void bubbleUp(int index){
        int parent = (index-1)/2; // because left child of heap is at 2i and right child of heap is at 2i+1 so parent is at (i-1)/2
        while(index>0 && heap[parent] > heap[index]){
            swap(parent, index);
            index = parent;
            parent = (index-1)/2;
        }
    }
    private void swap (int index1, int index2){
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }
    public void print(){
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
    }
    public static void main(String[] args) {
        bubbleupHeap obj = new bubbleupHeap(10);
        obj.insert(5);
        obj.insert(3);
        obj.insert(1);
        obj.insert(4);
        obj.insert(2);
        obj.insert(23);
        obj.insert(8);
        obj.insert(7);
        obj.insert(9);
        obj.insert(13);
        System.out.println("Heap after insertions:");
        obj.print();

        System.out.println("Removing the smallest element (root): " + obj.removemin());
        System.out.println("Heap after removing the smallest element:");
        obj.print();
        
    }

}
