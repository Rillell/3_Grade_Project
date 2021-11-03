package lect04;

// 인자 x, y를 받아들여 x+y를 리턴하는 람다식을 만들기
//함수형 인터페이스
@FunctionalInterface
interface MyFunction{
	int calc(int x, int y);
	//void print();
}

public class LamdaEx {
	public LamdaEx() {
		//람다식으로 구현
		/*MyFunction f = new MyFunction() {
			@Override
			public int calc(int x, int y) {
				return x + y;
			}
			
		}; */
		//람다식으로 구현
		MyFunction f = (x, y) -> {return x + y;};
		
		System.out.println(f.calc(22, 100));
		
		//x - y 람다식으로
		MyFunction fs = (x, y) -> {return x - y;}; 
		System.out.println(fs.calc(99, 9));
	}
	
	
	public static void main(String[] args) {
		new LamdaEx();
	}

}
