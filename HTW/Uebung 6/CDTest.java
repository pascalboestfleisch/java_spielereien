import static org.junit.Assert.*;
import org.junit.Test;
/**
 * Die Test-Klasse CDTest.
 *
* @author  pascal boestfleisch, emma ebel
 * @version Uebung09
 */
public class CDTest
{
    @Test
    public void test_Konstruktor_CD_interpret_Max_sollte_gueltig_sein(){
        final String erwarteterInterpret = "Max";
        Artikel cd = new CD(1234, 20, 30, erwarteterInterpret, "Tom", 12);
        
        final String tatsaechlicherInterpret = cd.getInterpret();
        assertEquals(erwarteterInterpret, tatsaechlicherInterpret);
    }
    
    //Fehlermeldung, da der Interpret nicht leer sein darf
    @Test(expected = IllegalArgumentException.class)
    public void test_Konstruktor_CD_interpret_leer_sollte_exception_werfen(){
        final String erwarteterInterpret = "";
        Artikel cd = new CD(1234, 20, 30, erwarteterInterpret, "Tom", 12);
        
        final String tatsaechlicherInterpret = cd.getInterpret();
        assertEquals(erwarteterInterpret, tatsaechlicherInterpret);
    }
    
    @Test
    public void test_Konstruktor_CD_titel_Eclipse_sollte_gueltig_sein(){
        final String erwarteterTitel = "Eclipse";
        Artikel cd = new CD(1234, 20, 30, "Nujabes", erwarteterTitel, 12);
        
        final String tatsaechlicherTitel = cd.getTitel();
        assertEquals(erwarteterTitel, tatsaechlicherTitel);
    }
    
    //Fehlermeldung, da der Titel nicht leer sein darf
    @Test(expected = IllegalArgumentException.class)
    public void test_Konstruktor_CD_titel_leer_sollte_exception_werfen(){
        final String erwarteterTitel = "";
        Artikel cd = new CD(1234, 20, 30, "Nujabes", erwarteterTitel, 12);
        
        final String tatsaechlicherTitel = cd.getTitel();
        assertEquals(erwarteterTitel, tatsaechlicherTitel);
    }
    
    @Test
    public void test_Konstruktor_CD_anzahlTitel_20_sollte_gueltig_sein(){
        final int erwarteteAnzahlTitel = 20;
        Artikel cd = new CD(1234, 20, 30, "Nujabes", "luvsic", erwarteteAnzahlTitel);
        
        final int tatsaechlicheAnzahlTitel = cd.getAnzahlTitel();
        assertEquals(erwarteteAnzahlTitel, tatsaechlicheAnzahlTitel);
    }
    
    //Fehlermeldung, da die Anzahl der Titel nicht negativ sein darf
    @Test(expected = IllegalArgumentException.class)
    public void test_Konstruktor_CD_anzahlTitel_negativ_10_sollte_exception_werfen(){
        final int erwarteteAnzahlTitel = -10;
        Artikel cd = new CD(1234, 20, 30, "Nujabes", "luvsic", erwarteteAnzahlTitel);
        
        final int tatsaechlicheAnzahlTitel = cd.getAnzahlTitel();
        assertEquals(erwarteteAnzahlTitel, tatsaechlicheAnzahlTitel);
    }
}
