package kr.ac.kopo.day16;

import java.util.Date;

class SleepThread extends Thread{

	@Override
	public void run() {
		System.out.println("현재시간 : " + new Date().toLocaleString());
	}
}

public class SleepMain {

	public static void main(String[] args) {
		SleepThread st = new SleepThread();
		st.start();
		while(true) {
			try {
				//main sleep의 thread가 선점하고 있기 때문에 이것을 풀기 위해 조금이라도 sleep을 걸어준다.
				Thread.sleep(100);// 슬립에 걸려있는 순간 runnable 상태로 돌아가면서 돈다 ....? 
				System.out.println("go!!!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		
		/*
		while(true) {
			try {
				Thread.sleep(1000);				
				System.out.println("현재시간 : " + new Date().toLocaleString());
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("go!!!");
		}
		*/
		/*
		System.out.println("메인 스레드를 2초동안 잠들게 하겠습니다. ");
		try {
			Thread.sleep(2000); // 중간에 문제가 생길 수도 있어서 checked exception에 대한 예외처리가 필요하다.
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("메인스레드가 2초후에 깨어났습니다.");
		*/
	}
}
