package lect10;

import java.util.Arrays;
import java.util.Comparator;
/*
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
*/
//��ü��
public class LamdaDemoEx {
	public static void main(String[] args) {
		//Comparator ��ü�� finalŬ������ ���� �񱳱��� �߰�
		String[] strings = { "�θ��� ���� �θ��� ���� ������.",
							"�� �ڽ��� �˶�!",
							"���� Į���� ���ϴ�!"	
						   };
		//�͸��� ��ü�� ����
		//==>���ٽ����� ����
		Arrays.sort(strings,(first, second)-> 
		{return first.length() - second.length();});
		
		
		for(String s:strings) System.out.println(s);
		
		//��ü�� �񱳱��� ����

		Rectangle[] retangles = {new Rectangle(100, 20),
								  new Rectangle(5, 4),
								  new Rectangle(10, 10)};
		//�͸��� ��ü�� ����
		//==>���ٽ����� ����
		Arrays.sort(retangles, (first, second)->
		{return first.findArea() - second.findArea();});
		
		for(Rectangle r:retangles) System.out.println(r);

	}
}
