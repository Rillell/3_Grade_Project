package lect07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//���ڴ��� ���Ϻ���
public class TextBufferedCopyEx {
	//�������
	BufferedInputStream fin = null;
	BufferedOutputStream fout = null;
	
	//������
	public TextBufferedCopyEx() {
		try {
			fin = new BufferedInputStream(new FileInputStream("./sampletext.txt"));
			fout = new BufferedOutputStream(new FileOutputStream("./sampletext_c2.txt"));
			
			byte[] buf = new byte[1024*10]; //10k ����
			System.out.println("���� ����!!");
			while(fin.available() > 0) {
				fin.read(buf);
				fout.write(buf);
			}
			fout.flush();
			
			System.out.println("���Ϻ��� �Ϸ�!!");
			fin.close();
			fout.close();	
			
		} catch (IOException e) {		
			System.out.println("����� ���� �߻� : " + e);
		}
	}
	public static void main(String[] args) {
		checkExcutionTimer.setStartTime();
		new TextBufferedCopyEx();
		checkExcutionTimer.setEndTime();
		checkExcutionTimer.printExecutionTime();
	}
}
