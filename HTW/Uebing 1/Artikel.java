
/**
 * Uebung 1
 * 
 * @Pascal Boestfleisch 388596, Emma Ebel 
 * @1.0
 */
import java.util.InputMismatchException;

public class Artikel
{
    /**
    * Deklarieren der Variablen artikelNr, art, bestand und menge, welche zur späteren Verwendung benötigt werden.
    * 
    * 
    */
private int artikelNr;
private String art;
private int bestand;
private int menge;

public Artikel(int artikelNr, String art, int bestand) {
    /**
     * Erschafft einen Konstruktor, bei dem es möglich ist, Artikelnummer, Art des Artikels und auch den derzeitigen Bestand
     * einzugeben. 
     * Ein Standardkonstruktor wie Artikel() ergibt hier keinen Sinn, da es mit ihm
     * nur möglich ist, den Namen der Instanz zu ändern. Einzelne Werte können bei der Erstellung nicht angegeben werden.
     */
    this.artikelNr = artikelNr;
    this.art = art;
    this.bestand = 0;
    if (bestand >= 0) {
        System.out.println("Bestand ist gültig!");
    }
    else {
        throw new IllegalArgumentException("Bestand kann nicht negativ sein!");
    }
    if (artikelNr >= 0) {
        System.out.println("Artikelnummer ist gültig!");
    }
    else {
        throw new IllegalArgumentException("Artikelnummer ist ungültig!");
    }
    }
public Artikel(int artikelNr, String art) {
    /**
     * Erschafft einen Konstruktor, welcher nur Artikelnummer und den Namen des Artikels beinhaltet.
     */
    this(artikelNr, art, 0);
    }
public String getArtikel(){
    /**
     * Durch "get" wird der Artikelname abgelesen und durch "return" möchte ich, dass der Wert ausgegeben wird.
     */
    return art;
    }
public int getArtikelNr(){
    /**
     * Durch "get" wird die Artikelnummer abgelesen und durch "return" wird mir die Artikelnummer ausgegeben.
     */
    return artikelNr;
    }
public int getBestand() {
    /**
     * Durch "get" wird der Bestand abgelesen und durch "return" möchte ich, dass der Wert ausgegeben wird.
     */
    return bestand;
    }
public void bucheZugang(int menge) {
    /**
     * Bestand wird vergrößert durch Menge + alter Bestand
     * Keine Rückgabe aufgrund von "void"
     */
    bestand = bestand + menge;
    if (menge <=0) {
        System.out.println("Zugang ist gültig!");
    }
    else {
        throw new IllegalArgumentException("Menge darf nicht 0 oder negativ sein!");
    }
    }
public void bucheAbgang(int menge) {
    /**
     * Bestand wird verringert durch Menge - alter Bestand
     * Keine Rückgabe aufgrund von "void"
     */
    bestand = bestand - menge;
    }
public String setArt(String neuerArt) {
    /**
     * Bearbeitet den momentanen Namen des Artikels, wird benötigt um z.B zu korrigieren. 
     * Der alte Name wird mit dem neuen Namen überschrieben.
     */
    System.out.println("Artikelname wird bearbeitet: " + art);
    art = neuerArt;
    return art;
    }
public void setBestand(int neuerBestand){
    /**
     * Bearbeitet den momentanen Bestand, wird benötigt um z.B zu korrigieren.
     * Der alte Bestand wird mit dem neuen Bestand überschrieben.
     */
    bestand = neuerBestand;
    }
public void setArtikelNr(int neueArtikelNr){
    /**
     * Bearbeitet die momentane Artikelnummer, wird benötigt um z.B zu korrigieren.
     * Die alte Artikelnummer wird mit der neuen Artikelnummer überschrieben.
     */
    artikelNr = neueArtikelNr;
    if (neueArtikelNr <= 0) {
        System.out.println("Neue Artikelnummer ist gültig!");
    }
    else {
        throw new IllegalArgumentException("Neue Artikelnummer ist ungültig!");
    }
    }
public String toString(){
    /**
     * Gibt die Artikelnummer, den Namen des Artikels und den Bestand wider.
     * Das gilt nur für die neusten Werte, welche eingegeben wurden.
     * Alte Werte werden durch neue überschrieben.
     */
    return "Artikel: " + artikelNr + ", Art: " + art + ", Bestand: " + bestand;
    }   
}


