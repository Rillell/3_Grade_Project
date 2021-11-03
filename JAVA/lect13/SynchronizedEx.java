package lect13;

class SharedPrinter{
	synchronized void print(String text) {
		for(int i=0; i<text.length(); i++) {
			System.out.print(text.charAt(i));
		}
		System.out.println();
	}
}

//Thread����
class WorkerThread implements Runnable{
	//�������
	private SharedPrinter p; //���� ������
	private String[] text;
	
	public WorkerThread(SharedPrinter p, String[] text) {
		this.p = p;
		this.text = text;
	}
	
	@Override
	public void run() {
		for(int i = 0; i<text.length; i++) {
			p.print(text[i]);
		}
	}
}

public class SynchronizedEx {

	public static void main(String[] args) {
		SharedPrinter p = new SharedPrinter();
		String[] engtext = {"1 Wise man say, ", 
						 "2 Only fools rush in", 
						 "3 Only fools rush in",
						 "4 Only fools rush in",
						 "5 Only fools rush in"
		};
		String[] kortext = {"1 ���ع��� ��λ��� ",
						    "2 ���ع��� ��λ��� ",
						    "3 ���ع��� ��λ��� ",
						    "4 ���ع��� ��λ��� ",
						    "5 ���ع��� ��λ��� "
		};
		
		//Thread ����
		Thread th1 = new Thread(new WorkerThread(p, engtext));
		Thread th2 = new Thread(new WorkerThread(p, kortext));
		
		//Thread �⵿
		th1.start();
		th2.start();
	}

}
