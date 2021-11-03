package lect13;

// 2. Runnable Interface 이용하여 구현 -> 함수형 인터페이스

// 1) Runnable 정의
class TimmerRunnable implements Runnable{
	int n = 0;
	
	@Override
	public void run() {
		while(true) {
			System.out.println(n);
			n++;
			
			try {
				Thread.sleep(1000); //1초간격
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}


public class TimerRunnableEx {
	public static void main(String[] args) {
		// 2) Runnable 객체화
		TimmerRunnable tr = new TimmerRunnable();
		
		// 3) Thread생성
		Thread th = new Thread(tr);
		
		// 4) Thread 기동
		th.start();
	}
		
}


