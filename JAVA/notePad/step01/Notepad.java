package notePad.step01;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;


public class Notepad extends JFrame implements WindowListener{
	//멤버변수
	private NoteActionListener nal;
	public JTextArea ta = new JTextArea(7, 20);
	private JMenuBar mb = new JMenuBar();
	private JMenu mfile;
	private String filename = "새파일";
	
	//생성자
	public Notepad() {
		this.setTitle(filename);
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.add(ta, BorderLayout.CENTER);	
		nal = new NoteActionListener(this);
		addWindowListener(this);
		
		mfile = new JMenu("파일");
		itemAdd("새파일", mfile);
		itemAdd("열기", mfile);
		itemAdd("저장", mfile);
		itemAdd("다른이름으로저장", mfile);
		itemAdd("종료", mfile);
		
		mb.add(mfile);
		setJMenuBar(mb);
		
		
		this.setVisible(true);
	}
	
	public void newFile() {
		ta.setText("");
	}
	
	public void itemAdd(String title, JMenu m) {
		JMenuItem mi = new JMenuItem(title);
		mi.addActionListener(nal);
		m.add(mi);
	}
	
	@Override
	public void windowClosing(WindowEvent we) {
		System.exit(0);
	}
	
	public static void main(String[] args) {
		new Notepad();
	}

	
	
	
	@Override
	public void windowOpened(WindowEvent e) {}
	@Override
	public void windowClosed(WindowEvent e) {}
	@Override
	public void windowIconified(WindowEvent e) {}
	@Override
	public void windowDeiconified(WindowEvent e) {}
	@Override
	public void windowActivated(WindowEvent e) {}
	@Override
	public void windowDeactivated(WindowEvent e) {}

}
