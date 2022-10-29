package newfileserv;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		File folderIn = new File("/Users/henny/Documents/folder1");

		File folderOut = new File("/Users/henny/Documents/folder2");

		try {
			FileService.copyAllFiles(folderIn, folderOut);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}