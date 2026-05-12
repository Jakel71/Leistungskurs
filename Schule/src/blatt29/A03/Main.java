package blatt29.A03;


public class Main {
    public static void main(String[] args) {
        DoubleLinkList<Integer> list = new DoubleLinkList<Integer>();
        System.out.println(list.isEmpty());
        list.add(1); //0
        list.add(2); //1
        list.add(3); //2
        list.add(4); //3
        list.add(5); //4
        list.add(6); //5
        System.out.println(list.get(4));
        list.add(9,4);
        System.out.println(list);
        System.out.println(list.get(4));
        System.out.println(list.size());
        System.out.println(list.remove(0));
        System.out.println(list);
        System.out.println(list.size());
        list.clear();
        System.out.println(list.isEmpty());
        System.out.println(list);
    }
}
