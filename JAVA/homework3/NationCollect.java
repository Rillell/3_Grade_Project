package homework3;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NationCollect {

	public static void main(String[] args) {
		Stream<Nation> sn = Nation.nations.stream();
		Stream<String> ss = sn.map(Nation::getName).limit(3); //�տ��� ���� 3������
		List<String> list = ss.collect(Collectors.toList()); //���Ҹ� List�� ����
		System.out.println(list);
		
		sn = Nation.nations.stream();
		Set<String> set = sn.map(Nation::getName).limit(3).collect(Collectors.toSet()); //���Ҹ� Set�� ����
		System.out.println(set);
		
		sn = Nation.nations.stream();
		Map<String, Double> map = sn.filter(Nation::isIsland).collect(Collectors.toMap(Nation::getName, //���Ҹ� key, ������ map�� ����
				Nation::getPopulation));
		System.out.println(map);
		
		sn = Nation.nations.stream();
		Set<Nation> hashSet = sn.filter(Predicate.not(Nation::isIsland))
				.collect(Collectors.toCollection(HashSet<Nation>:: new));
		hashSet.forEach(x -> Util.print("(" + x.getName() + ", " + x.getGdpRank() + ")"));
		System.out.println();
	}

}