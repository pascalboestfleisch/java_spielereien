
/**
 * Beschreiben Sie hier die Klasse Video.
 * 
 * @author pascal boestfleisch, emma ebel
 * @version Uebung 09
 */
public class Video extends Artikel {
    private String titel;
    private int spieldauer;
    private int jahr;
    
    /**
     * Konstruktor für das Objekt Video
     * @param artikelNr ist die vom User eingegebene Artikelnummer für dieses Objekt
     * @param bestand ist der vom User eingegebene Bestand
     * @param preis ist der vom User eingegebene Preis
     * @param titel ist der vom User eingegebene Titel
     * @param spieldauer ist die Laenge des Videos
     * @param jahr ist das Erscheinungsjahr des Videos
     */
    public Video(int artikelNr, int bestand, double preis, String titel, int spieldauer, int jahr) {
        super(artikelNr, "Medien", bestand, preis);
        
        if(titel.strip().isEmpty()) {
            throw new IllegalArgumentException(
            "Titel des Videos darf nicht leer sein!");
        }
        if(spieldauer < 0) {
            throw new IllegalArgumentException(
            "Spieldauer des Videos darf nicht negativ sein!");
        }
        if((jahr < 1900) || (jahr > 2022)) {
            throw new IllegalArgumentException (
            "Bitte geben Sie ein gültiges Jahr an!");
        }
        this.titel = titel;
        this.spieldauer = spieldauer;
        this.jahr = jahr;
    }
    
    public int getSpieldauer() {
        return spieldauer;
    }
    
    public int getJahr(){
        return jahr;
    }
    
    /**
     * Gibt die Beschreibung des jeweiligen Objektes an
     * @return Gibt den vom User eingegebenen Titel des Video-Objektes wieder
     */
    public String getBeschreibung() {
        return titel;
    }
    
    /**
     * Bestimmung des Artikeltyps für dieses Objekt
     * @return Gibt den Typen des Objektes wieder
     */
    public String getArtikelTyp() {
       return "Video";
    }
    
    /**
     * Eigener hashCode für das Objekt Video
     * @return Gibt den hashCode für das jewilige Video-Objekt wieder
     */
    @Override
    public int hashCode() {
        final int prime = 17;
        int result = 11;
        result = prime * result + ((titel == null) ? 0 : titel.hashCode());
        result = prime * result + jahr;
        return result;
    }
    
    /**
     * Eigene equals für das Objekt Video
     * Vergleicht Video-Objekte auf Gleichheit
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
        Video other = (Video) obj;
        if (titel == null) {
            if (other.titel != null)
                return false;
        } else if (!titel.equals(other.titel)) {
            return false;
        }
        if (jahr != other.jahr) {
            return false;
        }
        return true;
    }
}
