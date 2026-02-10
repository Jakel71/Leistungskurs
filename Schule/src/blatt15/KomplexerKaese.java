package blatt15;

import blatt14.MultiArrays;
import schisch_visualizer.SchischVisualizer;

public class KomplexerKaese {
    static char[][][] kaese;
    static SchischVisualizer sv = new SchischVisualizer();

    /**
     * Überprüfung, ob 2 3D-Char-Arrays identisch sind
     * @param arr1 char[][][]
     * @param arr2 char[][][]
     * @return true/false
     */
    public static boolean istIdentisch3D (char[][][] arr1, char[][][] arr2){
        if (arr1.length != arr2.length) return false;
        if (arr1[0].length != arr2[0].length) return false;
        if (arr1[0][0].length != arr2[0][0].length) return false;
        for (int h=0; h<arr1.length; h++) {
            for (int i = 0; i < arr1[h].length; i++) {
                for (int j = 0; j < arr1[h][i].length; j++) {
                    if (arr1[h][i][j] != arr2[h][i][j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Erstellt einen Kaese, ohne es im Schisch Visualizer zu initialisieren
     * @param a breite des Kaeses
     * @param b laenge des Kaeses
     * @param c tiefe des Kaeses
     */
    public static void initialisiereKaese(int a, int b, int c){
        kaese = new char[a][b][c];
        for(int h =0;h<c;h++) {
            kaese[h] = MultiArrays.createEmpty2DCharArray(a, b);
            for (int i = 0; i < kaese[h].length; i++) {
                for (int j = 0; j < kaese[h][i].length; j++) {
                    kaese[h][i][j] = '0';
                }
            }
        }
    }

    /**
     * erzeugt zufaellig Kaese
     * @param wahrscheinlichkeit wahrscheinlichkeit der Kaesegenerierung auf einem Feld
     */
    public static void kaeseZufall(double wahrscheinlichkeit){
        if(kaese!=null) {
            for (int h = 0; h < kaese.length; h++) {
                for (int i = 0; i < kaese[h].length; i++) {
                    for (int j = 0; j < kaese[h][i].length; j++) {
                        double zufallZahl = Math.random();
                        if (zufallZahl <= wahrscheinlichkeit) {
                            kaese[h][i][j] = '5';
                        }
                    }
                }
            }
        }
    }

     /**
     * Generiert Wasser und prüft, ob ein Kaese/Objekt wasserdicht ist. 3-Dimensional
     */
    public static void wasserGen (){
        for(int h =0;h<kaese.length;h++) {
            for (int i = 0; i < kaese[h].length; i++) {
                if (kaese[h][i][0] == '0') {
                    kaese[h][i][0] = '6';
                }
            }
        };

        char [][][] altkaese = new char[kaese.length][kaese[0].length][kaese[0][0].length];
            do {
                for(int h = 0; h<kaese.length; h++) {
                    altkaese[h] = MultiArrays.copy2DCharArray(kaese[h]);
                }
                for(int h = 0; h<kaese.length; h++) {
                    for (int i = 0; i <= kaese[h].length - 1; i++) {
                        for (int j = 0; j <= kaese[h][i].length - 1; j++) {
                            if (kaese[h][i][j] == '6') {
                                if (h > 0) {
                                    if (kaese[h - 1][i][j] == '0') {
                                        kaese[h - 1][i][j] = '6';
                                    }
                                }
                                if (h < kaese[h].length - 1) {
                                    if (kaese[h + 1][i][j] == '0') {
                                        kaese[h + 1][i][j] = '6';
                                    }
                                }

                                if (i > 0) {
                                    if (kaese[h][i - 1][j] == '0') {
                                        kaese[h][i - 1][j] = '6';
                                    }
                                }
                                if (i < kaese[h][i].length - 1) {
                                    if (kaese[h][i + 1][j] == '0') {
                                        kaese[h][i + 1][j] = '6';
                                    }
                                }
                                if (j > 0) {
                                    if (kaese[h][i][j - 1] == '0') {
                                        kaese[h][i][j - 1] = '6';
                                    }
                                }
                                if (j < kaese[h][i].length - 1) {
                                    if (kaese[h][i][j + 1] == '0') {
                                        kaese[h][i][j + 1] = '6';
                                    }
                                }
                            }
                        }

                    }
                }
            } while (!istIdentisch3D(altkaese, kaese));

        for(int h =0;h<kaese.length;h++) {
            sv.step(kaese[h]);
        }

        for(int h =0;h<kaese.length;h++) {
            for (int i = 0; i < kaese[0].length; i++) {
                if (kaese[h][i][kaese[i].length - 1] == '6') {
                    System.out.println("Kaese ist nicht Wasserdicht!");
                    return;
                }
            }
        }
        System.out.println("Kaese ist Wasserdicht!");
    }

    public static void main(String[] args) {
        initialisiereKaese(40,40, 40);
        kaeseZufall(0.65);

        for(int h=0; h<kaese.length; h++) {
            sv.step(kaese[h]);
        }
        wasserGen();
        sv.start();
    }
}
