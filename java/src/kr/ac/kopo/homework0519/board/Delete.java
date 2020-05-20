package kr.ac.kopo.homework0519.board;

import java.util.ArrayList;
import java.util.List;

public class Delete extends BoardFunction{
	private List<Board> boardList;
	
	public Delete(List<Board> boardList) {
		super();
		this.boardList = boardList;
	}

	public List<Board> delete() {
		int idx = scanInt("삭제할 번호를 입력하세요. ");
		idx = findIdx(idx, boardList);
		if (idx == -1) {
			System.out.println("글번호를 찾을 수 없습니다.");
		} else {
			boardList.remove(idx);
		}
		return boardList;
	}
}
