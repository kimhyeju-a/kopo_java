package kr.ac.kopo.account.ui;

import java.util.Scanner;

import kr.ac.kopo.account.serivce.AccountService;
import kr.ac.kopo.account.serivce.AccountServiceFactory;

public abstract class AccountBaseUI implements IAccountUI{

	private Scanner sc;
	protected AccountService accountService;
	public AccountBaseUI() {
		sc = new Scanner(System.in);
		accountService = AccountServiceFactory.getAccoutService();
	}
	
	protected int scanInt(String msg) {
		System.out.print(msg);
		return Integer.parseInt(sc.nextLine());
	}
	
	protected String scanStr(String msg) {
		System.out.print(msg);
		return sc.nextLine();
	}
}
