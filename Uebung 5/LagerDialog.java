import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * Dies ist eine Klasse die es dem Benutzer ermöglicht das Programm zu bedienen und damit zu arbeiten.
 * @ebel.emma @pascal.boestfleisch
 */
public class LagerDialog{
    private Lager lager;
    private Scanner input;
    
    private static final int LAGER_ANLEGEN_BENUTZERDEFINIERT = 1;
    private static final int LAGER_ANLEGEN_MAX_10 = 2;
    private static final int LEGE_ARTIKEL_AN = 3;
    private static final int ENTFERNE_ARTIKEL = 4;
    private static final int BESTAND_ZUGANG = 5;
    private static final int BESTAND_ABGANG = 6;
    private static final int PREIS_AENDERN_EINES_ARTIKELS = 7;
    private static final int PREIS_AENDERN_ALLE_ARTIKEL = 8;
    private static final int EINEN_ARTIKEL_ERMITTELN = 9;
    private static final int LAGER_AUSGEBEN = 10;
    private static final int ANZAHL_AKTUELLE_ARTIKEL = 11;
    private static final int ANZAHL_ARTIKEL_BESTIMMEN = 12;
    private static final int PROGRAMM_ENDE = 0;
    
    private final String KEIN_LAGER = "Es wurde noch kein Lager erstellt!";
    private final String VORHANDENES_LAGER = "Es wurde bereits ein Lager angelegt!";
    
    /**
     * Dies ist die Methode mit der das Programm startet.
     */
    public static void main(String[]args){
        new LagerDialog().start();
    }
 
    /**
     * Ermöglicht Eingaben vom User
     */
    private LagerDialog(){
        input = new Scanner(System.in);
    }
    
    /**
     * Starten des Programms mit Exceptions 
     * Eine Schleife zum verwenden mehrerer Methoden ohne neustarten des Programms.
     */
    public void start(){
        lager = null;
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
     * welche Tasten welche Methoden ausfuehren.
     * @return eingabe startet die Methode, welche der User eingegebenen hat
     */
    private int usereingabeEinlesen(){
        int eingabe;
        System.out.println(
            LAGER_ANLEGEN_BENUTZERDEFINIERT + " :Lager mit beliebig vielen Plätzen anlegen \n" +
            LAGER_ANLEGEN_MAX_10 + " :Lager mit 10 Plätzen anlegen \n" +
            LEGE_ARTIKEL_AN + " :Artikel anlegen \n" +
            ENTFERNE_ARTIKEL + " :Artikel entfernen \n" +
            BESTAND_ZUGANG + " :Bestand erhöhen \n" + 
            BESTAND_ABGANG + " :Bestand mindern \n" +
            PREIS_AENDERN_EINES_ARTIKELS + " :Preis eines Artikel ändern \n" +
            PREIS_AENDERN_ALLE_ARTIKEL + " :Preis aller Artikel ändern \n" +
            EINEN_ARTIKEL_ERMITTELN + " :Einen Artikel im Lager ermitteln \n" +
            LAGER_AUSGEBEN + " :Lager ausgeben lassen \n" +
            ANZAHL_AKTUELLE_ARTIKEL + " : Zeigt die aktuelle Anzahl der angelegten Artikel im Lager \n" +
            ANZAHL_ARTIKEL_BESTIMMEN + " : Gibt die aktuelle Größe des Lager an \n" +
            PROGRAMM_ENDE + " :Beenden des Programms");
            eingabe = input.nextInt();
            return eingabe;
    }
    
    /**
     * Die Methode, die es erlaubt die vorherig angelegten Methoden zu verwenden.
     * @param int eingabe Ausführen der vom User ausgewählten Methode
     */
    private void ausfuehren(int eingabe){
        if(eingabe == LAGER_ANLEGEN_BENUTZERDEFINIERT){
            lagerAnlegenBenutzerdefiniert();
        }
        if(eingabe == LAGER_ANLEGEN_MAX_10){
            lagerAnlegen10Plaetze();
        }
        if(eingabe == LEGE_ARTIKEL_AN){
            artikelAnlegen();
        }
        if(eingabe == ENTFERNE_ARTIKEL){
            artikelEntfernen();
        }
        if(eingabe == BESTAND_ZUGANG){
            bestandZugang();
        }
        if(eingabe == BESTAND_ABGANG){
            bestandAbgang();
        }
        if(eingabe == PREIS_AENDERN_EINES_ARTIKELS){
            preisAendernEinArtikel();
        }
        if(eingabe == PREIS_AENDERN_ALLE_ARTIKEL){
            preisAendernAlleArtikel();
        }
        if(eingabe == EINEN_ARTIKEL_ERMITTELN){
            artikelErmitteln();
        }
        if(eingabe == LAGER_AUSGEBEN){
            lagerAusgeben();
        }
        if(eingabe == ANZAHL_AKTUELLE_ARTIKEL) {
            anzahlAktuelleArtikel();
        }
        if(eingabe == ANZAHL_ARTIKEL_BESTIMMEN) {
            artikelAnzahlBestimmen();
        }
        if(eingabe == PROGRAMM_ENDE){
            programmEnde();
        }
    }
    
    /**
     * Methode zum Anlegen eines Lagers mit 10 Plätzen
     */
    private void lagerAnlegen10Plaetze(){
        if(lager != null) {
            System.out.println(VORHANDENES_LAGER);
        }else{
            lager = new Lager();
            System.out.println("Lager mit 10 Plätzen wurde hinzugefügt!");
        }
    }
    
    /**
     * Anlegen eines Lagers mit benutzerdefinierten Plätzen
     */
    private void lagerAnlegenBenutzerdefiniert(){
        if(lager != null) {
            System.out.println(VORHANDENES_LAGER);
        }else{
            System.out.println("Geben Sie die gewünschte Größe an!");
            int maxAnzahlArtikel = input.nextInt();
            lager = new Lager(maxAnzahlArtikel);
            System.out.println("Lager mit " + maxAnzahlArtikel + " wurde hinzugefügt!");
        }
    }
    
    /**
     * Ein vorher angelegtes Artikel-Objekt wird in das Array eingefügt
     */
    private void artikelAnlegen() {
        if(lager == null) {
            System.out.println(KEIN_LAGER);
        }else{
            System.out.println("Artikelnummer: ");
            int artikelNr = input.nextInt();
            input.nextLine();
            System.out.println("Artikelname: ");
            String art = input.nextLine();
            System.out.println("Möchten Sie einen Artikel mit Bestand anlegen? j/n");
            char auswahl = input.nextLine().charAt(0);
            System.out.println("Preis: ");
            double preis = input.nextDouble();
            Artikel artikel = null;
            if (auswahl == 'j') {
                System.out.println("Bestand : ");
                int bestand = input.nextInt();
                artikel = new Artikel(artikelNr, art, bestand, preis);
            } else {
                artikel = new Artikel(artikelNr, art, preis);
            }
            lager.legeAnArtikel(artikel);
            
            System.out.println("Artikel " + artikelNr + " wurde in das Lager hinzugefügt!");
        }
    }
    
    /**
     * Methode zum Entfernen einzelner Artikel-Objekte im Array
     */
    private void artikelEntfernen() {
        if(lager == null) {
            System.out.println(KEIN_LAGER);
        }else{
            System.out.println("Geben Sie die Artikelnummer ein, welche gelöscht werden soll!");
            int artikelNr = input.nextInt();
            lager.entferneArtikel(artikelNr);
            System.out.println("Folgende Artikelnummer wurde gelöscht: " + artikelNr);
        }
    }
    
    /**
     * Methode zur Buchung von Zugängen
     */
    private void bestandZugang() {
        if(lager == null) {
            System.out.println(KEIN_LAGER);
        }else {
            System.out.println("Geben Sie die Artikelnummer ein, welche einen Zugang bekommt!");
            int artikelNr = input.nextInt();
            System.out.println("Geben Sie den Zugang ein, welcher gebucht werden soll!");
            
            int zugang = input.nextInt();
            
            lager.bucheZugang(artikelNr, zugang);
            
            System.out.println("Bei folgende Artikelnummer wurde ein Zugang gebucht: " + artikelNr + 
            " Zugang in Höhe von: " + zugang);
        }
    }
    
    /**
     * Methode zur Buchung von Abgängen
     */
    private void bestandAbgang() {
        if(lager == null) {
            System.out.println(KEIN_LAGER);
        }else {
            System.out.println("Geben Sie die Artikelnummer ein, welche einen Abgang bekommt!");
            int artikelNr = input.nextInt();
            System.out.println("Geben Sie den Abgang ein, welcher gebucht werden soll!");
            
            int abgang = input.nextInt();
            
            lager.bucheAbgang(artikelNr, abgang);
            
            System.out.println("Bei folgende Artikelnummer wurde ein Abgang gebucht: " + artikelNr + 
            " Abgang in Höhe von: " + abgang);
        }
    }
    
    /**
     * Methode zur Preisänderung eines Artikels im Array
     */

    private void preisAendernEinArtikel() {
        if(lager == null) {
            System.out.println(KEIN_LAGER);
        }else {
            System.out.println("Geben Sie die Nummer des Artikels an, welcher eine Preisänderung erhält: ");
            int artikelNr = input.nextInt();
            
            System.out.println("Geben Sie den Prozentsatz an, mit dem der Preis verändert werden soll: ");
            double prozent = input.nextDouble();
            
            lager.aenderePreisEinesArtikels(artikelNr, prozent);
            System.out.println(artikelNr + " wurde mit dem Prozentsatz " + prozent + " geändert!");
        }
    }
    
    /**
     * Methode zur Preisänderung aller Artikel im Array
     */
     private void preisAendernAlleArtikel() {
        if(lager == null) {
            System.out.println(KEIN_LAGER);
        }else {
            System.out.println("Geben Sie den Prozentsatz an, mit dem die Preise aller Artikel geändert werden sollen: ");
            double prozent = input.nextDouble();
            
            lager.aenderePreisAllerArtikel(prozent);
            System.out.println("Alle Artikel wurden mit dem Prozentsatz " + prozent + " verrechnet!");
        }
    }
    
    /**
     * Methode zur Ermittlung eines Artikels im Array
     */
      private void artikelErmitteln() {
        if(lager == null) {
            System.out.println(KEIN_LAGER);
        }else {
            System.out.println("Geben Sie die Artikelnummer an, an die den Artikel ermitteln soll: ");
            int index = 0;
            int artikelNr = input.nextInt();
            lager.findeArtikel(artikelNr);
            
            lager.getArtikel(index);
            System.out.println("Artikelnummer " + artikelNr + " befindet sich an der Stelle " + index);
        }
    }
    
    /**
     * Das Lager-Array wird durch die toString-Methode ausgegeben
     */
    private void lagerAusgeben() {
        if(lager == null) {
            System.out.println(KEIN_LAGER);
        }else {
            System.out.println(lager.toString());
        }
    }
    
    /**
     * Methode zur Bestimmung der aktuellen Artikel im Lager-Array
     */
    private void anzahlAktuelleArtikel() {
        if (lager == null) {
            System.out.println(KEIN_LAGER);
        }else{
            lager.getArtikelAnzahl();
            System.out.println("Anzahl der Artikel: " + lager.getArtikelAnzahl());
        }
    }
    
    /**
     * Methode zur Bestimmung der Anzahl von Plätzen für Artikel im Lager-Array
     */
    private void artikelAnzahlBestimmen() {
        if(lager == null) {
            System.out.println(KEIN_LAGER);
        }else {
            lager.getLagerGroesse();
            System.out.println("Groesse des Lagers: " + lager.getLagerGroesse());
        }
    }
    
    /**
     * Beendet das Programm
     */
    private void programmEnde() {
        System.out.println("Programm wurde beendet, Sie können nun das Fenster schließen!");
    }
}  