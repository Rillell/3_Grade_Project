package lect11;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class PredicateEx {
	public static void main(String[] args) {
		Predicate<String> p = Predicate.isEqual("Java Lambda");
		System.out.println(p.test("Java Lambda"));  //true
		System.out.println(p.test("JavaLamda"));  //false
		
		IntPredicate even = x -> x%2 == 0;
		System.out.println(even.test(3) ? "¦��" : "Ȧ��"); //Ȧ��
		
		IntPredicate one = x -> x == 1;
		IntPredicate oneOrEven = one.or(even); //�ϳ��� true
		System.out.println(oneOrEven.test(1) ? "1Ȥ��¦��" : "1�ξƴ�Ȧ��");  //1Ȥ��¦��, true
	}
}
