package kr.ac.kopo.day16;

class Sync {
	
	public void a() {
		// 이메소드를 다 수행하기 전까지는 락이 걸려있다.
		// 공유자원에 대한 lock을 걸지는 않는다. 출력하는 것에만 lock거는것 
		synchronized(this) {
			for(int i = 0; i < 10; i++) {
				System.out.print('a');
			}			
		}
	}
	public synchronized void b() {
		for(int i = 0; i < 10; i++) {
			System.out.print('b');
		}
	}
	public synchronized void c() {
		for(int i = 0; i < 10; i++) {
			System.out.print('c');
		}
	}
}

class SyncThread extends Thread{
	private Sync sync;
	private int type;
	public SyncThread(Sync sync, int type) {
		this.sync = sync;
		this.type = type;
	}
	
	
	@Override
	public void run() {
		
		switch(type) {
		case 1 :
			sync.a();
			break;
		case 2 :
			sync.b();
			break;
		case 3 :
			sync.c();
			break;
		}
	}
	
}
public class SyncMain {

	public static void main(String[] args) {
		Sync sync = new Sync();
		//st,st2,st3 같은 자원을 공유하려고 함 
		SyncThread st = new SyncThread(sync,1);
		SyncThread st2 = new SyncThread(sync,2);
		SyncThread st3 = new SyncThread(sync,3);
		// 순서가 일정하지 않은 이유 : 이세개가 무한경쟁에 빠진다. 
		st.start();
		st2.start();
		st3.start();
	}
}
