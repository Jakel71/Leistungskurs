package blatt41.A01;

import java.net.*;
import java.io.*;

public class Nachricht {
    private String protokoll;
    private String nachricht;

    public Nachricht() {
    }

    public Nachricht(String protokoll, String nachricht) {
        this.protokoll = protokoll;
        this.nachricht = nachricht;
    }

    public String prepareMessage(){
        if(this.protokoll==null || this.nachricht==null) return null;
        return this.protokoll + "|" + this.nachricht;
    }

    static public boolean isValid(String protokollNachricht){
        if(protokollNachricht == null) return false;

        if(protokollNachricht.contains("|")){
            String[] parts = protokollNachricht.split("\\|");
            if(parts.length==2){
                return true;
            }
        }
        return false;
    }

    public String getProtokoll() {
        return this.protokoll;
    }

    public String getNachricht() {
        return this.nachricht;
    }

    public void setMessage(String protokollNachricht){
        if(!isValid(protokollNachricht)) return;
        String[] parts = protokollNachricht.split("\\|");
        this.protokoll = parts[0];
        this.nachricht = parts[1];
    }

    public void sendMessage(Socket socket){
        String message = this.prepareMessage();
        if(!isValid(message)) return;
        try{
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(message);
//            out.close();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Nachricht recieveMessage(Socket socket){
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String message = in.readLine();

//            in.close();

            if(isValid(message)) {
                String[] parts = message.split("\\|");
                this.setMessage(message);
                return new Nachricht(parts[0], parts[1]);
            } else{
                System.out.println("Invalid message.");
            }

        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String toString() {
        return "{"+ this.protokoll + " | " + this.nachricht + "}";
    }
}
