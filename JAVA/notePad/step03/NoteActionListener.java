package notePad.step03;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class NoteActionListener implements ActionListener{
	//�������
	private Notepad frm;
	private String cmd;
	
	public NoteActionListener(Notepad frm) {
		this.frm = frm;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		cmd = ae.getActionCommand();
		
		if(cmd.equals("������")) {
			String s = frm.getTa().getText();
			if(s.length() == 0) {
				frm.newFile();
			}
			else{
				int result = JOptionPane.showConfirmDialog(null, "�ۼ��� ������ �ֽ��ϴ�.\n�����Ͻðڽ��ϱ�?", 
						"Confirm", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.CLOSED_OPTION) {
					frm.newFile();
				}
				else if(result == JOptionPane.YES_OPTION) {
					JFileChooser chooser = new JFileChooser();
					
					int ret = chooser.showSaveDialog(null);
					
					if(ret != JFileChooser.APPROVE_OPTION) { //file�� �������� �ʾ���
						JOptionPane.showMessageDialog(null,
								"������ �������� �ʾҽ��ϴ�.", "���", 
								JOptionPane.WARNING_MESSAGE);
						return;
					}	
					//����ڰ� ������ ���ϸ��� ������
					String sFile = chooser.getSelectedFile().getPath();	
					frm.saveFile(sFile);
				}
				else
					frm.newFile();
			}
		}			
	
		
		else if(cmd.equals("����")) {
			String s = frm.getTa().getText();
			if(s.length() == 0){//�ۼ��� ������ ������
				JFileChooser chooser = new JFileChooser();
				
				int ret = chooser.showOpenDialog(null);
				
				if(ret != JFileChooser.APPROVE_OPTION) { //file�� �������� �ʾ���
					JOptionPane.showMessageDialog(null,
							"������ �������� �ʾҽ��ϴ�.", "���", 
							JOptionPane.WARNING_MESSAGE);
					return;
				}	
				//����ڰ� ������ ���ϸ��� ������
				String sFile = chooser.getSelectedFile().getPath();	
				frm.loadFile(sFile);
			}
			else {//�ۼ� ������ ������
				int result = JOptionPane.showConfirmDialog(null, "�ۼ��� ������ �ֽ��ϴ�.\n�����Ͻðڽ��ϱ�?", 
						"Confirm", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.CLOSED_OPTION) { //���� ���ϰ� ���Ͽ���
					JFileChooser chooser = new JFileChooser();
					
					int ret = chooser.showOpenDialog(null);
					
					if(ret != JFileChooser.APPROVE_OPTION) { //file�� �������� �ʾ���
						JOptionPane.showMessageDialog(null,
								"������ �������� �ʾҽ��ϴ�.", "���", 
								JOptionPane.WARNING_MESSAGE);
						return;
					}	
					//����ڰ� ������ ���ϸ��� ������
					String sFile = chooser.getSelectedFile().getPath();	
					frm.loadFile(sFile);
				}
				else if(result == JOptionPane.YES_OPTION) { //�����ϱ�
					JFileChooser chooser = new JFileChooser();
					
					int ret = chooser.showSaveDialog(null);
					
					if(ret != JFileChooser.APPROVE_OPTION) { //file�� �������� �ʾ���
						JOptionPane.showMessageDialog(null,
								"������ �������� �ʾҽ��ϴ�.", "���", 
								JOptionPane.WARNING_MESSAGE);
						return;
					}	
					//����ڰ� ������ ���ϸ��� ������
					String sFile = chooser.getSelectedFile().getPath();	
					frm.saveFile(sFile);
				}
				else {//���� ���ϰ� ���� ����
					JFileChooser chooser = new JFileChooser();
					
					int ret = chooser.showOpenDialog(null);
					
					if(ret != JFileChooser.APPROVE_OPTION) { //file�� �������� �ʾ���
						JOptionPane.showMessageDialog(null,
								"������ �������� �ʾҽ��ϴ�.", "���", 
								JOptionPane.WARNING_MESSAGE);
						return;
					}	
					//����ڰ� ������ ���ϸ��� ������
					String sFile = chooser.getSelectedFile().getPath();	
					frm.loadFile(sFile);
				}			
			}
			
			
			
		}
		else if(cmd.equals("����")) {
			if(frm.getFilename() == null || frm.getFilename() == "�� ����") { //���� �̸��� ���ų� '�� ����' �� ��� 
				JFileChooser chooser = new JFileChooser();	
				int ret = chooser.showSaveDialog(null);
				
				if(ret != JFileChooser.APPROVE_OPTION) { //file�� �������� �ʾ���
					JOptionPane.showMessageDialog(null,
							"������ �������� �ʾҽ��ϴ�.", "���", 
							JOptionPane.WARNING_MESSAGE);
					return;
				}	
				//����ڰ� ������ ���ϸ��� ������
				String sFile = chooser.getSelectedFile().getPath();	
				frm.saveFile(sFile);
			}
			else{ //���� �̸��� ���� ���
				frm.saveFile(frm.getFilename());
				JOptionPane.showMessageDialog(null, "�����Ͽ����ϴ�.", "Message", JOptionPane.PLAIN_MESSAGE);
			}		
			
		}
		
		
		else if(cmd.equals("�ٸ��̸���������")) {
			JFileChooser chooser = new JFileChooser();			
			int ret = chooser.showOpenDialog(null);
			
			if(ret != JFileChooser.APPROVE_OPTION) { //file�� �������� �ʾ���
				JOptionPane.showMessageDialog(null,
						"������ �������� �ʾҽ��ϴ�.", "���", 
						JOptionPane.WARNING_MESSAGE);
				return;
			}	
			//����ڰ� ������ ���ϸ��� ������
			String sFile = chooser.getSelectedFile().getPath();	
			frm.saveFile(sFile);
			
		}
		
		
		else {
			String s = frm.getTa().getText();
			if(s.length() == 0) {
				frm.windowClosing(null);
			}
			else{
				int result = JOptionPane.showConfirmDialog(null, "�ۼ��� ������ �ֽ��ϴ�.\n�����Ͻðڽ��ϱ�?", 
						"Confirm", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.CLOSED_OPTION) {
					frm.windowClosing(null);
				}
				else if(result == JOptionPane.YES_OPTION) {
					JFileChooser chooser = new JFileChooser();
					
					int ret = chooser.showSaveDialog(null);
					
					if(ret != JFileChooser.APPROVE_OPTION) { //file�� �������� �ʾ���
						JOptionPane.showMessageDialog(null,
								"������ �������� �ʾҽ��ϴ�.", "���", 
								JOptionPane.WARNING_MESSAGE);
						return;
					}	
					//����ڰ� ������ ���ϸ��� ������
					String sFile = chooser.getSelectedFile().getPath();	
					frm.saveFile(sFile);
				}
				else
					frm.windowClosing(null);
			}
		}
		
	}

}
