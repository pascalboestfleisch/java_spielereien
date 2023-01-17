import java.util.Scanner;
/**
 * Beschreiben Sie hier die Klasse CD.
 * 
 * @author pascal boestfleisch, emma ebel
 * @version Uebung 09
 */
public class CD extends Artikel {
   private String interpret;
   private String titel;
   private int anzahlTitel;
   private Scanner input;
   
   /**
     * Konstruktor für das Objekt CD
     * @param artikelNr ist die vom User eingegebene Artikelnummer für dieses Objekt
     * @param bestand ist der vom User eingegebene Bestand
     * @param preis ist der vom User eingegebene Preis
     * @param interpret ist der vom User eingegebene Interpret
     * @param titel ist der vom User eingegebene Titel
     * @param anzahlTitel ist die vom User eingegebene Anzahl der Titel auf der CD
     */
   public CD (int artikelNr, int bestand, double preis, String interpret, String titel, int anzahlTitel) {
       super(artikelNr, "Medien", bestand, preis);

       if(interpret.strip().isEmpty() || titel.strip().isEmpty() ) {
            throw new IllegalArgumentException(
                "Interpret und Titel dürfen nicht leer sein!"); 
       }
       if (anzahlTitel <= 0) {
            throw new IllegalArgumentException(
            "Die Anzahl der Titel auf einer CD können nicht negativ sein!");
       }
       this.interpret = interpret;
       this.titel = titel;
       this.anzahlTitel = anzahlTitel;
   }
   
   /**
    * Gibt die Beschreibung von Video-Objekten wieder
    * @return Gibt die vom User eingegeben Werte für Interpret und Titel wieder
    */
   public String getBeschreibung() {
       return interpret + ": " + titel;
   }
   
   /**
    * Bestimmung des Artikeltyps der jeweiligen Objekte
    * @return Gibt den Artikeltyp wieder
    */
   public String getArtikelTyp() {
       return "CD";
   }
   
   /**
    * @return Gibt Interpret wieder
    */
   public String getInterpret() {
       return interpret;
   }
   
   /**
    * @return Gibt Titel wieder
    */
   public String getTitel() {
       return titel;
   }
   
   /**
    * @return Gibt die Anzahl der Titel wieder
    */
   public int getAnzahlTitel() {
       return anzahlTitel;
   }
   
   /**
     * Eigener hashCode für das Objekt CD
     * @return Gibt den hashCode für das jewilige CD-Objekt wieder
     */
   @Override
    public int hashCode() {
        final int prime = 31;
        int result = 18;
        result = prime * result + ((titel == null) 
        ? 0 : titel.hashCode());
        result = prime * result + ((interpret == null) ? 0 : interpret.hashCode());
        result = prime * result + anzahlTitel;
        return result;
   }
   
   /**
     * Eigene equals für das Objekt CD
     * Vergleicht CD-Objekte auf Gleichheit
     * @return Je nachdem ob ein gleiches Objekt vorliegt oder nicht
     */
   @Override
   public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass () != obj.getClass()) {
            return false;
        }
        CD other = (CD) obj;
        if (titel == null) {
            if (other.titel != null)
                return false;
        } else if (!titel.equals(other.titel)) {
            return false;
        }
        if (anzahlTitel != other.anzahlTitel) {
            return false;
        }
        if (interpret == null) {
            if (other.interpret != null)
            return false;
        } else if (!interpret.equals(other.interpret)) {
            return false;
        }
        return true;
    }
}