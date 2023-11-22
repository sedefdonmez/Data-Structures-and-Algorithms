import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class HLinkedList {

    HNode head;
    HNode tail;

    HLinkedList() {
        head = null;
        tail = null;

    }
// Burada linkedlistin dolu olup olmasığını kontrol ediyorum. Linkedlistin içinde leman var mı yoksa boş mu
    boolean isFull() { // içinde eleman var mı?
        return head != null;
    }
//Burada Soure.txt in içindeki elemanları test classta oluşturduğum liste eklemek için method yazdım. Amacım source file daki elemanlardan yeni bir liste oluşturmak ve diğer metodları bu liste üzerinden yapmak
    public void addEndForSource(int value) {
        HNode newval = new HNode(value);
        if (isFull()) {
            if(!search1(value)) {
                tail.next = newval;
                tail = newval;

            } else {
                System.out.println("This value already exist");
            }
        } else {
            head = newval;
            tail = newval;
        }
    }
    //Burada Search.txt in içindeki elemanları test classta oluşturduğum liste eklemek için method yazdım. Amacım source file daki elemanlardan yeni bir liste oluşturmak ve diğer metodları bu liste üzerinden yapmak
    public void addEndForSearch(int value) {
        HNode newval = new HNode(value);
        if (isFull()) {
            tail.next = newval;
            tail = newval;
        } else {
            head = newval;
            tail = newval;
        }
    }
    //testte oluşturduğum listin sonuna elaman eklemek için bunu oluşturm hem bu metod ile ekeldiğim elemanı source filey ekliyorum
    public void addEndSource(int value) {
        HNode newval = new HNode(value);
        if (isFull()) {
            if(!search1(value)) {
                tail.next = newval;
                tail = newval;
                updateFile(value);
            } else {
                System.out.println("This value already exist");
            }
        } else {
            head = newval;
            tail = newval;
            updateFile(value);
        }
    }
    //testte oluşturduğum listin sonuna elaman eklemek için bunu oluşturm hem bu metod ile ekeldiğim elemanı source filey ekliyorum
    public void addEndSearch(int value) {
        HNode newval = new HNode(value);
        if (isFull()) {
            tail.next = newval;
            tail = newval;
            updateFileSearch(value);
        } else {
            head = newval;
            tail = newval;
            updateFileSearch(value);
        }
    }void updateFileSearch(int value) {
        try {
            FileWriter writer = new FileWriter("C:\\Users\\Sedef DÖNMEZ\\workplace\\data2024\\Homework\\Search.txt", true);
            writer.write("," + value);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void updateFile(int value) {
        try {
            FileWriter writer = new FileWriter("C:\\Users\\Sedef DÖNMEZ\\workplace\\data2024\\Homework\\Source.txt", true);
            writer.write("," + value);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    boolean search1(int value) {
        HNode temp = head;
        while(temp != null){
            if(temp.value == value) {
                temp = temp.next;
                return true;
            } else {
                temp = temp.next;
            }
        }
        return false;
    }

    void display() {
        HNode temp = head;
        while(temp != null) {
            System.out.print(temp.value + ",");
            temp = temp.next;
        }
        System.out.println();
    }
    void search (int value) {
        if (isFull()) {
            HNode temp = head;
            int index = -1;
            float count = 0;
            float memoryAccess = 0;
            float totalMemoryAccess = 0;

            while(temp != null) {
                index++;
                memoryAccess++;
                if(temp.value == value) {
                    System.out.println("Value " + value + " found with " + index + " th index ");
                    count++;
                    totalMemoryAccess += memoryAccess;
                }
                temp = temp.next;
            }
            float averageMemoryAccess = (totalMemoryAccess / count);
            System.out.println("total memory is " + totalMemoryAccess);
            System.out.println("average memory is " + averageMemoryAccess);
        } else {
            System.out.println("LinkedList empty");
        }
    }

    void addFront(int value) {
        HNode newnum = new HNode(value);
        newnum.next = head;
        head = newnum;
    }
    public void deletefront () {
        if(isFull()) {
            if(head == tail) {
                //Listede tek eleman var
                head = null;
                tail = null;
            } else {
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
                HNode temp = head;
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
    public void delete(int val) {
        if(isFull()) {
            if( head == tail) {
                if (head.value == val) {//tek eleman var ve o eleman silmek istediğimiz elemansa
                    head = null;
                    tail = null;
                }
            } else {
                if (head.value == val) { // en az iki elan var silmek istediğimiz ilk elaman
                    deletefront();
                } else {
                    HNode temp = null;
                    HNode temp2 = head;
                    while(temp2 != null && temp2.value != val) {
                        temp = temp2;
                        temp2 = temp2.next;
                    }
                    if(temp2 != null) {
                        if(temp2 == tail) {
                            deleteEnd();
                        } else {
                            HNode temp3 = temp2.next;
                            temp2.next = null;
                            temp.next = temp3;
                        }
                    }
                }
            }
        }
    }
    void question3 (int value) {
        HNode temp1 = head;
        HLinkedList question3list = new HLinkedList();

        float count = 0;
        float memoryAccess = 0;
        float totalMemoryAccess = 0;

         if(isFull()) {
             while(temp1 != null) {
                 memoryAccess++;
                 if(temp1.value == value ) {
                     question3list.addFront(value);
                     delete(value);
                     temp1 = head;
                     count++;
                     totalMemoryAccess += memoryAccess;
                 } else {
                     temp1 = temp1.next;
                 }
             }
         }
         float averageMemoryAccess = (totalMemoryAccess / count);
         System.out.println("total memory is " + totalMemoryAccess);
         System.out.println("average memory is " + averageMemoryAccess);
         temp1 = head;
         while (temp1 != null) {
             question3list.addEnd(temp1.value);
             temp1 = temp1.next;
         }
         question3list.writeToFile("C:\\Users\\Sedef DÖNMEZ\\workplace\\data2024\\Homework\\Search.txt");
         question3list.display();
    }
    public void addEnd(int num) {
        HNode newnum = new HNode(num);
        HNode temp  = head;
        if(isFull()) {
            while ( temp.next != null) {
                temp = temp.next;
            }
            temp.next = newnum;

        } else {
            head = newnum;
        }
    }
    public void writeToFile(String filePath) {
        try {
            FileWriter writer = new FileWriter("C:\\Users\\Sedef DÖNMEZ\\workplace\\data2024\\Homework\\Search.txt");
            HNode temp = head;

            while (temp != null) {
                writer.write(temp.value + ",");
                temp = temp.next;
            }

            // Flush and close the writer to clear previous content and write the new content
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void compare() {

    }
}

