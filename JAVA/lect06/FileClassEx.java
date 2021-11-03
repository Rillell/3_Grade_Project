package lect06;

import java.io.File;

//File 클래스를 이용하여 디렉토리, 파일의 정보 보기
public class FileClassEx {
	//멤버변수
	File f1, f2;
	static File[] subFiles;
	
	//생성자
	public FileClassEx() {
		String sfile = "c:/windows/system.ini";
		f1 = new File(sfile);
		
		System.out.println(f1.getPath() + ", " + f1.getParent() + ", " +
		                  f1.getName());
		
		String res = ""; //파일, 디렉토리 여부 기억
		if(f1.isFile()) res = "파일";
		else if(f1.isDirectory()) res = "디렉토리";
		System.out.println(f1.getPath() + "은 " + res + "입니다.");
		
		//c:/tmp
		String sfile2 = "c:/tmp/java_sample";
		f2 = new File(sfile2);
		if(!f2.exists()) f2.mkdir();	
		/*
		listDirectory(new File("c:/tmp"));
		listDirectory(f2);	
		*/
		
		listDirectory(new File("c:/tmp"));
		f2.renameTo(new File("c:/tmp/javasample"));
		listDirectory(new File("c:/tmp"));
	}
	
	//메소드
	public static void listDirectory(File dir) {
		System.out.println("Directory 정보를 보여줍니다......");
		
		subFiles = dir.listFiles();
		if(subFiles == null) return;
		
		for(int i = 0; i<subFiles.length; i++) {
			File f = subFiles[i];
			long t = f.lastModified();
			System.out.print(f.getName());
			System.out.print("\t파일크기 : " + f.length());
			System.out.printf("\t 수정한 시간 : %tb %td %ta %tT\n", t, t, t, t);
		}
		
	}
	
	
	
	public static void main(String[] args) {
		new FileClassEx();
	}
}
