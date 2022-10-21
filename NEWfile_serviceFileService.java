import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileService {
// дублює файли окремого типу з однієї папки в іншу
	public static long copyFile(File fileIn, File fileOut) throws IOException {
		try (InputStream is = new FileInputStream(fileIn);
				OutputStream os = new FileOutputStream(fileOut)) {
			return is.transferTo(os);
		}
	}

	public static void copyAllFiles(File folderIn, File folderOut, String extension) throws IOException {
		String ext = "." + extension;
		File[] files = folderIn.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile() && files[i].getName().endsWith(ext)) {
				File fileOut = new File(folderOut, files[i].getName());
				System.out.println(copyFile(files[i], fileOut));
				copyFile(files[i], fileOut);
				System.out.println("file " + files[i].getName() + " duplicated into the folder " + folderOut.getName());
			}
		}
	}
}
