package lect10;

import java.util.Arrays;

class RectangleR{
	private int width, height;
	
	public RectangleR(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public int findArea() {
		return width*height;
	}
	
	public String toString() {
		return String.format("사각형[폭=%d, 높이=%d]",width, height);
	}
}
//객체비교
public class DemoEx {
	public static void main(String[] args) {
		RectangleR[] retangles = {new RectangleR(100, 20),
								  new RectangleR(5, 4),
								  new RectangleR(10, 10)};
		Arrays.sort(retangles); //Comparable 객체가 되어야 객체 비교가 가능
		for(RectangleR r:retangles) System.out.println(r);	
	}
}
