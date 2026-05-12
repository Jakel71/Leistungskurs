package blatt29.A02;


public class Main {
    public static void main(String[] args) {
        LinkList<Integer> list = new LinkList<Integer>(null);
        System.out.println(list.isEmpty());
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list.get(0));
        list.add(6,0);
        System.out.println(list.get(0));
        System.out.println(list.contains(6));
        System.out.println(list.size());
        System.out.println(list.remove(0));
        System.out.println(list);
        System.out.println(list.size());
        list.clear();
        System.out.println(list.isEmpty());
        System.out.println(list);
    }
}
