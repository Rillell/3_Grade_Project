package lect07;

import java.time.Duration;
import java.time.Instant;

public class checkExcutionTimer {
	static Instant startInstant;
	static Instant endInstant;
	//시작시간
	public static void setStartTime() {
		startInstant = Instant.now();
		printTime(startInstant);
	}
	//종료시간
	public static void setEndTime() {
		endInstant = Instant.now();
		printTime(endInstant);
	}
	//소요시간
	public static void printExecutionTime() {
		Duration elaspedTime = Duration.between(startInstant, endInstant);
		System.out.println("소요시간 : " + elaspedTime.getNano());
	}
	
	//시간출력
	public static void printTime(Instant arg_time) {
		System.out.println(arg_time);
	}
	
	//현재시간 출력
	public static void printNowTime() {
		Instant nowInstant = Instant.now();
		System.out.println(nowInstant);
	}
	
}
