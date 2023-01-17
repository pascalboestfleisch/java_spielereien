/**
 * Lager
 * @ebel.emma @pascal.boestfleisch
 * @param Programm zur einfachen Lagerverwaltung.
 */
public class Lager{
   private Artikel[]artikelArray;
   private int artikelAnzahl = 0;
   private final static int MAX_DEFAULT = 10;
   int maxAnzahlArtikel;
   Artikel artikel;
   int artikelNr;
   /**
    * Erzeugt das Array.
    * @param int maxAnzahlArtikel ist die maximale Lagergroesse.
    */
   public Lager(int maxAnzahlArtikel){
        if ((maxAnzahlArtikel < 0) || (maxAnzahlArtikel == 0)){
            throw new IllegalArgumentException("Die maximale Lagergröße darf nicht 0 oder negativ sein!");
        }
        artikelArray = new Artikel[maxAnzahlArtikel];
        validiereLagerKapazitaet(artikelAnzahl);
   }
   
   /**
    * Erzeugt ein Arry mit der Maximalgröße von 10
    */
   public Lager(){
        artikelArray = new Artikel[MAX_DEFAULT];
        validiereLagerKapazitaet(artikelAnzahl);
   }
   
   private void validiereLagerKapazitaet (int artikelAnzahl) {
       if((artikelAnzahl > MAX_DEFAULT) || (artikelAnzahl > maxAnzahlArtikel)) {
           throw new IllegalArgumentException("Das Lager ist voll, es können keine weiteren Artikel angelegt werden!");
       }
   }
   
   /**
    * Sucht anhand der Artikelnummer den jeweiligen Artikel im Array/Lager.
    * @param artikelNr ist die Artikelnummer, die zum Suchen des Artikels genutzt wird.
    * @return index des Artikels im Lager.
    */
   public int findeArtikel(int artikelNr){
        int index = 0;
        for(Artikel artikel: this.artikelArray){
            if(artikel.artikelNr() == artikelNr){
                return index;
            }
            index++;
        }
        validiereIndex(index);
        return - 1;
   }
   
   /**
    * Legt einen neuen Artikel im lager an.
    * @param artikel ist zum anlegen eines Artikel.
    */
   public void legeAnArtikel(Artikel artikel){
        artikelArray[artikelAnzahl] = artikel;
        artikelAnzahl++;
        //for (int i = 0; i < artikelArray.length; i++) {
        //    if (artikelArray[i] == null) {
        //        artikelArray[i] = artikel;
        //        artikelAnzahl++;
        //    }
        //    if (artikelArray[i].artikelNr() == artikel.artikelNr()) {
        //        throw new IllegalArgumentException("Artikelnummer existiert bereits!");
        //    }
        // }
   }
  
   /**
    * Entfernt einen bereits angelegten Artikel
    * @param artikelNr zum suchen der zu löschenen Artikels.
    */
   public void entferneArtikel(int artikelNr){
       int index = findeArtikel(artikelNr);
       
       for(int i = 0; i < this.artikelArray.length -1;i++){
           if(i >= index){
               this.artikelArray[i]=this.artikelArray[i+1];
           }
           if(index >= MAX_DEFAULT) {
               this.artikelArray = null;
           }
       }
       validiereIndex(index);
       artikelAnzahl--;
   }
   
   /**
    * Bucht den Zugang des Bestands im Lager eines bestimmten Artikels.
    * @param artikelNr zum finden des Artikels, dessen Bestand gemehrt werden soll.
    * @param zugang ist der Zugang um der sich der Bestand mehrt.
    */
   public void bucheZugang(int artikelNr, int zugang){
        int index = findeArtikel(artikelNr);
        validiereIndex(index);
        this.artikelArray[index].bucheZugang(zugang);
   } 

   /**
    * Bucht den Abgang des Bestandes im Lager eines bestimmten Artikels.
    * @param artikelNr zum finden des Artikels, dessen Bestand gemehrt werden soll.
    * @param abgang ist der Abgang um der sich der Bestand mindert.
    */
   public void bucheAbgang(int artikelNr, int abgang){
        int index = findeArtikel(artikelNr);
        validiereIndex(index);
        this.artikelArray[index].bucheAbgang(abgang);
   }
   
   /**
    * Aendert den Preis eines Artikels prozentual.
    * @param artikelNr zum finden des Artikels, dessen Preis veraendert werden soll.
    * @param prozent ist der Prozentsatz um wie viel sich der Preis aendern soll.
    */
   public void aenderePreisEinesArtikels(int artikelNr,double prozent){
       if(prozent == 0){
           throw new IllegalArgumentException(
           "Bitte geben Sie die Prozent an um die sich der Preis aendern soll!");
       }
       int index = findeArtikel(artikelNr);
       double preis = this.artikelArray[index].getPreis();
       double neuerPreis = preis + (preis * (prozent / 100));
       validiereIndex(index);
       this.artikelArray[index].setPreis(neuerPreis);
   }
   
   /**
    * Aendert den Preis aller Artikel.
    * @param prozent ist der Prozentsatz um dem der Preis aller Artikel geaendert werden sollt.
    */ 
   public void aenderePreisAllerArtikel(double prozent){
       for(Artikel artikel: this.artikelArray){
           if(artikel != null){
                this.aenderePreisEinesArtikels(artikel.artikelNr(),prozent);
           }
       }
   }

   /**
    * Gibt das Artikelobjekt wieder.
    * @return index gibt das Artikelobjekt anhand des Index´s wieder.
    */
   public Artikel getArtikel(int index){
       validiereIndex(index);
       return this.artikelArray[index];
   }
   
   /**
    * Gibt die Anzahl der Artikel im Lager wieder.
    * @return artikelAnzahl gibt die Anzahl der angelegten Artikel im Lager wieder.
    */
   public int getArtikelAnzahl(){
       return this.artikelAnzahl;
   }
   
   /**
    * Gibt die groesse des Lagers wieder.
    * return gibt die gesamte groesse des Lagers wieder.
    */
   public int getLagerGroesse(){
       return this.artikelArray.length;  
   }
   
   /**
    * Gibt den Inhalt als String aus.
    * @return gibt den String wieder.
    */
   public String toString(){
       StringBuffer ausgabe = new StringBuffer();
       for(Artikel artikel: this.artikelArray){
           if(artikel != null){
                ausgabe.append(artikel.toString()).append("\n");
           }
       }
       return ausgabe.toString();
   }
   
   /**
    * @param int index überprüft die Gültigkeit des Index
    */
   private void validiereIndex(int index) {
       if ((index < 0) || (index > MAX_DEFAULT) || (index > maxAnzahlArtikel)) {
           throw new IllegalArgumentException ("Bitte überprüfen Sie Ihre Angaben!");
       }
   }
}