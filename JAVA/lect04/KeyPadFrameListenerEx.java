package lect04;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

//JFrame을 리스너화
public class KeyPadFrameListenerEx extends JFrame implements ActionListener{
	//멤버변수
	private JTextField txt;
	private JPanel panel;
	
	//생성자
	public KeyPadFrameListenerEx() {
		this.setTitle("KeyPad");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txt = new JTextField(20);
		this.add(txt, BorderLayout.NORTH);
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(0, 3));
		this.add(panel, BorderLayout.CENTER);
		
		for(int i = 1; i<10; i++) {
			JButton btn = new JButton(Integer.valueOf(i).toString());
			btn.setPreferredSize(new Dimension(100, 100));
			//리스너 추가
			//1) 이벤트 소스 : JButton
			//2) 이벤트 종류 : ActionEvent -> ActionListener
			//3) 리스너 구현 : 구현방식 => JFrame 을 리스너화
			btn.addActionListener(this);
			panel.add(btn);
		}
		
		this.pack();
		this.setVisible(true);
		
	}	
	//메서드
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		txt.setText(txt.getText()+command);	
	}

	public static void main(String[] args) {
		new KeyPadFrameListenerEx();
	}


}
