package kr.ac.kopo.homework0519.board;

import java.util.ArrayList;
import java.util.List;

public class Modify extends BoardFunction {
	private List<Board> boardList;
	
	public Modify(List<Board> boardList) {
		super();
		this.boardList = boardList;
	}

	public List<Board> modify() {
		int idx = scanInt("수정할 글 번호를 입력하세요 :");
		System.out.println("<수정 전 글번호 \"" + idx + "\"의 내용 >");
		idx = findIdx(idx,boardList);
		if (idx == -1) {
			System.out.println("글번호를 찾을 수 없습니다.");
		} else {
			boardList.get(idx).info();
			boardList.get(idx).setTitle(scanStr("수정할 제목을 입력 : "));
			boardList.get(idx).setAuthor(scanStr("수정할 글쓴이를 입력 : "));
			boardList.get(idx).setTime(super.date());
		}
		return boardList;
	}
	
}
