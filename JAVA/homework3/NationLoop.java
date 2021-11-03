package homework3;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NationLoop {

	public static void main(String[] args) {
		Stream<Nation> sn = Nation.nations.stream().peek(Util::printWithParenthesis); //�߰�����
		System.out.println("��� ��Ÿ����?");
		Optional<Nation> on = sn.max(Comparator.comparing(Nation::getPopulation));
		System.out.println(); //���󳪿�
		System.out.println(on.get()); //china �α����� ���� ����
		
		System.out.println(IntStream.of(5, 1, 2, 3).min().getAsInt()); //1
		
		sn = Nation.nations.stream();
		System.out.println(sn.count()); //8 ���󰳼�

	}

}
