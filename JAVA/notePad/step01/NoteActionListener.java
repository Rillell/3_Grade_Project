package notePad.step01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lect03.MyIndependentListenerEx;

public class NoteActionListener implements ActionListener{
	//멤버변수
	private Notepad frm;
	private String cmd;
	
	public NoteActionListener(Notepad frm) {
		this.frm = frm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		cmd = e.getActionCommand();
		
		if(cmd.equals("새파일")) {
			frm.newFile();
		}
		else if(cmd.equals("열기")) {
			frm.newFile();
		}
		else if(cmd.equals("저장")) {
			frm.newFile();
		}
		else if(cmd.equals("다른이름으로저장")) {
			frm.newFile();
		}
		else {
			frm.windowClosing(null);
		}
		
	}

}
