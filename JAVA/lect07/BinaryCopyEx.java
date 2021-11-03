package lect07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//byte단위로 파일복사
public class BinaryCopyEx {
	//멤버변수
	FileInputStream fin = null;
	FileOutputStream fout = null;
	
	public BinaryCopyEx() {
		try {
			fin = new FileInputStream(new File("./sample.pdf"));
			fout = new FileOutputStream(new File("./sample_c1.pdf"));
			
			System.out.println("파일복사 시작!!");
			
			int c;
			
			while((c = fin.read()) != -1) { //-1: END OF FILE
				fout.write((byte)c);
			}
			System.out.println("파일복사 완료!!");
			fin.close();
			fout.close();		
		} catch (IOException e) {
			System.out.println("입출력 오류 발생 : " + e);
		}
	}
	public static void main(String[] args) {
		checkExcutionTimer.setStartTime();
		new BinaryCopyEx();
		checkExcutionTimer.setEndTime();
		checkExcutionTimer.printExecutionTime();
	}
}
