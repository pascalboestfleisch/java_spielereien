
/**
 * Beschreiben Sie hier die Klasse Teilersumme.
 * 
 * @author pascal boestfleisch, emma ebel
 * @version Uebung 11
 */
public class Teilersumme
{
    //Test fuer die Lines of code Auswertung
    public long berechneTeilersumme(long zahl) {
        long sum = 0;
        if (zahl < 0) {
            throw new IllegalArgumentException("Zahl darf nicht negativ sein!");
        } else {
            for (long i = 1; i <= zahl; i++) {
                if (zahl % i == 0){
                    sum += i;
                }
            }
        }
        return sum;
    }
}
