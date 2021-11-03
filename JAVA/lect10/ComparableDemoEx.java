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
		return String.format("�簢��[��=%d, ����=%d]",width, height);
	}

	@Override
	public int compareTo(Rectangle o) {
		return findArea() - o.findArea();
	}
}
//��ü��
public class ComparableDemoEx {
	public static void main(String[] args) {
		Rectangle[] retangles = {new Rectangle(100, 20),
								  new Rectangle(5, 4),
								  new Rectangle(10, 10)};
		Arrays.sort(retangles); //Comparable ��ü�� �Ǿ�� ��ü �񱳰� ����
		for(Rectangle r:retangles) System.out.println(r);	
	}
}
