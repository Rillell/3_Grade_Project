package week5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabbedPaneEx extends JFrame{
	public TabbedPaneEx() {
		setTitle("���� ����� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		JTabbedPane pane = createTabbedPane(); //������ �����Ѵ�.
		c.add(pane, BorderLayout.CENTER);  //������ ����Ʈ�ؿ� �����Ѵ�.
		setSize(250, 250);
		setVisible(true);	
	}
	
	//������ �����ϰ� 3���� ���� �����Ͽ� �����Ѵ�.
	private JTabbedPane createTabbedPane() {
		JTabbedPane pane = new JTabbedPane(); //���� ��ü�� �����Ѵ�.
		pane.addTab("tab1", new JLabel(new ImageIcon("images/img1.jpg"))); //ù��° ��
		pane.addTab("tab2", new JLabel(new ImageIcon("images/img2.jpg"))); //�ι�° ��
		pane.addTab("tab3", new MyPanel());
		return pane;
	} 
	
	//3��° ���� ������Ʈ�� ���� �г�
	class MyPanel extends JPanel{
		public MyPanel() {
			this.setBackground(Color.yellow);
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.red);
			g.fillRect(10, 10, 50, 50);
			g.setColor(Color.blue);
			g.fillOval(10, 70, 50, 50);
			g.setColor(Color.black);
			g.drawString("tab 3�� ���� JPanel �Դϴ�.", 30, 50);
		}
	}
	
	public static void main(String[] args) {
		new TabbedPaneEx();
	}
}
