package kr.ac.kopo.homework11.StackQueue;

import java.util.Scanner;


public class StackQueueView {

	private Scanner sc;
	private StackView stackView;
	private QueueView queueView;
	
	public StackQueueView() {
		sc = new Scanner(System.in);
	}
	
	//StackView 와 QueueView에서 사용할 것이라 public으로 선언
	public int scanInt(String msg) {
		System.out.print(msg);
		int num = sc.nextInt();
		sc.nextLine();
		return num;
	}
	
	private void start() {
		System.out.println("===========================================");
		System.out.println("1) Stack");
		System.out.println("2) Queue");
		System.out.println("3) 종료");
		System.out.println("===========================================\n\n");
	}
	
	public void execute() {
		start();
		while(true) {
			int ver = scanInt("원하는 방식을 입력하세요 (1과 2중 선택) : ");
			if(ver == 3){				
				System.out.println("StackQueue Program 종료");
				System.exit(0);
			}
			switch(ver) {
			case 1:
				stackView = new StackView();
				break;
			case 2:
				queueView = new QueueView();
				break;
			default :
				System.out.println("잘못 입력했습니다. 다시입력해주세요. (숫자 1과 2만가능)");
				break;
			}
		}		
		
	}
}
