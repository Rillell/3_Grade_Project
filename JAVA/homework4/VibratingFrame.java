package homework4;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JFrame;

public class VibratingFrame extends JFrame{
	private Thread th;
	public VibratingFrame() {
		this.setTitle("진동하는 프레임 만들기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(200, 200);
		this.setLocation(300, 300);
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(!th.isAlive()) return;
				th.interrupt();
				
			}	
		});
		
		th = new Thread(() -> {
			Random r = new Random();
			
			while(true) {
					try {
						Thread.sleep(20);
					} catch (InterruptedException e1) {
						return;
					}
					int x = getX() + r.nextInt()%5;
					int y = getY() + r.nextInt()%5;
					setLocation(x, y);
			}
					
		});
		th.start();
		this.setVisible(true);
				
	}
	
	public static void main(String[] args) {
		new VibratingFrame();
	}

}
