public class GLinkedList< T extends Comparable> {
    private GNode<T> head;

    public GNode<T> createNode(T value) {
        return new GNode<T>(value);
    }

    public void insertToFront(T value) {
        GNode<T> newNode = createNode(value);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertToEnd(T value) {
        GNode<T> newNode = createNode(value);
        if (head == null) {
            head = newNode;
            return;
        } else {
            GNode<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public T findMin() {
        if (head == null) {
            return null;
        } else {
            T min = head.value;
            GNode<T> temp = head;
            while(temp.next != null) {
                if(min.compareTo(temp.value) == 1) {
                    min = temp.value;
                }
                temp = temp.next;
            }
            return min;
        }
    }
    public void deleteFirs() {
        if(head== null) {
            System.out.println("LinkedList empty");
        } else {
            head = head.next;
        }
    }
    public void delete(T value) {
        if (head == null) {
            System.out.println("LinkedList empty");
        } else {
            if (head.value.compareTo(value) == 0) {
                head = head.next;
            } else {
                GNode<T> temp = null;
                GNode<T> temp2 = head;
                while (temp2 != null && temp2.value.compareTo(value) != 0) {
                    temp = temp2;
                    temp2 = temp2.next;
                }
                if(temp2 != null) {
                    temp.next = temp2.next;
                }
            }
        }
    }

    public void display() {
        GNode<T> temp = head;
        while(temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
    public void recursiveaddToEnd(T value) {
        head = recursiveaddToEnd(head, value);
    }
    public GNode<T> recursiveaddToEnd(GNode<T> tempHead , T value) {
        if(tempHead == null) {
            return createNode(value);
        } else {
            tempHead.next = recursiveaddToEnd(tempHead.next, value);
        }
        return  tempHead;
    }

    public void sortedInsert(T value) {
        GNode<T> newnum = createNode(value);
        if(head == null) {
            head = newnum;
        } else if (value.compareTo(head.value) <= 0) {
            newnum.next = head;
            head = newnum;
        } else {
            GNode<T> temp = head;
            while( temp. next != null && temp.next.value.compareTo(value) == 1) {
                temp = temp.next;
            }
            newnum.next = temp.next;
            temp.next = newnum;
        }
    }
}


