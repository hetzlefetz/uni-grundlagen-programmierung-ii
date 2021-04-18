import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class HtmlConv {

	public static void main(String[] args) throws FileNotFoundException {

		var fileNameIn = "./datei1702_vor.html";
		var fileNameOut = "./datei1702_nach.html";

		var inFile = new File(fileNameIn);
		var outFile = new File(fileNameOut);
		var charset = Charset.forName("ISO8859_1");

		if (!inFile.exists()) {
			throw new FileNotFoundException("Missing in file. Expected to find: " + inFile.getAbsolutePath());
		}
		if (outFile.exists()) {
			outFile.delete();
		}

		try (BufferedReader bufferedFileReader = new BufferedReader(new FileReader(inFile, charset));
				BufferedWriter bufferedFileWriter = new BufferedWriter(new FileWriter(fileNameOut, charset));) {

			String currentLine = null;
			while ((currentLine = bufferedFileReader.readLine()) != null) {
				System.out.println(currentLine);
				bufferedFileWriter.write(currentLine.replace("ä", "&auml;").replace("Ä", "&Auml;")
						.replace("ö", "&ouml;").replace("Ö", "&Ouml;").replace("ü", "&uuml;").replace("Ü", "&Uuml;")
						.replace("ß", "&szlig;").replace("ẞ", "&#7838;"));
				bufferedFileWriter.newLine();
			}

		} catch (FileNotFoundException e) {
			System.out.println("File Not found!");
			System.out.println(e.getLocalizedMessage());
		} catch (IOException e) {
			System.out.println("IO Exception occured!");
			System.out.println(e.getLocalizedMessage());
		}

	}

}
