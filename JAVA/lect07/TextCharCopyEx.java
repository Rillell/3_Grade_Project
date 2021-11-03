package lect07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//���ڴ��� ���Ϻ���
public class TextCharCopyEx {
	//�������
	private FileReader fin = null;
	private FileWriter fout = null;
	
	//������
	public TextCharCopyEx() {
		try {
			fin = new FileReader(new File("./sampletext.txt"));
			fout = new FileWriter(new File("./sampletext_c1.txt"));
			
			int c = 0;
			System.out.println("���� ����!!");
			while((c=fin.read()) != -1) {
				fout.write((char)c);
			}
			System.out.println("���� �Ϸ�!!");
			fout.close();
			
		} catch (IOException e) {		
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		checkExcutionTimer.setStartTime();
		new TextCharCopyEx();
		checkExcutionTimer.setEndTime();
		checkExcutionTimer.printExecutionTime();
	}
}
