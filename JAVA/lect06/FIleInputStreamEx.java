package lect06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//바이트, 입력용, 파일읽기
public class FIleInputStreamEx {
	//멤버변수 선언
	String sFile = "";
	File    file;
	FileInputStream fin;
	
	//생성자
	public FIleInputStreamEx() {
		sFile = "./test.out";
		file = new File(sFile);
		
		byte[] bArray = new byte[6];
		try {
			fin = new FileInputStream(file);
			
			int c, n=0;
			
			while((c = fin.read())!= -1) { //-1: End of File			
				bArray[n] = (byte)c;
				n++;
			}
			fin.close();
			
			//화면출력
			for(byte b : bArray) System.out.println(b + "");
			
		} catch (IOException e) {	
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new FIleInputStreamEx();
	}
}
