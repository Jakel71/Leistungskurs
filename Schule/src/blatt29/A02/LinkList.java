package blatt29.A02;

public class LinkList<T> {
    Node<T> head;

    public LinkList(Node<T> head) {
        this.head = head;
    }

    public int size() {
        int size = 0;
        Node<T> current = head;
        while (current != null) {
            size++;
            current = current.next();
        }
        return size;
    }



    @Override
    public String toString() {
        return "LinkList{" +
                "head=" + head +
                '}';
    }
}
