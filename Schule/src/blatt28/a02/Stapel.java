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

    /**
     * Tauscht die zwei obersten Elemente
     */
    public void swap() {
        T tempUpper = this.pop();
        T tempLower = this.pop();
        this.push(tempUpper);
        this.push(tempLower);
    }

    /**
     * Rotiert die obersten n Elemente nach links im Kreis
     * @param anzahlElemente n Elemente
     */
    public void rotateLeft(int anzahlElemente){
        Stapel<T> stapel2 = new Stapel<T>();
        for(int i=0; i<anzahlElemente-1; i++){
            stapel2.push(this.pop());
        }
        T temp = this.pop();
        for(int i=0; i<anzahlElemente-1; i++){
            this.push(stapel2.pop());
        }
        this.push(temp);
    }

    /**
     * Rotiert die obersten n Elemente nach rechts im Kreis
     * @param anzahlElemente n Elemente
     */
    public void rotateRight(int anzahlElemente){
        T temp = this.pop();
        Stapel<T> stapel2 = new Stapel<T>();
        for(int i=0; i<anzahlElemente-1; i++){
            stapel2.push(this.pop());
        }
        this.push(temp);
        for(int i=0; i<anzahlElemente-1; i++){
            this.push(stapel2.pop());
        }
    }

    @Override
    public String toString() {
        return "Stapel{" +
                "liste=" + liste.toString() +
                '}';
    }
}
