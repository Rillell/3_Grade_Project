package lect03;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
//2. ���� ������ Ŭ���� ����

//3)������ Ŭ���� ����
public class MyIndependentListener implements ActionListener{
	//�������
	MyIndependentListenerEx frame;
	//������
	public MyIndependentListener(MyIndependentListenerEx frame) {
		this.frame = frame;
	}
	
	//�޼���
	@Override
	public void actionPerformed(ActionEvent e) {		
		if(e.getActionCommand().equals("Action")){
		frame.getBtn().setText("�׼�");
		frame.getLabel().setText("Action��ư�� ���õǾ����ϴ�");
	}
		else {
			frame.getBtn().setText("Action");
			frame.getLabel().setText("�׼� ��ư�� ���õǾ����ϴ�.");		
	}
}
}