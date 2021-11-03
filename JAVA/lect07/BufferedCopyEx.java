package lect07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//byte������ ���Ϻ���
public class BufferedCopyEx {
	//�������
	BufferedInputStream fin = null;
	BufferedOutputStream fout = null;
	
	public BufferedCopyEx() {
		try {
			fin = new BufferedInputStream(new FileInputStream("./sample.pdf"));
			fout = new BufferedOutputStream(new FileOutputStream("./sample_c3.pdf"));
			
			byte[] buf = new byte[1024*10]; //10k ����
			System.out.println("���Ϻ��� ����!!");
			
			/*
			int c;
			while((c = fin.read()) != -1) { 
				fout.write((byte)c);
			}
			//112165800
			*/
			
			while(fin.available() > 0) {
				fin.read(buf);
				fout.write(buf);
			}
			//40405600
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
		new BufferedCopyEx();
		checkExcutionTimer.setEndTime();
		checkExcutionTimer.printExecutionTime();
	}
}
