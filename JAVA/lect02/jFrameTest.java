package lect02;
import javax.swing.JFrame;


//1. JFrame ��üȭ�ؼ� ����
public class jFrameTest {
	
	public jFrameTest() {
		//JFrame ��ý
		JFrame frame = new JFrame();
		
		//����
		frame.setTitle("JFrame Test");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
	}
	
	public static void main(String[] args){
		jFrameTest jft = new jFrameTest();

	}
}

