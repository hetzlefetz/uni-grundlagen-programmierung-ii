package fxge1.view;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import fxge1.application.Utils;
import fxge1.model.Person;
import fxge1.model.Personen;
import fxge1.model.Tier;
import fxge1.model.Tier.TierKlasse;
import javafx.collections.ObservableList;

public class XMLDokument {

	static final String PATH = "C:\\Users\\knechtrootrecht\\source\\repos\\github.com\\hetzlefetz\\uni-grundlagen-programmierung-ii\\Präsenz\\P3";

	public static void createNewDokument(String verz, String filename) {
		File datei = new File(PATH + File.separatorChar + verz + File.separatorChar + filename);

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;

		ObservableList<Person> oliste = Personen.getAllPersonen();
		if (oliste == null)
			oliste = Personen.getDefaultList();

		try {
			builder = factory.newDocumentBuilder();
			Document dokument = builder.newDocument();
			createDokument(dokument, Utils.copyList(oliste));
			saveXMLDocumentToFile(datei, dokument);
			System.out.println("XML Datei erfolgreich erstellt.");
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	private static void createDokument(Document dokument, ArrayList<Person> personen) {
		Element root = dokument.createElement("Tierwelt");
		for (Person p : personen) {
			Element element = createNewKontaktElement(dokument, p, String.valueOf(p.getId()));
			root.appendChild(element);
		}
		dokument.appendChild(root);
		return;
	}

	public static void remove(String verz, String filename, String id) {
		File datei = new File(PATH + File.separatorChar + verz + File.separatorChar + filename);

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Document dokument = builder.parse(datei);
			removeKontaktById(dokument, id);
			saveXMLDocumentToFile(datei, dokument);
			System.out.println("Person erfolgreich gel�scht.");
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void insert(String verz, String filename, Person person) {
		File datei = new File(PATH + File.separatorChar + verz + File.separatorChar + filename);

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Document dokument = builder.parse(datei);
			insertKontakt(dokument, person);
			saveXMLDocumentToFile(datei, dokument);
			System.out.println("Person erfolgreich eingef�gt.");
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void removeKontaktById(Document dokument, String pId) {
		Element root = dokument.getDocumentElement();

		// ToDo
	}

	private static void insertKontakt(Document dokument, Person person) {
		Element root = dokument.getDocumentElement();

		// ToDo
	}

	private static Element createNewKontaktElement(Document dokument, Person pKontakt, String id) {

		Element kontakt = dokument.createElement("Person");

		// ToDo (s. auch XMLKontaktErstellen.java)

		return kontakt;
	}

	private static void saveXMLDocumentToFile(File datei, Document dokument) {
		try {
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();
			Source src = new DOMSource(dokument);
			Result dest = new StreamResult(datei);
			transformer.transform(src, dest);
		} catch (TransformerConfigurationException e1) {
			e1.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String filename = "Personen.xml";
		String verz = "resources";

		Person bruder = new Person(Person.PersonTyp.besitzer, "KleinerBruder", "Einstein", "w", 1, "einstein.jpeg",
				"KleinerBruder.einstein@beuth-hochschule.de");
		Tier freddy = new Tier(TierKlasse.vogel, "Sittich", 6, false, "Der Vogel piept",
				"Der Vogel lebt in einer Voliere");
		freddy.addName("Freddy");
		bruder.addTier(freddy);

		createNewDokument(verz, filename);
		remove(verz, filename, "5");
		// insert(verz, filename, bruder);
	}
}
