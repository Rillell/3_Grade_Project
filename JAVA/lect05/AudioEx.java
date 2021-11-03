package lect05;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;

//����� ���
public class AudioEx extends JFrame{
	//�������
	private JButton[] btn = {   new JButton("Play"), 
								new JButton("stop"),
								new JButton("play again")};
	private Clip clip;
	
	//������
	public AudioEx() {
		this.setTitle("����� ����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		
		//������Ʈ �߰�
		this.setLayout(new FlowLayout());
		for(int i=0; i<btn.length; i++) {
			this.add(btn[i]);
			btn[i].addActionListener((ActionEvent e)->{
				switch(e.getActionCommand()) {
				case "Play" :
					clip.start();
					break;
				case "stop":
					clip.stop();
					break;
				case "play again" :
					clip.setFramePosition(0);
					clip.start();
					break;
				}
			});
		}
		
		this.setVisible(true);
		loadAudio("./audio/�ֱ���1��.wav");
	}
	
	//clip load �޼���
	public void loadAudio(String pathName) {
		try {
			clip = AudioSystem.getClip();
			File audioFile = new File(pathName);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			clip.open(audioStream);		
		} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new AudioEx();
	}
}
