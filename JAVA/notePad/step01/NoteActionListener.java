package notePad.step01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lect03.MyIndependentListenerEx;

public class NoteActionListener implements ActionListener{
	//�������
	private Notepad frm;
	private String cmd;
	
	public NoteActionListener(Notepad frm) {
		this.frm = frm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		cmd = e.getActionCommand();
		
		if(cmd.equals("������")) {
			frm.newFile();
		}
		else if(cmd.equals("����")) {
			frm.newFile();
		}
		else if(cmd.equals("����")) {
			frm.newFile();
		}
		else if(cmd.equals("�ٸ��̸���������")) {
			frm.newFile();
		}
		else {
			frm.windowClosing(null);
		}
		
	}

}
