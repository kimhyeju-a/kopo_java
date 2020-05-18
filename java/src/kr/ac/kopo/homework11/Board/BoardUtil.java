package kr.ac.kopo.homework11.Board;

import java.time.LocalDate;
import java.util.Scanner;
/*
	변수 설명
		- num : 실제 배열의 index
		- boardIdx : 실제 배열의 index를 따라가게 되면 삭제시 문제가 생기므로
					 index와 no변수에 저장되는 숫자를 분리시켜 저장
					 boardIdx는 줄어들지 않는다 (실제 게시판도 삭제시 번호는 그대로 남아있음)
 */
public class BoardUtil {
	// 등록 날짜를 가져오기 위해 이것이 자바다에 있는 LocalDate클래스를 사용하였습니다!!
	private LocalDate date = LocalDate.now();
	private Board[] boardArr = new Board[100];
	private int num = 0;
	private int boardIdx = 0;
	private Scanner sc = new Scanner(System.in);

	private int scanInt(String msg) {
		System.out.print(msg);
		int num = sc.nextInt();
		sc.nextLine();
		return num;
	}

	private String scanStr(String msg) {
		System.out.print(msg);
		String str = sc.nextLine();
		return str;
	}
	
	//내가 조회하고자 하는 번호와 배열의 index번호는 다르므로 getNo을 이용해 내가 찾고자하는 번호가 있는 지 확인하는 메소드를 만들었습니다!
	private int findIdx(int idx) {
		for (int i = 0; i < num; i++) {
			if (idx == boardArr[i].getNo()) {
				return i;
			}
		}
		return -1;
	}

	// 1.전체 게시물 조회, num이 실제 인덱스를 담당하는 변수임으로 num-1까지 for문을 돌려 print한다.
	public void allPrint() {
		System.out.println("< 전체 게시글 조회 >");
		for(int i = 0; i < num; i++) {
			boardArr[i].info();
		}
	}

	// 2.글번호 등록 조회, findIdx 를 수행하여 idx 번호를 알아낸다.
	public void idxPrint() {
		int idx = scanInt("조회할 글 번호를 입력하세요 : ");
		idx = findIdx(idx);
		if (idx == -1) {
			System.out.println("글번호를 찾을 수 없습니다.");
		} else {
			boardArr[idx].info();
		}
	}

	// 3. 글등록, num은 index를 담당하고 있고, boardIdx는 실제 게시물 번호를 담당하고 있음.
	public void registration() {
		String title = scanStr("등록할 제목을 입력 : ");
		String author = scanStr("글쓴이 입력 : ");
		boardArr[num++] = new Board(++boardIdx, title, author, date);
	}

	// 4. 글수정 findIdx 를 수행하여 idx 번호를 알아낸다.
	public void modify() {
		int idx = scanInt("수정할 글 번호를 입력하세요 :");
		System.out.println("<수정 전 글번호 \"" + idx + "\"의 내용 >");
		idx = findIdx(idx);
		if (idx == -1) {
			System.out.println("글번호를 찾을 수 없습니다.");
		} else {
			boardArr[idx].info();
			boardArr[idx].setTitle(scanStr("수정할 제목을 입력 : "));
			boardArr[idx].setAuthor(scanStr("수정할 글쓴이를 입력 : "));
			boardArr[idx].setTime(date);
		}
	}

	// 5. 글삭제
	public void delete() {
		int idx = scanInt("삭제할 번호를 입력하세요. ");
		idx = findIdx(idx);
		if (idx == -1) {
			System.out.println("글번호를 찾을 수 없습니다.");
		} else {
			for (int i = idx; i <= num; i++) {
				boardArr[i] = boardArr[i + 1];
			}
			num--;
		}
	}

}
