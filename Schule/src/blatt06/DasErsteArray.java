package blatt06;

public class DasErsteArray {
    public static void main(String[] args) {
        int [] array = new int[990];
        for (int i = 0; i < array.length; i++) {
            array[i] = i+10;
            System.out.println("Der Wert von dem Element [" + (i+1) + "] ist: " + array[i]); // i+1, da die "nicht Informatiker" nicht wissen das man eigentlich bei 0 anfängt zu zählen, und wir das natürlich für alle machen :)
        }
        System.out.println(); // zum besseren Lesen, da nun die Vorwärts und Rückwerts-Schleife voneinander getrennt werden.
        for (int i = 0; i < array.length; i++) {
            int j = array.length - i;
            System.out.println("Der Wert von dem Element [" + j + "] ist: " + array[j-1]);
        }
        // Warum eigentlich? Wir haben NotenArrays schon in der Schule gemacht haben und dass irgendwie wie ein Rückschritt aussieht.
    }
}
