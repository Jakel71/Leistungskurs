package blatt19;

import java.util.ArrayList;

public class Tiefensuche {
    public static void tiefensuche(char[][] arr, int x, int y){

    }

    public static char[][] makiere(char[][] arr, int x, int y){
        arr[x][y] = 'X';
        return arr;
    }

    public static char[] erhalteWege(char[][]arr, int x, int y){
        StringBuilder wege = new StringBuilder();
        if(arr[x-1][y] == '1'){
            wege.append('n');
        }
        if(arr[x+1][y] == '1'){
            wege.append('s');
        }
        if(arr[x][y-1]=='1'){
            wege.append('w');
        }
        if(arr[y][y+1]=='1'){
            wege.append('o');
        }
        if(wege.length() == 0){
            return null;
        }
        return wege.toString().toCharArray();
    }

    public static boolean istSackgasse(char[][] arr, int x, int y){
        char[] wege = erhalteWege(arr, x, y);
        if(wege == null){
            return true;
        }
        return false;
    }
}
