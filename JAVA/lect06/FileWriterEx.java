package lect06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

//���ڴ���, ��¿�
public class FileWriterEx {
	//ȭ������ �Է¹޾Ƽ� �� ������ ���Ϸ� �����
	
	//�������
	String sFile="";
	File    file;
	FileWriter fout;
	InputStreamReader in;
	
	public FileWriterEx() {
		sFile = "./test.txt";
		file = new File(sFile);
		try {
			fout = new FileWriter(file);
			
			//�ַܼ� �Է�
			in = new InputStreamReader(System.in);
			int c;
			while((c = in.read())!= -1) { //-1 : ctrl + z
				fout.write(c);
			}
			in.close();
			fout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new FileWriterEx();
	}
}
