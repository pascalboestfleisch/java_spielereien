
/**
 * Beschreiben Sie hier die Klasse Buch.
 * 
 * @author pascal boestfleisch, emma ebel
 * @version Uebung 09
 */
public class Buch extends Artikel {
    private String titel;
    private String autor;
    private String verlag;
    
    /**
     * Konstruktor für das Objekt Buch
     * @param artikelNr ist die vom User eingegebene Artikelnummer für dieses Objekt
     * @param bestand ist der vom User eingegebene Bestand
     * @param preis ist der vom User eingegebene Preis
     * @param autor ist der vom User eingegebene Autor
     * @param titel ist der vom User eingegebene Titel
     * @param verlag ist der vom User eingegebene Verlag
     */
    public Buch (int artikelNr, int bestand, double preis, String autor, String titel, String verlag) {
       super(artikelNr, "Medien", bestand, preis);
        
        if(autor.strip().isEmpty() || titel.strip().isEmpty() || verlag.strip().isEmpty() ) {
            throw new IllegalArgumentException(
                "Titel, Verlag und Autor dürfen nicht leer sein!"); 
       }
       this.titel = titel;
       this.autor = autor;
       this.verlag = verlag;
    }
    
    /**
     * Gibt für das jeweilige Objekt die Beschreibung an
     * @return Gibt die Beschreibung für Buch wieder
     */
    public String getBeschreibung() {
        return autor + ": " +  titel;
    }
    
    /**
     * @return Gibt den Autor des Objektes wieder
     */
    public String getAutor() {
        return autor;
    }
    
    /**
     * @return Gibt den Titel des Objektes wieder
     */
    public String getTitel() {
        return titel;
    }
    
    /**
     * @return Gibt den Verlag des Objektes wieder
     */
    public String getVerlag() {
        return verlag;
    }
    
    /**
     * Bestimmung des Artikeltyps des Objektes
     * @return Gibt den Typ des Objektes wieder
     */
    public String getArtikelTyp() {
       return "Buch";
    }
    
    /**
     * Eigener hashCode für das Objekt Buch
     * @return Gibt den hashCode für das jewilige Buch-Objekt wieder
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 18;
        result = prime * result + ((titel == null) ? 0 : titel.hashCode());
        result = prime * result + ((autor == null) ? 0 : autor.hashCode());
        return result;
    }
    
    /**
     * Eigene equals für das Objekt Buch
     * Vergleicht Buch-Objekte auf Gleichheit
     * @return je nachdem ob ein gleiches Objekt vorliegt oder nicht
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
        Buch other = (Buch) obj;
        if (titel == null) {
            if (other.titel != null)
                return false;
        } else if (!titel.equals(other.titel)) {
            return false;
        }
        if (autor == null) {
            if (other.autor != null)
            return false;
        } else if (!autor.equals(other.autor)) {
            return false;
        }
        return true;
    }
}
