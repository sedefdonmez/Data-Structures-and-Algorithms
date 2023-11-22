public class GenericStackTest <T extends Comparable> {
    public static void main(String[] args) {
        genericStack<Integer> myStack = new genericStack<Integer>(Integer.class, 5);
        GenericStackTest<Integer> stkop = new GenericStackTest<Integer>();
        myStack.push(6);
        myStack.push(3);
        myStack.push(1);
        myStack.push(10);
        myStack.pop();
        System.out.println("---------------------");
        myStack.display();
        stkop.method(myStack,0);
        System.out.println("-----------------------");
        myStack.display();
        stkop.method(myStack,2);
        System.out.println("----------------------");
        myStack.display();
        stkop.method(myStack,9);
        System.out.println("---------------------");
        myStack.display();


    }
    public void method(genericStack<T> stk , T val) {
        if(!stk.isFull()) {
            while (!stk.isEmpty()) {
                T temp = stk.pop();
                if (temp.compareTo(val) == 1) {
                    stk.push(temp);
                    stk.push(val);
                    break;
                } else
                    continue;
            }
            if(stk.isEmpty())
                stk.push(val);

        }
    }
}
