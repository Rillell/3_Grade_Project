package lect03;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//2. ���������� ����
public class MyIndependentListenerEx extends JFrame{
	//�������
	private JButton btn;
	private JLabel label;
	//�޼���
	
	
	//������
	public MyIndependentListenerEx() {
		this.setTitle("���� ������ ���� ����");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//��ư, �� �߰�
		JPanel jp = new JPanel();
		//1) �̺�Ʈ �ҽ� ���� : JButton
		//2) �̺�Ʈ ���� ���� : ActionEvent -> ActionListener ����
		btn = new JButton("Action");
		//4) �̺�Ʈ �ҽ��� �̺�Ʈ������ ��ü ����
		MyIndependentListener ml = new MyIndependentListener(this);
		btn.addActionListener(ml);
		label = new JLabel("��ư�� ������ �ּ���!");
		
		jp.add(btn);
		jp.add(label);
		
		this.add(jp);		
		this.setVisible(true);
	}
	
	public JButton getBtn() {
		return btn;
	}
	public JLabel getLabel() {
		return label;
	}

	public static void main(String[] args) {
		MyIndependentListenerEx me = new MyIndependentListenerEx();
	}

}
