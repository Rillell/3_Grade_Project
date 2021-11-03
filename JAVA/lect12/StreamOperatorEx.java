package lect12;

import java.util.stream.IntStream;

//Stream의 연산 방식
public class StreamOperatorEx {
	
	public static void main(String[] args) {
		IntStream is = IntStream.rangeClosed(1, 5);
		
		is.filter(x -> {
			System.out.println("filter : " + x); //느긋한 연산(중간연산)
			return x % 2 == 0;
		}).map(x -> {
			System.out.println("map : " + x); //느긋한 연산(중간연산)
			return x * x;
		}).forEach(x -> {
			System.out.println("forEach : " + x); //조급한 연산(최종연산)
		});
		
		
		
		
	}
}
