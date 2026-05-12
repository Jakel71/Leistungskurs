package blatt29.A03;

/**
 * Klasse für eine DoubleLinkList
 * @version 1.0
 */
public class DoubleLinkList<T> {
    Node<T> head;
    Node<T> tail;

    /**
     * Param-Konstruktor
     * @param head Erster Node
     * @param tail Letzter Node
     */
    public DoubleLinkList(Node<T> head, Node<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    /**
     * Default-Konstruktor
     */
    public DoubleLinkList(){
    }

    /**
     * Bestimmt die Länge der Liste
     * @return int
     */
    public int size() {
        int size = 0;
        Node<T> current = this.head;
        while (current != null) {
            size++;
            current = current.next();
        }
        return size;
    }

    /**
     * Überprüft, ob die Liste leer ist
     * @return true/false
     */
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * Gibt das Element t mit dem Index i zurück
     * @param index i
     * @return t
     */
    public T get(int index) {
        if(index<0 || index>=this.size()){
            throw new IndexOutOfBoundsException();
        }

        if(index-size()/2>=0) {
            Node<T> current = this.tail;
            for (int i = this.size()-1; i > index-1; i--) {
                current = current.prev();
            }
            return current.value;
        }else{
            Node<T> current = this.head;
            for (int i = 0; i < index-1; i++) {
                current = current.next();
            }
            return current.value;
        }
    }

    /**
     * Fügt ein Element v am Ende der Liste hinzu
     * @param value v
     */
    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if(isEmpty()){
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        Node<T> current = this.tail;
        newNode.prev = current;
        current.next = newNode;
        this.tail = newNode;
    }

    /**
     * Fügt ein Element v am index i in der Liste hinzu
     * @param value v
     * @param index i
     */
    public void add(T value, int index) {
        Node<T> newNode = new Node<>(value);
        if(index<0 || index>=this.size()){
            throw new IndexOutOfBoundsException();
        }
        if(index==0){
            newNode.next = this.head;
            this.head = newNode;
            return;
        }
        Node<T> current;
        if(index-size()/2>=0){
            current = this.tail;
            for (int i = this.size()-1; i > index-1; i--) {
                current = current.prev();
            }
        }else {
            current = this.head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next();
            }
        }
        newNode.prev = current.prev;
        newNode.next = current.next;

        current.next = newNode;
        current.prev = newNode;
    }

    /**
     * Löscht ein Element e am index i und gibt dieses zurück
     * @param index i
     * @return e
     */
    public T remove(int index) {
        if(index<0 || index>=this.size()){
            throw new IndexOutOfBoundsException();
        }
        if(index==0){
            Node<T> temp = this.head;
            this.head = temp.next;
            return temp.value;
        }
        Node<T> current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next();
        }
        Node<T> temp = current.next;
        current.next = temp.next;
        return temp.value;
    }

    /**
     * Leert die Liste, sodass sie leer ist
     */
    public void clear() {
        this.head = null;
    }

    /**
     * Debug-Ausgabe
     * @return String
     */
    @Override
    public String toString() {
        return "LinkList{ " +
                head +
                " }";
    }

    /*
    c) Bei dem Hinzufügen, bearbeiten und Löschen von Daten, sind wir effizienter, da wir von 2 Seiten aus darauf zugreifen können und deswegen den kürzeren Weg automatisch ausnuten können. O(n) zu O(n/2), obwohl sich dies zu O(n) vereinfacht, in einem direkten Vergleich gewinnt jedoch die neuere Variante
     */
}
