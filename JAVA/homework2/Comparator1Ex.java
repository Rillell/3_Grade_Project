package homework2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Comparator1Ex {

	public static void main(String[] args) {
		List<Car> list = Car.cars.subList(0, 3); // 0 1 2 3 =>4개
		Car[] cars = list.toArray(new Car[3]); //배열 3개의 리스트
		
		Comparator<Car> modelComparator = Comparator.comparing(Car::getModel); //먼저 들어온 모델 3개
		
		System.out.println(Arrays.toString(cars)); //먼저 온 3개
		Arrays.sort(cars, modelComparator);
		System.out.println(Arrays.toString(cars));
		
		Arrays.sort(cars, modelComparator.reversed()); //반대로 출력
		System.out.println(Arrays.toString(cars));
		
		Arrays.sort(cars, Comparator.comparingInt(Car::getMileage)); //주행거리 적은 순
		System.out.println(Arrays.toString(cars));
		
		Arrays.sort(cars, Comparator.comparing(Car::getMileage, (a, b) -> b - a)); //주행거리 긴순
		System.out.println(Arrays.toString(cars));
		
		
	}

}
