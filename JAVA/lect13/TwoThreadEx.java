package lect13;

public class TwoThreadEx {
	//멤버변수
	static Runnable r1 = null;
	static Runnable r2 = null;
	
	public TwoThreadEx() {
		r1 = () -> {
			for(int i = 10; i>0; i--) {
				System.out.println("첫번째 쓰레드 : " + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					return;
				}
			}
		};
		
		r2 = () -> {
			for(int i = 10; i>0; i--) {
				System.out.println("두번째 쓰레드 : " + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					return;
				}
			}
		};
}
	
	
	
	public static void main(String[] args) {
		TwoThreadEx te = new TwoThreadEx();
		
		// 3개 Thread 기동
		Thread th1 = new Thread(r1);
		Thread th2 = new Thread(r2);
		
		th1.start();
		th2.start();
	}

}
