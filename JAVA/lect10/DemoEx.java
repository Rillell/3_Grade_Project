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
		return String.format("�簢��[��=%d, ����=%d]",width, height);
	}
}
//��ü��
public class DemoEx {
	public static void main(String[] args) {
		RectangleR[] retangles = {new RectangleR(100, 20),
								  new RectangleR(5, 4),
								  new RectangleR(10, 10)};
		Arrays.sort(retangles); //Comparable ��ü�� �Ǿ�� ��ü �񱳰� ����
		for(RectangleR r:retangles) System.out.println(r);	
	}
}
