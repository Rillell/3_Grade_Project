package lect04;

//메서드의 인자로 람다식이 전달
// 인자 x, y를 받아들여 x+y를 리턴하는 람다식을 만들기
//함수형 인터페이스
@FunctionalInterface
interface MyFunction4{
	int calc(int x, int y);
}

public class LamdaEx4 {
		//메서드 정의 (메서드의 인자로 람다식 전달)
		static void printMultiply(int x, int y, MyFunction4 f) {
			System.out.println(f.calc(x, y));
		}
		public LamdaEx4() {
			//람다식으로 구현
			printMultiply(100, 200, (x,y) -> x * y);
			
			//x - y를 구하는 람다식으로 구현
			printMultiply(100, 99, (x,y) -> x - y);
		}

	public static void main(String[] args) {
		new LamdaEx4();
	}

}
