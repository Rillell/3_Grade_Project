package lect03;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//3. Frame�� ������Ŭ������ ����
public class MyListenerFrameEx extends JFrame implements ActionListener{
	//�������
	private JButton btn = null;
	private JLabel label;
	//�޼���
	
	//������
	public MyListenerFrameEx() {
		this.setTitle("������ ��ü ������ ���� ����");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//��ư, �� �߰�
		JPanel jp = new JPanel();
		//1) �̺�Ʈ �ҽ�����
		//2)
		btn = new JButton("Action");
		//4) �̺�Ʈ ����
		btn.addActionListener(this);
		label = new JLabel("��ư�� ������ �ּ���!");
		
		jp.add(btn);
		jp.add(label);
		
		this.add(jp);		
		this.setVisible(true);
	}

	//3)������ ����(������)
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Action")) {
			btn.setText("Ȯ��");
			label.setText("Action��ư�� ���õǾ����ϴ�.");
		}
		else {
			btn.setText("Action");
			label.setText("�׼ǹ�ư�� ���õǾ����ϴ�.");
		}
		
	}
	
	public static void main(String[] args) {
		MyListenerFrameEx me = new MyListenerFrameEx();
	}


}
