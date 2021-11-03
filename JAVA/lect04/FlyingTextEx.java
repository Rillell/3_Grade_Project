package lect04;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

//Ű�̺�Ʈ -> Ű������ ���� : �͸�

public class FlyingTextEx extends JFrame{
	//�������
	private JLabel la = new JLabel("HELLO");
	
	//������
	public FlyingTextEx() {
		this.setTitle("�����¿� Ű�� �̿��Ͽ� �ؽ�Ʈ �����̱�");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		
		this.setLayout(null);
		
		la.setLocation(50, 50);
		la.setSize(100, 20);
		
		//Ű�� �����¿� ->
		//1) �̺�Ʈ�ҽ� -> JFrame
		//2) �̺�Ʈ ���� -> KeyEvent : KeyListener
		//3) ������ ���� : �͸��� ������
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
			public void keyTyped(KeyEvent e) { //���� Ű ���� ����
			}
			@Override
			public void keyReleased(KeyEvent e) { //���� Ű ���� ����
			}
			
		});
		
		this.setFocusable(true);
		this.requestFocus();
		this.add(la);
		this.setVisible(true);
	}
	
	//�޼���
	public static void main(String[] args) {
		new FlyingTextEx();
	}
}
