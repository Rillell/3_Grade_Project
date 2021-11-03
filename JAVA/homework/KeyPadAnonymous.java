package homework;

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
//KeyPad익명의 리스너로 구현
public class KeyPadAnonymous extends JFrame{
	//멤버변수
	private JTextField txt;
	private JPanel panel;
	
	//생성자
	public KeyPadAnonymous() {
		this.setTitle("KeyPad익명리스너");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txt = new JTextField(20);
		this.add(txt, BorderLayout.NORTH);
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(0, 3));
		this.add(panel, BorderLayout.CENTER);
		
		for(int i = 1; i<10; i++) {
			JButton btn = new JButton(Integer.valueOf(i).toString());
			btn.setPreferredSize(new Dimension(100, 100));
			
			//익명리스너 추가
			btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String command = e.getActionCommand();
					txt.setText(txt.getText()+command);					
				}
				
			});
			panel.add(btn);
		}
		
		this.pack();
		this.setVisible(true);
		
	}
	
	//메서드
	public static void main(String[] args) {
		new KeyPadAnonymous();
	}

}
