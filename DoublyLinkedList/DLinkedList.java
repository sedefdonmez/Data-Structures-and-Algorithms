public class DLinkedList<T extends Comparable> {
    DNode<T> head;
    public DNode<T> createDNode( T value) {
        return new DNode<T>(value);
    }
    public boolean isEmpty() {
        return head == null;
    }

    public void addFront(T value) {
        DNode<T> newnum = createDNode(value);
        if(isEmpty()) { // boş listeye ekledik
            head = newnum;
        } else {
            newnum.next = head;
            head.prev = newnum;
            head = newnum;
        }
    }
     public void addToEnd(T value) {
        DNode<T> newnum = createDNode(value);
        if (isEmpty()) {
            head = newnum;
         } else {
             DNode<T> temp = head;
             while(temp.next != null) {
                 temp = temp.next;
             }
             newnum.prev = temp;
             newnum.prev.next = newnum;
         }
     }
     public void delete(T value) {
        DNode<T> temp = createDNode(value);
        while (temp != null && temp.value != value) {
            temp = temp.next;
        }
        if(temp != null) {
            temp.prev.next = temp.next;
            if(temp.next != null) {
                temp.next.prev = temp.prev;
            }

        }
     }
}
