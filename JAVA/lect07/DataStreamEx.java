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
//==>  �ڹ��� �⺻���� ������Ÿ������ �����͸� ����� ó��
public class DataStreamEx {
	//�������
	private DataInputStream din = null;
	private DataOutputStream dout = null;
	
	//������
	public DataStreamEx() {
		try {
/*
			dout = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("./data.out")));
			dout.writeDouble(3.141592);
			dout.writeInt(2021);
			dout.writeUTF("����� �ٲٴµ��� 3���� ����� �ִ�.---�츣����");
			dout.writeUTF("ù°, �̻縦 �Ѵ�.");
			dout.writeUTF("�Ѥ�, ���� �ٲܼ� �ִ� ����� ������.");
			dout.writeUTF("��°, �ð��� �޸� ���� ���̴�.");
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
			System.out.println("����� ���� �߻�!!" + e);
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new DataStreamEx();
	}
}
