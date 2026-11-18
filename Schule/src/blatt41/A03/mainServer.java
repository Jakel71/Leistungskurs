package blatt41.A03;

public class mainServer {
    public static void main(String[] args) {
        while(true){
            try {
                int port = 6767;
                RegisterServer server = new RegisterServer(port);
                server.start();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("\n\n---------- NEW SESSION -----------");
        }
    }
}
