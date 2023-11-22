public class queue {
    int [] queue;
    int size;
    int last, first;
    int currentsize;

    queue(int size){
        this.size = size;
        queue = new int[size];
        first = 0;
        last = -1;
    }

    int size(){
        return queue.length;
    }
     int peek (){
        return queue[last];
     }

     boolean isEmpty() {
        return currentsize == 0;
     }
     boolean isFull() {
        return currentsize == size;
     }

     void enqueue(int item) {
        if(isFull()) {
            System.out.println("Queue is full");
        } else {
            last++;
            queue[last] = item;
            currentsize++;
        }
     }
     void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            first++;
            currentsize--;

        }
     }
     void display() {
        for(int i = first ; i <= last ; i++) {
            System.out.println(queue[i]);
        }
     }
}
