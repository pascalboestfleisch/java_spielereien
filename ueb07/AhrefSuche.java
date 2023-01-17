import java.util.Vector;

public class AhrefSuche {

    
                public static void main(String[] args) {
    
        String s = "kjfhdj<a href = \"http://www.google.at\" nochwas=\"juhuuu\"sdfs" +
                "dfsdf>ein link</a> und dann stehn da so toole sachen wie <script ty" +
                "pe=\"text/virtualaudio\"></script> und dann auch mal wieder ein" +
                "<a href=\"www.lasmichinruh.dee_ehh\">und noch ein link</a>";
        
        String[] urls = urls(s);
        System.out.println("TestString: '"+s+"'");
        System.out.println("urls:");
        
                                for(String u:urls){
            System.out.println(u);
        }
        
    }

    
    private static String[] urls(String htmlText){
        
        Vector<String> urls = new Vector<String>();
        
        // du suchst anfang und ende vom a-tag
        
        int e = 0; // das brauchen wir um zu wissen von wo wir weitersuchen
        while (true) {

            int a = htmlText.indexOf("<a ", e);
            if(a==-1){
                // nix gefunden
                break;
            }
            System.out.println("atag-Anfang gefunden bei Index = " + a);
            e = htmlText.indexOf("/a>", a);
            if(e==-1){
                // nix gefunden
                break;
            }
            
            // dazwischen muss ein href sein
            String atag = htmlText.substring(a, e);

            
            /*
             * ich nehm noch die spaces raus, ein url kann sowas meines Wissens
             * nach eh nicht haben um "href=" && "href =" zu
             * finden
             */
            atag = atag.replaceAll(" ", "");

            
            // suche href in atag das \" ist im Endeffekt nur ein "
            int ha = atag.toLowerCase().indexOf("href=\"".toLowerCase());
            ha += "href=\"".length();
            
            
            // wenn wir keinen href Anfang finden suchen wir auch kein Ende
            if (ha == -1) {
                System.err.println("Kein 'href' im a-tag!!");
            } else {

                // suche das ende von href also ein " (ich muss hier \"
                // schreiben wie oben)  wir suchen ab dem gefundenen href
                int he = ha;
                do {
                    he = atag.indexOf("\"", he + 1);
                } while (atag.charAt(he - 1) == '\\' || he == -1);

                if (he != -1) {
                    // und wenn ich mich nicht irre müsste das dann der url sein
                    urls.add(atag.substring(ha, he));
                }
            }
        }
        
        
        // wandelt den Vector noch in ein Array
        return urls.toArray(new String[]{});
    }
}