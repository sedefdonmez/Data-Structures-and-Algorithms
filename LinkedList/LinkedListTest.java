public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addfront(2);
        list.addfront(8);
        list.addfront(45);
        list.addfront(12);
        list.addfront(3);
        list.addfront(9);
        list.display();
        System.out.println("----------------");
        list.delete(2);
        list.display();
        System.out.println("-----------");
        list.deleteEnd();
        System.out.println(" delete end");
        list.display();

        System.out.println("  ");

        list.addEnd(6);
        list.addEnd(15);
        list.display();
        System.out.println(" ");
        list.addIndex(5, 5);
        list.display();

    }

}
