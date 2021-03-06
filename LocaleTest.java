
import java.util.Locale;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.Scanner;


public class LocaleTest {

	public static final void main(String[] args) {
		System.out.println("Locale: " + Locale.US.toString());
		
		String filePath = "/data/content/player/emails/en_US/accountCreateWithValidation.txt";
		try {
			LocaleTest lt = new LocaleTest();
			String fileContent = lt.readFileAsString(filePath);
			System.out.println("FileContent:\n" + fileContent);
		} catch (Exception ex) {
			System.out.println("Exception: " + ex.toString());
			ex.printStackTrace();
		}
	}
	
	private String readFileAsString(String filePath) throws java.io.IOException {

		String result = new String(readFileAsByteArray(filePath), "UTF-8");

		return result;
	}
	
	private byte[] readFileAsByteArray(String filePath) throws java.io.IOException {
		byte[] buffer = new byte[(int) new File(filePath).length()];
		BufferedInputStream f = null;
		try {
			f = new BufferedInputStream(new FileInputStream(filePath));
			f.read(buffer);
		} finally {
			if (f != null)
				try {
					f.close();
				} catch (IOException ignored) {
				}
		}
		return buffer;
	}

}
