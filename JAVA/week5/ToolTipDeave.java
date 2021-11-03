package week5;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ToolTipManager;

public class ToolTipDeave extends JFrame{
	public ToolTipDeave() {
		setTitle("���� ���� ��� ���� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		//ü�� �̹��� ���̺� ����
		JLabel cherryLabel = new JLabel(new ImageIcon("./images/cherry.jpg"));
		cherryLabel.setToolTipText("ü�� �̹��� ���");  //�����ޱ�
		
		//��� �̹��� ���̺� ����
		JLabel appleLabel = new JLabel(new ImageIcon("./images/apple.jpg"));
		appleLabel.setToolTipText("��� �̹��� ���");
		
		c.add(cherryLabel);
		c.add(appleLabel);
		
		//���� �Ŵ��� ��ü
		ToolTipManager m = ToolTipManager.sharedInstance();
		m.setInitialDelay(0);  //�ʱ� ƫ�� ��� ���� �ð� 0��
		m.setDismissDelay(10000);  // ƫ�� ���� �ð� 10��
		
		setSize(400, 220);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ToolTipDeave();
	}
}
