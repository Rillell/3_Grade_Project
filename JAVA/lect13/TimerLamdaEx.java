package lect13;

public class TimerLamdaEx {

	public static void main(String[] args) {
		
		Runnable r = () -> {
	         int n = 0;
	         while (true) {
	            
	            System.out.println(n);
	            n++;

	            try {
	               Thread.sleep(1000);
	            } catch (InterruptedException e) {
	               return;
	            }
	         }
	      };

	
		Thread th = new Thread(r);
		th.start();

	}

}
