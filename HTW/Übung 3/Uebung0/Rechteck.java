
/**
 * Beschreiben Sie hier die Klasse Rechner.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
import java.util.Scanner;
public class Rechteck
{

    public static void main (String [] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.println ("Laenge der Seite a:");
        double seiteA = scanner.nextDouble();
        
        System.out.println ("Laenge der Seite b:");
        double seiteB = scanner.nextDouble();
        
        System.out.println ("Das Rechteck hat die Folgenden Seiten:");
        System.out.println ("a: " + seiteA);
        System.out.println ("b: " + seiteB);
    
        double flaecheninhalt = seiteA * seiteB;
        double umfang = 2 * seiteA + 2 * seiteB;
        
        System.out.println ("Flaecheninhalt A = " + flaecheninhalt + " qcm");
        System.out.println ("Umfang U = " + umfang + " cm");
    
        }
    }
    
    


