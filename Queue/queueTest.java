public class queueTest {
    public static void main(String[] args) {
        queue queue = new queue(7);
        queue.enqueue(4);
        queue.enqueue(8);
        queue.enqueue(6);
        queue.enqueue(1);
        queue.enqueue(25);
        queue.display();

        System.out.println("-------------");
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.display();

    }

}
