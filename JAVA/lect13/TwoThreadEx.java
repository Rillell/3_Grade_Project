package lect13;

public class TwoThreadEx {
	//�������
	static Runnable r1 = null;
	static Runnable r2 = null;
	
	public TwoThreadEx() {
		r1 = () -> {
			for(int i = 10; i>0; i--) {
				System.out.println("ù��° ������ : " + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					return;
				}
			}
		};
		
		r2 = () -> {
			for(int i = 10; i>0; i--) {
				System.out.println("�ι�° ������ : " + i);
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
		
		// 3�� Thread �⵿
		Thread th1 = new Thread(r1);
		Thread th2 = new Thread(r2);
		
		th1.start();
		th2.start();
	}

}
