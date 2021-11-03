package lect05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OptionPaneEx extends JFrame{
	
	public OptionPaneEx() {
		this.setTitle("OptionPaneEx ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		
		JPanel panel = new JPanel();
		
		JButton inputBtn = new JButton("Input Name");
		JButton confirmBtn = new JButton("Confirm");
		JButton messageBtn = new JButton("Message");
		JTextField txt = new JTextField(10);
		
		panel.setBackground(Color.LIGHT_GRAY);
		panel.add(inputBtn);
		panel.add(confirmBtn);
		panel.add(messageBtn);
		panel.add(txt);
		
		//리스너 연결
		inputBtn.addActionListener((ActionEvent e)->{
			//입력다이얼로그 열기
			String name = JOptionPane.showInputDialog("이름을 입력하세요!");
			if(name != null) txt.setText(name);
		});
		
		confirmBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "계속할 것입니까?", "Confirm", JOptionPane.YES_NO_OPTION);
				
				if(result == JOptionPane.CLOSED_OPTION)
					txt.setText("Just Closed without Selection");
				else if(result == JOptionPane.YES_OPTION)
					txt.setText("YES");
				else 
					txt.setText("NO");
			}
			
		});
		messageBtn.addActionListener((ActionEvent e)->{
			JOptionPane.showMessageDialog(null, "조심하세요!!", "Message", JOptionPane.ERROR_MESSAGE);
		});
		this.add(panel, BorderLayout.NORTH);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new OptionPaneEx();
	}

}
