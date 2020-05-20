package kr.ac.kopo.homework0519.board;

import java.util.ArrayList;
import java.util.List;

public class Registration extends BoardFunction {
	private List<Board> boardList;
	private static int boardIdx = 0;

	public Registration(List<Board> boardList) {
		super();
		this.boardList = boardList;
	}

	public List<Board> registration() {
		String title = scanStr("등록할 제목을 입력 : ");
		String author = scanStr("글쓴이 입력 : ");
		boardList.add(new Board(++boardIdx, title, author,super.date()));

		return boardList;
	}
}
