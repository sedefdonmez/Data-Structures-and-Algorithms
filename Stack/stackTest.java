import javax.sound.midi.Soundbank;

public class stackTest   {
    public static void main(String[] args) {
        Stack stack = new Stack(15);
        Stack stack2 = new Stack(4);

        System.out.println("-------------merge-----------");
        stackTest tester3 = new stackTest();
        tester3.merge(stack,stack2);

        System.out.println("------------------");
        stack.push(15);
        System.out.println("----------------display-----------");
        stack.display();
        stack.push(5);
        stack.push(20);
        System.out.println("----------------display-----------");
        stack.display();
        stack.push(1);
        stack.push(4);
        stack.push(7);
        System.out.println("----------------display-----------");
        stack.display();

        System.out.println("--------------find min -----------");
        System.out.println(findMin(stack));
        System.out.println("-------------find max ----------");
        stackTest tester = new stackTest();
        tester.removeitem(stack, 20);
        System.out.println(findMax(stack));



        System.out.println("----------- peek method -----------------");
        System.out.println(stack.peek());


        System.out.println("------------------pop method--------------");
        stack.pop();
        System.out.println("------------");
        stack.display();
        stack.pop();
        stack.pop();
        System.out.println("--------");
        stack.display();

        System.out.println("--------------count method--------------");
        System.out.println(stack.count());

        System.out.println("---------search method-------------");
        System.out.println(search(stack, 5));
        System.out.println("------------removeitem----------");
        stackTest tester1 = new stackTest();
        tester1.removeitem(stack, 20);
        stack.display();





    }

    // This method searches a given value in a given stack
    public static boolean search(Stack stack, int item) {
        Stack tempStack = new Stack(stack.count());
        Stack temp2Stack = new Stack(stack.count());
        while (!stack.isEmpty()) {
            int tempItem = stack.pop();
            tempStack.push(tempItem);
        }
        while (!tempStack.isEmpty()) {
            int temp2Item = tempStack.pop();
            temp2Stack.push(temp2Item);
            stack.push(temp2Item);
        }
        while (!temp2Stack.isEmpty()) {
            int findItem = temp2Stack.pop();
            if (findItem == item) {
                return true;
            }
        }
        return false;
    }


    public void removeitem(Stack stack, int item) {

        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
        }

        Stack tempStack = new Stack(stack.count());
        Stack temp2Stack = new Stack(stack.count());

        while (!stack.isEmpty()) {
            int tempItem = stack.pop();
            tempStack.push(tempItem);
        }

        while (!tempStack.isEmpty()) {
            int temp2Item = tempStack.pop();
            temp2Stack.push(temp2Item);
            if (temp2Stack.peek() != item) {
                stack.push(temp2Item);
            }
        }
    }

    public static void bubbleSort(int[] stack) {
        boolean sorted = true;
        for (int i = 0; i < stack.length - 1; i++) {
            for (int j = 0; j < stack.length - 1 - i; j++) {
                if (stack[j] > stack[j + 1]) {
                    int temp = stack[j];
                    stack[j] = stack[j + 1];
                    stack[j + 1] = temp;
                    sorted = false;
                }
            }
        }
        if (sorted) return;
        sorted = true;

    }
    public static int findMin(Stack stack) {
        Stack tempStack = new Stack(stack.count());
        int min = stack.peek();
        while(!stack.isEmpty()) {
            int tempitem = stack.pop();
            tempStack.push(tempitem);
            if(min > tempitem) {
                min = tempitem;
            }
        }
        while (!tempStack.isEmpty()) {
            int temp2item = tempStack.pop();
            stack.push(temp2item);
        }
        return min;
    }
    public static int findMax(Stack stack) {
        Stack tempStack = new Stack(stack.count());
        int min = stack.peek();
        while(!stack.isEmpty()) {
            int tempitem = stack.pop();
            tempStack.push(tempitem);
            if(min < tempitem) {
                min = tempitem;
            }
        }
        while (!tempStack.isEmpty()) {
            int temp2item = tempStack.pop();
            stack.push(temp2item);
        }
        return min;
    }

    public void merge(Stack stack, Stack stack2) {
        Stack mergeStack = new Stack(stack.count()+stack2.count());
        while(!stack.isEmpty()) {
            mergeStack.push(stack.pop());
        }
        while(!stack2.isEmpty()){
            mergeStack.push(stack2.pop());
        }
        mergeStack.display();
    }

    public Stack sortStack(Stack stack) {
        Stack tempStack = new Stack(stack.count());
        while (!stack.isEmpty()) {
            int min = stack.peek();
            stack.pop();

            while (!tempStack.isEmpty() && tempStack.peek() < min) {
                stack.push(tempStack.pop());

            }
            tempStack.push(min);
        }
        return tempStack;
    }
}




