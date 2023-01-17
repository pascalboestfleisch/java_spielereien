
/**
 * Beschreiben Sie hier die Klasse VornameNachname.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
import java.util.Scanner;
public class VornameNachname
{
    private String vorname, nachname;
    private final int Jahr = 2021;
    
    public static void main (String [] args) {
        Scanner sc = new Scanner (System.in);
        Scanner scanner = new Scanner (System.in);
        
        System.out.println ("Ihr Vorname: ");
        String vorname = sc.nextLine();
        
        System.out.println ("Ihr Nachname: ");
        String nachname = sc.nextLine();
        
        System.out.println ("Ihr Geburtsjahr: ");
        int geburtsjahr = scanner.nextInt();
        
        System.out.println ("Sie heißen: " + nachname + ", " + vorname);
        
        int Jahr = 2021;
        
        int alter = Jahr - geburtsjahr;
        System.out.println ("Sie sind " + alter + " Jahre alt");
        
    
        
        
    
    
    
    }
    
}
