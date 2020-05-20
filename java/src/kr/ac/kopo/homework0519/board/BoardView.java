package kr.ac.kopo.homework0519.board;

import java.util.Scanner;

public class BoardView {
	
	private Scanner sc = new Scanner(System.in);
	private BoardMode mode = new BoardMode();
	private void start() {
		System.out.println("=========================================");
		System.out.println("1.전체게시물 조회");
		System.out.println("2.글번호 조회");
		System.out.println("3.글등록");
		System.out.println("4.글수정");
		System.out.println("5.글삭제");
		System.out.println("6.종료");
		System.out.println("=========================================\n\n");		
	}
	
	private int scanInt(String msg) {
		System.out.print(msg);
		int num = sc.nextInt();
		sc.nextLine();
		return num;
	}
	
	public void execute() {
		start();
		while(true) {
			int var = scanInt("메뉴 중 처리할 항목을 선택하세요 : ");
			if(var == 6) {
				System.out.println("게시판 프로그램이 종료되었습니다.");
				System.exit(0);
			}
			switch(var) {
			case 1 :
				mode.printAll();
				break;
			case 2 :
				mode.idxPrint();
				break;
			case 3 :
				mode.registration();
				break;
			case 4 :
				mode.modify();
				break;
			case 5 :
				mode.delete();
				break;
			default :
				System.out.println("잘못입력했습니다.");
				break;
			}
		}
	}
}
