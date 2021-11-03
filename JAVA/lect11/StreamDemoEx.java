package lect11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class StreamDemoEx {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		Random r = new Random();
		for(int i = 0; i<10; i++) 
			list.add(r.nextInt(30));
		
		//filter: > 10, sort, ���
		//1) Collection�����ӿ�ũ �����
		List<Integer> gt10 = new ArrayList();
		for(int i:list)
			if(i>10) gt10.add(i);
		
		Collections.sort(gt10);
		System.out.println(gt10);
		
		
		//2) Stream ó�� ���
		list.stream().filter(i -> i > 10).sorted().forEach(x -> System.out.print(x + " "));
		
		
	}
}
