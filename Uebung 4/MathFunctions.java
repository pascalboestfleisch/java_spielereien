import java.lang.Math;
/**
 * Klasse zum Berechnen von Teilsummen, Nullstellen und zum Prüfen einer ISBN-10
 * 
 * @author @pascal.boestfleisch, @emma.ebel
 * @version Uebung 4
 */

public class MathFunctions {
    private static long zahl;
    private static long isbn;
    private static double p;
    private static double q;
    private static int anzahl;
    private static double x;
    private static int zahl1;
    private static int zahl2;
    private static final long ISBN_MIN = 100000000L;
    private static final long ISBN_MAX = 999999999L;
    
    /**
     * Privater Konstruktor, da kein weiteres Objekt hinzugefügt werden soll
     */
    private MathFunctions() {
    }
    
    /**
     * Berechnet die Teilersumme von der vom User eingegebenen Zahl
     * Die Methode wird bei negativen Zahlen abgebrochen
     * i fängt bei 1 an, da man nicht durch 0 teilen darf
     * Wenn i kleiner als die vom User eingegebene Zahl ist, wird i um 1 addiert und weiter gerechnet
     * Wenn der mod der Zahl und i 0 ergibt, wird i auf den Wert der Summe addiert und somit erhält man die Teilersumme
     * @param long zahl ist der vom User angegebene Wert, mit dem gerechnet wird
     * @return gibt den Wert der Summe nach der Addition mit i an
     */
    public static long berechneTeilersumme(long zahl) {
        long sum = 0;  
        if (zahl < 0) {
              throw new IllegalArgumentException("Zahl darf nicht negativ sein!");
        }else{
              for (long i = 1; i <= zahl; i++){
                    if (zahl % i == 0){
                        sum += i;
                    }
              }
        }
        return sum;
        }
    
    /**
     * Gibt eine Fehlermeldung bei falschen Angaben
     * i sind die Stellen, mit denen gerechnet wird.
     * Solange i größer 0 ist, wird i um 1 subtrahiert und weiter gerechnet
     * isbn % 10 gibt die Stelle an, welche als nächstes mit i multipliziert und anschließend zur Summe addiert wird
     * isbn / 10 bereitet die nächste Stelle vor
     * Die for-Schleife bewirkt, dass dieser Vorgang bis zum gewünschten Ergebnis fortgeführt wird
     * @param isbn ist die Eingabe vom User
     * @return gibt long als String aus
     */
    public static String berechneChecksummeIsbn(long isbn) {
        long sum = 0;
        long pruefZiffer = 0;
        long pruefendeZahl = isbn;
        long i = 9;
        if ((isbn < ISBN_MIN) || (isbn > ISBN_MAX)) {
            throw new IllegalArgumentException("ISBN muss aus 9 Zeichen bestehen!");
        }
        if(isbn < 0) {
             throw new IllegalArgumentException("ISBN darf nicht negativ sein!");
        }else{
             for (i = 9; i >= 0; i--) {
                    long stelle = isbn % 10;
                    sum = sum + i * stelle;
                    isbn = isbn / 10;
                }
             pruefZiffer = sum % 11;
        }  
        if (pruefZiffer == 10) {
            pruefZiffer = 10;
            return ("x");
        } 
        String longString = String.valueOf(pruefZiffer);
        return "" + pruefZiffer;
        }
     
    /**
     * Wenn die Diskriminante d größer 0 ist, sind es reele Nullstellen
     * Wenn die Diskriminante d gleich 0 ist, gibt es doppelte Nullstellen
     * Wenn die Diskriminante d kleiner 0 ist, sind dort komplexe Nullstellen aufzufinden
     * Die geschriebene Methode verwendet die PQ-Formel zum Berechnen der jeweiligen Nullstellen
     * @param double p steht für die erste Eingabe des Users
     * @param double q steht für die zweite Eingabe des Users
     */
    public static String berechneNullstellen(double p, double q) {
        double x1 = 0;
        double x2 = 0;
        double  d = Math.pow(q/2,2) - q;
        if(d > 0){
            x1 = -(p/2)-Math.sqrt(d);
            x2 = -(p/2)+Math.sqrt(d);
            return("Zwei reele Nullstellen: " + x1 + "|" + x2);
        }else if(d == 0){
            x1 = -(p/2)+Math.sqrt(d);
            return("Doppelte Nullstelle: " + x1);
        }else if(d < 0){
            x1 = -(p/2)+Math.sqrt(d);
            x2 = -(p/2)-Math.sqrt(d);
            return("Zwei komplexe Nullstellen!");
        }
        return ("P: " + p + "Q: " + q);
    }
        
    public static boolean istSummeVonPotenzen(long zahl) {
       long a = 1;
       long b = 1;
       long c = 1;
       //long left = 1L;
       //long right = zahl;
       //long generatedLong = left + (long) (Math.random() * (right - left));
       if ((zahl < 0) || (zahl == 0)) {
            throw new IllegalArgumentException("Nur natürliche und ganze Zahlen!");
       }else{
           for (long i = 1; i == zahl; i++) {
                a = a*i + a*i + a*i + a*i;
           }
           for (long i = 1; i == zahl; i++) {
                b = b*i + b*i + b*i;
           }
           for (long i = 1; i == zahl; i++) {
                c = c*i + c*i;
           }
        }
       if (zahl == a+b+c) {
           return true;
       }else {
           return false;
       }
    }
    
    /**
     * Wenn zahl1 0 ist, wird zahl2 ausgegeben und umgekehrt
     * Die groessere der beiden Zahlen wird durch die kleinere Zahl subtrahiert und das Ergebnis ist der ggT
     * @param int zahl1 erste Eingabe vom User
     * @param int zahl2 zweite Eingabe vom User
     * @return zahl1 gibt den groessten gemeinsamen Teiler an
     */
    public static int berechneGgt(int zahl1, int zahl2) {
        if ((zahl1 < 0) || (zahl2 < 0)){
           throw new IllegalArgumentException("Zahlen dürfen nicht negativ sein!");
        }else{
           if (zahl1 == 0){
               return zahl2;
           }while (zahl2 != 0) {
               if (zahl1 > zahl2) {
                    zahl1 = zahl1 - zahl2;
               }else {
                    zahl2 = zahl2 - zahl1;
               }
           }
           return zahl1;
        }
    }
    
    /**
     * i startet bei 1 und wird so lange erhoeht, bis sie die Zahl des Users entspricht. 
     * Wenn die Zahl 0 ist, wird 1 ausgegeben.
     * Wenn nicht, dann wird die Summe mit i multipliziert um die Fakultaet zu erhalten
     * @param int zahl ist die vom User eingegebene Zahl
     * @return sum zeigt das Ergebnis, welche die Methode ausgerechnet hat
     */
    public static long berechneFakultaet(int zahl) {
        int sum = 1;
        if (zahl < 0) {   
            throw new IllegalArgumentException ("Zahl darf nicht negativ sein!");
        }else{
            for (int i = 1; i <= zahl; i++) {
                if (zahl == 0) {
                    sum = 1;
                } else {
                    sum = sum * i;
                }
            }
        }
        return sum;
    }
    
    public static double berechneReihensumme(int anzahl, double x) {
        double i = 1;
        double y = 0;
        double z = 0;
        double j = (x - 1) * i;
        double k = (i * x) * i;
        double sum = 0;
        if ((anzahl < 0) || (x < 0)) {
            throw new IllegalArgumentException("Zahl darf nicht negativ sein"); 
        }
        else{
            for (i = 1; i <= anzahl; i++) {
                y = j;
                z = k;
                sum += y / z;
            }
            return sum;
        }
    }
}




    

