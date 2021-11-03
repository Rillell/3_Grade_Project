package lect17;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.Line2D.Float;

import javax.swing.JPanel;

public class MCanvas extends JPanel{
	//펜의 종류를 저장
	private Pen p = null;
	//그림을 그리기 위한 객체
	private Graphics g = null;
	private Graphics2D g2 = null;
	//마우스의 좌표정보를 저장하기 위한 변수
	private int xp = 0;
	private int yp = 0;
	private int xr = 0;
	private int yr = 0;
	
	public MCanvas(Pen pen, String address, int port) {
		this.p = pen;
		//Thread 생성 및 기동
		MulticastThread rr = new MulticastThread(address, port, this);
		Thread th = new Thread(rr);
		th.start();
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xp = e.getX();
				yp = e.getY();
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				xr = e.getX();
				yr = e.getY();	
				
				//
				if(xp!=xr && yp!=yr) draw();
				//멀티캐스트 그룹에게 송신
				rr.send(xp, yp, xr, yr, p.getType());
			}
		});	
	}
	
	public void draw() {
		g = this.getGraphics();
		g2 = (Graphics2D) g;
		//g2설정
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.BLUE);
		g2.setStroke(new BasicStroke(2));
		
		Shape s;
		
		//펜의 타입에 따라 그리기 
		switch(p.getType()) {
			case 0: //사각형
				//사각형그리기
				s = new Rectangle(getStartX(), getStartY(), getW(), getH());
				g2.draw(s);
				break;
				
			case 1: //삼각형
				s = new Polygon(getArrayX(), getArrayY(), 3);
				g2.draw(s);
				break;
			case 2 : //모서리가 둥근 사각형
				s = new RoundRectangle2D.Float(getStartX(), getStartY(), getW(), getH(), 20, 20 );
				g2.draw(s);
				break;
			case 3: //원을 출력
				s = new Ellipse2D.Float(getStartX(), getStartY(), getW(), getH());
				g2.draw(s);
				break;
			case 4: //채워진 부채꼴 (파이형으로)
				s = new Arc2D.Float(getStartX(), getStartY(), getW(), getH(), 90, 90, Arc2D.PIE);
				break;
			case 5: //직선
				s = new Line2D.Float(xp, yp, xr, yr);
				g2.draw(s);
				break;
			case 6: //선택영역 지우기
				g2.clearRect(getStartX(), getStartY(), getW(), getH());
				break;
			case 7: //다 지우기
				//g2.c
				break;
			
		}
		
	}
	
	public void draw(int xp, int yp, int xr, int yr, int penType) {
		this.xp = xp;
		this.yp = yp;
		this.xr = xr;
		this.yr = yr;
		
		g = this.getGraphics();
		g2 = (Graphics2D) g;
		//g2설정
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.BLUE);
		g2.setStroke(new BasicStroke(2));
		
		Shape s;
		
		//펜의 타입에 따라 그리기 
		switch(penType) {
			case 0: //사각형
				//사각형그리기
				s = new Rectangle(getStartX(), getStartY(), getW(), getH());
				g2.draw(s);
				break;
				
			case 1: //삼각형
				s = new Polygon(getArrayX(), getArrayY(), 3);
				g2.draw(s);
				break;
			case 2 : //모서리가 둥근 사각형
				s = new RoundRectangle2D.Float(getStartX(), getStartY(), getW(), getH(), 20, 20 );
				g2.draw(s);
				break;
			case 3: //원을 출력
				s = new Ellipse2D.Float(getStartX(), getStartY(), getW(), getH());
				g2.draw(s);
				break;
			case 4: //채워진 부채꼴 (파이형으로)
				s = new Arc2D.Float(getStartX(), getStartY(), getW(), getH(), 90, 90, Arc2D.PIE);
				g2.draw(s);
				break;
			case 5: //직선
				s = new Line2D.Float(xp, yp, xr, yr);
				g2.draw(s);
				break;
			case 6: //선택영역 지우기
				g2.clearRect(getStartX(), getStartY(), getW(), getH());
				break;
			case 7: //다 지우기
				//
				break;
			
		}
		
	}
	
	//마우스 포인터 정보중 작은 x좌표의 값을 반환한다.
	private int getStartX() {
		if(xp > xr) return xr;		
		return xp;
	}
	
	//마우스 포인터 정보중 작은 y좌표의 값을 반환한다.
	private int getStartY() {
		if(yp > yr) return yr;
		return yp;
	}
	
	//작은 y좌표 값에서 큰 y좌표값을 뺀 값을 반환
	private int getH() {
		int h = 0;
		if(yp > yr) h = yp - yr;
		else h = yr = yp;
		return h;
	}
	
	//작은 x좌표 값에서 큰 x좌표값을 뺀 값을 반환
	private int getW() {
		int w = 0;		
		if(xp > xr) w = xp - xr;
		else w = xr - xp;		
		return w;
	}
	
	//삼각형을 그리기 회한 x좌표의 배열을 반환
	private int[] getArrayX() {
		int xa[] = new int[3];
		if(xp > xr) {
			xa[0] = xr;
			xa[1] = xr + (xp - xr);
			xa[2] = xp;
		}else {
			xa[0] = xp;
			xa[1] = xp + (xr-xp);
			xa[2] = xr;
		}
		return xa;
	}
	
	//삼각형을 그리기 회한 y좌표의 배열을 반환
	private int[] getArrayY() {
		int ya[] = new int[3];
		if(yp > yr) {
			ya[0] = yp;
			ya[1] = yr;
			ya[2] = yp;
		}else {
			ya[0] = yr;
			ya[1] = yp;
			ya[2] = yr;
		}
		return ya;
	}
}
