package lect07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

//PrintWriter 
//==>자바의 기본 데이타형이나 객체까지도 출력가능
public class PrintWriterEx {
	//멤버변수
	private PrintWriter out = null;
	private double sum = 0;
	private Scanner s = null;
	
	//생성자
	public PrintWriterEx() {
		try {
/*
			out = new PrintWriter(new FileWriter("./pdata.txt"));
			out.println("3.141592");
			out.println("2021");
			out.println("9999.99");
			out.flush();
			out.close();
*/
			
			s = new Scanner(new BufferedReader(new FileReader("./pdata.txt")));
			while(s.hasNext()) {
				if(s.hasNextDouble())
					sum += s.nextDouble();
				else s.hasNext();
			}
			s.close();
			System.out.println("Sum = " + sum);

		} catch (IOException e) {
			System.out.println("입출력 오류!!!" + e);
		}
	}
	public static void main(String[] args) {
		new PrintWriterEx();
	}

}
