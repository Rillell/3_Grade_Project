package homework;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class TemperatureInner extends JFrame{
	private JTextField text1;
	private JTextField text2;
	private JButton btn;
	
	public TemperatureInner() {
		//JFrame �Ӽ�����
		this.setTitle("�µ���ȯ��(���θ�����)");
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
		InnerListener listener = new InnerListener();
		btn.addActionListener(listener);
		
		panel1.add(label1); //�����̳ʿ� ������Ʈ�� ��ġ
		panel1.add(text1);
		panel2.add(label2);
		panel2.add(text2);
		panel3.add(btn);
		
		//JFrmae�� JPanel ��ġ
		this.add(panel1, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.CENTER);
		this.add(panel3, BorderLayout.SOUTH);
				
		this.setVisible(true);
	}
	//���θ�����
	private class InnerListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(text2.getText().equals("")) {
				double f =Double.parseDouble(text1.getText());
				double c=(f-32)*5/9;
				text2.setText(String.format("%4.2f", c));
			}
			else{
				double c2 =Double.parseDouble(text2.getText());
				double f2= c2*1.8 + 32;
				text1.setText(String.format("%4.2f", f2));	
			}			
		}	
	}
		public static void main(String[] args) {	
			TemperatureInner jft = new TemperatureInner();
	}

}
