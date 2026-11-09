package blatt41.A01;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class client {
    public static void antwort(BufferedReader in) {
        String antwort = null;
        try {
            antwort = in.readLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Server: " + antwort);

    }

    public static void schreiben(PrintWriter out) {
        Scanner in = new Scanner(System.in);
        String text = null;
        System.out.print("Client: ");
        text = in.nextLine();
        try {
            out.println(text);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void schreiben(PrintWriter out, String text) {
        try {
            out.println(text);
            System.out.println("Client: " + text);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
            try {
                Socket socket = new Socket("518-16", 6967);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));


                schreiben(out,"Hallo");
                antwort(in);
                antwort(in);

                schreiben(out,"JAN");
                antwort(in);

                schreiben(out,"19");
                antwort(in);
                antwort(in);

                schreiben(out,"HOWDY!");
                antwort(in);

                schreiben(out,"GERNE");
                socket.close();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    }
}
