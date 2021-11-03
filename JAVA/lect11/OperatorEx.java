package lect11;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

public class OperatorEx {
	public static void main(String[] args) {
		IntUnaryOperator add2 = x -> x + 2;
		System.out.println(add2.applyAsInt(9));  //11
		
		UnaryOperator<Integer> add2again = x -> x + 2;
		System.out.println(add2again.apply(9)); //11
		
		IntUnaryOperator mul2 = x -> x * 2;
		IntUnaryOperator add2mul2 = add2.andThen(mul2);
		System.out.println(add2mul2.applyAsInt(9)); //22
		
		IntBinaryOperator add = (x, y) -> x + y;
		System.out.println(add.applyAsInt(7, 9)); //16
		
		List<Integer> list = new ArrayList<>();
		list.add(4);
		list.add(5);
		list.add(6);
		list.replaceAll(x -> x + 100);
		System.out.println(list); //104 105 106
		
	}
}
