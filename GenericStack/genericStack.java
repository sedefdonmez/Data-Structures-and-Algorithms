public class genericStack<T extends Comparable> {
    private T [] items;
    private int top;

    public genericStack(Class<T> dataType, int size){
        this.top=-1;
        items=(T[])java.lang.reflect.Array.newInstance(dataType, size);
    }
    public T pop()
    {
        if(isEmpty()){
            System.out.println("stack is empty");
            return items[0];
        }else{
            this.top--;
            return this.items[this.top+1];
        }
    }
    public boolean isEmpty()
    {
        return this.top==-1;
    }
    public boolean isFull()
    {
        return this.top==this.items.length-1;
    }
    public int size(){
        return this.items.length;
    }
    public T peek(){
        return this.items[this.top];
    }

    public void clear(){
        this.top=-1;
    }
    public void display(){
        if(!isEmpty()) {
            for(int i=top;i>=0;i--){
                System.out.println(this.items[i]);
            }
        }

    }

    public void push(T val){
        if(isFull()){
            System.out.println("stack is full");
        }else{
            this.items[++this.top]=val;
        }
    }
    /*This mrthod is in an class other than GnericStack class
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

     */
    }