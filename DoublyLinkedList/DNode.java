public class DNode <T> {
    T value;
    DNode<T> next;
    DNode<T> prev;

    public DNode(T value) {
        this.value = value;
        next = null;
        prev = null;
    }

}
