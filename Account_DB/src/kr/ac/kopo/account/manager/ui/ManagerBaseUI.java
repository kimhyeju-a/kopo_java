package kr.ac.kopo.account.manager.ui;

import java.util.Scanner;

import kr.ac.kopo.account.manager.service.ManagerService;

public abstract class ManagerBaseUI implements IManagerUI{

	private Scanner sc;
	protected ManagerService managerService;
	public ManagerBaseUI() {
		sc = new Scanner(System.in);
		managerService = new ManagerService();
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
