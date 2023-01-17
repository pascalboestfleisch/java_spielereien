import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * Dialog zum aktiven Testen der Klasse MathFunctions
 * 
 * @author @pascal.boestfleisch @emma.ebel
 * @version Uebung 4
 */

public class MathFunctionsDialog {
    private MathFunctions mathfunctions;
    private Scanner input;
    
    private static final int TEILERSUMME_BERECHNEN = 1;
    private static final int CHECKSUMME_BERECHNEN = 2;
    private static final int NULLSTELLEN_BERECHNEN = 3;
    private static final int REIHENSUMME_BERECHNEN = 4;
    private static final int FAKULTAET_BERECHNEN = 5;
    private static final int GGT_BERECHNEN = 6;
    private static final int SUMMEN_VON_POTENZEN_BERECHNEN = 7;
    private static final int ENDE = 0;
    
    public MathFunctionsDialog() {
        input = new Scanner(System.in);
    }
    
    /**
     * Hauptschleife des Dialoges. Liest Funktionen ein und gibt bei falschen Eingaben eine Fehlermeldung zurück
     * @param Hauptschleife mit Fehlermeldungen
     */
    public void start() {
        int funktion = -1;
        while (funktion != ENDE) {
            try {
                funktion = einlesenFunktion();
                ausfuehrenFunktion(funktion);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            } catch(InputMismatchException e) {
                System.out.println(e);
                input.nextLine();
            } catch(Exception e) {
                System.out.println(e);
                e.printStackTrace(System.out);
            }
        }
    }
    
    /**
     * Menü und Funktionen anzeigen lassen
     * @return Funktion als ganzzahliger Wert
     */
    private int einlesenFunktion() {
        int funktion;
        
        System.out.print(TEILERSUMME_BERECHNEN   + ": Berechnen einer Teilsumme \n" +
            CHECKSUMME_BERECHNEN + ": Berechnen der Checksumme einer ISBN \n" +
            NULLSTELLEN_BERECHNEN + ": Berechnen der Nullstellen durch die PQ-Formel \n" +
            REIHENSUMME_BERECHNEN + ": Berechnen der Reihensumme \n" +
            FAKULTAET_BERECHNEN + ": Berechnen der Fakultät \n" +
            GGT_BERECHNEN + ": Berechnen des größten gemeinsamen Teilers \n" +
            SUMMEN_VON_POTENZEN_BERECHNEN + ": Prüfen, ob \n" +          
            ENDE + ": Ende des Programms");
            
        funktion = input.nextInt();
        input.nextLine();
        return funktion;
    }
    
    /**
     * Gibt an, welche Methoden ausgeführt werden, wenn die entsprechende Funktion eingegeben wurde
     * @param Greift auf die Methoden auf, welche durch die Funktion ausgelesen werden sollen
     */
    private void ausfuehrenFunktion(int funktion) {
        if (funktion == TEILERSUMME_BERECHNEN){
            teilsummeBerechnen();
        }else if (funktion == CHECKSUMME_BERECHNEN) {
            checksummeBerechnen();
        }else if (funktion == NULLSTELLEN_BERECHNEN) {
            nullstellenBerechnen();
        }else if (funktion == REIHENSUMME_BERECHNEN) {
            reihensummeBerechnen();
        }else if (funktion == FAKULTAET_BERECHNEN) {
            fakultaetBerechnen();
        }else if (funktion == GGT_BERECHNEN) {
            ggtBerechnen();
        }else if (funktion == SUMMEN_VON_POTENZEN_BERECHNEN) {
            summenPotenzBerechnen();
        }else if (funktion == ENDE) {
            System.out.println("Ende des Programms");
        } else {
            System.out.println("Falsche Eingabe!");
        }
        System.out.println(mathfunctions);
    }
    
    /**
     * Berechnet die Teilersumme einer vom User definierten Zahl.
     * @param int zahl ist der Wert, welcher vom User eingegeben und anschließend berechnet wird.
     */
    private void teilsummeBerechnen() {
        System.out.println("Geben Sie die Zahl ein, von der die Teilsumme berechnet werden soll!");
        long zahl = input.nextLong();
        System.out.println("Zahl: " +mathfunctions.berechneTeilersumme(zahl));
    }
    
    /**
     * Berechnet ob eine ISBN gültig ist und ob sie als letzte Ziffer eine 10 hat. Wenn ja wird die Prüfziffer als x ausgegeben
     * Gibt das Ergebnis als String aus
     * @param long isbn ist die vom User eingegebene ISBN, welche überprüft werden soll
     */
    private void checksummeBerechnen() {
        System.out.println("Geben Sie die ISBN ein, welche überprüft werden soll!");
        long isbn = input.nextLong();
        System.out.println("ISBN: " +mathfunctions.berechneChecksummeIsbn(isbn));
    }
    
    /**
     * Berechnet vom User angegebene Werte für p und q auf deren Nullstellen.
     * Gibt das Ergebnis als String aus
     * @param double p,q sind die Werte, welche für die PQ-Formel benötigt werden
     */
    private void nullstellenBerechnen() {
        System.out.println("Geben Sie p an!");
        double p = input.nextDouble();
        System.out.println("Geben Sie q an!");
        double q = input.nextDouble();
        System.out.println("p und q: " +mathfunctions.berechneNullstellen(p,q));
    }
    
    private void reihensummeBerechnen() {
        System.out.println("Geben Sie die Anzahl an!");
        int anzahl = input.nextInt();
        System.out.println("Geben Sie x an!");
        double x = input.nextDouble();
        System.out.println("Anzahl und x: " + mathfunctions.berechneReihensumme(anzahl,x));
    }
    
    private void fakultaetBerechnen() {
        System.out.println("Geben Sie die !Zahl an!");
        int zahl = input.nextInt();
        System.out.println("!Zahl: " + mathfunctions.berechneFakultaet(zahl));
    }
    
    private void ggtBerechnen() {
        System.out.println("Geben Sie die erste Zahl an!");
        int zahl1 = input.nextInt();
        System.out.println("Geben Sie die zweite Zahl an!");
        int zahl2 = input.nextInt();
        System.out.println("Zahl 1 und 2: " + mathfunctions.berechneGgt(zahl1,zahl2));
    }
    
    private void summenPotenzBerechnen() {
        System.out.println("Geben Sie eine Zahl ein!:");
        long zahl = input.nextLong();
        System.out.println("Zahl: " + mathfunctions.istSummeVonPotenzen(zahl));
    }
    
    /**
     * Startet die Main-Methode zum Erzeugen des MathFunctionsDialogs und somit auch die Testschleife
     */
    public static void main(String[] args) {
        new MathFunctionsDialog().start();
    }
}