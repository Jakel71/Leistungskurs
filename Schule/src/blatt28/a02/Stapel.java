package blatt28.a02;

import java.util.ArrayList;

/**
 * Erzeugt einen Stack
 * @param <T> typ des Stacks
 * @version 1.0
 */
public class Stapel <T> {
    private ArrayList<T> liste = new ArrayList<T>();

    /**
     * Konstruktor
     */
    public Stapel() {
    }

    /**
     * Überprüft, ob der Stack leer ist
     * @return boolean
     */
    public boolean emtpy() {
        return liste.size()==0;
    }

    /**
     * Gibt das oberste Element zurück, ohne es zu löschen
     * @return typ des Stacks (Element)
     */
    public T peek() {
        return liste.getLast();
    }

    /**
     * Übergibt und löscht das oberste Element aus dem Stack
     * @return typ des Stacks (Element)
     */
    public T pop() {
        return liste.removeLast();
    }

    /**
     * Fügt das Element oben auf den Stack hinzu
     * @param element des typs vom Stack
     */
    public void push(T element) {
        liste.add(element);
    }

    /**
     * dupliziert das oberste Element auf den Stack nochmal obendrauf
     */
    public void duplicate() {
        T temp = this.pop();
        this.push(temp);
        this.push(temp);
    }

    @Override
    public String toString() {
        return "Stapel{" +
                "liste=" + liste.toString() +
                '}';
    }
}
