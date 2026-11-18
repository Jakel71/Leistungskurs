package blatt41.A03;

public class mainClient {
    public static void main(String[] args) {
        try {
            int port = 6767;
            RegisterClient client = new RegisterClient(port, "localhost");
            client.connect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
