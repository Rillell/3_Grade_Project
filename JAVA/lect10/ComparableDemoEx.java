package lect10;

import java.util.Arrays;

class Rectangle implements Comparable<Rectangle>{
	private int width, height;
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public int findArea() {
		return width*height;
	}
	
	public String toString() {
		return String.format("사각형[폭=%d, 높이=%d]",width, height);
	}

	@Override
	public int compareTo(Rectangle o) {
		return findArea() - o.findArea();
	}
}
//객체비교
public class ComparableDemoEx {
	public static void main(String[] args) {
		Rectangle[] retangles = {new Rectangle(100, 20),
								  new Rectangle(5, 4),
								  new Rectangle(10, 10)};
		Arrays.sort(retangles); //Comparable 객체가 되어야 객체 비교가 가능
		for(Rectangle r:retangles) System.out.println(r);	
	}
}
