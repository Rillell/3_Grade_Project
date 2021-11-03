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

//KeyPad 독립리스너 작성
public class KeyPadIndependent extends JFrame{
	//멤버변수
	private JTextField txt;
	private JPanel panel;
	
	//생성자
	public KeyPadIndependent() {
		this.setTitle("KeyPad독립리스너");
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
			btn.addActionListener(new KeyPadIndependentListener());
			panel.add(btn);
		}
		
		this.pack();
		this.setVisible(true);
		
	}	
	//메서드
	public static void main(String[] args) {
		new KeyPadIndependent();
	}	
}

class KeyPadIndependentListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		JTextField text = (JTextField)e.getSource();
		String command = e.getActionCommand();
		text.setText(text.getText()+command);			
	}		
}


	