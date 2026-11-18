package blatt41.A03;

import blatt41.A01.Nachricht;

import java.net.ServerSocket;
import java.net.Socket;

public class RegisterServer {
    private int port;

    public RegisterServer(int port) {
        this.port = port;
    }

    public void start() {
        try {
            ServerSocket server = new ServerSocket(this.port);

            Socket client = server.accept();

            communicate(client);

            client.close();
            server.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void communicate(Socket client) {
        try {
            Nachricht n = new Nachricht("WEL", "Willkommen");

            n.sendMessage(client);
            System.out.println("Server: " + n);

            n.recieveMessage(client);
            System.out.println("Client: " + n);

            n.setMessage("QST|Wie geht es dir?");
            n.sendMessage(client);
            System.out.println("Server: " + n);

            n.recieveMessage(client);
            System.out.println("Client: " + n);

            n.setMessage("FIN|Danke.");
            n.sendMessage(client);
            System.out.println("Server: " + n);

            n.recieveMessage(client);
            System.out.println("Client: " + n);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
