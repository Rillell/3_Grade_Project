package lect06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//����Ʈ, �Է¿�, �����б�
public class FIleInputStreamEx {
	//������� ����
	String sFile = "";
	File    file;
	FileInputStream fin;
	
	//������
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
			
			//ȭ�����
			for(byte b : bArray) System.out.println(b + "");
			
		} catch (IOException e) {	
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new FIleInputStreamEx();
	}
}
