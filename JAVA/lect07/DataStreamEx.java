package lect07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//DataInputStream, DataOutputStream
//==>  자바의 기본적인 데이터타입으로 데이터를 입출력 처리
public class DataStreamEx {
	//멤버변수
	private DataInputStream din = null;
	private DataOutputStream dout = null;
	
	//생성자
	public DataStreamEx() {
		try {
/*
			dout = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("./data.out")));
			dout.writeDouble(3.141592);
			dout.writeInt(2021);
			dout.writeUTF("사람을 바꾸는데는 3가지 방법이 있다.---헤르만헷세");
			dout.writeUTF("첫째, 이사를 한다.");
			dout.writeUTF("둘쨰, 나를 바꿀수 있는 사람을 만난다.");
			dout.writeUTF("셋째, 시간을 달리 ㅆ는 것이다.");
			dout.flush();
			dout.close();
*/
			
			din = new DataInputStream(new BufferedInputStream(new FileInputStream("./data.out")));
			System.out.println(din.readDouble());
			System.out.println(din.readInt());
			System.out.println(din.readUTF());
			System.out.println(din.readUTF());
			System.out.println(din.readUTF());
			System.out.println(din.readUTF());
			din.close();

		} catch (IOException e) {
			System.out.println("입출력 오류 발생!!" + e);
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new DataStreamEx();
	}
}
