package DSA;

import java.util.Arrays;

class Task {
    public String TaskName;
    public int priority;

    public Task(String name, int priority) {
        this.TaskName = name;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "TaskName='" + TaskName + '\'' +
                ", priority=" + priority +
                '}';
    }

}

class PriorityQueue {
    private Task[] heap;
    private int size;
    private int capacity;

    public PriorityQueue(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.heap = new Task[capacity];

    }

    public void insert(String name, int priority) {
        if (size == capacity) {
            System.out.println("Heap is full");
        }
        Task task = new Task(name, priority);
        heap[size] = task;
        size++;

        bubbleupHeap(size - 1);

    }

    private void bubbleupHeap(int index) {
        int parentindex = (index - 1) / 2;
        while (index > 0 && heap[parentindex].priority > heap[index].priority) {
            swap(index, parentindex);
            index = parentindex;
            parentindex = (index - 1) / 2;
        }
    }

    public void swap(int index, int parentindex) {
        Task temp = heap[index];
        heap[index] = heap[parentindex];
        heap[parentindex] = temp;
    }

    

    public void print() {
        System.out.println(Arrays.toString(Arrays.copyOf(heap, size)));

    }

    public Task execute() {
        if (size == 0) {
            System.out.println("String is empty");
            return null;
        }
        Task highestPriority = heap[0];
        heap[0] = heap[size - 1];
        size--;
        bubbledown(0);
        return highestPriority;

    }

    public void bubbledown(int index) {
        while (index < size) {
            int leftchild = (index * 2) + 1;
            int rightchild = (index * 2) + 2;
            int minimum = index;
            if (leftchild < size && heap[leftchild].priority < heap[minimum].priority) {
                minimum = leftchild;
            }
            if (rightchild < size && heap[rightchild].priority < heap[minimum].priority) {
                minimum = rightchild;
            }
            if (minimum == index) {
                break;
            }
            swap(index, minimum);
            index = minimum;
        }
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(10);
        pq.insert("Printer", 10);
        pq.insert("api", 1);
        pq.insert("Response", 4);
        pq.insert("Db query", 7);
        pq.insert("Scheduler", 2);

        System.out.println("Priority Queue after adding tasks:");
        pq.print();

        System.out.println("Executing Task");
        while (true) {
            Task executedTask = pq.execute();
            if (executedTask == null) {
                break;
            }
            System.out.println("Executed: " + executedTask);
            System.out.print("Priority Queue: ");
            pq.print();
        }

    }

}
