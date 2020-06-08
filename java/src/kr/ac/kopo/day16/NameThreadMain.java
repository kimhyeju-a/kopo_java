package kr.ac.kopo.day16;
class NameThread extends Thread {
	public NameThread() {
		super();
	}
	
//	public NameThread(String name) {
//		setName(name);
//	}
	
	public NameThread(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		System.out.println("바뀌기 전 스레드 이름 : " + getName());
		
		//NameThread-1 => ChangeThread -1;
		//NameThread-2 => ChangeThread -2; 이름을 변경하고 싶다. 
		int idx = getName().lastIndexOf("-");
		String no = getName().substring(idx);
		
		setName("ChangeThread" + no);
		System.out.println("변경된 스레드 이름 : " + getName());
	}
}

public class NameThreadMain {

	public static void main(String[] args) {
		
		NameThread nt = new NameThread("NameThread-1");
		NameThread nt2 = new NameThread();
		
		nt.start();
		nt2.start();
	}
}
