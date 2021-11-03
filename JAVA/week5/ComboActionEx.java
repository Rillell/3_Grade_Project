package week5;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ComboActionEx extends JFrame{
	private String[] fruits = {"apple", "cherry", "pear"};
	private ImageIcon[] images = {new ImageIcon("./images/apple.jpg"),
			new ImageIcon("./images/cherry.jpg"),
			new ImageIcon("./images/pear.jpg")};
	private JLabel imgLabel = new JLabel(images[0]);
	
	public ComboActionEx() {
		this.setTitle("�޺��ڽ� Ȱ�뿹��");
		this.setSize(300, 250);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JComboBox<String> combo = new JComboBox<String>(fruits); //�޺��ڽ� ����
		c.add(combo);
		c.add(imgLabel);
		
		
		combo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb = (JComboBox<String>)e.getSource();
				int index = cb.getSelectedIndex();  //���õ� �������� �ε��� ��ȣ �˱�
				imgLabel.setIcon(images[index]);  //�ε����� �̹����� �̹��� ���̺� ���
			}
		});
		
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new ComboActionEx();
	}
	
}
