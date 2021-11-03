package lect06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

//문자단위, 출력용
public class FileWriterEx {
	//화면으로 입력받아서 그 내용을 파일로 만들기
	
	//멤버변수
	String sFile="";
	File    file;
	FileWriter fout;
	InputStreamReader in;
	
	public FileWriterEx() {
		sFile = "./test.txt";
		file = new File(sFile);
		try {
			fout = new FileWriter(file);
			
			//콘솔로 입력
			in = new InputStreamReader(System.in);
			int c;
			while((c = in.read())!= -1) { //-1 : ctrl + z
				fout.write(c);
			}
			in.close();
			fout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new FileWriterEx();
	}
}
