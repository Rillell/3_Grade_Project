package lect02;

import javax.swing.JButton;
import javax.swing.JFrame;  //ctrl shift o

public class NullLayoutEx extends JFrame{
	//�������(�Ӽ�)
	//�޼���
	//������
	public NullLayoutEx(){
		this.setTitle("Null ��ġ������ ����");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//��ġ������ NULL����
		this.setLayout(null);
		
		for(int i=1; i<=10; i++) {
			JButton btn = new JButton(Integer.toString(i));
			this.add(btn);
			//��ġ����
			btn.setSize(50, 30);
			btn.setLocation(i*30, i*30);
		}
		
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		NullLayoutEx nl = new NullLayoutEx();
	}

}
