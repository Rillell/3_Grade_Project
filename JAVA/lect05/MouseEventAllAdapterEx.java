package lect05;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

//MouseEvent
//ctrl + shift + o

//4. �͸� �����ʷ� ����
public class MouseEventAllAdapterEx extends JFrame {
	//�������
	private JLabel label = new JLabel("    Move Me");
	
	//�޼���
	
	//������
	public MouseEventAllAdapterEx() {
		this.setTitle("Mouse Event ����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		
		this.setLayout(null); //��ġ������ ����
		label.setLocation(50, 50);
		label.setSize(80, 20);
		
		this.add(label);
		
		//1. �̺�Ʈ �ҽ� ���� : JFrame
		//2. �̺�Ʈ ���� ���� : MouseEvent, MouseMotionEvent
		//3. ������ ���� : MouseListener, MouseMotionListener
		//5. ������ ����
		Container c = this.getContentPane();
		//this.addMouseListener(this);
		//MouseAdapter �����Ͽ� �͸��� �����ʷ� ����
		c.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Component comp = (Component)e.getSource();
				comp.setBackground(Color.CYAN);
				setTitle("mouseEntered(" + e.getX() + ", " + e.getY() + ")");			
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Component comp = (Component)e.getSource();
				comp.setBackground(Color.YELLOW);
				setTitle("mouseExited(" + e.getX() + ", " + e.getY() + ")");				
			}
		});
		//MouseMotionAdapter�� �����ؼ� �͸��� �����ʷ� ����
		c.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				label.setLocation(e.getX(), e.getY());
				setTitle("mouseMoved(" + e.getX() + ", " + e.getY() + ")");			
			}		
		});
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MouseEventAllAdapterEx();
	}
}
