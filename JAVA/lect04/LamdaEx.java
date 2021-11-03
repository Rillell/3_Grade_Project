package lect04;

// ���� x, y�� �޾Ƶ鿩 x+y�� �����ϴ� ���ٽ��� �����
//�Լ��� �������̽�
@FunctionalInterface
interface MyFunction{
	int calc(int x, int y);
	//void print();
}

public class LamdaEx {
	public LamdaEx() {
		//���ٽ����� ����
		/*MyFunction f = new MyFunction() {
			@Override
			public int calc(int x, int y) {
				return x + y;
			}
			
		}; */
		//���ٽ����� ����
		MyFunction f = (x, y) -> {return x + y;};
		
		System.out.println(f.calc(22, 100));
		
		//x - y ���ٽ�����
		MyFunction fs = (x, y) -> {return x - y;}; 
		System.out.println(fs.calc(99, 9));
	}
	
	
	public static void main(String[] args) {
		new LamdaEx();
	}

}
