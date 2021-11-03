package lect10;

import java.util.Comparator;

//���ٽ� ��뿡 ���ǻ���
@FunctionalInterface
interface UseThis{
	void use();
}

public class UseLamdaEx {
	public void lamda() {
		String hi = "Hi!!";
		
		//�͸��� ��ü�� ����
		UseThis u1 = new UseThis() {
			@Override
			public void use() {
				System.out.println(this); //1.������ü(�͸�ü)������ this�� ������ü �ڽ��̴� ==> UseThis��ü
				//hi = hi + "Lamda!!"; //2. ������ü������ �ܺ����������� ����Ҷ� final�� �ν� => ���� ������ �� ����
				System.out.println(hi);
			}	
		};
		u1.use();
		
		//���ٽ����� ����
		UseThis u2 = () -> {
			System.out.println(this); //2. ���ٽ��� this�� ���ٽ��� ������ �ܺΰ�ü�� �ǹ� ==> UseLamdaEx
			//hi = hi + "lamda"; //2. ���ٽĿ��� ����ϴ� ���������� final�� �ν� ==> ������ �� ����.
			System.out.println(hi);
		};
		u2.use();
	}
	
	public String toString() {
		return "UseLamdaEx";
	}
	
	public static void main(String[] args) {
		int one = 1;
		new UseLamdaEx().lamda();
		//3. ���ٽ� �ܺο��� ����� ������ �̸��� ������ ���ٽĿ����� ����� �� ���� 
		//Comparator<String> c = (one, two) -> {return one.length() - two.length();};
	}

}
