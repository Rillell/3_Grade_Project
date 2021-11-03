package homework3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StreamWrite {

	public static void main(String[] args) {
		Path sourcePath = Paths.get("./pdata.txt");
		Path targetPath = new File("./pdata02.txt").toPath();
		
		try(InputStream input = Files.newInputStream(sourcePath);
				BufferedReader reader = new BufferedReader(new InputStreamReader(input));
				OutputStream out = Files.newOutputStream(targetPath);
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out))){
			String line = null;
			
			while((line = reader.readLine()) != null) {
				System.out.println(line);
				
				
				writer.write(line, 0, line.length());
			}
			writer.flush();
		} catch (IOException e) {
			System.err.format("IOException : %s%n", e);
		}

	}

}
