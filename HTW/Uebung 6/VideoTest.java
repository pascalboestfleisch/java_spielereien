import static org.junit.Assert.*;
import org.junit.Test;
/**
 * Die Test-Klasse VideoTest.
 *
 * @author  pascal boestfleisch, emma ebel
 * @version Uebung09
 */
public class VideoTest
{
    @Test
    public void test_Konstruktor_Video_titel_Max_sollte_gueltig_sein(){
        final String erwarteterTitel = "Max";
        Artikel video = new Video(1234, 20, 30, erwarteterTitel, 70 , 2021);
        
        final String tatsaechlicherTitel = video.getBeschreibung();
        assertEquals(erwarteterTitel, tatsaechlicherTitel);
    }
    
    //Fehlermeldung, da Titel nicht leer sein darf
    @Test (expected = IllegalArgumentException.class)
    public void test_Konstruktor_Video_titel_leer_sollte_exception_werfen(){
        final String erwarteterTitel = "";
        Artikel video = new Video(8324, 22, 11, erwarteterTitel, 92 , 2020);
        
        final String tatsaechlicherTitel = video.getBeschreibung();
        assertEquals(erwarteterTitel, tatsaechlicherTitel);
    }
    
    @Test
    public void test_Konstruktor_Video_spieldauer_60_sollte_gueltig_sein(){
        final int erwarteteSpieldauer = 60;
        Artikel video = new Video(9123, 33, 55, "Fleischkaes", erwarteteSpieldauer , 1991);
        
        final int tatsaechlicheSpieldauer = video.getSpieldauer();
        assertEquals(erwarteteSpieldauer, tatsaechlicheSpieldauer);
    }
    
    //Fehlermeldung, da die Spieldauer nicht negativ sein darf
    @Test(expected = IllegalArgumentException.class)
    public void test_Konstruktor_Video_spieldauer_negativ_2_sollte_exception_werfen(){
        final int erwarteteSpieldauer = -2;
        Artikel video = new Video(1125, 61, 71, "Spiderman", erwarteteSpieldauer , 2000);
        
        final int tatsaechlicheSpieldauer = video.getSpieldauer();
        assertEquals(erwarteteSpieldauer, tatsaechlicheSpieldauer);
    }
    
    @Test
    public void test_Konstruktor_Video_jahr_2003_sollte_gueltig_sein(){
        final int erwartetesJahr = 2000;
        Artikel video = new Video(4412, 33, 55, "Kindskoepfe", 60 , erwartetesJahr);
        
        final int tatsaechlichesJahr = video.getJahr();
        assertEquals(erwartetesJahr, tatsaechlichesJahr);
    }
    
    @Test
    public void test_Konstruktor_Video_jahr_2022_sollte_gueltig_sein(){
        final int erwartetesJahr = 2022;
        Artikel video = new Video(4412, 33, 55, "Kindskoepfe", 60 , erwartetesJahr);
        
        final int tatsaechlichesJahr = video.getJahr();
        assertEquals(erwartetesJahr, tatsaechlichesJahr);
    }
    
    @Test
    public void test_Konstruktor_Video_jahr_1900_sollte_gueltig_sein(){
        final int erwartetesJahr = 1900;
        Artikel video = new Video(4412, 33, 55, "Kindskoepfe", 60 , erwartetesJahr);
        
        final int tatsaechlichesJahr = video.getJahr();
        assertEquals(erwartetesJahr, tatsaechlichesJahr);
    }
    
    //Fehlermeldung, da 1899 nicht eingeschlossen ist
    @Test(expected = IllegalArgumentException.class)
    public void test_Konstruktor_Video_jahr_1899_sollte_exception_werfen(){
        final int erwartetesJahr = 1899;
        Artikel video = new Video(4412, 33, 55, "Kindskoepfe", 60 , erwartetesJahr);
        
        final int tatsaechlichesJahr = video.getJahr();
        assertEquals(erwartetesJahr, tatsaechlichesJahr);
    }
    
    //Fehlermeldung, da 2023 nicht eingeschlossen ist
    @Test(expected = IllegalArgumentException.class)
    public void test_Konstruktor_Video_jahr_2023_sollte_exception_werfen(){
        final int erwartetesJahr = 2023;
        Artikel video = new Video(4412, 33, 55, "Kindskoepfe", 60 , erwartetesJahr);
        
        final int tatsaechlichesJahr = video.getJahr();
        assertEquals(erwartetesJahr, tatsaechlichesJahr);
    }
}
