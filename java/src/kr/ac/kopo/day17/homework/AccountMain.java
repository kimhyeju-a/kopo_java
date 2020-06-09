package kr.ac.kopo.day17.homework;

import java.util.Random;

class Atm extends Thread {
	private User user;
	AtmAction atm;
	private Random r = new Random();

	public Atm(User user) {
		this.user = user;
		atm = new AtmAction(user);
	}

	public synchronized void run() {
		for (int i = 0; i < 2; i++) {
			int price = 1000 * (r.nextInt(10) + 1);
			atm.withdraw(price);
			atm.deposit(price);
		}
	}
}

class Account {
	private String name;
	private int money;

	public Account(String name, int money) {
		this.name = name;
		this.setMoney(money);
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
}

class User {
	String name;
	Account account;

	public User(String name, Account account) {
		this.name = name;
		this.account = account;
	}

}

class AtmAction {
	User user;
	Account account;

	public AtmAction(User user) {
		this.user = user;
		account = user.account;
	}

	public synchronized void withdraw(int price) {
//		try {
			if (account.getMoney() - price >= 0) {
				System.out.println(user.name + "고객님이 " + price + "원을 출금하셨습니다.");
				account.setMoney(account.getMoney() - price);
			} else {
				System.out.println("출금금액 : " + price + "원 => 잔액이 부족하여 출금을 할 수 없습니다.");
			}
			System.out.println("현재잔액은 " + account.getMoney() + "원입니다.");
//			
//		} catch (Exception e) {
//
//		}
	}

	public synchronized void deposit(int price) {
//		try {
			System.out.println(user.name + "고객님이 " + price + "원을 입금하셨습니다.");
			account.setMoney(account.getMoney() + price);
			System.out.println("현재잔액은 " + account.getMoney() + "원입니다.");
//		} catch (Exception e) {
//		}
	}
}

public class AccountMain {
	public static void main(String[] args) {
		Account ac = new Account("홍길동", 10000);
		Atm a1 = new Atm(new User("홍길동", ac));
		Atm a2 = new Atm(new User("어머니", ac));
		Atm a3 = new Atm(new User("아버지", ac));
		a1.start();
		a2.start();
		a3.start();
	}
}
