package lect16;

public class MessengerB {
	
	MessengerFrame f = null;
	
	public MessengerB() {
		f = new MessengerFrame(6000, 5000, "127.0.0.1");
		f.setTitle("MessengerB");
	}

	public static void main(String[] args) {
		new MessengerB();
	}
}
