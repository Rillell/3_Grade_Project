package lect04;

// 메게변수가 없는 람다식을 만들기
//함수형 인터페이스
@FunctionalInterface
interface MyFunction3{
	void print();
}

public class LamdaEx3 {
	public LamdaEx3() {
		//람다식으로 구현
		MyFunction3 fprint = () -> {System.out.println("잘 쉬었나요?");};
		fprint.print();
		
		fprint = () -> System.out.println("람다는 재밌어요~~~");
		fprint.print();
	}

	
	
	public static void main(String[] args) {
		new LamdaEx3();
	}

}
