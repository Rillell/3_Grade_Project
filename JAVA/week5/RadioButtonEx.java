package week5;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class RadioButtonEx extends JFrame{
	public RadioButtonEx() {
		this.setTitle("������ư ����� ����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(250, 150);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		ButtonGroup g = new ButtonGroup();
		
		//������ư ����
		JRadioButton apple = new JRadioButton("���");
		JRadioButton pear = new JRadioButton("��", true);  //�谡 ���õ� ����
		JRadioButton cherry = new JRadioButton("ü��");
		
		//��ư �׷쿡 ������ư ����
		g.add(apple);
		g.add(pear);
		g.add(cherry);
		
		c.add(apple);    c.add(pear);   c.add(cherry);   //����Ʈ�ҿ� ������ư ����, ����Ʈ�ҿ� ���ԵǾ�� ȭ�鿡 ��µ�.
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new RadioButtonEx();
	}
}
