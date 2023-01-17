import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * Dies ist eine Klasse die es dem Benutzer ermöglicht das Programm zu bedienen und um es interaktiv zu Testen
 * @author ebel emma, pascal boestfleisch
 * @version Uebung 10
 * 
 */
public class QueueDialog{
    private Queue queue;
    private Scanner input;
    
    private static final int PERSON_WARTESCHLANGE_ANLEGEN               = 1;
    private static final int STRING_WARTESCHLANGE_ANLEGEN               = 2;
    
    private static final int PERSON_ANLEGEN_UND_HINZUFUEGEN             = 3;
    private static final int PERSON_ENTFERNEN                           = 4;
    private static final int PERSON_AN_BESTIMMTER_STELLE_AUSGEBEN       = 5;
    private static final int PRUEFEN_OB_WARTESCHLANGE_LEER              = 6;
    private static final int PRUEFEN_OB_WARTESCHLANGE_VOLL              = 7;
    private static final int GROESSE_DER_WARTESCHLANGE                  = 8;
    private static final int PERSONEN_AUS_WARTESCHLANGE_ENTFERNEN       = 9;
    private static final int PROGRAMM_ENDE                              = 0;
    
    private final String KEINE_WARTESCHLANGE                    = "Es wurde noch keine Warteschlange erstellt!";
    private final String BEREITS_VORHANDENE_WARTESCHLANGE       = "Es wurde bereits eine Warteschlange erstellt!";
    PersonQueue personqueue;
    StringQueue stringqueue;
    PersonQueueMain personqueuemain;
    StringQueueMain stringqueuemain;
    
    /**
     * Dies ist die Methode mit der das Programm startet.
     */
    public static void main(String[]args){
        new QueueDialog().start();
    }
 
    /**
     * Ermöglicht Eingaben vom User
     */
    private QueueDialog(){
        input = new Scanner(System.in);
    }
    
    /**
     * Starten des Programms mit Exceptions 
     * Eine Schleife zum verwenden mehrerer Methoden ohne neustarten des Programms.
     */
    public void start(){
        queue = null;
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
            "Warteschlange fuer Personen anlegen: "                             + PERSON_WARTESCHLANGE_ANLEGEN              + "\n" +              
            "Warteschlange fuer String anlegen: "                               + STRING_WARTESCHLANGE_ANLEGEN              + "\n" +             
            "Person anlegen und in die Warteschlange hinzufuegen: "             + PERSON_ANLEGEN_UND_HINZUFUEGEN            + "\n" +             
            "Person aus der Warteschlange entfernen: "                          + PERSON_ENTFERNEN                          + "\n" +                           
            "Person an bestimmter Stelle in der Warteschlange wiedergeben: "    + PERSON_AN_BESTIMMTER_STELLE_AUSGEBEN      + "\n" +       
            "Pruefen ob die Warteschlange leer ist: "                           + PRUEFEN_OB_WARTESCHLANGE_LEER             + "\n" +             
            "Pruefen ob die Warteschlange voll ist: "                           + PRUEFEN_OB_WARTESCHLANGE_VOLL             + "\n" +             
            "Groesse der Warteschlange wieder geben: "                          + GROESSE_DER_WARTESCHLANGE                 + "\n" +                                               
            "Beenden des Programms:"                                            + PROGRAMM_ENDE);
            
            eingabe = input.nextInt();
            return eingabe;
    }
    
    /**
     * Die Methode, die es erlaubt die vorherig angelegten Methoden zu verwenden.
     * @param int eingabe Ausführen der vom User ausgewählten Methode
     */
    private void ausfuehren(int eingabe){
        if(eingabe == PERSON_WARTESCHLANGE_ANLEGEN){
            personenWarteschlangeAnlegen();
        }
        if(eingabe == STRING_WARTESCHLANGE_ANLEGEN){
            stringWarteschlangeAnlegen();
        }
        if(eingabe == PERSON_ANLEGEN_UND_HINZUFUEGEN){
            personAnlegenUndHinzufuegen();
        }
        if(eingabe == PERSON_AN_BESTIMMTER_STELLE_AUSGEBEN){
            personAnBestimmterStelleAusgeben();
        }
        if(eingabe == PRUEFEN_OB_WARTESCHLANGE_LEER){
            pruefenObWarteschlangeLeer();
        }
        if(eingabe == PRUEFEN_OB_WARTESCHLANGE_VOLL){
            pruefenObWarteschlangeVoll();
        }
        if(eingabe == GROESSE_DER_WARTESCHLANGE){
            groesseDerWarteschlange();
        }
        if(eingabe == PERSONEN_AUS_WARTESCHLANGE_ENTFERNEN){
            personenEntfernen();
        }
        if(eingabe == PROGRAMM_ENDE){
            programmEnde();
        }
    }
    
    /**
     * Methode zum Anlegen einer Warteschlange mit Personen
     */
    private void personenWarteschlangeAnlegen(){
        if(queue != null) {
            System.out.println(BEREITS_VORHANDENE_WARTESCHLANGE);
        }else{
            System.out.println("Geben Sie die gewünschte Größe an!");
            int maxQueueSpots = input.nextInt();
            personqueuemain = new PersonQueueMain(maxQueueSpots);
            System.out.println("Warteschlange erstellt");
        }
    }
    
    /**
     * Methode zum Anlegen einer Warteschlange als String
     */
    private void stringWarteschlangeAnlegen(){
        if(queue != null) {
            System.out.println(BEREITS_VORHANDENE_WARTESCHLANGE);
        }else{
            System.out.println("Geben Sie die gewünschte Größe an!");
            int maxQueueSpots = input.nextInt();
            stringqueuemain = new StringQueueMain(maxQueueSpots);
            System.out.println("String-Warteschlange wurde erstellt");
        }
    }
    
    /**
     * Ein vorher angelegtes Person-Objekt wird in das Warteschlangen-Array eingefuegt
     */
    private void personAnlegenUndHinzufuegen() {
        if(queue == null) {
            System.out.println(KEINE_WARTESCHLANGE);
        }else{
            System.out.println("Vorname: ");
            String vorname = input.next();
            input.nextLine();
            System.out.println("Nachname: ");
            String nachname = input.nextLine();
            Person person = null;
            person = new Person(vorname, nachname);
            personqueue.addLast(person);
            
            System.out.println(vorname + ", " + nachname + " " + "wurde in die Warteschlange hinzugefügt!");
        }
    }
    
    /**
     * Methode zum Entfernen von Person-Objekte im Array an vorderster Stelle
     */
    private void personenEntfernen() {
        if(queue == null) {
            System.out.println(KEINE_WARTESCHLANGE);
        }else{
            personqueue.removeFirst();
            System.out.println("Die Person an der ersten Stelle wurde geloescht!");
        }
    }

    /**
     * Methode zur Ermittlung einer Person an einer Stelle im Warteschlangen-Array
     */
      private void personAnBestimmterStelleAusgeben() {
        if(queue == null) {
            System.out.println(KEINE_WARTESCHLANGE);
        }else {
            System.out.println("Geben Sie die Stelle an, an welcher die Person ermittelt werden soll");
            int i = input.nextInt();
            personqueue.get(i);
        }
    }
    
    /**
     * Gibt die Groesse des Warteschlangen-Arrays wieder
     */
    private void groesseDerWarteschlange() {
        if(queue == null) {
            System.out.println(KEINE_WARTESCHLANGE);
        }else {
            personqueue.size();
        }
    }
    
    /**
     * Methode zum Pruefen, ob das Warteschlangen-Array voll ist
     */
    private void pruefenObWarteschlangeVoll() {
        if (queue == null) {
            System.out.println(KEINE_WARTESCHLANGE);
        }else{
            personqueue.full();
            System.out.println("Ist die Warteschlange voll: " + personqueue.full());
        }
    }
    
    /**
     * Methode zum Pruefen, ob das Warteschlangen-Array leer ist
     */
    private void pruefenObWarteschlangeLeer() {
        if(queue == null) {
            System.out.println(KEINE_WARTESCHLANGE);
        }else {
            personqueue.empty();
            System.out.println("Ist die Warteschlange leer: " + personqueue.empty());
        }
    }
    
    /**
     * Beendet das Programm
     */
    private void programmEnde() {
        System.out.println("Programm wurde beendet, Sie können nun das Fenster schließen!");
    }
}  
