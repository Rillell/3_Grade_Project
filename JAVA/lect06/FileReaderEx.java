package lect06;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//���ڴ���, �Է¿�
public class FileReaderEx {
	//�������
	File file;
	FileReader fin;
	
	//������
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
