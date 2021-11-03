package lect13;

public class MainThreadEx {
	public static void main(String[] args) {
		long id = Thread.currentThread().getId();
		String name = Thread.currentThread().getName();
		int priority = Thread.currentThread().getPriority();
		Thread.State s = Thread.currentThread().getState();
		
		System.out.println("현재 쓰레드의 이름 : " + name);
		System.out.println("현재 쓰레드의 id : " + id);
		System.out.println("현재 쓰레드의 우선순위 : " + priority);
		System.out.println("현재 쓰레드의 상태값 : " + s);
	}
}
