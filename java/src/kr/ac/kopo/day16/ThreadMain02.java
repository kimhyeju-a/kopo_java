package kr.ac.kopo.day16;
/*
 * Thread 생성하는 2가지 방식
 * 1. thread 클래스 상속
 * 2. Runnable 인터페이스 상속
 */
class ExtendThread extends Thread{

	@Override
	public void run() {
		for(int i = 1; i <=100; i++) {
			System.out.println( i + "번째 인형 눈 붙이기 ");
		}
	}
	
}

class ImplementThread implements Runnable{

	@Override
	public void run() {
		for(int i = 1; i <=100; i++) {
			System.out.println( i + "번째 인형 입 만들기 ");
		}
	}
}

public class ThreadMain02 {

	public static void main(String[] args) {

		System.out.println("현재실행중인 스레드 개수 : " + Thread.activeCount());
		ExtendThread et = new ExtendThread();
		ImplementThread ie = new ImplementThread();
		Thread t = new Thread(ie);
		et.start(); // 이스레드는 메인에 있는 스레드가 아니다. 따라서 메인에 있는 동작보다 늦게 끝날수도, 빨리 끝날수도 있다.
		t.start();
		//		ie.start();
		// thread 클래스에만 start가 있기 때문에 사용이 불가능하다. 
		// runnable 클래스는 무조건 run만 가능하다.
		for(int i = 1; i <= 100; i++) {
			System.out.println("이것보다 밑에있는 activecount가 먼저 나올 수 없다.");
		}
		System.out.println("현재실행중인 스레드 개수 : " + Thread.activeCount());
		
		try {
			et.join();
			t.join();
		} catch (Exception e) {
		e.printStackTrace();
		}
		System.out.println("인형만들기 감독 종료");
	}
}
