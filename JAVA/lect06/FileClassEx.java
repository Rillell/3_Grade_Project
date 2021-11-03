package lect06;

import java.io.File;

//File Ŭ������ �̿��Ͽ� ���丮, ������ ���� ����
public class FileClassEx {
	//�������
	File f1, f2;
	static File[] subFiles;
	
	//������
	public FileClassEx() {
		String sfile = "c:/windows/system.ini";
		f1 = new File(sfile);
		
		System.out.println(f1.getPath() + ", " + f1.getParent() + ", " +
		                  f1.getName());
		
		String res = ""; //����, ���丮 ���� ���
		if(f1.isFile()) res = "����";
		else if(f1.isDirectory()) res = "���丮";
		System.out.println(f1.getPath() + "�� " + res + "�Դϴ�.");
		
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
	
	//�޼ҵ�
	public static void listDirectory(File dir) {
		System.out.println("Directory ������ �����ݴϴ�......");
		
		subFiles = dir.listFiles();
		if(subFiles == null) return;
		
		for(int i = 0; i<subFiles.length; i++) {
			File f = subFiles[i];
			long t = f.lastModified();
			System.out.print(f.getName());
			System.out.print("\t����ũ�� : " + f.length());
			System.out.printf("\t ������ �ð� : %tb %td %ta %tT\n", t, t, t, t);
		}
		
	}
	
	
	
	public static void main(String[] args) {
		new FileClassEx();
	}
}
