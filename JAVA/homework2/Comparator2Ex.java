package homework2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Comparator2Ex {

	public static void main(String[] args) {
		List<Car> list = Car.cars.subList(0, 3); //���긮��Ʈ 0 1 2 3 
		Car[] cars = list.toArray(new Car[4]); //����Ʈ �迭4ĭ
		
		Comparator<Car> modelComparator = Comparator.comparing(Car::getModel);
		
		System.out.println(Arrays.toString(cars));
		Comparator<Car> modelComparatorNullsFirst = Comparator.nullsFirst(modelComparator); //null���� �� ������
		Arrays.sort(cars, modelComparatorNullsFirst); //null�� ��ü���� ���� ������ ����ϴ� Comparator��ȯ
		System.out.println(Arrays.toString(cars));
		
		list.set(2,  new Car("�ڶ���", false, 10, 220000));  //3��°�� ����Ʈ��� �߰�
		cars = list.toArray(new Car[3]); //3ĭ�� �迭
		System.out.println(Arrays.toString(cars));
		Comparator<Car> modelNAgeComparator = modelComparator.thenComparing(Car::getAge); //���ο� Comparator��ȯ
		Arrays.sort(cars, modelNAgeComparator);
		System.out.println(Arrays.toString(cars)); //���� ���� ��

	}

}
