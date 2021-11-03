package homework2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Comparator2Ex {

	public static void main(String[] args) {
		List<Car> list = Car.cars.subList(0, 3); //서브리스트 0 1 2 3 
		Car[] cars = list.toArray(new Car[4]); //리스트 배열4칸
		
		Comparator<Car> modelComparator = Comparator.comparing(Car::getModel);
		
		System.out.println(Arrays.toString(cars));
		Comparator<Car> modelComparatorNullsFirst = Comparator.nullsFirst(modelComparator); //null값이 맨 앞으로
		Arrays.sort(cars, modelComparatorNullsFirst); //null을 객체보다 작은 값으로 취급하는 Comparator반환
		System.out.println(Arrays.toString(cars));
		
		list.set(2,  new Car("코란도", false, 10, 220000));  //3번째에 리스트요소 추가
		cars = list.toArray(new Car[3]); //3칸의 배열
		System.out.println(Arrays.toString(cars));
		Comparator<Car> modelNAgeComparator = modelComparator.thenComparing(Car::getAge); //새로운 Comparator반환
		Arrays.sort(cars, modelNAgeComparator);
		System.out.println(Arrays.toString(cars)); //나이 적은 순

	}

}
