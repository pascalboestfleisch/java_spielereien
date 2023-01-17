
/**
 * Warteschlangen-Array als String
 * 
 * @author pascal boestfleisch, emma ebel 
 * @version Uebung 10
 */
public abstract class StringQueue implements Queue{
    private String[] stringArray;
    private final static int MAX_DEFAULT = 10;
    int maxQueueSpots;
    int stringAnzahl = 0;

    /**
     * Konstruktor fuer das String-Warteschlangen-Array
     * @param queueSpots User bestimmt die Groesse des Warteschlangen-Arrays
     */
    public StringQueue (int queueSpots){
       if ((maxQueueSpots < 0 || (maxQueueSpots == 0))){
           throw new IllegalArgumentException("Die Anzahl der Warteschlangeplaetze darf nicht 0 oder negativ sein!");
       }
       this.stringArray = new String[queueSpots];
       this.maxQueueSpots  = queueSpots;
    }

     /**
     * Fuegt eine Person an das Ende des String-Warteschlangen-Arrays hinzu
     * @param String string Bezieht sich auf das String-Objekt
     */
    public void addLast (String string){
        stringArray[stringAnzahl] = string;
        stringAnzahl++;
    }

    /**
     * Entfernt ein String-Objekt, welches im String-Warteschlangen-Array an erster Stelle steht
     * @return Gibt entferntes String-Objekt wieder
     */
    public String removeFirst(){
       String removeString = this.stringArray[0];
       for(int i = 0; i < this.stringArray.length -1;i++){
           if(i >= 0){
               this.stringArray[i]=this.stringArray[i+1];
           }
       }
       return removeString;
    }

    /**
     * Ermittelt den Momenten Platz eines String-Objektes im String-Warteschlangen-Arrays
     * @param i Ist die Stelle, welche ueberprueft werden soll
     * @return Gibt die Stelle im String-Warteschlangen-Array an
     */
    public String get(int i){
        return this.stringArray[i];
    }

    /**
     * Ueberprueft ob das String-Warteschlangen-Array leer ist
     * @return Gibt je nach Situation true oder false wieder
     */
    public boolean empty(){
        return this.stringArray[0] == null;
    }

    /**
     * Ueberprueft ob das String-Warteschlangen-Array voll ist
     * @return Gibt je nach Situation true oder false wieder
     */
    public boolean full(){
        return this.stringArray[maxQueueSpots-1] != null;
    }

    /**
     * Ermittelt die Groesse des String-Warteschlangen-Arrays
     * @return Gibt die Groesse des String-Warteschlangen-Arrays wieder
     */
    public int size(){
        return stringAnzahl;
    }

    /**
     * Geht durch das String-Warteschlangen-Array und gibt es wieder
     * @return Gibt das String-Warteschlangen-Array durch und gibt es wieder
     */
    public void print(){
        return;
    }
}
