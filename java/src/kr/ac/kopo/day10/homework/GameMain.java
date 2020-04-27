package kr.ac.kopo.day10.homework;

import java.util.Scanner;

public class GameMain {
	static int total_win = 0;
	static int total_lose = 0;
	static int total_same = 0;
	public static void score(int check) {
		if(check == 1)
			total_win++;
		else if(check == 0)
			total_lose++;
		else
			total_same++;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char ch = 'D';
		int you;
		while(ch != 'C') {
			System.out.println("게임을 선택하세요 \n   A.가위바위보 \n   B.주사위 값 맞추기 \n   C.종료");
			ch = sc.nextLine().charAt(0);
			if(ch == 'A' || ch == 'a') {
				System.out.println("가위바위보 게임입니다.");
				System.out.println("가위바위보중 하나를 선택하세요");
				System.out.println("(1:가위, 2:바위, 3.보)");
				you = sc.nextInt();
				sc.nextLine();
				
				while(you != 1 && you != 2 && you != 3) {
					System.out.println("다시 입력하세요");
					you = sc.nextInt();
					sc.nextLine();					
				}
				
				ScissorsRockPaper srp = new ScissorsRockPaper();
				int check = srp.startGame(you);
				score(check);
			
			}else if(ch == 'B' || ch == 'b') {
				System.out.println("주사위 값 맞추기 게임입니다.");
				System.out.println("주사위를 선택하세요(1~6값 중 하나)");
				you = sc.nextInt();
				sc.nextLine();
				while(you < 1 || you > 6) {
					System.out.println("다시 입력하세요");
					you = sc.nextInt();
					sc.nextLine();					
				}
				Dice d = new Dice();
				int check = d.startGame(you);
				score(check);
				
			}else if(ch == 'C' || ch == 'c') {
				System.out.println("게임을 종료합니다.");
				break;
			}else {
				System.out.println("다시 입력하세요");
			}
		}
		System.out.println("당신의 게임 전적은 " + total_win + "승 " + total_lose + "패 " + total_same + "무입니다.");
	}
}
