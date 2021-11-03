package lect02;
import javax.swing.JFrame;


//1. JFrame °´Ã¼È­ÇØ¼­ »ý¼º
public class jFrameTest {
	
	public jFrameTest() {
		//JFrame °´Ã½
		JFrame frame = new JFrame();
		
		//¼³Á¤
		frame.setTitle("JFrame Test");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
	}
	
	public static void main(String[] args){
		jFrameTest jft = new jFrameTest();

	}
}

