
public class Stack  {
    private int stackOftop;
    private int size;
    private int [] stack;

    Stack(int size) {
        this.size = size;
        stack = new int[size];
        stackOftop = -1;
    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("This stack is empty");
        }
        return stack[stackOftop];
    }
    public int count(){
        return stackOftop+1;
    }
    public boolean isEmpty() {
        if(stackOftop < 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean isFull() {
        if(stackOftop == stack.length -1) {
            return true;
        }else {
            return false;
        }
    }
    public void push(int item) {
        if(isFull()) {
            System.out.println("Stack is full");
        } else {
            stackOftop++;
            stack[stackOftop] = item;
        }
    }
    public int pop() {
        if(isEmpty()) {
            System.out.println("Stack is empty");
            return 0;
        } else {
            int temp = stack[stackOftop];
            stackOftop--;
            return temp;
        }
    }
    public void display() {
        if(isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            for(int i = stackOftop ; i >= 0 ; i --) {
                System.out.println(stack[i]);
            }
        }
    }
}
