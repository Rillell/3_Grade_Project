package lect12;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

public class FilesStreamEx {

	public static void main(String[] args) {
		File file = new File("c:/windows");	
		File[] fs = file.listFiles();
		
		Stream<File> stream = Arrays.stream(fs);
		long count = stream.filter(x -> x.isDirectory() == false).count();
		System.out.println("c:/windows에 있는 파일의 갯수는? " + count);
		

	}

}
