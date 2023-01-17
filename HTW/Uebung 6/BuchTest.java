import static org.junit.Assert.*;
import org.junit.Test;
/**
 * Die Test-Klasse BuchTest.
 *
 * @author  pascal boestfleisch, emma ebel
 * @version Uebung09
 */
public class BuchTest {
    @Test
    public void test_Konstruktor_Buch_autor_Max_sollte_gueltig_sein(){
        final String erwarteterAutor = "Max";
        Artikel buch = new Buch(1234, 20, 30, erwarteterAutor, "Tom", "Karlsen");
        
        final String tatsaechlicherAutor = buch.getAutor();
        assertEquals(erwarteterAutor, tatsaechlicherAutor);
    }
    
    @Test
    public void test_Konstruktor_Buch_titel_Affe_sollte_gueltig_sein(){
        final String erwarteterTitel = "Affe";
        Artikel buch = new Buch(4123, 33, 11, "Tom", erwarteterTitel, "Urpils");
        
        final String tatsaechlicherTitel = buch.getTitel();
        assertEquals(erwarteterTitel, tatsaechlicherTitel);
    }
    
    @Test
    public void test_Konstruktor_Buch_verlag_Sesam_sollte_gueltig_sein(){
        final String erwarteterVerlag = "Sesam";
        Artikel buch = new Buch(1526, 98, 72, "Tom", "Gibby", erwarteterVerlag);
        
        final String tatsaechlicherVerlag = buch.getVerlag();
        assertEquals(erwarteterVerlag, tatsaechlicherVerlag);
    }
    
    //Fehlermeldung sollte auftreten, da der Autor nicht leer sein darf
    @Test (expected = IllegalArgumentException.class)
    public void test_Konstruktor_Buch_autor_leer_sollte_exception_werfen(){
        Artikel buch = new Buch(1526, 98, 72, "", "Gibby", "Tommy");
    }
    
    //Fehlermeldung sollte auftreten, da der Titel nicht leer sein darf
    @Test (expected = IllegalArgumentException.class)
    public void test_Konstruktor_Buch_titel_leer_sollte_exception_werfen(){
        Artikel buch = new Buch(5772, 18, 5, "Mayo", "", "Tommy");
    }
    
    //Fehlermeldung sollte auftreten, da der Verlag nicht leer sein darf
     @Test (expected = IllegalArgumentException.class)
    public void test_Konstruktor_Buch_verlag_leer_sollte_exception_werfen(){
        Artikel buch = new Buch(6612, 1, 2, "Mayo", "Pils", "");
    }
}
