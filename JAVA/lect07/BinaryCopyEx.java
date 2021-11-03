package lect07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//byte������ ���Ϻ���
public class BinaryCopyEx {
	//�������
	FileInputStream fin = null;
	FileOutputStream fout = null;
	
	public BinaryCopyEx() {
		try {
			fin = new FileInputStream(new File("./sample.pdf"));
			fout = new FileOutputStream(new File("./sample_c1.pdf"));
			
			System.out.println("���Ϻ��� ����!!");
			
			int c;
			
			while((c = fin.read()) != -1) { //-1: END OF FILE
				fout.write((byte)c);
			}
			System.out.println("���Ϻ��� �Ϸ�!!");
			fin.close();
			fout.close();		
		} catch (IOException e) {
			System.out.println("����� ���� �߻� : " + e);
		}
	}
	public static void main(String[] args) {
		checkExcutionTimer.setStartTime();
		new BinaryCopyEx();
		checkExcutionTimer.setEndTime();
		checkExcutionTimer.printExecutionTime();
	}
}
