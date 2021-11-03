package lect10;

@FunctionalInterface
interface Mathmatical{ //���� �޼��常 ����
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

//�޼��� ����
public class MethodRefDemoEx {
	public static void main(String[] args) {
		Mathmatical m;
		Pickable p;
		Computable c;
		
		//m = d -> Math.abs(d);
		//==> �޼��� ���� : �����޼��� ����
		m = Math::abs;	//abs => ����
		System.out.println(m.calculator(-8927.99));
		
		//p = (a, b) -> a.charAt(b);
		//==> �޼��� ���� : �ν��Ͻ��޼��� ����
		p = String::charAt;
		System.out.println(p.pick("�ȳ� �ν��Ͻ� �޼��� ����!!", 5));
		
		Utils utils = new Utils();
		//c = (a, b) -> utils.add(a, b);
		//==> �޼��� ���� : �ν��Ͻ��޼��� ����
		c = utils::add;
		System.out.println(c.compute(99, 88));
	}
	
}
