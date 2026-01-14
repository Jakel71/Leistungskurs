package blatt14;



public class Simulationen {


    /**
     * Füllt ein 2D-char Array mit einem Zeichen
     * @param arr 2D Char array
     * @param zeichen Einzusetzendes Zeichen
     * @param wahrsch Wahrscheinlichkeit des Einsetzens
     * @return gefülltes Array
     */
    public static char[][] fuellen(char[][] arr,char zeichen, double wahrsch){
        for(int j=0;j<arr.length;j++){
            for(int k=0;k<arr[j].length;k++){
                if(Math.random()<=wahrsch){
                    arr[j][k] = zeichen;
                }
            }
        }
        return arr;
    }

    /**
     * Füllt ein 2D-char Array mit einem Zeichen
     * @param arr 2D Char array
     * @param norm Zeichen, welches überschrieben werden soll
     * @param zeichen Einzusetzendes Zeichen
     * @param wahrsch Wahrscheinlichkeit des Einsetzens
     * @return gefülltes Array
     */
    public static char[][] fuellen(char[][] arr,char norm,char zeichen, double wahrsch){
        for(int j=0;j<arr.length;j++){
            for(int k=0;k<arr[j].length;k++){
                if(Math.random()<=wahrsch){
                    if (arr[j][k] == norm) {
                        arr[j][k] = zeichen;
                    }
                }
            }
        }
        return arr;
    }

    public static char[][] platzieren(char[][] arr, char zeichen, boolean dopplung){
        while(true) {
            int posX = (int) (Math.random() * arr.length);
            int posY = (int) (Math.random() * arr[0].length);
            if(arr[posX][posY] != zeichen) {
                arr[posX][posY] = zeichen;
                break;
            }
        }
        return arr;
    }

    /**
     * Returned das Feld Nördlich
     * @param arr 2D-Char Array
     * @param position Position(x|y) in [x,y]
     * @return
     */
    public static char getNorden(char[][] arr, int[] position){
        if (position[1] == 0) {
            position[1] = arr[0].length;
        } else{
            position[1]--;
        }
        return arr[position[0]][position[1]];
    }

    public static void main(String args[]){

    }
}
