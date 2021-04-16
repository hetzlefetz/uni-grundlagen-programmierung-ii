package fxge1;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Base64;

public class Utils {
	
	public static InputStream InputStreamFromBase64(String s ) {
		return new ByteArrayInputStream(Base64.getDecoder().decode(s.getBytes()));
	}

}
