package lect02;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;

//2. JFrame ����� ���ؼ� ����
public class JFrameTest2 extends JFrame{
	public JFrameTest2() {
		//JFrame �Ӽ�����
		this.setTitle("JFrame ��� Test");
		this.setSize(700, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //�ݱ� ������ ��������
		
		//��ġ������ ����
		this.setLayout(new FlowLayout());
		
		//Component �߰�
		JButton btn = new JButton("�׽�Ʈ");
		JButton btnC = new JButton("���");
		JButton btnP = new JButton("����");
		
		btn.setSize(20, 20);
		btnC.setSize(20, 20);
		btnP.setSize(20, 20);
		
		this.add(btn); //�����̳ʿ� ������Ʈ�� ��ġ
		this.add(btnC);
		this.add(btnP);
			
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		JFrameTest2 jft = new JFrameTest2();
	}
}
