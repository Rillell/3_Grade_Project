package lect12;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//스트림 생성 방식
public class GenerateStreamEx {
	public static void main(String[] args) {
		//배열로 부터 스트림 생성
		int[] ia = {1, 3, 5, 7, 9, 11, 13, 15};
		
		IntStream is = Arrays.stream(ia);
		is.forEach(x -> System.out.print(x + " "));
		
		System.out.println();
		
		//스트링 배열
		String[] sa = {"The", "pen", "is", "mighter", "than", "the", "sword"};
		Stream<String> ss = Stream.of(sa);
		ss.forEach(x -> System.out.print(x + " "));
		System.out.println();
		
		//double 배열
		double[] da = {3.14, 1.5, 5.9, 6.2, 9.9};
		DoubleStream ds = DoubleStream.of(da);
		ds.forEach(x -> System.out.print(x + " "));
		System.out.println();
		
		//
		IntStream is2 = IntStream.iterate(1, x -> x + 2).limit(10);
		is2.forEach(x -> System.out.print(x + " "));
		System.out.println();
		
		//
		IntStream is3 = new Random().ints(0, 50).limit(10);
		is3.forEach(x -> System.out.print(x + " "));
		System.out.println();
		
		//
		Stream<Double> ds2 = Stream.generate(Math:: random).limit(10);
		ds2.forEach(x -> System.out.print(x + " "));
		System.out.println();
		
		//
		IntStream is4 = IntStream.range(1, 5);
		is4.forEach(x -> System.out.print(x + " "));
		System.out.println();
	}
}
