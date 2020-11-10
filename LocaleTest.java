
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

		byte[] buffer = new byte[(int) new File(filePath).length()];
		BufferedInputStream f = null;
		String scannerFinal = "";
		try {
			f = new BufferedInputStream(new FileInputStream(filePath));
			f.read(buffer);

			try {
				String scanner = new Scanner(new File(filePath)).useDelimiter("\\Z").next();
				scannerFinal = scanner;
			} catch(Exception ex) {
				scannerFinal = new String(buffer);
			}
		} finally {
			if (f != null)
				try {
					f.close();
				} catch (IOException ignored) {
				}
		}

		ByteBuffer bb = ByteBuffer.allocate(buffer.length);

		return scannerFinal;
	}

}
