/**
 * Legt fuer das Warteschlangen-Array Person-Objekte an
 * 
 * @author boestfleisch pascal, ebel emma 
 * @version Uebung 10
 */
public class Person {
    private String vorname;
    private String nachname;
    
    /**
     * Konstruktor um ein Person-Objekt zu erstellen
     * @param vorname Gibt den Vornamen der Person an
     * @param nachname Gibt den Nachnamen der Person an
     */
    public Person(String vorname, String nachname) {
        if(vorname.strip().isEmpty() || nachname.strip().isEmpty()) {
            throw new IllegalArgumentException(
                "Bitte geben Sie den Vor- und Nachnamen ein!");
        }
        this.vorname = vorname;
        this.nachname = nachname;
    }
    
    /**
     * get-Methode um den Vornamen der Person zu erhalten
     * @param vorname Ist der Vorname der Person
     * @return Gibt den Vornamen wieder
     */
    public String getVorname (String vorname) {
        return vorname;
    }
    
    /**
     * get-Methode um den Nachnamen der Person zu erhalten
     * @param nachname Ist der Nachname der Person
     * @return Gibt den Nachnamen wieder
     */
    public String getNachname (String nachname) {
        return nachname;
    }
    
    /**
     * set-Methode um den Vornamen einer Person zu aendern
     * @param vorname Ist der Vorname der Person, welcher geaendert werden soll
     */
    public void setVorname (String vorname) {
        this.vorname = vorname;
    }
    
    /**
     * set-Methode um den Nachnamen der Person zu aendern
     * @param nachname Ist der Nachname der Person, welcher geaendert werden soll
     */
    public void setNachname (String nachname) {
        this.nachname = nachname;
    }
}