package lect10;

import java.util.Comparator;

//람다식 사용에 유의사항
@FunctionalInterface
interface UseThis{
	void use();
}

public class UseLamdaEx {
	public void lamda() {
		String hi = "Hi!!";
		
		//익명의 객체로 정의
		UseThis u1 = new UseThis() {
			@Override
			public void use() {
				System.out.println(this); //1.지역객체(익명객체)에서의 this는 지역객체 자신이다 ==> UseThis객체
				//hi = hi + "Lamda!!"; //2. 지역객체에서는 외부지역변수를 사용할때 final로 인식 => 값을 변경할 수 없음
				System.out.println(hi);
			}	
		};
		u1.use();
		
		//람다식으로 정의
		UseThis u2 = () -> {
			System.out.println(this); //2. 람다식의 this는 람다식을 실행한 외부객체를 의미 ==> UseLamdaEx
			//hi = hi + "lamda"; //2. 람다식에서 사용하는 지역변수는 final로 인식 ==> 변경할 수 없다.
			System.out.println(hi);
		};
		u2.use();
	}
	
	public String toString() {
		return "UseLamdaEx";
	}
	
	public static void main(String[] args) {
		int one = 1;
		new UseLamdaEx().lamda();
		//3. 람다식 외부에서 선언된 동일한 이름의 변수를 람다식에서는 사용할 수 없음 
		//Comparator<String> c = (one, two) -> {return one.length() - two.length();};
	}

}
