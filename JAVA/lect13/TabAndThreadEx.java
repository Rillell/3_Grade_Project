package lect13;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

class MyLabel extends JLabel{
	private int barSize = 0; //���� Bar�� ũ��
	private int maxBarSize;  // Bar�� �ִ�ũ��
	
	public MyLabel(int maxBarSize) {
		this.maxBarSize = maxBarSize;
	}
	
	@Override
	public void paintComponent(Graphics g) { //�׸��� ����
		super.paintComponent(g); //�ʱ�ȭ
		g.setColor(Color.MAGENTA);
		int width = (int)(((double)this.getWidth())/maxBarSize*barSize);
		if(width==0) return;
		g.fillRect(0, 0, width, this.getHeight());
	}
	
	//������
	synchronized void fill() {
		if(barSize == maxBarSize) { //�ִ�ġ ����Ǿ����Ƿ� wait
			try {
				wait();
			} catch (InterruptedException e) {
				return;
			}
		}
		barSize++; //����
		repaint(); //paintComponent�޼��� ȣ�� --> �׷��� �׸���
		notify(); //wait���� Thread�� ����
	}
	//�Һ�
	synchronized void consume() {
		if(barSize==0) {
			try {
				wait();
			} catch (InterruptedException e) {
				return;
			}
		}
		barSize--; //�Һ�
		repaint(); //paintComponent�޼��� ȣ�� --> �׷��� �׸���
		notify();  //wait���� Thread�� ����
	}
}


public class TabAndThreadEx extends JFrame{
	private MyLabel bar = new MyLabel(100);
	
	public TabAndThreadEx() {
		this.setTitle("�����ڼҺ��� �˰��� ����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		//bar�߰�, ����
		bar.setBackground(Color.orange);
		bar.setOpaque(true);
		bar.setLocation(20, 50);
		bar.setSize(300, 20);
		this.add(bar);
		
		//������ ���� --> main thread�� keyEvent�� �۾�
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				bar.fill(); //�����ڸ޼��� ȣ��
			}
		});
		
		//�Һ��� ���� -> 0.1�� �������� �Һ�
		Thread cth = new Thread(() -> {
			while(true) {
				try {
					Thread.sleep(100);
					bar.consume(); //�Һ��� �޼���
				} catch (InterruptedException e1) {
					return;
				}
			}
		});
		cth.start();
		
		this.setSize(350, 200);
		this.setVisible(true);
		
	}

	public static void main(String[] args) {
		new TabAndThreadEx();
	}

}
