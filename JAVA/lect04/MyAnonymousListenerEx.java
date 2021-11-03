package lect04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
// 4. 익명의 리스너로 구현
public class MyAnonymousListenerEx extends JFrame{
	//멤버변수
	private JButton btn = null;
	private JLabel label;
	//메서드
	
	//생성자
	public MyAnonymousListenerEx() {
		this.setTitle("리스너 구현 예제 : 익명의 리스너");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//버튼, 라벨 추가
		JPanel jp = new JPanel();
		btn = new JButton("Action");
		//1)이벤트소스 결정 : JButton
		//2) 이벤트 종류 결정
		
		//3)리스너 구현 : 익명의 리스너 구현
		//ActionListener객체를 al로 명명해서 객체변수 al 사용
		/*ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Action")) {
					btn.setText("액션");
					label.setText("Action 버튼이 선택돼었습니다!");
				}
				else {
					btn.setText("Action");
					label.setText("앳션 버튼이 선택되었습니다!");
				}
			}};
			
		//4)리스너 연결
		btn.addActionListener(al);*/
		
		//3) 리스너 구현 :익명의 리스너 구현 -> 연결
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Action")) {
					btn.setText("액션");
					label.setText("Action 버튼이 선택돼었습니다!");
				}
				else {
					btn.setText("Action");
					label.setText("액션 버튼이 선택되었습니다!");
				}			
			}		
		});
		
		
		label = new JLabel("버튼을 선택해 주세요!");
		
		jp.add(btn);
		jp.add(label);
		
		this.add(jp);		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		MyAnonymousListenerEx me = new MyAnonymousListenerEx();
	}

}
