package blatt20.A4_unterricht;

public class MAIN {
    public static void main(String[] args) {
        Smartphone s1 = new Smartphone("Dino","Dorne17", 100, 0.000001, 1, 16, 100,100,"doernchenOS",true,1048576);
        Smartphone s2 = new Smartphone("Dino","Dorne17", 100, 0.000001, 1, 16, 100,100,"doernchenOS",true,1048576);
        System.out.println(s1.equals(s2));
    }
}
