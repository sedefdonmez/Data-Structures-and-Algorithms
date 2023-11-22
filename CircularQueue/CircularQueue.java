public class CircularQueue <T> {
    int head ;
    int tail;
    T [] queue;

    public CircularQueue(Class<T> dataType , int size) {
        tail = 0;
        head = 0;
        queue = (T [])java.lang.reflect.Array.newInstance(dataType,size+1);
    }

    boolean isEmpty() {
        return  head == tail;
    }

    int size() {
        return queue.length;
    }
    boolean isFull() {
        return (tail + 1) % size() == head;
    }

    public void enQueue(T val) throws Exception {
        if(isFull()) {
            throw new Exception("Queue is full");
        } else {
            tail = (tail +1) % size();
            queue[tail] = val;
        }
    }
    public T deQueue() throws Exception {
        if(isEmpty()) {
            throw new Exception("Queue is empty");
        } else {
            head = (head +1 ) % size();
            return queue[head];
        }
    }
    public void display() {
        int temp = (head + 1 ) % size();
        while(temp != (tail +1) % size()) {
            System.out.println(queue[temp]);
            temp = (temp + 1) % size();
        }
    }


}
