package lect04;

//�޼����� ���ڷ� ���ٽ��� ����
// ���� x, y�� �޾Ƶ鿩 x+y�� �����ϴ� ���ٽ��� �����
//�Լ��� �������̽�
@FunctionalInterface
interface MyFunction4{
	int calc(int x, int y);
}

public class LamdaEx4 {
		//�޼��� ���� (�޼����� ���ڷ� ���ٽ� ����)
		static void printMultiply(int x, int y, MyFunction4 f) {
			System.out.println(f.calc(x, y));
		}
		public LamdaEx4() {
			//���ٽ����� ����
			printMultiply(100, 200, (x,y) -> x * y);
			
			//x - y�� ���ϴ� ���ٽ����� ����
			printMultiply(100, 99, (x,y) -> x - y);
		}

	public static void main(String[] args) {
		new LamdaEx4();
	}

}
