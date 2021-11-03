package homework;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

//JFrame을 리스너화
public class KeyPadFrameEx extends JFrame{
	//멤버변수
	private JTextField txt;
	private JPanel panel;
	
	//생성자
	public KeyPadFrameEx() {
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
			panel.add(btn);
		}
		
		this.pack();
		this.setVisible(true);
		
	}
	
	//메서드
	public static void main(String[] args) {
		new KeyPadFrameEx();
	}

}
