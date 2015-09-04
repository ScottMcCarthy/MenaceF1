package crawl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class UXDelete {
	
	private static String TranslationDirectory = "/Users/ScottMcCarthy/git/OneSearch-Translations/src/main/resources/com/proquest/apps/onesearch";
	private static String TranslationDirectoryPi = "/home/pi/OneSearch/OneSearch-Translations/src/main/resources/com/proquest/apps/onesearch";

	private static List<File> filterUXfiles(Collection<File> files){
		List<File> uxFiles = new ArrayList<File>();
		for (File f : files) {
			if (f.getAbsolutePath().contains("UX_")) uxFiles.add(f);
		}
		return uxFiles;
	}
	
	private static void killUXFiles (List<File> uxFiles) {
		for (File uxFile : uxFiles) {
			File destination = new File(uxFile.getAbsolutePath().replace("UX_", "_"));
			try {
				FileUtils.copyFile(uxFile, destination);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Starting...");
		File transDir = new File(TranslationDirectoryPi);
		Collection<File> allFiles = FileUtils.listFiles(transDir, null, true);
		killUXFiles(filterUXfiles(allFiles));
		


	}

}
