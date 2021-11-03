package homework2;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface CarConsumer{
	void accept(Car car);
}
@FunctionalInterface
interface CarPredicate{
	boolean test(Car car);
}
public class Car {
	//멤버변수
	private String model; //모델명
	private boolean gasoline; //가솔린 <-> 디젤
	private int age; //연식
	private int mileage; //주행거리
	
	//생성자
	public Car(String model, boolean gasoline, int age, int mileage) { 
		this.model = model;
		this.gasoline = gasoline;
		this.age = age;
		this.mileage = mileage;
	}
	//메서드 선언
	public String getModel() {return model;} 
	public boolean isGasoline() {return gasoline;}
	public int getAge() {return age;}
	public int getMileage() {return mileage;}
	public String toString() {
		return String.format("Car(%s, %s, %d, %d)",  model, gasoline, age, mileage); //리턴되는 문자열 형태 지정
	}
	public static final List<Car> cars = Arrays.asList( //list생성, final: 변경불가
			new Car("소나타", true, 18, 210000), // 소나타, 가솔린차량, 18년, 주행거리
			new Car("코란도", false, 15, 200000),
			new Car("그랜저", true, 12, 150000),
			new Car("싼타페", false, 10, 220000),
			new Car("아반테", true, 10, 70000),
			new Car("에쿠스", true, 6, 100000),
			new Car("그랜저", true, 5, 80000),
			new Car("소나타", true, 2, 35000),
			new Car("쏘렌토", false, 1, 10000),
			new Car("아반테", true, 1, 7000));			
}

