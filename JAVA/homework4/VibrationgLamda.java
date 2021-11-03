package homework4;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;

import homework4.VibratingThread.Vibrating;

public class VibrationgLamda extends JFrame{
	Runnable r = () -> {
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
	};
	
	
	public VibrationgLamda() {
		setTitle("진동하는 프레임 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 200);
		setLocation(300, 300);
		setVisible(true);
		

		Thread th = new Thread(r);
		getContentPane().addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(!th.isAlive()) return;
				th.interrupt();
			}
		});
		
		th.start();
	}
	
	public static void main(String[] args) {
		new VibrationgLamda();

	}

}
