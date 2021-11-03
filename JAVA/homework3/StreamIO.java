package homework3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class StreamIO {

	public static void main(String[] args) {
		Path sourcePath = Paths.get("./pdata.txt");
		Path targetPath = new File("./pdata01.txt").toPath();
		
		try(InputStream input = Files.newInputStream(sourcePath);
				BufferedInputStream bin = new BufferedInputStream(input);
				BufferedOutputStream bout = new BufferedOutputStream(Files.newOutputStream(targetPath))
				){
			int index = 0;
			byte[] buffer = new byte[1024];
			
			while((index = bin.read(buffer)) != -1) {
				bout.write(buffer, 0, index);
			}
			bout.flush();
		}catch(IOException e) {
			System.err.format("IOException: %s%n", e);
		}
	}
}

