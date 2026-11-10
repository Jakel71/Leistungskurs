package blatt41.A01;

public class main {
    public static void main(String[] args) {
        try {
            String host = "10.8.205.28";
            int port = 753;
            Client client = new Client(host,port);

            client.LMSG("Hallo");
            client.antwort();
            client.antwort();

            client.LMSG("JAN");
            client.antwort();

            client.LMSG("19");
            client.antwort();
            client.antwort();

            client.LMSG("HOWDY!");
            client.antwort();

            client.LMSG("GERNE");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
