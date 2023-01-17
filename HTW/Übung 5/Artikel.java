/**
 * Artikel
 * @ebel.emma @pascal.boestfleisch
 * @param Programm zur einfachen Bestandsaufnahme.
 */
/**
 * @param Deklaration und Kapselung der Attribute.
 */
public class Artikel{
    private String art;
    private int artikelNr;
    private int bestand;
    private double preis;
    private final long ARTIKELNUMMER_MIN = 1000L;
    private final long ARTIKELNUMMER_MAX = 9999L;

    /**
     * Konstruktor für ein Objekt mit Artikelnummer, Artikelname, Bestand und Preis
     * @param int artikelNr ist die vom User eingegebene Artikelnummer
     * @param String art ist der vom User eingegebene Artikelname
     * @param int bestand ist der vom User eingegebene Bestand
     * @param double preis ist der vom User eingegebene Preis
     */
    public Artikel (int artikelNr, String art, int bestand,double preis){
        if(artikelNr <= 0 ) {
                throw new IllegalArgumentException (
                    "Bitte geben Sie eine Artikelnummer an!");
        }
        if(art.strip().isEmpty()) {
                throw new IllegalArgumentException(
                    "Der Artikel/Die Artikelart muss benannt werden! Bitte benennen Sie den Artikel!"); 
        }
        if(bestand < 0 ) {
                throw new IllegalArgumentException (
                    "Der Bestand darf und kann nicht geringer als 0 sein!");
        }
        if((preis < 0) || (preis == 0)) {
                throw new IllegalArgumentException (
                    "Bitte prüfen Sie Ihre Eingabe!");
        }
        this.art=art;
        this.artikelNr=artikelNr;
        this.bestand=bestand;
        this.preis=preis;
    }
    
    /**
     * Konstruktor für ein Objekt ohne Bestand
     * @param int artikelNr ist die vom User eingegebene Artikelnummer
     * @param String art ist der vom User eingegebene Artikelname
     * @param double preis ist der vom User eingegebene Preis
     */
    public Artikel (int artikelNr, String art,double preis){
        this(artikelNr, art, 0, preis);
    }
   
    /**
     * Methode um einen Zugang zu buchen
     * @param int zugang ist der vom User eingegebene Wert
     */
    public void bucheZugang(int zugang){
        if(zugang < 0){
            throw new IllegalArgumentException(
            "Der Zugang darf und kann nicht als Negativ verbucht werden!");
        }
        if(zugang == 0){
            throw new IllegalArgumentException(
            "Bitte geben Sie den Zugang ein!");
        }
        bestand = bestand + zugang;    
    }
    
    /**
     * Methode um einen Abgang zu buchen
     * @param int abgang ist der vom User eingegebene Wert
     */
    public void bucheAbgang(int abgang){
        if(abgang > bestand){
            throw new IllegalArgumentException(
            "Der Abgang darf und kann nicht größer als Der aktuelle Bestand sein! Bitte prüfen Sie Ihre Eingabe!");
        }
        if(abgang < 0){
            throw new IllegalArgumentException(
            "Bitte schreiben Sie die Zahlen im Betrag!");
        }
        if (abgang == 0){
            throw new IllegalArgumentException(
            "Bitte geben Sie den Abgang ein!");
        }
        bestand = bestand - abgang;
    }
    
    /**
     * Eine Methode um den Artikelnamen aufzurufen
     * @return gibt Artikelnamen aus
     */
    public String getArt(){
        return art;
    }
    
    /**
     * Eine Methode um die Artikelnummer aufzurufen
     * @return gibt Artikelnummer aus
     */
    public int artikelNr(){
        return artikelNr;
    }
    
    /**
     * Eine Methode um den Bestand aufzurufen
     * @return gibt Bestand aus
     */
    public int getBestand(){
        return bestand;
    }
    
    /**
     * Eine Methode um den Preis abzurufen
     * @return gibt Preis aus
     */
    public double getPreis(){
        return preis;
    }
    
    /**
     * Eine Methode zum nachträglichen Ändern eines Artikelnamens
     * @param String art ist der vom User eingegebene Artikelname
     */
    public void setArt(String art){
        this.art=art;
    }
    
    /**
     * Dies ist eine Methode zum nachtraeglichen aendern von der Artikelnummer
     * @param int artikelNr ist die vom User eingegebene Artikelnummer
     */
    public void setArtikelNr(int artikelNr){
        this.artikelNr=artikelNr;
    }
    
    /**
     * Dies ist eine Methode zum nachtraeglichen aendern vom Bestand
     * @param int bestand ist der vom User eingegebene Bestand
     */
    public void setBestand(int bestand){
        this.bestand=bestand;
    }
    
    /**
     * Eine Methode zur nachträglichen Änderung des Preises
     * @param double preis ist der vom User eingegebene Preis
     */
    public void setPreis(double preis){
        this.preis=preis;
    }
    
    /**
     * Hier wird alles in einen String gepackt um nachher eine Anzeige auf dem Bildschirm zu erhalten
     * @return Wiedergabe der Variablen als String
     */
    public String toString(){
        return "Artikelart: " + art + "\nArtikelnummer: " + artikelNr + "\nBestand: " + bestand + "\nPreis" + preis;
    }
}