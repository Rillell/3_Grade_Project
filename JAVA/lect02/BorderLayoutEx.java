package lect02;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutEx extends JFrame{
	
	public BorderLayoutEx() {
		this.setTitle("BorderLayout ����");
		this.setBounds(50, 50, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//��ġ������ JFrame => BorderLayout
		this.setLayout(new BorderLayout(10, 10));
		
		//Component ���� �� ��ġ
		JButton btnAdd = new JButton("ADD");
		JButton btnSub = new JButton("SUB");
		JButton btnMul = new JButton("MUL");
		JButton btnDiv = new JButton("DIV");
		JButton btnExe = new JButton("EXE");
		
		this.add(btnAdd, BorderLayout.NORTH);
		this.add(btnSub, BorderLayout.WEST);
		this.add(btnMul, BorderLayout.EAST);
		this.add(btnDiv, BorderLayout.SOUTH);
		this.add(btnExe, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new BorderLayoutEx();
	}

}
