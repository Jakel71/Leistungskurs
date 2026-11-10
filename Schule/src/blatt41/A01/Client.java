package blatt41.A01;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    zustaende Zustand = zustaende.INIT;
    Socket socket;
    BufferedReader in;
    PrintWriter out;
    Scanner scanner = new Scanner(System.in);


    Client(String host, int port) {
        try {
            socket = new Socket("10.8.205.28", 753);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String antwort() {
        String antwort = null;
        try {
            antwort = in.readLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Server: " + antwort);
        return antwort;

    }

    public void MSG() {
        String text = null;
        System.out.print("How many Messages? ");
        if(scanner.nextInt() >= 1) {
            System.out.print("Client: ");
            text = scanner.nextLine();
            try {
                out.println("1| " + text);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            MSG();
        } else {
            LMSG();
        }
    }

    public void LMSG() {
        String text = null;
        System.out.print("Client: ");
        text = scanner.nextLine();
        try {
            out.println("2| " + text);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void LMSG(String text) {
        System.out.print("Client: ");
        try {
            out.println("2| " + text);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void end(){
        out.println("3|");
        System.out.println("END OF Kommunikation!!!");
    }

    public void communication() {
        while(true) {
            System.out.print("press 3 to end the kommunikation: ");
            if(scanner.nextInt() == 3) {
                end();
            } else {
                MSG();
            }
            int key = (int) antwort().toCharArray()[0];
            if(key=='3') {
                end();
                break;
            }

        }
    }
}
