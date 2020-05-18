package kr.ac.kopo.homework11.Lotto;

import java.util.Scanner;

public class LottoView {

	private Scanner sc;
	private LottoUtil util;
	
	public LottoView() {
		sc = new Scanner(System.in);
		util = new LottoUtil();
	}
	
	private int scanInt(String msg) {
		System.out.print(msg);
		int num = sc.nextInt();
		sc.nextLine();

		return num;
	}
	
	private void start() {
		System.out.println("1 ) 방법 1 : for문을 이용한 lotto번호 추출");
		System.out.println("2 ) 방법 2 : TreeSet을 이용한 lotto번호 추출");
		System.out.println("3 ) 방법 3 : ArrayList을 이용한 lotto번호 추출");
		System.out.println("4 ) 방법 4 : Map을 이용한 lotto번호 추출");
		System.out.println("5 ) 종료.");
		System.out.println("===================");
	}
	
	public void execute() {
		start();
		int gameNum;
		while(true) {
			int ver = scanInt("방법 몇으로 출력할 것인지 입력하세요 : ");
			if(ver == 5){				
				System.out.println("로또게임 종료");
				System.exit(0);
			}
			
			gameNum = scanInt("게임수를 입력하세요 : ");
			switch(ver) {
			case 1:
				util.gameOne(gameNum);
				break;
			case 2:
				util.gameTwo(gameNum);
				break;
			case 3:
				util.gameTree(gameNum);
				break;
			case 4:
				util.gameFour(gameNum);
				break;
			}
		}		
		
	}
}
