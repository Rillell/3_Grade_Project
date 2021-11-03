package lect13;

// 2. Runnable Interface �̿��Ͽ� ���� -> �Լ��� �������̽�

// 1) Runnable ����
class TimmerRunnable implements Runnable{
	int n = 0;
	
	@Override
	public void run() {
		while(true) {
			System.out.println(n);
			n++;
			
			try {
				Thread.sleep(1000); //1�ʰ���
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}


public class TimerRunnableEx {
	public static void main(String[] args) {
		// 2) Runnable ��üȭ
		TimmerRunnable tr = new TimmerRunnable();
		
		// 3) Thread����
		Thread th = new Thread(tr);
		
		// 4) Thread �⵿
		th.start();
	}
		
}


