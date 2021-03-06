package lect04;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

//키이벤트 -> 키리스너 구현 : 익명

public class FlyingTextEx extends JFrame{
	//멤버변수
	private JLabel la = new JLabel("HELLO");
	
	//생성자
	public FlyingTextEx() {
		this.setTitle("상하좌우 키를 이용하여 텍스트 움직이기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		
		this.setLayout(null);
		
		la.setLocation(50, 50);
		la.setSize(100, 20);
		
		//키가 상하좌우 ->
		//1) 이벤트소스 -> JFrame
		//2) 이벤트 종류 -> KeyEvent : KeyListener
		//3) 리스너 구현 : 익명의 리스너
		this.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				switch(keyCode) {
				case KeyEvent.VK_UP:
					la.setLocation(la.getX(), la.getY() - 10);
					break;
				case KeyEvent.VK_DOWN:
					la.setLocation(la.getX(), la.getY() + 10);
					break;
				case KeyEvent.VK_LEFT:
					la.setLocation(la.getX() - 10, la.getY());
					break;	
				case KeyEvent.VK_RIGHT:
					la.setLocation(la.getX() + 10, la.getY());
					break;
				}		
			}
			@Override
			public void keyTyped(KeyEvent e) { //누른 키 떼는 순간
			}
			@Override
			public void keyReleased(KeyEvent e) { //누른 키 떼는 순간
			}
			
		});
		
		this.setFocusable(true);
		this.requestFocus();
		this.add(la);
		this.setVisible(true);
	}
	
	//메서드
	public static void main(String[] args) {
		new FlyingTextEx();
	}
}
