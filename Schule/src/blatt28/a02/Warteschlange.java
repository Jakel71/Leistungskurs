package blatt28.a02;

import java.util.ArrayList;

/**
 * erzeugt eine Queue
 * @param <T> Datentyp der Queue
 * @version 1.0
 */
public class Warteschlange <T> {
    private ArrayList<T> liste = new ArrayList<T>();

    /**
     * Konstruktor
     */
    public Warteschlange() {}

    /**
     * Fügt ein Element am Ende hinzu
     * @param t das Element
     * @return true/false, ob es funktioniert hat
     */
    public boolean add(T t) {
        return this.liste.add(t);
    }

    /**
     * Gibt das erste Element (a) der Queue zurück, ohne es zu löschen
     * @return Element a
     */
    public T peek() {
        return this.liste.getFirst();
    }

    /**
     * Gibt das erste Element (a) der Queue zurück und löscht es
     * @return Element a
     */
    public T poll() {
        return this.liste.removeFirst();
    }

    /**
     * Überprüft, ob die Warteschlange leer ist
     * @return true/false
     */
    public boolean empty() {
        return this.liste.isEmpty();
    }

    /**
     * dupliziert das letzte Element aus dem Queue
     */
    public void duplicate() {
        T temp = null;
        for (int i = 0; i < this.liste.size(); i++) {
            temp = this.poll();
            this.add(temp);
        }
        this.add(temp);
    }

    @Override
    public String toString() {
        return "Warteschlange{" +
                "liste=" + liste.toString() +
                '}';
    }
}
