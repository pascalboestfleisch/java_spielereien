
/**
 * Beschreiben Sie hier die Klasse ArtikelDialog.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
import java.util.Scanner;
import java.util.InputMismatchException;

public class ArtikelDialog {
    private Scanner input;
    
    private Artikel artikel;
    
    private static final int BUCHE_ZUGANG = 1;
    private static final int BUCHE_ABGANG = 2;
    private static final int ARTIKEL_NAME_AENDERN = 3;
    private static final int ARTIKELNUMMER_AENDERN = 4;
    private static final int ARTIKEL_AUSGEBEN = 5;
    private static final int ENDE = 0;
    
    public ArtikelDialog() {
        input = new Scanner(System.in);
    }
    
    public void start() {
        artikel = null;
        int funktion = 0;
        
         while (funktion!= ENDE);{
            try {
                optionenAnzeigen();
                funktion = einleseFunktion();
                ausfuehrenFunktion(funktion);
            } 
            catch (IllegalArgumentException e) {
                System.out.println(e);
            }
            catch (InputMismatchException e) {
                System.out.println(e);
                input.nextLine();
            }
            catch (Exception e) {
                System.out.println(e);
                e.printStackTrace(System.out);
            }
        
    }
    }
    
    private void optionenAnzeigen() {
        System.out.println(BUCHE_ZUGANG + ": Zugang buchen;/n" +
            BUCHE_ABGANG + ": Abgang buchen;/n" + 
            ARTIKEL_NAME_AENDERN + ": Name des Artikels aendern;/n" +
            ARTIKELNUMMER_AENDERN + ": Nummer des Artikels aendern;/n" +
            ARTIKEL_AUSGEBEN + ": Artikel ausgeben;/n" +
            ENDE        + ": beenden");
    }
    
    private int einleseFunktion() {
        int funktion = input.nextInt();
            input.nextLine();
        return funktion;
    }
     
    private void ausfuehrenFunktion(int funktion) {
        if (funktion == BUCHE_ZUGANG) {
            zugangBuchen();
        } 
        else if (funktion == BUCHE_ABGANG) {
            abgangBuchen();
        }
        else if (funktion == ARTIKEL_NAME_AENDERN) {
            artNameAendern();
        }
        else if (funktion == ARTIKELNUMMER_AENDERN) {
            artNrAendern();
        }
        else if (funktion == ARTIKEL_AUSGEBEN) {
            artikelAusgeben();
        }
        else if (funktion == ENDE) {
            System.out.println ("Programmende");
        }
        else {
            System.out.println("Falsche Eingabe!");
        }
        System.out.println(artikel);
    }
    
    private void zugangBuchen() {
        if (artikel == null) {
            System.out.println("Es wurde noch kein Artikel angelegt!");
        }
        else {
            System.out.println(artikel);
        }
    }
    
    private void abgangBuchen() {
        if (artikel == null) {
            System.out.println("Es wurde noch kein Artikel angelegt!");
        }
        else {
            System.out.println(artikel);
        }
    }
    
    private void artikelAusgeben() {
        if (artikel == null) {
            System.out.println("Es wurde noch kein Artikel angelegt!");
        }
        else {
            System.out.println(artikel);
        }
    }
    
    private void artNameAendern() {
        if (artikel == null) {
            System.out.println("Es wurde noch kein Artikel angelegt");
        }
        else {
            System.out.println("Neuen Namen eingeben: ");
            String art = input.next();
            artikel.setArt(art);
        } 
    }
    
    private void artNrAendern() {
        if (artikel == null) {
            System.out.println("Es wurde noch kein Artikel angelegt");
        }
        else {
            System.out.println("Neue Artikelnummer eingeben: ");
            int artNr = input.next();
            artikel.setArtikelNr(artikelNr);
        }
    }
    
        public static void main(String[] args) {
        new ArtikelDialog().start();
    }
    }
    
    
