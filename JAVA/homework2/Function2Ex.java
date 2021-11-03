package homework2;

import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class Function2Ex {
	public static void main(String[] args) {
		Function<Car, String> f1 = c -> c.getModel(); //String타입으로 모델명 반환
		ToIntFunction<Car> f2 = c -> c.getAge();  //연식 반환
		
		for(Car car : Car.cars)
			//(모델명, 연식)출력
			System.out.print("(" + f1.apply(car) + ", " + f2.applyAsInt(car) + ")");
		System.out.println();
		
		double averageAge = average(Car.cars, c -> c.getAge()); 
		double avergeMileage =  average(Car.cars, c -> c.getMileage());
		
		System.out.println("평균 연식 = " + averageAge);
		System.out.println("평균 주행거리 = " + avergeMileage);
	}
	
	static public double average(List<Car> cars, ToIntFunction<Car> f) { //평균 메서드 작성
		double sum = 0.0;
		for(Car car : cars)
			sum += f.applyAsInt(car);
		return sum / cars.size(); //sum / 차의 개수
	}
}
