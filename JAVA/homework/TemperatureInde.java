package homework;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class TemperatureInde extends JFrame{
	private JTextField text1;
	private JTextField text2;
	private JButton btn;
	
	public TemperatureInde() {
		//JFrame �Ӽ�����
		this.setTitle("�µ���ȯ��(����������)");
		this.setSize(300, 180);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//JPanel ��ü����
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		//Component �߰�
		JLabel label1 = new JLabel("ȭ�� �µ� ");
		text1 = new JTextField("", 15);
		JLabel label2 = new JLabel("���� �µ� ");
		text2 = new JTextField("", 15);
		btn = new JButton("��ȯ");
	
		btn.setSize(20, 20);
		//������ ����
		TemperInde listener = new TemperInde(this);
		
		panel1.add(label1); //�����̳ʿ� ������Ʈ�� ��ġ
		panel1.add(text1);
		panel2.add(label2);
		panel2.add(text2);
		panel3.add(btn);
		btn.addActionListener(listener);
		
		//JFrmae�� JPanel ��ġ
		this.add(panel1, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.CENTER);
		this.add(panel3, BorderLayout.SOUTH);
				
		this.setVisible(true);
	}

	public JTextField getText1() {
		return text1;
	}
	public JTextField getText2() {
		return text2;
	}

		public static void main(String[] args) {	
			TemperatureInde jft = new TemperatureInde();
	}

}
