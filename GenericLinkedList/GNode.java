public class GNode <T> {
    public T value;
    public GNode<T> next;

    public GNode(T value) {
        this.value = value;
        this.next = null;

    }
    public String toString() {
        return String.valueOf(value);
    }
}

