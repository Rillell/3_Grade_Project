package lect03;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//1.���� ������ ����
public class MyInnerListenerFrameEx extends JFrame{
	//�������
	private JButton btn = null;
	private JLabel label;
	//�޼���
	
	//������
	public MyInnerListenerFrameEx() {
		this.setTitle("���� ������ ���� ����");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//��ư, �� �߰�
		JPanel jp = new JPanel();
		
		//1)�̺�Ʈ �ҽ����� : JButton --> 
		//2)�̺�Ʈ ���� : Action Event -->AXtionListener����
		btn = new JButton("Action");		
		label = new JLabel("��ư�� ������ �ּ���!");
		//4) �̺�Ʈ ������ ����
		MyInnerListener listener = new MyInnerListener();
		btn.addActionListener(listener);
		
		jp.add(btn);
		jp.add(label);
		
		this.add(jp);		
		this.setVisible(true);
	}
	
	//3)������ ���� : ���� �����ʷ� ����
	private class MyInnerListener implements ActionListener{

		@Override //�����Ϸ����� ������ �޼������� �˷��ִ� Annotation
		public void actionPerformed(ActionEvent e) {
			//JButton bt = (JButton)e.getSource();
			//if(bt.getText().equals("Action")) {
			if(e.getActionCommand().equals("Action")) {
				btn.setText("Ȯ��");
				label.setText("Action ��ư�� ���õǾ����ϴ�.");
			}
			else {
				btn.setText("Action");
				label.setText("Ȯ�� ��ư�� ���õǾ����ϴ�");
			}			
		}		
	}
	
	public static void main(String[] args) {
		MyInnerListenerFrameEx me = new MyInnerListenerFrameEx();
	}

}
