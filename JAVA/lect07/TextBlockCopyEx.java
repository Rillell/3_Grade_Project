package lect07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//���ڴ��� ���Ϻ���
public class TextBlockCopyEx {
	//�������
	FileInputStream fin = null;
	FileOutputStream fout = null;
	
	//������
	public TextBlockCopyEx() {
		try {
			fin = new FileInputStream(new File("./sampletext.txt"));
			fout = new FileOutputStream(new File("./sampletext_c3.txt"));
			
			byte[] buf = new byte[1024*10]; //10k ����		
			System.out.println("���� ����!!");
			
			while(true) {
				int n = fin.read(buf);
				fout.write(buf);
				if(n < buf.length) break;
			}
			fout.flush();
			System.out.println("���� �Ϸ�!!");
			fin.close();
			fout.close();	
			
		} catch (IOException e) {		
			System.out.println("����� ���� �߻� : " + e);
		}
	}
	public static void main(String[] args) {
		checkExcutionTimer.setStartTime();
		new TextBlockCopyEx();
		checkExcutionTimer.setEndTime();
		checkExcutionTimer.printExecutionTime();
	}
}
