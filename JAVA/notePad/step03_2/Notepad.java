package notePad.step03_2;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

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
	private String filename = null;
	
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
	
	public void itemAdd(String title, JMenu m) {
		JMenuItem mi = new JMenuItem(title);
		mi.addActionListener(nal);
		m.add(mi);
	}
	
	public void newFile() {//새 파일
		filename = "새 파일";
		setTitle(filename);
		ta.setText("");
	}
	
	public void loadFile(String fn) {//열기
		File file = new File(fn);
		Path sourcePath = Paths.get(fn);
			
		try {
			ByteBuffer buf = ByteBuffer.allocate(1024);
			FileChannel fileChannel = FileChannel.open(sourcePath, StandardOpenOption.READ);
			Charset charset = Charset.defaultCharset();
			ta.setText("");
			
			while(fileChannel.read(buf) != -1) {
				buf.flip();
				ta.append(charset.decode(buf).toString() + "");
				buf.clear();
			}
		}catch (IOException e) {		
			e.printStackTrace();
		}
		filename = fn;
		this.setTitle(fn);
	}
	
	public void saveFile(String fn) {//저장
		File file = new File(fn);
		Path path = Paths.get(fn);
		
		try {
			FileChannel dup = FileChannel.open(path,
					StandardOpenOption.WRITE, StandardOpenOption.CREATE);
			
			ByteBuffer buf = ByteBuffer.allocate(1024);
			String s = ta.getText();
			
			buf.put(s.getBytes());
			buf.flip();
			
			dup.write(buf);
			dup.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public JTextArea getTa() {
		return ta;
	}
	
	public String getFilename() {
		return filename;
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
