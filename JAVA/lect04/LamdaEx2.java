package lect04;

// ���� x�� �޾Ƶ鿩 ������ �����ϴ� ���ٽ��� �����
//�Լ��� �������̽�
@FunctionalInterface
interface MyFunction2{
	int calc(int x);
	//void print();
}

public class LamdaEx2 {
	public LamdaEx2() {
		//���ٽ����� ����
		//MyFunction2 fsquare = (x) -> {return x*x;};
		MyFunction2 fsquare = x -> {return x*x;};
		
		System.out.println(fsquare.calc(5));
	}
	
	
	public static void main(String[] args) {
		new LamdaEx2();
	}

}
