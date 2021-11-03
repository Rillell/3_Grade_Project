package notePad.step02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class NoteActionListener implements ActionListener{
	//멤버변수
	private Notepad frm;
	private String cmd;
	
	public NoteActionListener(Notepad frm) {
		this.frm = frm;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		cmd = ae.getActionCommand();
		
		if(cmd.equals("새파일")) {
			frm.newFile();
		}
		else if(cmd.equals("열기")) {
			JFileChooser chooser = new JFileChooser();
			
			int ret = chooser.showOpenDialog(null);
			
			if(ret != JFileChooser.APPROVE_OPTION) { //file을 선택하지 않았음
				JOptionPane.showMessageDialog(null,
						"파일을 선택하지 않았습니다.", "경고", 
						JOptionPane.WARNING_MESSAGE);
				return;
			}	
			//사용자가 선택한 파일명을 가져옴
			String sFile = chooser.getSelectedFile().getPath();	
			frm.loadFile(sFile);
			
		}
		else if(cmd.equals("저장")) {
			JFileChooser chooser = new JFileChooser();
			
			int ret = chooser.showSaveDialog(null);
			
			if(ret != JFileChooser.APPROVE_OPTION) { //file을 선택하지 않았음
				JOptionPane.showMessageDialog(null,
						"파일을 저장하지 않았습니다.", "경고", 
						JOptionPane.WARNING_MESSAGE);
				return;
			}	
			//사용자가 선택한 파일명을 가져옴
			String sFile = chooser.getSelectedFile().getPath();	
			frm.saveFile(sFile);
		}
		else if(cmd.equals("다른이름으로저장")) {
			JFileChooser chooser = new JFileChooser();
			
			int ret = chooser.showOpenDialog(null);
			
			if(ret != JFileChooser.APPROVE_OPTION) { //file을 선택하지 않았음
				JOptionPane.showMessageDialog(null,
						"파일을 저장하지 않았습니다.", "경고", 
						JOptionPane.WARNING_MESSAGE);
				return;
			}	
			//사용자가 선택한 파일명을 가져옴
			String sFile = chooser.getSelectedFile().getPath();	
			frm.saveFile(sFile);
		}
		else {
			frm.windowClosing(null);
		}
		
	}

}
