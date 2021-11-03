package lect12;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class ReduceEx {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(3, 4, 5, 1, 2);
		
		int sum1 = numbers.stream().reduce(0, (x, y) -> x + y);
		int sum2 = numbers.stream().reduce(0, Integer::sum);
		int mul1 = numbers.stream().reduce(1, (x, y) -> x*y);
		
		System.out.println(sum1);
		System.out.println(sum2);
		System.out.println(mul1);
		
		Optional<Integer> sum3 = numbers.stream().reduce(Integer::sum); //Че
		OptionalInt sum4 = numbers.stream().mapToInt(x -> x.intValue()).reduce(Integer::sum); //Че
		Optional<Integer> mul2 = numbers.stream().reduce((x, y) -> x * y); //Аі
		
		System.out.println(sum3.get());
		System.out.println(sum4.getAsInt());
		mul2.ifPresent(x -> System.out.println(x));
		
		
	}
	
	
}
