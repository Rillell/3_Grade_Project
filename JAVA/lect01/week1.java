package lect01;
import java.util.*;

public class week1 {

	public static void main(String[] args) {
		HashMap<String, String> dic = new HashMap<String, String>();
		
		dic.put("1001", "홍길동  10199998888  Hong@mail.com");
		dic.put("1002", "임꺽정  10122223333  Lim@mail.com");
		dic.put("1003", "알파고  10155557777  Alphgo@mail.com");
		
		Set<String> keys = dic.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String key = it.next();
			String value = dic.get(key);
			System.out.print("(" + key + " : " + value + ")");
		}
		System.out.println();
		
		Scanner scanner = new Scanner(System.in);
		for(int i = 0; i<4; i++) {
			System.out.print("학번 : ");
			String eng = scanner.next();
			String kor = dic.get(eng);
			if(kor == null)System.out.println(eng + "는 존재하지 않는 학번입니다.");
			else System.out.println(kor);
		}

	}

}
