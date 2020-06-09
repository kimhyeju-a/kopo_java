package kr.ac.kopo.day17.homework.account;

import java.util.Random;

class Account {
	private Random r = new Random();
	private String name;
	private int money;
	private int cash;

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

	public synchronized void deposit(String name2) {
		cash = 1000 * (r.nextInt(10) + 1);
		System.out.println(name2 + "고객님이 "+ name +" 님의 계좌에 " + cash + "원을 입금하셨습니다.");
		money += cash;
		System.out.println("현재잔액은 " + money + "원입니다.");
	}
	
	public synchronized void withdraw(String name2) {
		cash = 1000 * (r.nextInt(10) + 1);
		if (money - cash < 0) {
			System.out.println("출금금액 : " + cash + "원 => 잔액이 부족하여 출금할 수 없습니다");
		} else {
			System.out.println(name2 + "고객님이 "+ name +" 님의 계좌에서 " + cash + "원을 출금하셨습니다");
			money -= cash;
		}
		System.out.println("현재잔액은 " + cash + "원입니다");

	}
}
