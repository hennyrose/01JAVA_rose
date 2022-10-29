package newfileserv;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileServiceThread implements Runnable {

	private File fileIn;
	private File fileOut;

	public FileServiceThread(File fileIn, File fileOut) {
		super();
		this.fileIn = fileIn;
		this.fileOut = fileOut;
	}

	public static long copyFile(File fileIn, File fileOut) throws IOException {
		try (InputStream is = new FileInputStream(fileIn);
				OutputStream os = new FileOutputStream(fileOut)) {
			System.out.println("File " + fileIn.getName() + "copied successfully!");
			return is.transferTo(os);
		}
	}

	@Override
	public void run() {
		try {
			copyFile(fileIn, fileOut);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}