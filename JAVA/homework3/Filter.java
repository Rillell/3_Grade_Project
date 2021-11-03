package homework3;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Filter {

	public static void main(String[] args) {
		Stream<String> s1 = Stream.of("a2", "b1", "b2", "c1", "c2", "c3");
		Stream<String> s2 = s1.filter(s -> s.startsWith("c"));
		Stream<String> s3 = s2.skip(1); //1개만큼 스트림 원소 건너뜀
		System.out.print("문자열 스트림 s3 : ");
		s3.forEach(Util::print);
		
		IntStream i1 = IntStream.of(1, 2, 1, 3, 3, 2, 4);
		IntStream i2 = i1.filter(i -> i % 2 == 0);
		IntStream i3 = i2.distinct(); //중복된 연산 제거
		System.out.print("\n정수 스트림 i3 : ");
		i3.forEach(Util::print);

	}

}
