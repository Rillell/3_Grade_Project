package lect11;

import java.util.function.Function;
import java.util.function.IntToDoubleFunction;
import java.util.function.ToDoubleBiFunction;

public class FunctionEx {
	public static void main(String[] args) {
		Function<Integer, Integer> add2 = x -> x + 2;
		Function<Integer, Integer> mul2 = x -> x * 2;
		
		System.out.println(add2.apply(9));
		System.out.println(mul2.apply(9));
		
		System.out.println(add2.andThen(mul2).apply(9)); //실행순서 9+2=11, 11*2=22
		System.out.println(add2.compose(mul2).apply(9)); //실행순서 9*2=18, 18+2=20
		
		IntToDoubleFunction half = x -> x / 2.0;
		System.out.println(half.applyAsDouble(9));
		
		ToDoubleBiFunction<String, Integer> circleArea = (s, i) -> Double.parseDouble(s) * i * i;
		double area = circleArea.applyAsDouble("3.14", 7);
		System.out.println(area);
		
	}
}
