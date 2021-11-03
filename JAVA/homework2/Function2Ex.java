package homework2;

import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class Function2Ex {
	public static void main(String[] args) {
		Function<Car, String> f1 = c -> c.getModel(); //StringŸ������ �𵨸� ��ȯ
		ToIntFunction<Car> f2 = c -> c.getAge();  //���� ��ȯ
		
		for(Car car : Car.cars)
			//(�𵨸�, ����)���
			System.out.print("(" + f1.apply(car) + ", " + f2.applyAsInt(car) + ")");
		System.out.println();
		
		double averageAge = average(Car.cars, c -> c.getAge()); 
		double avergeMileage =  average(Car.cars, c -> c.getMileage());
		
		System.out.println("��� ���� = " + averageAge);
		System.out.println("��� ����Ÿ� = " + avergeMileage);
	}
	
	static public double average(List<Car> cars, ToIntFunction<Car> f) { //��� �޼��� �ۼ�
		double sum = 0.0;
		for(Car car : cars)
			sum += f.applyAsInt(car);
		return sum / cars.size(); //sum / ���� ����
	}
}
