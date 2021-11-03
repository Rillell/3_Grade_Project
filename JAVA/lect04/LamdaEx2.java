package lect04;

// 인자 x를 받아들여 제곱을 리턴하는 람다식을 만들기
//함수형 인터페이스
@FunctionalInterface
interface MyFunction2{
	int calc(int x);
	//void print();
}

public class LamdaEx2 {
	public LamdaEx2() {
		//람다식으로 구현
		//MyFunction2 fsquare = (x) -> {return x*x;};
		MyFunction2 fsquare = x -> {return x*x;};
		
		System.out.println(fsquare.calc(5));
	}
	
	
	public static void main(String[] args) {
		new LamdaEx2();
	}

}
