package notePad.step03;

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
			String s = frm.getTa().getText();
			if(s.length() == 0) {
				frm.newFile();
			}
			else{
				int result = JOptionPane.showConfirmDialog(null, "작성한 내용이 있습니다.\n저장하시겠습니까?", 
						"Confirm", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.CLOSED_OPTION) {
					frm.newFile();
				}
				else if(result == JOptionPane.YES_OPTION) {
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
				else
					frm.newFile();
			}
		}			
	
		
		else if(cmd.equals("열기")) {
			String s = frm.getTa().getText();
			if(s.length() == 0){//작성한 내용이 없을때
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
			else {//작성 내용이 있을떄
				int result = JOptionPane.showConfirmDialog(null, "작성한 내용이 있습니다.\n저장하시겠습니까?", 
						"Confirm", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.CLOSED_OPTION) { //저장 안하고 파일열기
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
				else if(result == JOptionPane.YES_OPTION) { //저장하기
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
				else {//저장 안하고 파일 열기
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
			}
			
			
			
		}
		else if(cmd.equals("저장")) {
			if(frm.getFilename() == null || frm.getFilename() == "새 파일") { //파일 이름이 없거나 '새 파일' 인 경우 
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
			else{ //파일 이름이 있을 경우
				frm.saveFile(frm.getFilename());
				JOptionPane.showMessageDialog(null, "저장하였습니다.", "Message", JOptionPane.PLAIN_MESSAGE);
			}		
			
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
			String s = frm.getTa().getText();
			if(s.length() == 0) {
				frm.windowClosing(null);
			}
			else{
				int result = JOptionPane.showConfirmDialog(null, "작성한 내용이 있습니다.\n저장하시겠습니까?", 
						"Confirm", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.CLOSED_OPTION) {
					frm.windowClosing(null);
				}
				else if(result == JOptionPane.YES_OPTION) {
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
				else
					frm.windowClosing(null);
			}
		}
		
	}

}
