package blatt20.A1;

/**
 * Repräsentiert einfache Kaffemaschine
 * @author Jan
 * @version 1.0
 */
public class Kafeemaschine {

    double bohnen;
    double wasser;
    double dreck;
    double kaffesatz;

    /**
     * füllt bohnen um Menge auf
     * @param amount Menge in gr
     */
    public void bohnenAuffuellen (double amount){
        this.bohnen += amount;
        if(this.bohnen > 350){
            this.bohnen = 350;
        }
    }

    /**
     * leert bohnen um Menge
     * @param amount Menge in gr
     */
    public void bohnenLeeren (double amount){
        this.bohnen -= amount;
        if(this.bohnen < 0){
            this.bohnen = 0;
        }
    }

    /**
     * füllt Wasser um Menge auf
     * @param amount Menge in ml
     */
    public void wasserAuffuellen (double amount){
        this.wasser += amount;
        if(this.wasser > 800){
            this.wasser = 800;
        }
    }

    /**
     * leert Wasser um Menge
     * @param amount Menge in ml
     */
    public void wasserLeeren (double amount){
        this.wasser -= amount;
        if(this.wasser < 0){
            this.wasser = 0;
        }
    }

    /**
     * reinigt Wasserbehaelter, damit er wieder benutzt werden kann
     * VORAUSETZUNG: kein Wasser im Behaelter;
     */
    public void wasserReinigen(){
        if(this.wasser ==0) {
            this.dreck = 0;
        }
    }

    /**
     * leert den Kaffesatz der Maschine, dort wird der Abfall aus der Produktion von Kaffee gesammelt
     */
    public void kaffesatzLeeren(){
        this.kaffesatz =0;
    }

    /**
     * Zieht Kaffee aus der Maschine, falls alle Bedingungen erfüllt sind
     * @param intensitaet 1=0,5g Bohnen & 10 = 5g Bohnen
     * @param menge 10-200ml
     */
    public void kaffeeZiehenDump(int intensitaet, double menge){
        //Dreck Handeling
        if(this.dreck >90){
            System.out.println("Zu viel dreck! Versuch es später erneut, nachdem du den Dreck beseitigt hast!");
            return;
        } else if (this.dreck>75) {
            if (Math.random()<=0.5) {
                System.out.println("Zu viel dreck! Versuch es erneut oder entferne den Dreck aus dem Wasser!");
                return;
            }
        } else if (this.dreck >50) {
            if(Math.random()<=0.25) {
                System.out.println("Zu viel dreck! Versuch es erneut oder entferne den Dreck aus dem Wasser!");
                return;
            }
        }

        //Platz-Handeling
        if(menge >this.wasser){
            System.out.println("Zu wenig Wasser! Bitte nachfüllen!");
            return;
        }

        double bohnenMenge = menge/10*(0.5*intensitaet);

        if(bohnenMenge > this.bohnen){
            System.out.println("Zu wenig Bohnen! Bitte nachfüllen!");
            return;
        }
        if(bohnenMenge>(600-this.kaffesatz)){
            System.out.println("Zu wenig Platz im Kaffeesatz! Bitte leeren!");
            return;
        }

        this.dreck++;
        this.kaffesatz+=bohnenMenge;
        this.bohnen -= bohnenMenge;
        this.wasser -= menge;

        System.out.println("Kaffee wurde gezogen!");
    }

    /**
     * Zieht Kaffee aus der Maschine & erfüllt alle Bedingungen, bzw. füllt nach, leert, reinigt, etc.
     * @param intensitaet 1=0,5g Bohnen & 10 = 5g Bohnen
     * @param menge 10-200ml
     */
    public void kaffeeZiehenSmart(int intensitaet, double menge){
        //Dreck Handeling
        if(this.dreck >50){
            wasserLeeren(800-this.wasser);
            wasserReinigen();
            wasserAuffuellen(800);
            System.out.println("Dreck im Wasser beseitigt!");
        }

        //Platz-Handeling
        if(menge >this.wasser){
            wasserAuffuellen(800-this.wasser);
            System.out.println("Wasser wurde nachgefuellt");
        }

        double bohnenMenge = menge/10*(0.5*intensitaet);
        if(bohnenMenge > this.bohnen){
            bohnenAuffuellen(350-this.bohnen);
            System.out.println("Bohnen wurden nachgefuellt!");

        }
        if(bohnenMenge>(600-this.kaffesatz)){
            kaffesatzLeeren();
            System.out.println("Kaffesatz wurde geleert!");
        }

        this.dreck++;
        this.kaffesatz+=bohnenMenge;
        this.bohnen -= bohnenMenge;
        this.wasser -= menge;

        System.out.println("Kaffee wurde gezogen!");
    }
}
