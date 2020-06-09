package kr.ac.kopo.day16;

class Data {
	public synchronized void a() {
		try {
			notify(); //떙!
			System.out.println("a() 메소드 호출...");
			wait();
		} catch (Exception e) {
		}
//		Thread.yield(); // 현지 run인 아이를 runnable로 바꿔주는 것
	}
	
	public synchronized void b() {
//		Thread.yield(); // 현지 run인 아이를 runnable로 바꿔주는 것 하지만 이것도 찰나의 순간이라 안바뀐것처럼 보일 수 있다.
		try {
			notify();//떙! 
			System.out.println("b() 메소드 호출...");
			
//			wait();
		} catch (Exception e) {
		}
	}
}

class NotifyThread01 extends Thread {
	private Data data;
	
	public NotifyThread01(Data data) {
		this.data = data;
	}

	@Override
	public void run() {
		for(int i =0; i < 10; i++) {
			data.a();
		}
	}
	
}

class NotifyThread02 extends Thread {
	private Data data;
	
	public NotifyThread02(Data data) {
		this.data = data;
	}

	@Override
	public void run() {
		for(int i =0; i < 10; i++) {
			data.b();
		}
	}	
}
public class NotifyMain {

	public static void main(String[] args) {
		Data data = new Data();
		
		//두개의 thread가 공유영역을 사용하고 싶다.
		NotifyThread01 nt01 = new NotifyThread01(data);
		NotifyThread02 nt02 = new NotifyThread02(data);
		
		nt02.start();
		nt01.start();
	}
}
