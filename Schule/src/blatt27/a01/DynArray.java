package blatt27.a01;

import java.util.Arrays;

/**
 * Dynamisches Array
 * @version 1.0
 */
public class DynArray {
    private int[] arr;

    /**
     * Konstruktor
     */
    public DynArray() {
        this.arr = new int[0];
    }

    /**
     * if arr.length==0
     * @return int
     */
    public boolean isEmpty() {
        return arr.length == 0;
    }

    /**
     * Größe des Arrays
     * @return int
     */
    public int size() {
        return arr.length;
    }

    /**
     * gibt Element an Stelle A zurück
     * @param index Stelle A
     * @return int
     */
    public int get(int index) {
        if(index >= 0 && index < arr.length) {
            return arr[index];
        }else {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + arr.length);
        }
    }

    /**
     * Ueberprueft, ob ein Wert A in Array ist
     * @param value Wert A
     * @return int
     */
    public boolean contains(int value) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gibt die Stelle eines Wertes A in einem Array zurück; -1, wenn nicht vorhanden
     * @param value Wert A
     * @return int, des ersten Auftretens
     */
    public int indexOf(int value) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Fügt ein Element A ans Ende der Liste hinzu
     * @param value Element A
     */
    public void add(int value) {
        int[] arr2 = new int[this.arr.length + 1];
        for (int i = 0; i < this.arr.length; i++) {
            arr2[i] = this.arr[i];
        }
        arr2[this.arr.length] = value;
        this.arr = arr2;
    }

    /**
     * Fügt ein Element A an der Stelle B im Array hinzu
     * @param index Element A
     * @param value Stelle B
     */
    public void add(int index, int value) {
        if(index < 0 || index >= this.arr.length) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + this.arr.length);
        }
        int[] arr2 = new int[this.arr.length + 1];
        int j =0;
        for (int i = 0; i < this.arr.length; i++) {
            if(i == index) {
                arr2[j] = value;
                j++;
            }
            arr2[j] = this.arr[i];
            j++;
        }
        this.arr = arr2;
    }

    /**
     * Ueberschreibt den Wert an Stelle B mit dem Wert A
     * @param index Stelle B
     * @param value Wert A
     */
    public void set(int index, int value) {
        if(index < 0 || index >= this.arr.length) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + this.arr.length);
        }
        this.arr[index] = value;
    }

    /**
     * Entfernt ein Element aus der Liste an Stelle A und gibt den Wert des Elementes B zurück
     * @param index Stelle A
     * @return Wert des Elements B
     */
    public int remove(int index) {
        if(index < 0 || index >= this.arr.length) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + this.arr.length);
        }
        int[] arr2 = new int[this.arr.length - 1];
        int j =0;
        int value = -10000;
        for (int i = 0; i < this.arr.length-1; i++) {
            if(i == index) {
                value = this.arr[i];
                j++;
            }
            arr2[i] = this.arr[j];
            j++;
        }
        this.arr = arr2;
        return value;
    }

    /**
     * Mobbt die Liste Weg, sodass sie leer wird.
     */
    public void clear() {
        this.arr = new int[0];
    }

    /**
     * Ausgabefunktion für die Liste
     * @return String für Ausgabe
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < this.arr.length-1; i++) {
            sb.append(this.arr[i]).append(" | ");
        }
        if (this.arr.length > 0) {
            sb.append(this.arr[this.arr.length - 1]);
        }
        sb.append(" ]");
        return sb.toString();
    }

    /*
    Getter und Setter unnötig, da wir mit anderen Funktionen diese ersetzt haben, welche sinnvoller sind, da sie die Dynamik einbauen.
     */
}
