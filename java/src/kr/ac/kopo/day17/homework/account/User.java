package kr.ac.kopo.day17.homework.account;

class User extends Thread{
	String name;
	Account account;

	public User(String name, Account account) {
		this.name = name;
		this.account = account;
	}

	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			account.deposit(name);
			account.withdraw(name);
		}
	}
	
}
