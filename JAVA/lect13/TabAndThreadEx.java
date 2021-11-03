package lect13;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

class MyLabel extends JLabel{
	private int barSize = 0; //현재 Bar의 크기
	private int maxBarSize;  // Bar의 최대크기
	
	public MyLabel(int maxBarSize) {
		this.maxBarSize = maxBarSize;
	}
	
	@Override
	public void paintComponent(Graphics g) { //그리기 정의
		super.paintComponent(g); //초기화
		g.setColor(Color.MAGENTA);
		int width = (int)(((double)this.getWidth())/maxBarSize*barSize);
		if(width==0) return;
		g.fillRect(0, 0, width, this.getHeight());
	}
	
	//생산자
	synchronized void fill() {
		if(barSize == maxBarSize) { //최대치 생산되었으므로 wait
			try {
				wait();
			} catch (InterruptedException e) {
				return;
			}
		}
		barSize++; //생산
		repaint(); //paintComponent메서드 호출 --> 그래픽 그리기
		notify(); //wait상태 Thread를 깨움
	}
	//소비
	synchronized void consume() {
		if(barSize==0) {
			try {
				wait();
			} catch (InterruptedException e) {
				return;
			}
		}
		barSize--; //소비
		repaint(); //paintComponent메서드 호출 --> 그래픽 그리기
		notify();  //wait상태 Thread를 깨움
	}
}


public class TabAndThreadEx extends JFrame{
	private MyLabel bar = new MyLabel(100);
	
	public TabAndThreadEx() {
		this.setTitle("생산자소비자 알고리즘 적용");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		//bar추가, 설정
		bar.setBackground(Color.orange);
		bar.setOpaque(true);
		bar.setLocation(20, 50);
		bar.setSize(300, 20);
		this.add(bar);
		
		//생산자 적용 --> main thread각 keyEvent로 작업
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				bar.fill(); //생산자메서드 호출
			}
		});
		
		//소비자 적용 -> 0.1초 간격으로 소비
		Thread cth = new Thread(() -> {
			while(true) {
				try {
					Thread.sleep(100);
					bar.consume(); //소비자 메서드
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
