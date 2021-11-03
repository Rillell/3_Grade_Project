package lect04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
// 4. �͸��� �����ʷ� ����
public class MyAnonymousListenerEx extends JFrame{
	//�������
	private JButton btn = null;
	private JLabel label;
	//�޼���
	
	//������
	public MyAnonymousListenerEx() {
		this.setTitle("������ ���� ���� : �͸��� ������");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//��ư, �� �߰�
		JPanel jp = new JPanel();
		btn = new JButton("Action");
		//1)�̺�Ʈ�ҽ� ���� : JButton
		//2) �̺�Ʈ ���� ����
		
		//3)������ ���� : �͸��� ������ ����
		//ActionListener��ü�� al�� ����ؼ� ��ü���� al ���
		/*ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Action")) {
					btn.setText("�׼�");
					label.setText("Action ��ư�� ���õž����ϴ�!");
				}
				else {
					btn.setText("Action");
					label.setText("�ܼ� ��ư�� ���õǾ����ϴ�!");
				}
			}};
			
		//4)������ ����
		btn.addActionListener(al);*/
		
		//3) ������ ���� :�͸��� ������ ���� -> ����
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Action")) {
					btn.setText("�׼�");
					label.setText("Action ��ư�� ���õž����ϴ�!");
				}
				else {
					btn.setText("Action");
					label.setText("�׼� ��ư�� ���õǾ����ϴ�!");
				}			
			}		
		});
		
		
		label = new JLabel("��ư�� ������ �ּ���!");
		
		jp.add(btn);
		jp.add(label);
		
		this.add(jp);		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		MyAnonymousListenerEx me = new MyAnonymousListenerEx();
	}

}
