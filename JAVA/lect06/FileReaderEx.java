package lect06;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//문자단위, 입력용
public class FileReaderEx {
	//멤버변수
	File file;
	FileReader fin;
	
	//생성자
	public FileReaderEx() {
		String sFile = "c:/windows/system.ini";
		//String sFile = "./test.out";
		file = new File(sFile);
		try {
			fin = new FileReader(file);
			
			int c;
			while((c = fin.read())!= -1){
				System.out.print((char)c);
			}
			fin.close();
		} catch (IOException e) {		
			e.printStackTrace();
		}	
	}
	
	public static void main(String[] args) {
		new FileReaderEx();
	}
}
