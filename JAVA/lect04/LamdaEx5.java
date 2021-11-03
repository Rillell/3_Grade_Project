package lect04;


//�Լ��� �������̽�(���ʸ�)
@FunctionalInterface
interface MyFunction5<T>{
	void print(T x);
}

public class LamdaEx5 {
	public LamdaEx5() {
		//���ٽ����� ����
		MyFunction5<String> f1 = (x) -> {System.out.println(x.toString());};
		f1.print("String Generic Type ��� ���ٽ�");
		
		MyFunction5<Integer> f2 = (x) -> {System.out.println(x.toString());};
		f2.print(Integer.valueOf(100));
	}
	
	
	public static void main(String[] args) {
		new LamdaEx5();
	}

}
