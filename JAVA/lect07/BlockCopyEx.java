package lect07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//byte단위로 파일복사
public class BlockCopyEx {
	//멤버변수
	FileInputStream fin = null;
	FileOutputStream fout = null;
	
	public BlockCopyEx() {
		try {
			fin = new FileInputStream(new File("./sample.pdf"));
			fout = new FileOutputStream(new File("./sample_c2.pdf"));
			
			byte[] buf = new byte[1024*10]; //10k 단위
			System.out.println("파일복사 시작!!");
			
			while(true) {
				int n = fin.read(buf);
				fout.write(buf);
				if(n < buf.length) break;
			}
			fout.flush();
			
			System.out.println("파일복사 완료!!");
			fin.close();
			fout.close();		
		} catch (IOException e) {
			System.out.println("입출력 오류 발생 : " + e);
		}
	}
	public static void main(String[] args) {
		checkExcutionTimer.setStartTime();
		new BlockCopyEx();
		checkExcutionTimer.setEndTime();
		checkExcutionTimer.printExecutionTime();
	}
}
