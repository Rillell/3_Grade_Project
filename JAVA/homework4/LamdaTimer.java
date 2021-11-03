package homework4;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class LamdaTimer extends JFrame{
private JLabel timerLabel;
	
	public LamdaTimer(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	}
	
	Runnable r = () -> {		
		int n = 0;
		while(true) {
			timerLabel.setText(Integer.toString(n));
			n++;
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				return;
			}
		}
	};

	
	public LamdaTimer() {
		setTitle("Ramda�� ������ Ÿ�̸� ������ ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		c.add(timerLabel);
		
		TimerRunnable runnable = new TimerRunnable(timerLabel);
		Thread th = new Thread(runnable);
			
		setSize(250, 150);
		setVisible(true);
		
		th.start();
	}
	
	public static void main(String[] args) {
		new LamdaTimer();

	}

}
