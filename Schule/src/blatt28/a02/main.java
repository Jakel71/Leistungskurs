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
        System.out.println(stapel2);
        stapel2.pop();
        System.out.println(stapel2);
    }
}
