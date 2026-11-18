package blatt41.A02;

public class mainClient {
    public static void main(String[] args) {
        try {
            int port = 6767;
            FirstClient client = new FirstClient(port, "localhost");
            client.connect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
