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
	//���� ������ ����
	private Pen p = null;
	//�׸��� �׸��� ���� ��ü
	private Graphics g = null;
	private Graphics2D g2 = null;
	//���콺�� ��ǥ������ �����ϱ� ���� ����
	private int xp = 0;
	private int yp = 0;
	private int xr = 0;
	private int yr = 0;
	
	public MCanvas(Pen pen, String address, int port) {
		this.p = pen;
		//Thread ���� �� �⵿
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
				//��Ƽĳ��Ʈ �׷쿡�� �۽�
				rr.send(xp, yp, xr, yr, p.getType());
			}
		});	
	}
	
	public void draw() {
		g = this.getGraphics();
		g2 = (Graphics2D) g;
		//g2����
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.BLUE);
		g2.setStroke(new BasicStroke(2));
		
		Shape s;
		
		//���� Ÿ�Կ� ���� �׸��� 
		switch(p.getType()) {
			case 0: //�簢��
				//�簢���׸���
				s = new Rectangle(getStartX(), getStartY(), getW(), getH());
				g2.draw(s);
				break;
				
			case 1: //�ﰢ��
				s = new Polygon(getArrayX(), getArrayY(), 3);
				g2.draw(s);
				break;
			case 2 : //�𼭸��� �ձ� �簢��
				s = new RoundRectangle2D.Float(getStartX(), getStartY(), getW(), getH(), 20, 20 );
				g2.draw(s);
				break;
			case 3: //���� ���
				s = new Ellipse2D.Float(getStartX(), getStartY(), getW(), getH());
				g2.draw(s);
				break;
			case 4: //ä���� ��ä�� (����������)
				s = new Arc2D.Float(getStartX(), getStartY(), getW(), getH(), 90, 90, Arc2D.PIE);
				break;
			case 5: //����
				s = new Line2D.Float(xp, yp, xr, yr);
				g2.draw(s);
				break;
			case 6: //���ÿ��� �����
				g2.clearRect(getStartX(), getStartY(), getW(), getH());
				break;
			case 7: //�� �����
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
		//g2����
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.BLUE);
		g2.setStroke(new BasicStroke(2));
		
		Shape s;
		
		//���� Ÿ�Կ� ���� �׸��� 
		switch(penType) {
			case 0: //�簢��
				//�簢���׸���
				s = new Rectangle(getStartX(), getStartY(), getW(), getH());
				g2.draw(s);
				break;
				
			case 1: //�ﰢ��
				s = new Polygon(getArrayX(), getArrayY(), 3);
				g2.draw(s);
				break;
			case 2 : //�𼭸��� �ձ� �簢��
				s = new RoundRectangle2D.Float(getStartX(), getStartY(), getW(), getH(), 20, 20 );
				g2.draw(s);
				break;
			case 3: //���� ���
				s = new Ellipse2D.Float(getStartX(), getStartY(), getW(), getH());
				g2.draw(s);
				break;
			case 4: //ä���� ��ä�� (����������)
				s = new Arc2D.Float(getStartX(), getStartY(), getW(), getH(), 90, 90, Arc2D.PIE);
				g2.draw(s);
				break;
			case 5: //����
				s = new Line2D.Float(xp, yp, xr, yr);
				g2.draw(s);
				break;
			case 6: //���ÿ��� �����
				g2.clearRect(getStartX(), getStartY(), getW(), getH());
				break;
			case 7: //�� �����
				//
				break;
			
		}
		
	}
	
	//���콺 ������ ������ ���� x��ǥ�� ���� ��ȯ�Ѵ�.
	private int getStartX() {
		if(xp > xr) return xr;		
		return xp;
	}
	
	//���콺 ������ ������ ���� y��ǥ�� ���� ��ȯ�Ѵ�.
	private int getStartY() {
		if(yp > yr) return yr;
		return yp;
	}
	
	//���� y��ǥ ������ ū y��ǥ���� �� ���� ��ȯ
	private int getH() {
		int h = 0;
		if(yp > yr) h = yp - yr;
		else h = yr = yp;
		return h;
	}
	
	//���� x��ǥ ������ ū x��ǥ���� �� ���� ��ȯ
	private int getW() {
		int w = 0;		
		if(xp > xr) w = xp - xr;
		else w = xr - xp;		
		return w;
	}
	
	//�ﰢ���� �׸��� ȸ�� x��ǥ�� �迭�� ��ȯ
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
	
	//�ﰢ���� �׸��� ȸ�� y��ǥ�� �迭�� ��ȯ
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
