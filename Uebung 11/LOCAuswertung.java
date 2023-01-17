import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.*;
import java.util.*;

/**
 * Beschreiben Sie hier die Klasse LOCAuswertung.
 * 
 * @author pascal boestfleisch, emma ebel 
 * @version Uebung 11
 */
public class LOCAuswertung
{
    private File file;
    private PrintStream out;
    
    /**
     * Aufbau eines eigenen cat-Kommandos. Der Name der Datei wird als Kommandozeilenparameter uebergeben.
     */
    public static void main ( String args[] ) {
        try {
            if (args.length == 1) {
                LOCAuswertung locauswertung = new LOCAuswertung(args[0]);
                locauswertung.view();
            }else{
                System.out.println("Gebrauch: LOCAuswertung dateiname");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Konstruktor gibt das Arbeitsverzeichnis aus und erzeugt ein file-Objekt 
     * @param filename Ist der Name der Datei, welche auf ihre LOC ueberprueft werden soll
     */
    public LOCAuswertung(String filename) {
        out = System.out;
        out.println("Arbeitsverzeichnis: " + System.getProperty("user.dir"));
        file = new File(filename);
        validiereFiles();
    }
    
    /**
     * Methode um den Namen der aktuellen Datei zu ermitteln
     * @return gibt den Namen der Datei wieder
     */
    public String getFileName() {
        return "" + file;
    }
    
    /**
     * Methode zur Validierung der file-Objekte. Ueberprueft ob die file-Objekte existieren und lesbar sind
     */
    public void validiereFiles() {
        if ( !file.exists() || !file.canRead() ) {
            System.out.println(file.getAbsolutePath());
            throw new FileNotReadableException("Kann " + file + " nicht lesen!");
        }
        if ( !file.isFile() || !file.exists() ) {
            System.out.println(file.getAbsolutePath());
            throw new NotNormalFileException("Die Datei: " + file + " ist kein Verzeichnis und keine normale Datei!");
        }
    }
    
    /**
     * Liest die file-Objekte ein und gibt die Anzahl der Zeilen von Code an
     * Ignoriert leere Zeilen, Zeilen die mit "/" beginnen und Zeilen die mit "*" beginnt
     */
    public int lineCount() throws IOException  {
        validiereFiles();
        String line;
        int executableLines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!(line.startsWith("/") || line.startsWith("*") || line.strip().isEmpty())) {
                    executableLines++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return executableLines;
    }
    
    /**
     * Wird fuer das eigene cat-Kommando benoetigt
     * Gibt ein Array mit allen Daten im Verzeichnis zurueck
     */
    public void ls() {
        String [] files = file.list();
        for (int i = 0; i < files.length; i++) {
            out.println( files[i] );
        }
    }

    /**
     * Wird fuer das eigene cat-Kommando benoetigt
     * In dieser Methode wird die Datei eingelesen
     */
    public void cat() throws IOException {
        try (BufferedReader in = new BufferedReader  (
                new FileReader (file))){
            String line;
            while ((line = in.readLine()) != null) {
                out.println( line );
            }
        }
    }
    
    /**
     * Wird fuer das eigene cat-Kommando benoetigt
     * Wenn ein Verzeichnisname angegeben wird, wird der Verzeichnisinhalt ausgegeben
     */
    public void view() {
        try {
            if (file.isDirectory()) {
                ls();
            }
            else if (file.isFile()) {
                cat();
            }
            else {
                throw new NotNormalFileException("Kein Verzeichnis oder Datei!");
            }
        }catch (IOException e) {
            throw new FileNotReadableException("Ein-/Ausgabefehler");
        }
    }
}

