package lect12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileChannelCopyEx {
	public FileChannelCopyEx() {
		try {
			FileInputStream fis = new FileInputStream("./sample.pdf");
			Path path = Paths.get("./sample_c1.pdf");
			
			FileChannel org = fis.getChannel();
			FileChannel cpy = FileChannel.open(path, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
			
			ByteBuffer buf = ByteBuffer.allocate(10240);
			
			while(org.read(buf) != -1) {
				buf.flip();
				cpy.write(buf);
				buf.clear();
			}
			org.close();
			cpy.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		checkExcutionTimer.setStartTime();
		new FileChannelCopyEx();
		checkExcutionTimer.setEndTime();
		checkExcutionTimer.printExecutionTime();
	}
}
