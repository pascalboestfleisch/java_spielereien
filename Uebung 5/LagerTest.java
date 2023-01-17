import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Die Test-Klasse LagerTest.
 *
 * @pascal.boestfleisch @emma.ebel
 * @Übung 6
 */
public class LagerTest
{
    private final double DELTA = 1e-15;
    //Korrektheit der Angaben im Konstruktor überprüfen
    @Test
    public void test_Konstruktor_Lager_lagergroesse_15_sollte_gueltig_sein(){
        final int erwarteteMaxAnzahl = 15;
        Lager lager = new Lager(erwarteteMaxAnzahl);
        
        final int tatsaechlicheMaxAnzahl = lager.getLagerGroesse();
        assertEquals(erwarteteMaxAnzahl, tatsaechlicheMaxAnzahl);
    }
    
    @Test
    public void test_Konstruktor_Lager_lagergroesse_61_sollte_gueltig_sein(){
        final int erwarteteMaxAnzahl = 61;
        Lager lager = new Lager(erwarteteMaxAnzahl);
        
        final int tatsaechlicheMaxAnzahl = lager.getLagerGroesse();
        assertEquals(erwarteteMaxAnzahl, tatsaechlicheMaxAnzahl);
    }
    
    @Test
    public void test_Konstruktor_Lager_lagergroesse_9923_sollte_gueltig_sein(){
        final int erwarteteMaxAnzahl = 9923;
        Lager lager = new Lager(erwarteteMaxAnzahl);
        
        final int tatsaechlicheMaxAnzahl = lager.getLagerGroesse();
        assertEquals(erwarteteMaxAnzahl, tatsaechlicheMaxAnzahl);
    }
    
    @Test
    public void test_Konstruktor_Lager_defaultgroesse_10_sollte_gueltig_sein(){
        final int erwarteteDefaultGroesse = 10;
        Lager lager = new Lager();
        
        final int tatsaechlicheMaxAnzahl = lager.getLagerGroesse();
        assertEquals(erwarteteDefaultGroesse, tatsaechlicheMaxAnzahl);
    }
    
    //Fehlermeldung bei ungültiger Lagergröße sollten Exceptions werfen
    @Test(expected = IllegalArgumentException.class)
    public void test_Konstruktor_Lager_lagergroesse_negative_angaben_sollten_exceptions_werfen() {
        new Lager(-20);
    }
    
    //Artikel wird angelegt und überprüft, ob es diesen Artikel bereits im Lager gibt
    @Test
    public void test_legeAnArtikel_Lager_nicht_vorhandenen_artikel_anlegen_sollte_korrekt_sein() {
        final int erwarteteAnzahl = 1;
        Lager lager = new Lager(15);
        Artikel artikel = new Artikel(2015, "Tom", 0, 1);
        lager.legeAnArtikel(artikel);
        final int tatsaechlicheAnzahl = lager.getArtikelAnzahl();
        assertEquals(erwarteteAnzahl, tatsaechlicheAnzahl);
    }
    
    //Artikelnummer, welche es bereits im Array gibt, sollte Exception werfen
    @Test (expected = IllegalArgumentException.class)
    public void test_legeAnArtikel_Lager_bereits_vorhandener_artikel_sollte_exception_werfen() {
        Lager lager = new Lager();
        Artikel artikel = new Artikel(9951, "Kaffee", 20, 10);
        lager.legeAnArtikel(artikel);
        new Artikel(9951, "Kühe", 33, 51);
        lager.legeAnArtikel(artikel);
    }
    
    //Weitere Artikel in ein volles Lager anlegen sollte Exception werfen
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void test_legeAnArtikel_Lager_artikel_anlegen_wenn_lager_voll_sollte_exception_werfen() {
        Lager lager = new Lager(1);
        Artikel artikel = new Artikel(9123, "Affe", 0, 1);
        lager.legeAnArtikel(artikel);
        new Artikel(9241, "Mond", 51, 20);
        lager.legeAnArtikel(artikel);
    }
    
    //Es wird geprüft, ob ein angelegter Artikel aus dem Lager entfernt wird
    @Test
    public void test_entferneArtikel_Lager_artikel_aus_lager_entfernen_sollte_korrekt_sein() {
        final int erwarteteAnzahl = 0;
        Lager lager = new Lager();
        Artikel artikel = new Artikel(2021, "Tim", 0 ,1);
        lager.legeAnArtikel(artikel);
        lager.entferneArtikel(2021);
        final int tatsaechlicheAnzahl = lager.getArtikelAnzahl();
        assertEquals(erwarteteAnzahl, tatsaechlicheAnzahl);
    }
    
    //Bei ungültiger Artikelnummer sollte beim Entfernen des Artikels eine Exception geworfen werden
    @Test(expected = NullPointerException.class)
    public void test_entferneArtikel_Lager_ungueltige_artikelnummer_sollte_exception_werfen() {
        Lager lager = new Lager();
        Artikel artikel = new Artikel(2021, "Tim", 0 ,1);
        lager.legeAnArtikel(artikel);
        lager.entferneArtikel(5021);
    }
    
    //Überprüfung ob ein Artikel im Lager einen gültigen Zugang erhält
    @Test
    public void test_bucheZugang_Lager_gueltiger_Zugang_500_eines_artikels_im_lager_sollte_korrekt_sein() {
        final int erwarteterBestand = 621;
        Lager lager = new Lager();
        Artikel artikel = new Artikel(2021, "Tim", 121 ,1);
        lager.legeAnArtikel(artikel);
        lager.bucheZugang(2021, 500);
        final int tatsaechlicherBestand = artikel.getBestand();
        assertEquals(erwarteterBestand, tatsaechlicherBestand);
    }
    
    //Fehlermeldung bei ungültigem Zugang
    @Test (expected = IllegalArgumentException.class)
    public void test_bucheZugang_Lager_ungueltiger_Zugang_negativ_500_eines_artikels_sollte_exception_werfen() {
        Lager lager = new Lager();
        Artikel artikel = new Artikel(3033, "Tom", 121, 1);
        lager.legeAnArtikel(artikel);
        lager.bucheZugang(3033, -500);
    }
    
    //Überprüfung ob ein Artikel im Lager einen gültigen Abgang erhält
    @Test
    public void test_bucheAbgang_Lager_gueltiger_Abgang_612_eines_artikels_im_lager_sollte_korrekt_sein() {
        final int erwarteterBestand = 88;
        Lager lager = new Lager();
        Artikel artikel = new Artikel(2021, "Tim", 700 ,1);
        lager.legeAnArtikel(artikel);
        lager.bucheAbgang(2021, 612);
        final int tatsaechlicherBestand = artikel.getBestand();
        assertEquals(erwarteterBestand, tatsaechlicherBestand);
    }
    
    //Fehlermeldung bei negativem Bestand nach Abgang
    @Test (expected = IllegalArgumentException.class)
    public void test_bucheAbgang_Lager_negativer_Bestand_sollte_exception_werfen() {
        Lager lager = new Lager();
        Artikel artikel = new Artikel(2021, "Tim", 700 ,1);
        lager.legeAnArtikel(artikel);
        lager.bucheAbgang(2021, 701);
    }
    
    //Preis eines Artikels erhöhen sollte korrekt sein
    @Test
    public void test_aenderePreisEinesArtikels_Lager_preis_30_um_100_prozent_erhoehen_sollte_korrekt_sein() {
        final double erwarteterPreis = 60;
        Lager lager = new Lager();
        Artikel artikel = new Artikel(2021, "Tim", 121 ,30);
        lager.legeAnArtikel(artikel);
        lager.aenderePreisEinesArtikels(2021, 100);
        final double tatsaechlicherPreis = artikel.getPreis();
        assertEquals(erwarteterPreis, tatsaechlicherPreis, DELTA);
    }
    
    //Preis eines Artikels verringern sollte korrekt sein
    @Test
    public void test_aenderePreisEinesArtikels_Lager_preis_30_um_negativ_50_prozent_verringern_sollte_korrekt_sein() {
        final double erwarteterPreis = 15;
        Lager lager = new Lager();
        Artikel artikel = new Artikel(2021, "Tim", 121 ,30);
        lager.legeAnArtikel(artikel);
        lager.aenderePreisEinesArtikels(2021, -50);
        final double tatsaechlicherPreis = artikel.getPreis();
        assertEquals(erwarteterPreis, tatsaechlicherPreis, DELTA);
    }
    
    //Fehlerfall beim Ändern des Preises eines Artikels. Wenn der Preis negativ wird, soll eine Exception geworfen werden
    @Test (expected = IllegalArgumentException.class)
    public void test_aenderePreisEinesArtikels_Lager_preis_nach_aenderung_negativ_sollte_exception_werfen() {
        Lager lager = new Lager();
        Artikel artikel = new Artikel(2021, "Tim", 121 ,1);
        lager.legeAnArtikel(artikel);
        lager.aenderePreisEinesArtikels(2021, -1000);
    }
}
