public class CircularBuffer {
    private int[] buffer;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        buffer = new int[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public void insert(int element) {
        if (size == capacity) {
            front = (front + 1) % capacity;
        } else {
            size++;
        }
        buffer[rear] = element;
        rear = (rear + 1) % capacity;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(buffer[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularBuffer circularBuffer = new CircularBuffer(3);
        circularBuffer.insert(1);
        circularBuffer.insert(2);
        circularBuffer.insert(3);
        circularBuffer.display();
        circularBuffer.insert(4);
        circularBuffer.display();
    }
}
