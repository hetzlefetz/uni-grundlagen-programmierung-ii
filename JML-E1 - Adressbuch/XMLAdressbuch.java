import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class XMLAdressbuch {

    private ArrayList<Kontakt> contacts = new ArrayList<>();

    public XMLAdressbuch(String filePath) throws ParserConfigurationException, SAXException, IOException {
        var file = new File(filePath);
        if (!file.exists())
            throw new FileNotFoundException();

        var fac = DocumentBuilderFactory.newInstance();
        var builder = fac.newDocumentBuilder();
        var doc = builder.parse(file);
        parse(doc);
    }

    private void parse(Document doc) {
        var c = doc.getElementsByTagName("Kontakt");
        System.out.println(c.getLength());
        for (int i = 0; i < c.getLength(); i++) {

            var item = c.item(i);
            var type = item.getAttributes().getNamedItem("typ").getTextContent();

            var vn = ((Element) item).getElementsByTagName("Vorname").item(0).getTextContent();
            var nn = ((Element) item).getElementsByTagName("Nachname").item(0).getTextContent();
            var str = ((Element) item).getElementsByTagName("Strasse").item(0).getTextContent();
            var plz = ((Element) item).getElementsByTagName("PLZ").item(0).getTextContent();
            var ort = ((Element) item).getElementsByTagName("Ort").item(0).getTextContent();
            var lan = ((Element) item).getElementsByTagName("Land").item(0).getTextContent();
            contacts.add(new Kontakt(type == "privat" ? Kontakt.KontaktTyp.privat : Kontakt.KontaktTyp.geschaeftlich,
                    nn, vn, str, plz, ort, lan));

        }

    }

    public ArrayList<String> getAlleNamen() {
        var result = new ArrayList<String>();
        for (var c : contacts) {
            result.add(c.getVorname() + " " + c.getNachname());
        }
        return result;

    }

    public ArrayList<Kontakt> getAdressenDaten(String vorname, String nachname) {
        var result = new ArrayList<Kontakt>();
        for (var c : contacts) {
            if (c.getNachname().equalsIgnoreCase(nachname) && c.getVorname().equalsIgnoreCase(vorname)) {
                result.add(c);
            }
        }
        return result;
    }

}
