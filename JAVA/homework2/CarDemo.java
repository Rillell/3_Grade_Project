package homework2;

import java.util.ArrayList;
import java.util.List;

public class CarDemo {
	public static void main(String[] args) {
		List<Car> dieselCars = findCars(Car.cars, c -> !c.isGasoline());  //가솔린이 아닌 차량
		//List<Car> dieselCars = findCars(Car.cars, Car::isGasoline);
		System.out.println("디이젤 자동차 = " + dieselCars);
		
		List<Car> oldCars = findCars(Car.cars, c -> c.getAge() > 10);  //연식이 10년 이상인 차량 
		System.out.println("오래된 자동차 = " + oldCars);
		
		List<Car> oldDieselCars = findCars(Car.cars, c -> c.getAge() > 10 && !c.isGasoline());  //10년 이상이고 가솔린이 아닌 차량
		System.out.println("오래된 디이젤 자동차 = " + oldDieselCars);
		
		List<Car> youngCars = findCars(Car.cars, c -> c.getAge() < 10 && c.isGasoline());  //연식이 10년 이상인 차량 
		System.out.println("10년 이하의 가솔린 자동차 = " + youngCars);
		
		System.out.print("디이젤 자동차 = ");
		printCars(dieselCars, c -> System.out.printf("%s(%d) " , c.getModel(), c.getAge()));  //모델명, 연식
		System.out.print("\n오래된 자동차 = ");
		printCars(oldCars, c -> System.out.printf("%s(%d, %d) ", c.getModel(), c.getAge(), c.getMileage()));  //모델명, 연식, 주행거리
		
	}
	
	public static List<Car> findCars(List<Car> all, CarPredicate cp){ //메서드 선언
		List<Car> result = new ArrayList<>(); //list생성
		for(Car car : all) {  //List<Car>의 자료를 car에 넣음
			if(cp.test(car))  //cp.test(car) == true일 경우
				result.add(car);  //result에 car추가 
		}
		return result; 
	}
	public static void printCars(List<Car> all, CarConsumer cc) {
		for(Car car : all) { //List<Car>의 자료를 car에 넣음
			cc.accept(car); 
		}
	}
	
}
