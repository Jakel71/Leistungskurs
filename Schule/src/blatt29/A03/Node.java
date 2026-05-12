package blatt29.A03;

/**
 * Klasse zum Speichern eines Node-Elements in der DoubleLinkList
 * @version 1.0
 */
public class Node<T> {
    final T value;
    protected Node<T> next;
    protected Node<T> prev;

    /**
     * Konstruktor
     * @param value Wert
     */
    public Node(T value) {
        this.value = value;
    }

    /**
     * Überprüft, ob ein weiteres Element existiert
     * @return true/false
     */
    public boolean hasNext(){
        return next != null;
    }

    /**
     * Gibt die nächste Node zurück
     * @return Node
     */
    public Node<T> next(){
        if(this.next != null){
            return this.next;
        }else {
            return null;
        }
    }

    /**
     * Überprüft, ob ein vorheriges Element existiert
     * @return true/false
     */
    public boolean hasPrev(){
        return prev != null;
    }

    /**
     * Gibt die vorherige Node zurück
     * @return Node
     */
    public Node<T> prev(){
        if(this.prev != null){
            return this.prev;
        }else {
            return null;
        }
    }

    /**
     * Debug Ausgaben
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.value);
        if(this.next != null){
            sb.append(" --> ");
            sb.append(this.next);
        }
        return sb.toString();
    }
}
