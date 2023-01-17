
/**
 * Beschreiben Sie hier die Klasse StringQueueMain.
 * 
 * @author pascal boestfleisch, emma ebel 
 * @version Uebung 10
 */
public class StringQueueMain
{
    private String[] stringArray;
    private int maxQueueSpots;

    /**
     * Konstruktor fuer das String-Warteschlangen-Array
     * @param queueSpots User bestimmt die Groesse des Warteschlangen-Arrays
     */
    public StringQueueMain (int maxQueueSpots){
        if ((maxQueueSpots < 0) || (maxQueueSpots == 0)){
           throw new IllegalArgumentException("Die Anzahl der Warteschlangeplaetze darf nicht 0 oder negativ sein!");
       }
       this.stringArray = new String[maxQueueSpots];
    }
}
