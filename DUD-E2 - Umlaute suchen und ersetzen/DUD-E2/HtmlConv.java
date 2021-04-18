import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class HtmlConv {

	/**
	 * 
	 * @param args - Not used
	 * @return exitCodes -1: input file not found -2: I/O Excpetion during
	 *         conversation 0 : All good
	 */
	public static void main(String[] args) {

		var fileNameIn = "./datei1702_vor.html";
		var fileNameOut = "./datei1702_nach.html";

		var inFile = new File(fileNameIn);
		var outFile = new File(fileNameOut);
		var charset = Charset.forName("ISO8859_1");

		if (!inFile.exists()) {
			System.out.println("Missing in file. Expected to find: " + inFile.getAbsolutePath());
			System.exit(-1);
		}

		if (outFile.exists()) {
			outFile.delete();
		}

		try (BufferedReader bufferedFileReader = new BufferedReader(new FileReader(inFile, charset));
				BufferedWriter bufferedFileWriter = new BufferedWriter(new FileWriter(fileNameOut, charset));) {

			String currentLine = null;
			while ((currentLine = bufferedFileReader.readLine()) != null) {
				bufferedFileWriter.write(currentLine.replace("ä", "&auml;").replace("Ä", "&Auml;")
						.replace("ö", "&ouml;").replace("Ö", "&Ouml;").replace("ü", "&uuml;").replace("Ü", "&Uuml;")
						.replace("ß", "&szlig;").replace("ẞ", "&#7838;"));
				bufferedFileWriter.newLine();
			}
		} catch (IOException e) {
			System.out.println("I/O Exception occured!");
			System.out.println(e.getLocalizedMessage());
			System.exit(-2);
		}
	}
}
