package lect03;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyEventFrameEx extends JFrame{
	//�������
	private JButton btn = null;
	private JLabel label;
	//�޼���
	
	//������
	public MyEventFrameEx() {
		this.setTitle("������ ���� ����");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//��ư, �� �߰�
		JPanel jp = new JPanel();
		btn = new JButton("Action");
		label = new JLabel("��ư�� ������ �ּ���!");
		
		jp.add(btn);
		jp.add(label);
		
		this.add(jp);		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		MyEventFrameEx me = new MyEventFrameEx();
	}

}
