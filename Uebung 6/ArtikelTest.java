import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Die Test-Klasse ArtikelTest.
 *
 * @pascal.boestfleisch @emma.ebel
 * @Übung 6
 */
public class ArtikelTest
{
    //Überprüfung korrekter Datenaufnahme im Konstruktor
    @Test
    public void test_Konstruktor_Artikel_artikelnummer_2021_erwartet_korrekt() {
        final int erwarteteArtikelnummer = 2021;
        Artikel artikel = new Artikel(erwarteteArtikelnummer, "Tom", 0, 1);
        
        final int tatsaechlicheArtikelnummer = artikel.getArtikelNr();
        assertEquals(erwarteteArtikelnummer, tatsaechlicheArtikelnummer);
    }
    
    @Test
    public void test_Konstruktor_Artikel_artikelnummer_4857_erwartet_korrekt() {
        final int erwarteteArtikelnummer = 4857;
        Artikel artikel = new Artikel(erwarteteArtikelnummer, "Tom", 0, 1);
        
        final int tatsaechlicheArtikelnummer = artikel.getArtikelNr();
        assertEquals(erwarteteArtikelnummer, tatsaechlicheArtikelnummer);
    }
    
    @Test
    public void test_Konstruktor_Artikel_artikelnummer_1158_erwartet_korrekt() {
        final int erwarteteArtikelnummer = 1158;
        Artikel artikel = new Artikel(erwarteteArtikelnummer, "Tom", 0, 1);
        
        final int tatsaechlicheArtikelnummer = artikel.getArtikelNr();
        assertEquals(erwarteteArtikelnummer, tatsaechlicheArtikelnummer);
    }
    
    @Test
    public void test_Konstruktor_Artikel_bestand_921_erwartet_korrekt() {
        final int erwarteterBestand = 921;
        Artikel artikel = new Artikel(9231, "Tom", 921, 1);
        
        final int tatsaechlicherBestand = artikel.getBestand();
        assertEquals(erwarteterBestand, tatsaechlicherBestand);
    }
    
     @Test
    public void test_Konstruktor_Artikel_bestand_44213_erwartet_korrekt() {
        final int erwarteterBestand = 44213;
        Artikel artikel = new Artikel(6947, "Tim", 44213, 1);
        
        final int tatsaechlicherBestand = artikel.getBestand();
        assertEquals(erwarteterBestand, tatsaechlicherBestand);
    }
    
     @Test
    public void test_Konstruktor_Artikel_bestand_25162312_erwartet_korrekt() {
        final int erwarteterBestand = 25162312;
        Artikel artikel = new Artikel(1286, "Papier", 25162312, 1);
        
        final int tatsaechlicherBestand = artikel.getBestand();
        assertEquals(erwarteterBestand, tatsaechlicherBestand);
    }
    
    //Fehlerfälle im Konstruktor sollten Exception werfen
    @Test(expected = IllegalArgumentException.class)
    public void test_Konstruktor_Artikel_artikelnummer_502_sollte_exception_werfen() {
        new Artikel(502, "Mond", 0, 1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_Konstruktor_Artikel_artikelnummer_92315_sollte_exception_werfen() {
        new Artikel(92315, "Affe", 0, 1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_Konstruktor_Artikel_artikelnummer_negativ_4091_sollte_exception_werfen() {
        new Artikel(-4091, "Löwe", 0, 1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_Konstruktor_Artikel_artikelnummer_0000_sollte_exception_werfen() {
        new Artikel(0000, "Elefant", 0, 1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_Konstruktor_Artikel_bestand_negativ_20_sollte_exception_werfen() {
        new Artikel(9312, "Bier", -20, 1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_Konstruktor_Artikel_bestand_negativ_1_sollte_exception_werfen() {
        new Artikel(9412, "Urpils", -1, 1);
    }
    
    //Korrektheit von Abgängen überprüfen
    @Test
    public void test_bucheAbgang_Artikel_bestand_300_erwartet_korrekt() {
        final int erwarteterBestand = 300;
        Artikel artikel = new Artikel(3021, "Tom", 500, 1);
        
        artikel.bucheAbgang(200);
        final int tatsaechlicherBestand = artikel.getBestand();
        assertEquals(erwarteterBestand, tatsaechlicherBestand);
    }
    
    @Test
    public void test_bucheAbgang_Artikel_bestand_591_erwartet_korrekt() {
        final int erwarteterBestand = 591;
        Artikel artikel = new Artikel(6841, "Ball", 942, 1);
        
        artikel.bucheAbgang(351);
        final int tatsaechlicherBestand = artikel.getBestand();
        assertEquals(erwarteterBestand, tatsaechlicherBestand);
    }
    
    @Test
    public void test_bucheAbgang_Artikel_bestand_49231_erwartet_korrekt() {
        final int erwarteterBestand = 49231;
        Artikel artikel = new Artikel(5888, "Kugel", 92955, 1);
        
        artikel.bucheAbgang(43724);
        final int tatsaechlicherBestand = artikel.getBestand();
        assertEquals(erwarteterBestand, tatsaechlicherBestand);
    }
    
    //Fehlerfälle beim Abgang sollten Exceptions werfen
    
    @Test(expected= IllegalArgumentException.class)
    public void test_bucheAbgang_Artikel_negativer_bestand_negativ_100_sollte_exception_werfen(){
        Artikel artikel = new Artikel(5923, "Affe", 300, 1);
        artikel.bucheAbgang(400);
    }
    
    @Test(expected= IllegalArgumentException.class)
    public void test_bucheAbgang_Artikel_negativer_bestand_negativ_1_sollte_exception_werfen(){
        Artikel artikel = new Artikel(5923, "Affe", 300, 1);
        artikel.bucheAbgang(301);
    }
    
    //Korrektheit bei Zugängen überprüfen
    @Test
    public void test_bucheZugang_Artikel_bestand_999_erwartet_korrekt() {
        final int erwarteterBestand = 999;
        Artikel artikel = new Artikel(4957, "Tom", 269, 1);
        
        artikel.bucheZugang(730);
        final int tatsaechlicherBestand = artikel.getBestand();
        assertEquals(erwarteterBestand, tatsaechlicherBestand);
    }
    
    //Negativer Zugang übergeben sollte Exception werfen
    @Test(expected= IllegalArgumentException.class)
    public void test_bucheZugang_Artikel_negativer_Zugang_sollte_exception_werfen(){
        Artikel artikel = new Artikel(5552, "Motorrad", 502, 1);
        artikel.bucheZugang(-400);
    }
}
