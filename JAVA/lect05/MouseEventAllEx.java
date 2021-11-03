package lect05;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

//MouseEvent
//ctrl + shift + o

//4. JFrame을 리스너로 구현
public class MouseEventAllEx extends JFrame 
implements MouseListener, MouseMotionListener{
	//멤버변수
	private JLabel label = new JLabel("    Move Me");
	
	//메서드
	
	//생성자
	public MouseEventAllEx() {
		this.setTitle("Mouse Event 예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		
		this.setLayout(null); //배치관리자 제거
		label.setLocation(50, 50);
		label.setSize(80, 20);
		
		this.add(label);
		
		//1. 이벤트 소스 결정 : JFrame
		//2. 이벤트 종류 결정 : MouseEvent, MouseMotionEvent
		//3. 리스너 구현 : MouseListener, MouseMotionListener
		//5. 리스너 연결
		Container c = this.getContentPane();
		//this.addMouseListener(this);
		c.addMouseListener(this);
		c.addMouseMotionListener(this);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MouseEventAllEx();
	}

	//MouseListener 재정의
	@Override
	public void mousePressed(MouseEvent e) {		
		label.setLocation(e.getX(), e.getY());
		this.setTitle("mousePressed(" + e.getX() + ", " + e.getY() + ")");
	}

	@Override
	public void mouseReleased(MouseEvent e) {		
		label.setLocation(e.getX(), e.getY());
		this.setTitle("mouseReleased(" + e.getX() + ", " + e.getY() + ")");
	}

	@Override
	public void mouseEntered(MouseEvent e) {	
		Component comp = (Component)e.getSource();
		comp.setBackground(Color.CYAN);
		this.setTitle("mouseEntered(" + e.getX() + ", " + e.getY() + ")");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Component comp = (Component)e.getSource();
		comp.setBackground(Color.YELLOW);
		this.setTitle("mouseExited(" + e.getX() + ", " + e.getY() + ")");
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		label.setLocation(e.getX(), e.getY());
		this.setTitle("mouseClicked(" + e.getX() + ", " + e.getY() + ")");
	}
	//MouseMotionLisstener 구현
	@Override
	public void mouseDragged(MouseEvent e) {
		label.setLocation(e.getX(), e.getY());
		this.setTitle("mouseDragged(" + e.getX() + ", " + e.getY() + ")");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		label.setLocation(e.getX(), e.getY());
		this.setTitle("mouseMoved(" + e.getX() + ", " + e.getY() + ")");		
	}
}
