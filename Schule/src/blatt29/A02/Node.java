package blatt29.A02;

public class Node<T> {
    final T value;
    protected Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    public boolean hasNext(){
        return next != null;
    }

    public Node<T> next(){
        if(next != null){
            return next;
        }else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
