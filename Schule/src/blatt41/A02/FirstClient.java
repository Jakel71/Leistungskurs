package blatt41.A02;

import blatt41.A01.Nachricht;

import java.net.Socket;
import java.util.Scanner;

public class FirstClient {
    private int port;
    private String ip;

    public FirstClient(int port, String ip) {
        this.port = port;
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void connect() {
        try {
            Socket server = new Socket(ip, port);

            communicate(server);

            server.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void communicate(Socket server) {
        try{
            Nachricht n = new Nachricht();
            n.recieveMessage(server);
            System.out.println("Server: " + n);

            n.setMessage("Gre|Hallo");
            n.sendMessage(server);
            System.out.println("Client: " + n);

            n.recieveMessage(server);
            System.out.println("Server: " + n);

            Scanner input = new Scanner(System.in);
            System.out.print("Client: ANS | ");
            n.setMessage("ANS|" +  input.nextLine());
            n.sendMessage(server);

            n.recieveMessage(server);
            System.out.println("Server: " + n);

            n.setMessage("FIN|Danke.");
            n.sendMessage(server);
            System.out.println("Client: " + n);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
