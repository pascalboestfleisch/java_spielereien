
/**
 * Beschreiben Sie hier die Klasse PersonQueueMain.
 * 
 * @author pascal boestfleisch, emma ebel
 * @version Uebung 10
 */
public class PersonQueueMain
{
   public Person[] personArray;
   private int maxQueueSpots;
   /**
    * Konstruktor fuer das Warteschlangen-Array
    */
   public PersonQueueMain (int maxQueueSpots){
       if ((maxQueueSpots < 0) || (maxQueueSpots == 0)){
           throw new IllegalArgumentException("Die Anzahl der Warteschlangeplaetze darf nicht 0 oder negativ sein!");
       }
       personArray = new Person[maxQueueSpots];
   }
}
