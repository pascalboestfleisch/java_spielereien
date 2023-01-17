import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * Dies ist eine Klasse die es dem Benutzer ermöglicht das Programm zu bedienen und damit zu arbeiten.
 * @ebel.emma @pascal.boestfleisch
 */
public class ArtikelDialog{
    /**
     * Zuweisung der Tasten/Zahlen zu den jeweiligen Methoden.
     */
    private static Artikel artikel;
    
    private Scanner input;
    private static final int ARTIKEL_ANLEGEN_MIT_BESTAND = 1;
    private static final int ARTIKEL_ANLEGEN_OHNE_BESTAND = 2;
    private static final int BESTAND_ZUGANG = 3;
    private static final int BESTAND_ABGANG = 4;
    private static final int ARTIKEL_ART_AENDERN = 5;
    private static final int ARTIKEL_ARTIKRLNUMMER_AENDERN = 6;
    private static final int ARTIKEL_BESTAND_AENDERN = 7;
    private static final int ARTIKEL_AUSGEBEN = 8;
    private static final int PREIS_AENDERN = 9;
    private static final int PROGRAMM_ENDE = 0;
    
    private final String KEIN_ARTIKEL = "Es wurde noch kein Artikel erstellt!";
    private final String VORHANDENER_ARTIKEL = "Es wurde bereits ein Artikel angelegt!";
    
    /**
     * Dies ist die Methode mit der das Programm startet.
     */
    public static void main(String[]args){
        new ArtikelDialog().start();
    }
    
    /**
     * Ermöglicht Eingaben vom User
     */
    public ArtikelDialog(){
        input = new Scanner(System.in);
    }
    
    /**
     * Starten des Programms mit Exceptions
     * Eine Schleife zum verwenden mehrerer Methoden ohne neustarten des Programms
     */
    public void start(){
        artikel = null;
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
            ARTIKEL_ANLEGEN_MIT_BESTAND + " :Artikel mit Bestand anlegen \n" +
            ARTIKEL_ANLEGEN_OHNE_BESTAND + " :Artikel ohne Bestand anlegen \n" +
            BESTAND_ZUGANG + " :Bestand erhöhen \n" + 
            BESTAND_ABGANG + " :Bestand mindern \n" +
            ARTIKEL_ART_AENDERN + " :Art des Artikel ändern \n" +
            ARTIKEL_ARTIKRLNUMMER_AENDERN + " :Artikelnummer des Artikels ändern \n" +
            ARTIKEL_BESTAND_AENDERN + " :Bestand der Artikels ändern \n" +
            ARTIKEL_AUSGEBEN + " :Artikel anzeigen lassen \n" +
            PREIS_AENDERN + " : Preis ändern \n" +
            PROGRAMM_ENDE + " :Beenden des Programms");
            eingabe = input.nextInt();
            return eingabe;
    }
    
    /**
     * Die Methode, die es erlaubt die vorherig angelegten Methoden zu verwenden
     * @param int eingabe sind die vom User eingegebenen Werte
     */
    private void ausfuehren(int eingabe){
        if(eingabe == ARTIKEL_ANLEGEN_MIT_BESTAND){
            artikelAnlegenMitBestand();
        }
        if(eingabe == ARTIKEL_ANLEGEN_OHNE_BESTAND){
            artikelAnlegenOhneBestand();
        }
        if(eingabe == BESTAND_ZUGANG){
            bestandZugang();
        }
        if(eingabe == BESTAND_ABGANG){
            bestandAbgang();
        }
        if(eingabe == ARTIKEL_ART_AENDERN){
            artAendern();
        }
        if(eingabe == ARTIKEL_ARTIKRLNUMMER_AENDERN){
            artikelnummerAendern();
        }
        if(eingabe == ARTIKEL_BESTAND_AENDERN){
            bestandAendern();
        }
        if(eingabe == ARTIKEL_AUSGEBEN){
            artikelAusgeben();
        }
        if(eingabe == PREIS_AENDERN) {
            preisAendern();
        }
        if(eingabe == PROGRAMM_ENDE){
            programmEnde();
        }
    }
    
    /**
     * Hier werden die Eingaben/Befehle an den Konstruktor, der 4 Parameter besitzt, weitergerecht.
     */
    private void artikelAnlegenMitBestand() {
        if(artikel != null) {
            System.out.println(VORHANDENER_ARTIKEL);
        }else{
           System.out.println("Bitte geben Sie hier die Artikelnummer an!");
           int artikelNr = input.nextInt();
           
           System.out.println("Bitte geben Sie hier die Art/den Artikelnamen an (ohne Sonderzeichen und Whitespace)!");
           String art = input.next();
           
           System.out.println("Bitte geben Sie hier den Bestand des jeweiligen Artikels an!");
           int bestand = input.nextInt();
           
           System.out.println("Bitte geben Sie hier den Preis des Artikels an!");
           double preis = input.nextDouble();
           
           Artikel artikel= new Artikel(artikelNr, art, bestand, preis);
           this.artikel = artikel;
        }
    }
    
    /**
     * Hier werden die Eingaben/Befehle an den Konstruktor, der 3 Parameter besitzt, weitergerecht.
     */
    private void artikelAnlegenOhneBestand() {
        if(artikel != null) {
            System.out.println(VORHANDENER_ARTIKEL);
        }else{
           System.out.println("Bitte geben Sie hier die Artikelnummer an!");
           int artikelNr = input.nextInt();
           
           System.out.println("Bitte geben Sie hier die Art/den Artikelnamen an!");
           String art = input.next();
           
           System.out.println("Bitte geben Sie hier den Preis an!");
           double preis = input.nextDouble();
           
           Artikel artikel= new Artikel(artikelNr, art, preis);
           this.artikel = artikel;
        }
    }
    /**
     * Hier wird die Methode aufgerufen um den Bestand zu erhöhen
     */
    private void bestandZugang() {
        if(artikel == null) {
            System.out.println(KEIN_ARTIKEL);
        }else {
            System.out.println("Bitte geben Sie hier den Zugang an!");
            int zugang = input.nextInt();
            
            artikel.bucheZugang(zugang);
            System.out.println("aktueller Bestand: "+artikel.getBestand());
        }
    }
    
    /**
     * Hier wird die Methode aufgerufen um den Bestand zu mindern.
     */
    private void bestandAbgang() {
        if(artikel == null) {
            System.out.println(KEIN_ARTIKEL);
        }else {
            System.out.println("Bitte geben Sie hier den Abgang an!");
            int abgang = input.nextInt();
            
            artikel.bucheAbgang(abgang);
            System.out.println("aktueller Bestand: "+artikel.getBestand());
    
        }
    }
    
    /**
     * Hier wird die Methode aufgerufen um die Art des Artikels zu aendern.
     */

    private void artAendern() {
        if(artikel == null) {
            System.out.println(KEIN_ARTIKEL);
        }else {
            System.out.println("Bitte geben Sie die neue Art ein!");
            String art = input.next();
            artikel.setArt(art);
            
            System.out.println("neue Artikelart: "+ artikel.getArt());
        }
    }
    
    /**
     * Hier wird die Methode aufgerufen um die Artikelnummer der Artikels zu aendern.
     */
     private void artikelnummerAendern() {
        if(artikel == null) {
            System.out.println(KEIN_ARTIKEL);
        }else {
            System.out.println("Bitte geben Sie die neue Artnummer ein!");
            int artikelNr = input.nextInt();
            artikel.setArtikelNr(artikelNr);
            
            System.out.println("neue Artikelnummer: "+ artikel.getArt());
        }
    }
    
    /**
     * Hier wierd die Methode aufgerufen um den Bestand des Artikels zu aendern. 
     */
      private void bestandAendern() {
        if(artikel == null) {
            System.out.println(KEIN_ARTIKEL);
        }else {
            System.out.println("Bitte geben Sie die neuen Bestand ein!");
            int bestand = input.nextInt();
            artikel.setBestand(bestand);
            
            System.out.println("neue Bestand: "+ artikel.getArt());
        }
    }
    /**
     * Hier wird die toString Methode wieder ausgegeben.
     */
    private void artikelAusgeben() {
        if(artikel == null) {
            System.out.println(KEIN_ARTIKEL);
        }else {
            System.out.println(artikel.toString());
        }
    }
    /**
     * Hier kann der Preis nachträglich geändert werden
     */
    private void preisAendern() {
        if (artikel == null) {
            System.out.println(KEIN_ARTIKEL);
        }else{
            System.out.println("Bitte geben Sie den neuen Preis an!");
            double preis = input.nextDouble();
            artikel.setPreis(preis);
        }
    }
    /**
     * Beendet das Programm
     */
    private void programmEnde() {
        System.out.println("Programm wurde beendet, Sie können nun das Fenster schließen!");
    }
}  