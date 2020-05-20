package kr.ac.kopo.homework0519.board;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class BoardFunction {
	private Scanner sc = new Scanner(System.in);

	public int scanInt(String msg) {
		System.out.print(msg);
		int num = sc.nextInt();
		sc.nextLine();
		return num;
	}

	public String scanStr(String msg) {
		System.out.print(msg);
		String str = sc.nextLine();
		return str;
	}
	protected int findIdx(int idx, List<Board> boardList) {
		for(int i = 0; i < boardList.size() ; i++) {
			if(boardList.get(i).getNo() == idx) {
				return i;
			}
		}
		return -1;
	}

	public LocalDate date() {
		LocalDate date = LocalDate.now();
		return date;
	}
}
