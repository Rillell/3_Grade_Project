package lect07;

import java.text.SimpleDateFormat;
import java.util.Date;

public class checkExcutionTime {
	static private Date start_time;
	static private Date end_time;
	static private long lstart_time;
	static private long lend_time;
	//시작시간
	public static void setStartTime() {
		lstart_time = System.currentTimeMillis();
		start_time = new Date(lstart_time);
		printTime(start_time);
	}
	//종료시간
	public static void setEndTime() {
		lend_time = System.currentTimeMillis();
		end_time = new Date(lend_time);
		printTime(end_time);
	}
	//소요시간계산 출력
	public static void printExecutuonTime() {
		long ltimeGap = lend_time - lstart_time;
		System.out.println("소요시간: " + ltimeGap / 1000 + "초 (" + ltimeGap+")");
	}
	//시간출력
	public static void printTime(Date arg_time) {
		SimpleDateFormat st = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(st.format(arg_time));
	}
	//현재시간출력
	public static void printNowTime() {
		Date now_time = new Date(System.currentTimeMillis());
		SimpleDateFormat st = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(st.format(now_time));
	}
}
