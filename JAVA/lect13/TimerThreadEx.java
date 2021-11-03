package lect13;

// 1. Thread class를 상속받아 Thread 정의

// 1) Thread 정의
class TimerThread extends Thread{
	//멤버변수
	int n = 0;
	
	//
	@Override
	public void run() {
		while(true) {
			System.out.println(n);
			n++;
			
			try {
				sleep(1000); //1초단위로 증가
			} catch (InterruptedException e) {
				return;
			}
		}
	}
	
}

public class TimerThreadEx {
	public static void main(String[] args) {
		// 2) Thread 객체화
		TimerThread th = new TimerThread();
		// 3) Thread 기동
		th.start();
	}
	
	
	
}
