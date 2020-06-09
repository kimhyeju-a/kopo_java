package kr.ac.kopo.day17.homework;

import java.util.Random;
class AccountAction extends Thread{
	public AccountAction(User1 user1) {
		Random r = new Random();
		int a = r.nextInt(2);
		if(a == 0)
			a();
		else b();
	}

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
class Action implements Runnable {
	private long depositeMoney = 500000;

	public void run() {
		synchronized (this) {

			for (int i = 0; i < 30; i++) {
				notify();
				try {
					wait();
//					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (getDepositeMoney() <= 0)
					break;
				withDraw(1000);
			}
		}
	}

	public void withDraw(long howMuch) {
		if (getDepositeMoney() > 0) {
			depositeMoney -= howMuch;
			System.out.print(Thread.currentThread().getName() + " , ");
			System.out.printf("잔액 : %,d 원 %n", getDepositeMoney());
		} else {
			System.out.print(Thread.currentThread().getName() + " , ");
			System.out.println("잔액이 부족합니다.");
		}
	}

	public long getDepositeMoney() {
		return depositeMoney;
	}
}
class Account1 {
	private String name;
	private int money;
	public Account1(String name, int money) {
		super();
		this.name = name;
		this.money = money;
	}
}
class User1{
	String name;
	Account1 account;
	int cnt;
	Random r = new Random();
	int a = r.nextInt(2);
	public User1(String name, Account1 account) {
		super();
		this.name = name;
		this.account = account;
	}
	
}

public class AccountMain01 {
	public static void main(String[] args) {
		Action a = new Action();
		Account1 ac = new Account1("홍길동", 10000);
		AccountAction aa = new AccountAction(new User1("홍길동", ac));
		AccountAction aa1 = new AccountAction(new User1("어머니", ac));
		AccountAction aa2 = new AccountAction(new User1("아버지", ac));
		
		
		
//		Thread ut1 = new Thread(a,user1.name);
//		Thread ut2 = new Thread(a,user2.name);
//		Thread ut3 = new Thread(a,user3.name);
//		
//		ut1.start();
//		ut2.start();
//		ut3.start();
	}
}
