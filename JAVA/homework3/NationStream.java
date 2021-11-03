package homework3;

import java.util.Comparator;
import java.util.stream.Stream;

public class NationStream {

	public static void main(String[] args) {
		System.out.println("\n국가 이름 순서 :");
		Stream<Nation> n1 = Nation.nations.stream();
		Stream<Nation> n2 = n1.sorted(Comparator.comparing(Nation::getName));
		Stream<String> s3 = n2.map(x -> x.getName());
		s3.forEach(Util::printWithParenthesis);
		
		System.out.println("\n국가 GDP순서 : ");
		Stream<Nation> n3 = Nation.nations.stream();
		Stream<Nation> n4 = n3.sorted(Comparator.comparing(Nation::getGdpRank));
		Stream<String> s4 = n4.map(x -> x.getName());
		s4.forEach(Util::printWithParenthesis);

	}

}
