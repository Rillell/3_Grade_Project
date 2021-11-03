package homework;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.StringTokenizer;

import javax.swing.*;

public class NumericCalculatorLamda extends JFrame{	
	public NumericCalculatorLamda() {
		//JFrame �Ӽ�����
		this.setTitle("���ٽ� ��Ģ���� ����");
		this.setSize(700, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		//JPanel ��ü����
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();		
		panel2.setLayout(new GridLayout(4, 4, 10, 5));	
		
		//Component �߰�
		JLabel cal = new JLabel("���� ");
		JTextField text = new JTextField("", 15);
		JLabel result = new JLabel("��� ");
		JTextField text2 = new JTextField("", 15);

		for(int i = 0; i<10; i++) {
			String number = Integer.toString(i);
			JButton button = new JButton(number);
			//������ �߰�
			button.addActionListener((ActionEvent e)-> {
				String command = e.getActionCommand();
				text.setText(text.getText()+command);	
			});
			
			panel2.add(button);
		}
		JButton ce = new JButton("CE");
		ce.addActionListener((ActionEvent e) -> {
			text.setText("");
			text2.setText("");
		});
		JButton equ = new JButton("=");
		equ.addActionListener((ActionEvent e) -> {
			StringTokenizer st = new StringTokenizer(text.getText(), "+-X/", true);
			
			int first = Integer.parseInt(st.nextToken());
			String op = st.nextToken();
			int second = Integer.parseInt(st.nextToken());
			switch(op) {
			case "+" : text2.setText(first + second + ""); break;
			case "-" : text2.setText(first - second + ""); break;
			case "X" : text2.setText(first * second + ""); break;
			case "/" : text2.setText(first / second + ""); break;
			}

		});
		JButton plus = new JButton("+");
		plus.addActionListener((ActionEvent e) -> {
			String command = e.getActionCommand();
			text.setText(text.getText()+command);
		});
		JButton min = new JButton("-");
		min.addActionListener((ActionEvent e) -> {
			String command = e.getActionCommand();
			text.setText(text.getText()+command);
		});
		JButton mul = new JButton("X");
		mul.addActionListener((ActionEvent e) -> {
			String command = e.getActionCommand();
			text.setText(text.getText()+command);
		});
		JButton div = new JButton("/");
		div.addActionListener((ActionEvent e) -> {
			String command = e.getActionCommand();
			text.setText(text.getText()+command);
		});
		
		panel1.add(cal);
		panel1.add(text);
		panel1.add(result);
		panel1.add(text2);	

		panel2.add(ce);
		panel2.add(equ);
		panel2.add(plus);
		panel2.add(min);
		panel2.add(mul);
		panel2.add(div);
		
		this.add(panel1, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.CENTER);
		
		this.setVisible(true);
			
	}

	public static void main(String[] args) {
		NumericCalculatorLamda jft = new NumericCalculatorLamda();

	}

}
