package lect07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//byte������ ���Ϻ���
public class BlockCopyEx {
	//�������
	FileInputStream fin = null;
	FileOutputStream fout = null;
	
	public BlockCopyEx() {
		try {
			fin = new FileInputStream(new File("./sample.pdf"));
			fout = new FileOutputStream(new File("./sample_c2.pdf"));
			
			byte[] buf = new byte[1024*10]; //10k ����
			System.out.println("���Ϻ��� ����!!");
			
			while(true) {
				int n = fin.read(buf);
				fout.write(buf);
				if(n < buf.length) break;
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
		new BlockCopyEx();
		checkExcutionTimer.setEndTime();
		checkExcutionTimer.printExecutionTime();
	}
}
