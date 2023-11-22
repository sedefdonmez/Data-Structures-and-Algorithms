
public class CircularLinkedList<T extends Comparable<T>> {
    CNode<T> head;

    public void addToFront(T value){

        // handle empty
        if (head == null){
            head = new CNode<T>(value);
            head.next = head;
            return;
        }

        CNode<T> iterator = head;
        while (iterator.next != head){
            iterator = iterator.next;
        }

        CNode<T> newNode = new CNode<T>(value);
        newNode.next = head;
        iterator.next = newNode;
        head = newNode;
    }

    public void addToEnd(T value){

        // handle empty
        if (head == null){
            head = new CNode<T>(value);
            head.next = head;
            return;
        }

        CNode<T> iterator = head;
        while (iterator.next != head){
            iterator = iterator.next;
        }

        CNode<T> newNode = new CNode<T>(value);
        newNode.next = head;
        iterator.next = newNode;
    }
}