package lect07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//문자단위 파일복사
public class TextBlockCopyEx {
	//멤버변수
	FileInputStream fin = null;
	FileOutputStream fout = null;
	
	//생성자
	public TextBlockCopyEx() {
		try {
			fin = new FileInputStream(new File("./sampletext.txt"));
			fout = new FileOutputStream(new File("./sampletext_c3.txt"));
			
			byte[] buf = new byte[1024*10]; //10k 단위		
			System.out.println("복사 시작!!");
			
			while(true) {
				int n = fin.read(buf);
				fout.write(buf);
				if(n < buf.length) break;
			}
			fout.flush();
			System.out.println("복사 완료!!");
			fin.close();
			fout.close();	
			
		} catch (IOException e) {		
			System.out.println("입출력 오류 발생 : " + e);
		}
	}
	public static void main(String[] args) {
		checkExcutionTimer.setStartTime();
		new TextBlockCopyEx();
		checkExcutionTimer.setEndTime();
		checkExcutionTimer.printExecutionTime();
	}
}
