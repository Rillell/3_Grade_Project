package homework4;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;



public class VibratingThread extends JFrame{
	class Vibrating extends Thread{
		@Override
		public void run() {
			Random r = new Random();
			
			while(true) {
				try {
					Thread.sleep(20);
				}catch(InterruptedException e) {
					return;
				}
				int x = getX() + r.nextInt()%5;
				int y = getY() + r.nextInt()%5;
				setLocation(x, y);
			}
			
		}
	}
	
	public VibratingThread() {
		setTitle("진동하는 프레임 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 200);
		setLocation(300, 300);
		setVisible(true);
		
		Vibrating th = new Vibrating();
		
		getContentPane().addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(!th.isAlive()) return;
				th.interrupt();
			}
		});
		
		th.start();
	}

	public static void main(String[] args) {
		new VibratingThread();

	}

}
