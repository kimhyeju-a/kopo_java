package kr.ac.kopo.day17.homework2;

import java.util.Random;

public class Donation {
	private int money;
	private Random rand;
	private int total;
	
	public Donation() {
		rand = new Random();
		total = 0;
	}
	
	public synchronized int donate(int callNum) {

		try {
			notify();
			money = (rand.nextInt(10) + 1) * 1000;
			total += money;
			System.out.println(callNum + "번 콜센터 : " + money + "원을 받았습니다.");
			wait();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		} return money;
	}
	
	public int getTotal() {		
		return total;
	}
}	