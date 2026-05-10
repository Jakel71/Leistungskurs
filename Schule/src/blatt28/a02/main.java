package blatt28.a02;

public class main {

    public static void main(String[] args) {
        Stapel<Integer> stapel = new Stapel<Integer>();
        stapel.push(1);
        stapel.push(2);
        stapel.push(3);
        System.out.println(stapel);
        stapel.pop();
        System.out.println(stapel);

        Stapel<String> stapel2 = new Stapel<String>();
        stapel2.push("Hallo ");
        stapel2.push("Welt ");
        stapel2.push("Dinooo!");
        stapel2.push("Gudeee");
        stapel2.push("moin");
        System.out.println(stapel2);
        stapel2.pop();
        System.out.println(stapel2);

        Warteschlange<Integer> warteschlange = new Warteschlange<Integer>();
        warteschlange.add(1);
        warteschlange.add(2);
        warteschlange.add(3);
        System.out.println(warteschlange);
        warteschlange.poll();
        System.out.println(warteschlange);

        Warteschlange<String> warteschlange2 = new Warteschlange<String>();
        warteschlange2.add("Hallo");
        warteschlange2.add("Welt ");
        warteschlange2.add("Dinooo!");
        warteschlange2.add("Gudeee");
        warteschlange2.add("moin");
        System.out.println(warteschlange2);
        warteschlange2.poll();
        System.out.println(warteschlange2);
        warteschlange2.duplicate();
        System.out.println(warteschlange2);
    }
}
