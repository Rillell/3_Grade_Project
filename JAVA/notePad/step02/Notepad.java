package notePad.step02;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;


public class Notepad extends JFrame implements WindowListener{
	//�������
	private NoteActionListener nal;
	public JTextArea ta = new JTextArea(7, 20);
	private JMenuBar mb = new JMenuBar();
	private JMenu mfile;
	private String filename = "������";
	
	//������
	public Notepad() {
		this.setTitle(filename);
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.add(ta, BorderLayout.CENTER);	
		nal = new NoteActionListener(this);
		addWindowListener(this);
		
		mfile = new JMenu("����");
		itemAdd("������", mfile);
		itemAdd("����", mfile);
		itemAdd("����", mfile);
		itemAdd("�ٸ��̸���������", mfile);
		itemAdd("����", mfile);
		
		mb.add(mfile);
		setJMenuBar(mb);
		
		
		this.setVisible(true);
	}
	
	public void itemAdd(String title, JMenu m) {
		JMenuItem mi = new JMenuItem(title);
		mi.addActionListener(nal);
		m.add(mi);
	}
	
	public void newFile() {//�� ����
		ta.setText("");
	}
	
	public void loadFile(String fn) {//����
		File file = new File(fn);
		FileReader fin;
			
		try {
			fin = new FileReader(file);
			
			int c;
			ta.setText("");
			
			while((c = fin.read()) != -1) {
				ta.append((char)c + "");
			}
			fin.close();
		}catch (IOException e) {		
			e.printStackTrace();
		}
		filename = fn;
		this.setTitle(fn);
	}
	
	public void saveFile(String fn) {//����
		File file = new File(fn);
		FileWriter fout;
		BufferedWriter bw;
		
		try {
			fout = new FileWriter(file);
			bw = new BufferedWriter(fout);
			bw.write(ta.getText());
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		filename = fn;
		this.setTitle(fn);
	}
	
	
	@Override
	public void windowClosing(WindowEvent we) {
		System.exit(0);
	}

	@Override
	public void windowOpened(WindowEvent we) {}
	@Override
	public void windowClosed(WindowEvent we) {}
	@Override
	public void windowIconified(WindowEvent we) {}
	@Override
	public void windowDeiconified(WindowEvent we) {}
	@Override
	public void windowActivated(WindowEvent we) {}
	@Override
	public void windowDeactivated(WindowEvent we) {}
	
	
	public static void main(String[] args) {
		new Notepad();
	}
}
