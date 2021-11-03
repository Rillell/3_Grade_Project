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

//오디오 재생
public class AudioEx extends JFrame{
	//멤버변수
	private JButton[] btn = {   new JButton("Play"), 
								new JButton("stop"),
								new JButton("play again")};
	private Clip clip;
	
	//생성자
	public AudioEx() {
		this.setTitle("오디오 제어");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		
		//컴포넌트 추가
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
		loadAudio("./audio/애국가1절.wav");
	}
	
	//clip load 메서드
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
