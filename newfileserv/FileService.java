package newfileserv;

import java.io.File;
import java.io.IOException;

public class FileService {

	public static void copyAllFiles(File folderIn, File folderOut) throws IOException {
		File[] files = folderIn.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile()) {
				File fileOut = new File(folderOut, files[i].getName());

				Thread thr = new Thread(new FileServiceThread(files[i], fileOut));
				thr.start();
			}
		}
	}
}