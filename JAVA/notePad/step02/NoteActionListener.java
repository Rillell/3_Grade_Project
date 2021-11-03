package notePad.step02;

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
			frm.newFile();
		}
		else if(cmd.equals("����")) {
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
		else if(cmd.equals("����")) {
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
			frm.windowClosing(null);
		}
		
	}

}
