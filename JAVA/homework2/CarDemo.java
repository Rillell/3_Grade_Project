package homework2;

import java.util.ArrayList;
import java.util.List;

public class CarDemo {
	public static void main(String[] args) {
		List<Car> dieselCars = findCars(Car.cars, c -> !c.isGasoline());  //���ָ��� �ƴ� ����
		//List<Car> dieselCars = findCars(Car.cars, Car::isGasoline);
		System.out.println("������ �ڵ��� = " + dieselCars);
		
		List<Car> oldCars = findCars(Car.cars, c -> c.getAge() > 10);  //������ 10�� �̻��� ���� 
		System.out.println("������ �ڵ��� = " + oldCars);
		
		List<Car> oldDieselCars = findCars(Car.cars, c -> c.getAge() > 10 && !c.isGasoline());  //10�� �̻��̰� ���ָ��� �ƴ� ����
		System.out.println("������ ������ �ڵ��� = " + oldDieselCars);
		
		List<Car> youngCars = findCars(Car.cars, c -> c.getAge() < 10 && c.isGasoline());  //������ 10�� �̻��� ���� 
		System.out.println("10�� ������ ���ָ� �ڵ��� = " + youngCars);
		
		System.out.print("������ �ڵ��� = ");
		printCars(dieselCars, c -> System.out.printf("%s(%d) " , c.getModel(), c.getAge()));  //�𵨸�, ����
		System.out.print("\n������ �ڵ��� = ");
		printCars(oldCars, c -> System.out.printf("%s(%d, %d) ", c.getModel(), c.getAge(), c.getMileage()));  //�𵨸�, ����, ����Ÿ�
		
	}
	
	public static List<Car> findCars(List<Car> all, CarPredicate cp){ //�޼��� ����
		List<Car> result = new ArrayList<>(); //list����
		for(Car car : all) {  //List<Car>�� �ڷḦ car�� ����
			if(cp.test(car))  //cp.test(car) == true�� ���
				result.add(car);  //result�� car�߰� 
		}
		return result; 
	}
	public static void printCars(List<Car> all, CarConsumer cc) {
		for(Car car : all) { //List<Car>�� �ڷḦ car�� ����
			cc.accept(car); 
		}
	}
	
}
