package lect07;

import java.time.Duration;
import java.time.Instant;

public class checkExcutionTimer {
	static Instant startInstant;
	static Instant endInstant;
	//���۽ð�
	public static void setStartTime() {
		startInstant = Instant.now();
		printTime(startInstant);
	}
	//����ð�
	public static void setEndTime() {
		endInstant = Instant.now();
		printTime(endInstant);
	}
	//�ҿ�ð�
	public static void printExecutionTime() {
		Duration elaspedTime = Duration.between(startInstant, endInstant);
		System.out.println("�ҿ�ð� : " + elaspedTime.getNano());
	}
	
	//�ð����
	public static void printTime(Instant arg_time) {
		System.out.println(arg_time);
	}
	
	//����ð� ���
	public static void printNowTime() {
		Instant nowInstant = Instant.now();
		System.out.println(nowInstant);
	}
	
}
