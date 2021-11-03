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
		Stream<String> ss = sn.map(Nation::getName).limit(3); //앞에서 부터 3개나라
		List<String> list = ss.collect(Collectors.toList()); //원소를 List에 저장
		System.out.println(list);
		
		sn = Nation.nations.stream();
		Set<String> set = sn.map(Nation::getName).limit(3).collect(Collectors.toSet()); //원소를 Set에 저장
		System.out.println(set);
		
		sn = Nation.nations.stream();
		Map<String, Double> map = sn.filter(Nation::isIsland).collect(Collectors.toMap(Nation::getName, //원소를 key, 값으로 map에 저장
				Nation::getPopulation));
		System.out.println(map);
		
		sn = Nation.nations.stream();
		Set<Nation> hashSet = sn.filter(Predicate.not(Nation::isIsland))
				.collect(Collectors.toCollection(HashSet<Nation>:: new));
		hashSet.forEach(x -> Util.print("(" + x.getName() + ", " + x.getGdpRank() + ")"));
		System.out.println();
	}

}
