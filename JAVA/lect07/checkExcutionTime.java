package lect07;

import java.text.SimpleDateFormat;
import java.util.Date;

public class checkExcutionTime {
	static private Date start_time;
	static private Date end_time;
	static private long lstart_time;
	static private long lend_time;
	//���۽ð�
	public static void setStartTime() {
		lstart_time = System.currentTimeMillis();
		start_time = new Date(lstart_time);
		printTime(start_time);
	}
	//����ð�
	public static void setEndTime() {
		lend_time = System.currentTimeMillis();
		end_time = new Date(lend_time);
		printTime(end_time);
	}
	//�ҿ�ð���� ���
	public static void printExecutuonTime() {
		long ltimeGap = lend_time - lstart_time;
		System.out.println("�ҿ�ð�: " + ltimeGap / 1000 + "�� (" + ltimeGap+")");
	}
	//�ð����
	public static void printTime(Date arg_time) {
		SimpleDateFormat st = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(st.format(arg_time));
	}
	//����ð����
	public static void printNowTime() {
		Date now_time = new Date(System.currentTimeMillis());
		SimpleDateFormat st = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(st.format(now_time));
	}
}
