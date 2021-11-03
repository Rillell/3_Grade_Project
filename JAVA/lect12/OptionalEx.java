package lect12;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class OptionalEx {
	public static OptionalDouble divide(double x, double y) {
		return y == 0? OptionalDouble.empty() : OptionalDouble.of(x/y);
	}
	
	
	public static void main(String[] args) {
		OptionalInt i = OptionalInt.of(100);
		OptionalDouble d = OptionalDouble.of(3.141592);
		Optional<String> s = Optional.of("Good Afternoon!");
		
		System.out.println(i.getAsInt());
		System.out.println(d.getAsDouble());
		System.out.println(s.get());

		System.out.println(i);
		System.out.println(d);
		System.out.println(s);
		
		System.out.println(divide(1.0, 2.0));
		System.out.println(divide(1.0, 0.0));
		
		System.out.println("================================");
		String s1 = "Stream Test"; //1���׽�Ʈ
		//String s1 = null; //2���׽�Ʈ
		Optional<String> so = Optional.ofNullable(s1);
		
		if(s1 != null) System.out.println(s1);
		else System.out.println("����");
		
		if(so.isPresent()) System.out.println(so.get());
		else System.out.println("����");
		
		String s2 = so.orElse("����");
		System.out.println(s2);
		
		so.ifPresentOrElse(x -> System.out.println(x), ()-> System.out.println("����"));
		
	}

}
