public class LinkedList {
    Node head;
    Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    //dolu mu
    public boolean isFull() {
        if(head != null) {
            return true;
        } else {
            return false;
        }
    }
    //Başa eleman ekleme
    public void addfront( int num) {
        Node newnum = new Node(num);
        if(isFull()) {
            newnum.next = head;
            head = newnum;

        } else {
            head = newnum;
            tail = newnum;
        }
    }
    //Sona ekleme
    public void addEnd(int num) {
        Node newnum = new Node(num);
        if(isFull()) {
            tail.next = newnum;
            tail = newnum;

        } else {
            head = newnum;
            tail = newnum;
        }
    }

    public void display() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.number + "" );
            temp = temp.next;
        }
    }
    // istenilen indekse eleman ekleme
    public void addIndex(int num, int index) {
        Node newnum = new Node(num);
        if(isFull()) {
            if( index == 0 ) {
                newnum.next = head;
                head = newnum;
            } else {
                Node temp1 = null;
                Node temp2 = head;
                int currentindex = 0;
                while( temp2 != null && currentindex < index) {
                    temp1 = temp2;
                    temp2 = temp2.next;
                    currentindex++;
                }
                if(temp2 == null) {
                    tail.next = newnum;
                    tail = newnum;
                } else {
                    temp1.next = newnum;
                    newnum.next = temp2;
                }
            }
        } else {
            head = newnum;
            tail = newnum;
        }
    }
    public void deletefront () {
        if(isFull()) {
            if(head == tail) {
                //Listede tek eleman var
                head = null;
                tail = null;
            } else {
                /*
                Node newhead = head.next;
                head.next = null;
                head = newhead;
                 */
                head = head.next;
            }

        } else {
            System.out.println("Linkedlist already empty");
        }
    }
    public void deleteEnd () {
        if(isFull()) {
            if(head == tail ) {
                tail = null;
                head = null;
            } else {
                Node temp = head;
                while(temp.next != tail ) {
                    temp = temp.next;
                }
                temp.next = null;
                tail = temp;
            }
        } else {
            System.out.println("LinkedList is already empty");
        }
    }

    public void deleteIndex(int index) {
        if(isFull() && index >= 0) {
            if(head == tail ) { //tek eleman var
                head = null;
                tail = null;
            } else { // en az iki eleman var
                if ( index == 0) { //index 0 ise baştan siler
                    deletefront();
                } else { // en az iki eleman var sildiğimiz eleman baştan değil
                    Node temp = null;
                    Node temp2 = head;
                    int currentindex = 0;
                    while(temp2 != null && currentindex < index) {
                        temp = temp2;
                        temp2 = temp2.next;
                        currentindex++;
                    }
                    if( temp2 != null) {//sondan silme
                        if(temp2 == tail) {
                            deleteEnd();
                        } else {// aradan silme
                            Node temp3 = temp2.next;
                            temp2.next = null;
                            temp.next = temp3;
                        }
                    }
                }
            }
        }
    }

    public void delete(int num) {
        if(isFull()) {
            if( head == tail) {
                if (head.number == num) {//tek eleman var ve o eleman silmek istediğimiz elemansa
                    head = null;
                    tail = null;
                }
            } else {
                if (head.number == num) { // en az iki elan var silmek istediğimiz ilk elaman
                    deletefront();
                } else {
                    Node temp = null;
                    Node temp2 = head;
                    while(temp2 != null && temp2.number != num) {
                        temp = temp2;
                        temp2 = temp2.next;
                    }
                    if(temp2 != null) {
                        if(temp2 == tail) {
                            deleteEnd();
                        } else {
                            Node temp3 = temp2.next;
                            temp2.next = null;
                            temp.next = temp3;
                        }
                    }
                }
            }
        }
    }
}
