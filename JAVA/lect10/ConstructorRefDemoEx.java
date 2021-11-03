package lect10;
@FunctionalInterface
interface NewObject<T>{
	T getObject(T o);
}
@FunctionalInterface
interface NewArray<T>{
	T[] getArray(int size);
}

//생성자 참조
public class ConstructorRefDemoEx {
	public static void main(String[] args) {
		NewObject<String> so;
		NewArray<Integer> ia;
		
		//so = s -> new String(s);
		//==> 메서드 참조 : 생성자 참조
		so = String::new;
		String str = so.getObject("비가오니 자고싶어");
		System.out.println(str);
		
		//ia = x -> new Integer[x];
		//==> 메서드 참조 : 생성자 참조
		ia = Integer[]::new;
		Integer[] array = ia.getArray(5);
		
		array[0] = 10;
		array[1] = 11;
		array[2] = 12;
		array[3] = 13;
		array[4] = 14;
		
		for(Integer i:array) System.out.println(i);
	}
}
