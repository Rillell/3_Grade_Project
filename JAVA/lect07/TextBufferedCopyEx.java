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

//문자단위 파일복사
public class TextBufferedCopyEx {
	//멤버변수
	BufferedInputStream fin = null;
	BufferedOutputStream fout = null;
	
	//생성자
	public TextBufferedCopyEx() {
		try {
			fin = new BufferedInputStream(new FileInputStream("./sampletext.txt"));
			fout = new BufferedOutputStream(new FileOutputStream("./sampletext_c2.txt"));
			
			byte[] buf = new byte[1024*10]; //10k 단위
			System.out.println("복사 시작!!");
			while(fin.available() > 0) {
				fin.read(buf);
				fout.write(buf);
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
		new TextBufferedCopyEx();
		checkExcutionTimer.setEndTime();
		checkExcutionTimer.printExecutionTime();
	}
}
