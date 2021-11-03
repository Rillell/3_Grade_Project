package lect10;

@FunctionalInterface
interface Mathmatical{ //단일 메서드만 정의
	double calculator(double d);
}
@FunctionalInterface
interface Pickable{
	char pick(String s, int i);
}
@FunctionalInterface
interface Computable{
	int compute(int x, int y);
}

class Utils{
	int add(int a, int b) {
		return a + b;
	}
}

//메서드 참조
public class MethodRefDemoEx {
	public static void main(String[] args) {
		Mathmatical m;
		Pickable p;
		Computable c;
		
		//m = d -> Math.abs(d);
		//==> 메서드 참조 : 정적메서드 참조
		m = Math::abs;	//abs => 절댓값
		System.out.println(m.calculator(-8927.99));
		
		//p = (a, b) -> a.charAt(b);
		//==> 메서드 참조 : 인스턴스메서드 참조
		p = String::charAt;
		System.out.println(p.pick("안녕 인스턴스 메서드 참조!!", 5));
		
		Utils utils = new Utils();
		//c = (a, b) -> utils.add(a, b);
		//==> 메서드 참조 : 인스턴스메서드 참조
		c = utils::add;
		System.out.println(c.compute(99, 88));
	}
	
}
