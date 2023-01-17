/**
 * Beschreiben Sie hier die Klasse InterfaceQueue.
 * 
 * @author boestfleisch pascal, ebel emma 
 * @version Uebung 10
 */

public interface Queue {
    //Objekt hinten einfuegen
    public void addLast (Object o);
    
    //entfernt das erste Element und gibt eine Referenz darauf zurueck
    public Object removeFirst();
    
    //Das i-te Element zurueckgeben
    public Object get (int i);
    
    //Testen, ob schon Elemente eingefuegt wurden
    public boolean empty();
    
    //Testen, ob noch Elemente einfuegbar sind
    public boolean full();
    
    //Anzahl eingefuegter Elemente
    public int size();
    
    //Gibt die Warteschlange wieder
    public void print(Queue q);
    }