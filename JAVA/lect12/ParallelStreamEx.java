package lect12;

import java.util.stream.IntStream;

// 스트림 병렬처리
public class ParallelStreamEx {

	public static void main(String[] args) {
		//순차처리
		long total;
		checkExcutionTimer.setStartTime();
		IntStream seq = IntStream.rangeClosed(1, 100000000);
		total = seq.sum();		
		System.out.println("순차처리 : " + total);
		checkExcutionTimer.setEndTime();
		checkExcutionTimer.printExecutionTime();
		
		//병렬처리
		checkExcutionTimer.setStartTime();
		IntStream parallel = IntStream.rangeClosed(1, 100000000).parallel();
		total = parallel.sum();
		System.out.println("병렬처리 : " + total);
		checkExcutionTimer.setEndTime();
		checkExcutionTimer.printExecutionTime();

	}

}
