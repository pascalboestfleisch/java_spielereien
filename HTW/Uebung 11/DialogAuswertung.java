import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * Beschreiben Sie hier die Klasse DialogAuswertung.
 * 
 * @author pascal boestfleisch, emma ebel 
 * @version Uebung 11
 */
public class DialogAuswertung
{
    private static LOCAuswertung locauswertung;
    private Scanner input;

    private static final int LOCAUSWERTUNG_KONSTRUKTOR = 1;
    private static final int LINECOUNT_ANZEIGEN = 2;
    private static final int PROGRAMM_ENDE = 0;

    private final String KEINE_AUSWERTUNG = "Es wurde noch kein Konstruktor verwendet!";
    private final String VORHANDENE_AUSWERTUNG = "Es wurde bereits ein Konstruktor verwendet!";

    /**
     * Start des Dialoges
     */
    public static void main(String[]args) {
        new DialogAuswertung().start();
    }

    public DialogAuswertung() {
        input = new Scanner(System.in);
    }

    /**
     * Starten des Programms mit Exceptions
     * Eine Schleife zum verwenden mehrerer Methoden ohne neustarten des Programms
     */
    public void start(){
        locauswertung = null;
        int eingaben = -1;
        while(eingaben != PROGRAMM_ENDE){
            try{
                eingaben = usereingabeEinlesen();
                ausfuehren(eingaben);
            } catch (IllegalArgumentException Illegal_Argument) {
                System.out.println(Illegal_Argument);
            } catch (InputMismatchException e) {
                System.out.println(e);
                System.out.println("Bitte geben Sie nur Zahlen ein!");
                input.nextLine();
            }
        }
    }

    /**
     * Anzeige aller Methoden auf dem Bildschirm und erlaubt es dem Benutzer einzusehen,
     * welche Tasten welche Methoden ausfuehren
     * @return eingabe gibt die ausgewaehlte Methode aus
     */
    private int usereingabeEinlesen(){
        int eingabe;
        System.out.println(
            LOCAUSWERTUNG_KONSTRUKTOR + " :Konstruktor fuer die LOC Auswertung anlegen \n" +
            LINECOUNT_ANZEIGEN + " :Lines of code der Datei anzeigen lassen \n" +
            PROGRAMM_ENDE + " :Beenden des Programms");
        eingabe = input.nextInt();
        return eingabe;
    }

    /**
     * Die Methode, die es erlaubt die vorherig angelegten Methoden zu verwenden
     * @param int eingabe sind die vom User eingegebenen Werte
     */
    private void ausfuehren(int eingabe){
        if(eingabe == LOCAUSWERTUNG_KONSTRUKTOR){
            locAuswertungKonstruktor();
        }
        if(eingabe == LINECOUNT_ANZEIGEN){
            try
            {
                showLineCount();
            }
            catch (java.io.IOException ioe)
            {
                ioe.printStackTrace();
            }
        }
        if(eingabe == PROGRAMM_ENDE){
            programmEnde();
        }
    }

    /**
     * Gibt das Arbeitsverzeichnis wieder und erstellt ein file-Objekt, welches gleichzeitig durch eine 
     * andere Methode validiert wird
     */
    private void locAuswertungKonstruktor() {
        System.out.println("Bitte geben Sie den Namen der Datei an!");
        String filename = input.next();
        LOCAuswertung locauswertung = new LOCAuswertung(filename);
        this.locauswertung = locauswertung;
    }

    /**
     * Fuehrt die Methode aus um die Zeilen des Codes in der Datei zu ermitteln und gibt anschließend den Namen
     * der Datei und dessen LOC wieder
     */
    private void showLineCount() throws java.io.IOException {
        if (locauswertung == null) {
            System.out.println(KEINE_AUSWERTUNG); 
        }else{
            try
            {
                locauswertung.lineCount();
            }
            catch (java.io.IOException ioe)
            {
                ioe.printStackTrace();
            }
        }
        System.out.println(locauswertung.getFileName() + ": " + locauswertung.lineCount() + " LOC");
    }

    /**
     * Beendet das Programm
     */
    private void programmEnde() {
        System.out.println("Programm wurde beendet, Sie können nun das Fenster schließen!");
    }
}
