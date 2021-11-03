package homework2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Comparator1Ex {

	public static void main(String[] args) {
		List<Car> list = Car.cars.subList(0, 3); // 0 1 2 3 =>4��
		Car[] cars = list.toArray(new Car[3]); //�迭 3���� ����Ʈ
		
		Comparator<Car> modelComparator = Comparator.comparing(Car::getModel); //���� ���� �� 3��
		
		System.out.println(Arrays.toString(cars)); //���� �� 3��
		Arrays.sort(cars, modelComparator);
		System.out.println(Arrays.toString(cars));
		
		Arrays.sort(cars, modelComparator.reversed()); //�ݴ�� ���
		System.out.println(Arrays.toString(cars));
		
		Arrays.sort(cars, Comparator.comparingInt(Car::getMileage)); //����Ÿ� ���� ��
		System.out.println(Arrays.toString(cars));
		
		Arrays.sort(cars, Comparator.comparing(Car::getMileage, (a, b) -> b - a)); //����Ÿ� ���
		System.out.println(Arrays.toString(cars));
		
		
	}

}
