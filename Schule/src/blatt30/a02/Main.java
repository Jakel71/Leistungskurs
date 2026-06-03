package blatt30.a02;

public class Main {
    public static void main(String[] args) {
        BinBaum baum = new BinBaum(new Node(8));
        baum.add(6);
        baum.add(7);
        baum.add(-10);
        baum.add(10);
        baum.add(9);
        baum.add(5);
//        System.out.println(baum.search(7).getValue());
//        System.out.println(baum.depht());
//        System.out.println(baum.remove(8).getValue());
//        System.out.println(baum.remove(6).getValue());
//        System.out.println(baum.count());
        blatt07.ArbeitMitArrays.printArray(baum.toArray());
        baum.postOrder();
    }
}
