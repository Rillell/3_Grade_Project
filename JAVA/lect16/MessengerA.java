package lect16;

public class MessengerA {
	
	MessengerFrame f = null;
	
	public MessengerA() {
		f = new MessengerFrame(5000, 6000, "127.0.0.1");
		f.setTitle("MessengerA");
	}

	public static void main(String[] args) {
		new MessengerA();
	}

}
