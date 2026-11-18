package blatt41.A02;

public class mainServer {
    public static void main(String[] args) {
        while(true){
            try {
                int port = 6767;
                FirstServer server = new FirstServer(port);
                server.start();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("\n\n---------- NEW SESSION -----------");
        }
    }
}
