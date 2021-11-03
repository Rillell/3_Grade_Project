package lect14;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Shape2DPanel2 extends JPanel{
	ArrayList<Shape> shapeArray = new ArrayList<Shape>();
	public Shape2DPanel2() {
		//그릴 도형을 정의
		Shape s;
		
		//그릴 도형 설정
		s = new Rectangle2D.Float(10, 10, 70, 80);
		shapeArray.add(s);
		s = new RoundRectangle2D.Float(110, 10, 70, 80, 20, 20);
		shapeArray.add(s);
		s = new Ellipse2D.Float(210, 10, 80, 80);
		shapeArray.add(s);
		s = new Arc2D.Float(310, 10, 80, 80, 90, 90, Arc2D.OPEN);
		shapeArray.add(s);
		s = new Arc2D.Float(410, 10, 80, 80, 90, 90, Arc2D.CHORD);
		shapeArray.add(s);
		s = new Arc2D.Float(510, 10, 80, 80, 90, 90, Arc2D.PIE);
		shapeArray.add(s);
		
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g); //초기화
		//2D그리기
		Graphics2D g2 = (Graphics2D)g;
		
		//그리기 환경설정
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.red);
		g2.setStroke(new BasicStroke(3));
		//Gradient효과 주기
		GradientPaint gp = new GradientPaint(0, 10, Color.WHITE, 0, 70, Color.RED);
		g2.setPaint(gp);
		for(Shape s : shapeArray) g2.fill(s);
	}
	
}


public class MoreShapeEx2 extends JFrame{

	public MoreShapeEx2() {
		this.setTitle("2D 그래픽 그리기");
		this.setSize(600, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Shape2DPanel2 panel = new Shape2DPanel2();
		this.add(panel);
		
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new MoreShapeEx2();
	}

}
