package lect04;


//함수형 인터페이스(제너릭)
@FunctionalInterface
interface MyFunction5<T>{
	void print(T x);
}

public class LamdaEx5 {
	public LamdaEx5() {
		//람다식으로 구현
		MyFunction5<String> f1 = (x) -> {System.out.println(x.toString());};
		f1.print("String Generic Type 사용 람다식");
		
		MyFunction5<Integer> f2 = (x) -> {System.out.println(x.toString());};
		f2.print(Integer.valueOf(100));
	}
	
	
	public static void main(String[] args) {
		new LamdaEx5();
	}

}
