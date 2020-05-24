package kr.ac.kopo.account.user.ui;

import java.util.Scanner;

import kr.ac.kopo.account.ui.IAccountUI;
import kr.ac.kopo.account.user.service.UserService;
import kr.ac.kopo.account.user.service.UserServiceFactory;

public abstract class BaseUI implements IUserUI{

	private Scanner sc;
	protected UserService userService;
	public BaseUI() {
		sc = new Scanner(System.in);
		userService = UserServiceFactory.getUserService();
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
