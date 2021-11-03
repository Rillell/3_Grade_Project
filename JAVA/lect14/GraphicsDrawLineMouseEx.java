package lect14;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

class MyPanel extends JPanel{
	private Vector<Point> vStart = new Vector<Point>();
	private Vector<Point> vEnd = new Vector<Point>();
	
	public MyPanel() {
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Point startP = e.getPoint();
				vStart.add(startP);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				Point endP = e.getPoint();
				vEnd.add(endP);
				
				repaint(); //paintComponent 메서드 호출
			}
		});	
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g); //초기화
		g.setColor(Color.BLUE);
		
		for(int i=0; i<vStart.size(); i++) {
			Point s = vStart.elementAt(i);
			Point e = vEnd.elementAt(i);
			g.drawLine((int)s.getX(), (int)s.getY(), (int)e.getX(), (int)e.getY());
		}
	}
}

public class GraphicsDrawLineMouseEx extends JFrame{
	public GraphicsDrawLineMouseEx() {
		this.setTitle("마우스로 그리기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		this.add(new MyPanel());
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new GraphicsDrawLineMouseEx();
	}

}
