/**
 * Legt ein Warteschlangen-Array an und fuegt Person-Objekte hinein etc.
 * 
 * @author boestfleisch pascal, ebel emma 
 * @version Uebung 10
 */
public abstract class PersonQueue implements Queue{
    public Person[] personArray;
    private int maxQueueSpots;
    private int personenAnzahl = 0;
    PersonQueueMain personqueuemain;
    
    /**
     * Fuegt eine Person an das Ende des Warteschlangen-Arrays hinzu
     * @param Person person Bezieht sich auf das Person-Objekt, welches in der Klasse Person erstellt wird
     */
    public void addLast (Person person){
        personArray[personenAnzahl] = person;
        personenAnzahl++;
    }
    
    /**
     * Entfernt ein Person-Objekt, welches im Warteschlangen-Array an erster Stelle steht
     * @return Gibt entferntes Person-Objekt wieder
     */
    public Person removeFirst(){
       Person removePerson = personqueuemain.personArray[0];
       for(int i = 0; i < personqueuemain.personArray.length -1;i++){
           if(i >= 0){
               personqueuemain.personArray[i]=personqueuemain.personArray[i+1];
           }
       }
       return removePerson;
    }
    
    /**
     * Ermittelt den Momenten Platz eines Person-Objektes im Warteschlangen-Arrays
     * @param i Ist die Stelle, welche ueberprueft werden soll
     * @return Gibt die Stelle im Warteschlangen-Array an
     */
    public Person get(int i){
        return personqueuemain.personArray[i];
    }
    
    /**
     * Ueberprueft ob das Warteschlangen-Array leer ist
     * @return Gibt je nach Situation true oder false wieder
     */
    public boolean empty(){
        return personqueuemain.personArray[0] == null;
    }
    
    /**
     * Ueberprueft ob das Warteschlangen-Array voll ist
     * @return Gibt je nach Situation true oder false wieder
     */
    public boolean full(){
        return personqueuemain.personArray[maxQueueSpots-1] != null;
    }
    
    /**
     * Ermittelt die Groesse des Warteschlangen-Arrays
     * @return Gibt die Groesse des Warteschlangen-Arrays wieder
     */
    public int size(){
        return personenAnzahl;
    }
    
    /**
     * Geht das Warteschlangen-Array durch und gibt es wieder
     * @return Gibt Warteschlangen-Array wieder
     */
    public void print(){
        return;
    }
}