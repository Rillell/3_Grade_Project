package lect04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//5. ���ٽ����� ������ ����
public class MyLamdaListenerEx extends JFrame{
	//�������
	private JButton btn = null;
	private JLabel label;
	//�޼���
	
	//������
	public MyLamdaListenerEx() {
		this.setTitle("������ ���� ���� : ���ٽ����� ����");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//��ư, �� �߰�
		JPanel jp = new JPanel();
		btn = new JButton("Action");
		//1)�̺�Ʈ �ҽ� ���� : JButton
		//2)�̺�Ʈ ���� ���� : ActionEvent ->
		//3)���ٽ����� ������ ����
		/*�Լ��� interface
		 * interface ActionListener{
		 * public void actionPerformed(ActionEvent e);
		 * }
		 */
		/*ActionListener ll = (ActionEvent e) -> {
			if(e.getActionCommand().equals("Action")) {
				btn.setText("�׼�");
				label.setText("Action��ư�� ���õǾ����ϴ�.");
			}
			else {
				btn.setText("Action");
				label.setText("�׼ǹ�ư�� ���õǾ����ϴ�.");
			}
		};
		*/
		//4) ������ ����
		//btn.addActionListener(ll);
		
		btn.addActionListener((ActionEvent e) -> {
			if(e.getActionCommand().equals("Action")) {
				btn.setText("�׼�");
				label.setText("Action��ư�� ���õǾ����ϴ�.");
			}
			else {
				btn.setText("Action");
				label.setText("�׼ǹ�ư�� ���õǾ����ϴ�.");
			}
		});
		
		label = new JLabel("��ư�� ������ �ּ���!");
		
		jp.add(btn);
		jp.add(label);
		
		this.add(jp);		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		MyLamdaListenerEx me = new MyLamdaListenerEx();
	}

}
