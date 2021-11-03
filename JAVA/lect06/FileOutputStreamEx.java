package lect06;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//1) Byte, ��¿� ��Ʈ�� ó��, ���Ͼ���
public class FileOutputStreamEx {
	//�������
	String sFile = "";
	File    file;
	FileOutputStream fout;
	
	//������
	public FileOutputStreamEx() {
		sFile = "./test.out";
		file = new File(sFile);
		
		byte b[] = {7, 51, 3, 4, -1, 24};
		try {		
			fout = new FileOutputStream(file);
			//fout = new FileOutputStream(new File(sFile));
			for(int i=0; i < b.length; i++) {
				fout.write(b[i]);
			}
			fout.close();
		} catch (IOException e) {			
			e.printStackTrace();
			System.out.println("����� ���� �߻�!!" + e);
		}
	}
	
	public static void main(String[] args) {
		new FileOutputStreamEx();
	}
}
