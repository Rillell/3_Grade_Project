package lect04;

// �ްԺ����� ���� ���ٽ��� �����
//�Լ��� �������̽�
@FunctionalInterface
interface MyFunction3{
	void print();
}

public class LamdaEx3 {
	public LamdaEx3() {
		//���ٽ����� ����
		MyFunction3 fprint = () -> {System.out.println("�� ��������?");};
		fprint.print();
		
		fprint = () -> System.out.println("���ٴ� ��վ��~~~");
		fprint.print();
	}

	
	
	public static void main(String[] args) {
		new LamdaEx3();
	}

}
