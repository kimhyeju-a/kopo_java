package kr.ac.kopo.day11;

import java.util.Random;

class Super {
	public final int MAX = 100;
	public void print() {
		System.out.println("Super print() 호출 ...");
	}
}
class Sub extends Super {
	@Override
	public void print() {
		System.out.println("Sub print() 호출 ...");
	}
}

class MyRandom extends Random {

	/**
	 * nextInt(10)
	 * 상위 클래스 Random의 0 ~ 9 사이의 난수 추출이 아닌 
	 * 1 ~ 10 사이의 난수를 추출
	 *  
	 */
	//소스 -> override implement Methods
	@Override
	public int nextInt(int bound) {
		int r = super.nextInt(bound) + 1;
		return r;
	}	
	
}

/*
//String 은 final 클래스 이기 때문에 상속을 받을 수 없다.
class MyString extends String {
	
}
 */

public class FinalMain {

	public static void main(String[] args) {
//		Random r = new Random();
//		int random = r.nextInt(100) + 1;
		
		MyRandom r = new MyRandom();
		int random = r.nextInt(2); // 1 ~ 2만 
		
		System.out.println("추출된 정수 : " + random);
	}
}
