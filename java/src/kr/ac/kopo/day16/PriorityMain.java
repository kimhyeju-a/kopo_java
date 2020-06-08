package kr.ac.kopo.day16;

class PriorityThread extends Thread {

	public PriorityThread() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PriorityThread(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		System.out.println(getName() + " 우선순위 : " + getPriority());
		/*
		 * 우선순위가 높다고 해서 먼저 선택될 수 있다는 확률이 높다는 얘기지 무조건 먼저 실행되는 것을 보장하지는 않는다.
		 * 우선순위 => 먼저 선택되서 실행되고 빨리 끝나는 확률이 높은것 / 먼저 실행되는 것을 보장 xxxxx
		 * 무조건 실행되는 것을 보장하면 우선순위가 낮은 애들이 작업풀에 계속 있을 수도 있다.
		 */
		for(int i = 0; i <= 100; i++) {			
			System.out.println(getName() + "  : " + i+"번째 작업중" );
		}
	}
	
}

public class PriorityMain {

	public static void main(String[] args) {
		PriorityThread pt = new PriorityThread("우선순위 1인스레드");
		PriorityThread pt2 = new PriorityThread("우선순위 10인스레드");
		pt.setPriority(Thread.MIN_PRIORITY);
		pt2.setPriority(Thread.MAX_PRIORITY);
		pt.start();
		pt2.start();
	}
}
