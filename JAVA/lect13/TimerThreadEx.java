package lect13;

// 1. Thread class�� ��ӹ޾� Thread ����

// 1) Thread ����
class TimerThread extends Thread{
	//�������
	int n = 0;
	
	//
	@Override
	public void run() {
		while(true) {
			System.out.println(n);
			n++;
			
			try {
				sleep(1000); //1�ʴ����� ����
			} catch (InterruptedException e) {
				return;
			}
		}
	}
	
}

public class TimerThreadEx {
	public static void main(String[] args) {
		// 2) Thread ��üȭ
		TimerThread th = new TimerThread();
		// 3) Thread �⵿
		th.start();
	}
	
	
	
}
