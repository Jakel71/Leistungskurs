package blatt18;


public class Ackermann {

    public static int  ackermann(int x,int y){
        if(x==0){
            return y+1;
        } if(y==0){
            return ackermann(x-1,1);
        }
        return ackermann(x-1,ackermann(x,y-1));
    }
    public static void main(String args[]){
        long start = System.currentTimeMillis();
        System.out.println(ackermann(4,1));
        long end = System.currentTimeMillis();
        long dur = end - start;
        System.out.println(dur + " Millisekunde(n)");
        System.out.println(dur/1000 + " Sekunde(n)");
    }
}
