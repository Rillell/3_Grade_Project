package lect02;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//2. JFrame ����� ���ؼ� ����
public class JFramePanelTest3 extends JFrame{
	public JFramePanelTest3() {
		//JFrame �Ӽ�����
		this.setTitle("JFrame ��� Test");
		this.setSize(700, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //�ݱ� ������ ��������
		
		//JPanel ��ü����
		JPanel panel = new JPanel();
		
		//Component �߰�
		JButton btn = new JButton("�׽�Ʈ");
		JButton btnC = new JButton("���");
		JButton btnP = new JButton("����");
		
		btn.setSize(20, 20);
		btnC.setSize(20, 20);
		btnP.setSize(20, 20);
		
		panel.add(btn); //�����̳ʿ� ������Ʈ�� ��ġ
		panel.add(btnC);
		panel.add(btnP);
		
		//JFrmae�� JPanel ��ġ
		this.add(panel);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		JFramePanelTest3 jft = new JFramePanelTest3();
	}
}
