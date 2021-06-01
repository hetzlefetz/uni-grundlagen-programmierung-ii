import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

/**
 * Main
 */
public class Main {

    public static String PATH_TO_ADDRESS_BOOK = "C:\\Users\\knechtrootrecht\\source\\repos\\github.com\\hetzlefetz\\uni-grundlagen-programmierung-ii\\JML-E1 - Adressbuch\\adressen2.xml";

    public static void main(String[] args) {

        try {
            var addr = new XMLAdressbuch(PATH_TO_ADDRESS_BOOK);
            addr.getAdressenDaten("Max", "Mustermann").get(0).toString();
            var alle = addr.getAlleNamen();
            for (var s : alle) {
                System.out.println(s);
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}