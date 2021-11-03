package homework;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

//JFrame�� ������ȭ
public class KeyPadLamda extends JFrame{
	//�������
	private JTextField txt;
	private JPanel panel;
	
	//������
	public KeyPadLamda() {
		this.setTitle("KeyPad���ٸ�����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txt = new JTextField(20);
		this.add(txt, BorderLayout.NORTH);
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(0, 3));
		this.add(panel, BorderLayout.CENTER);
		
		for(int i = 1; i<10; i++) {
			JButton btn = new JButton(Integer.valueOf(i).toString());
			btn.setPreferredSize(new Dimension(100, 100));
			//���� ������ �߰�
			btn.addActionListener((ActionEvent e) -> {
				String command = e.getActionCommand();
				txt.setText(txt.getText()+command);	
			});
			panel.add(btn);
		}
		
		this.pack();
		this.setVisible(true);
		
	}
	
	//�޼���
	public static void main(String[] args) {
		new KeyPadLamda();
	}

}