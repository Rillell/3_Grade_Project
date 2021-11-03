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
		return String.format("사각형[폭=%d, 높이=%d]",width, height);
	}

	@Override
	public int compareTo(Rectangle o) {
		return findArea() - o.findArea();
	}
}
*/
//객체비교
public class LamdaDemoEx {
	public static void main(String[] args) {
		//Comparator 객체가 final클래스에 대한 비교기준 추가
		String[] strings = { "로마에 가면 로마의 법을 따르라.",
							"너 자신을 알라!",
							"펜은 칼보다 강하다!"	
						   };
		//익명의 객체로 정의
		//==>람다식으로 변경
		Arrays.sort(strings,(first, second)-> 
		{return first.length() - second.length();});
		
		
		for(String s:strings) System.out.println(s);
		
		//객체에 비교기준 제시

		Rectangle[] retangles = {new Rectangle(100, 20),
								  new Rectangle(5, 4),
								  new Rectangle(10, 10)};
		//익명의 객체로 정의
		//==>람다식으로 변경
		Arrays.sort(retangles, (first, second)->
		{return first.findArea() - second.findArea();});
		
		for(Rectangle r:retangles) System.out.println(r);

	}
}
