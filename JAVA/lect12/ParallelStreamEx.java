package lect12;

import java.util.stream.IntStream;

// ��Ʈ�� ����ó��
public class ParallelStreamEx {

	public static void main(String[] args) {
		//����ó��
		long total;
		checkExcutionTimer.setStartTime();
		IntStream seq = IntStream.rangeClosed(1, 100000000);
		total = seq.sum();		
		System.out.println("����ó�� : " + total);
		checkExcutionTimer.setEndTime();
		checkExcutionTimer.printExecutionTime();
		
		//����ó��
		checkExcutionTimer.setStartTime();
		IntStream parallel = IntStream.rangeClosed(1, 100000000).parallel();
		total = parallel.sum();
		System.out.println("����ó�� : " + total);
		checkExcutionTimer.setEndTime();
		checkExcutionTimer.printExecutionTime();

	}

}
