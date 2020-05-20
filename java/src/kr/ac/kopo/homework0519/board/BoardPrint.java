package kr.ac.kopo.homework0519.board;

import java.util.List;

public class BoardPrint extends BoardFunction{
	private List<Board> boardList;
	public BoardPrint() {}
	public BoardPrint(List<Board> boardList) {
		super();
		this.boardList = boardList;
	}
	
	public void allPrint() {
		System.out.println("< 전체 게시글 조회 >");
		if(boardList == null) {
			System.out.println("\t조회할 게시물이 없습니다.");
		}else {
			for(Board board : boardList) {
				board.info();
			}
		}
	}
	
	public void idxPrint() {
		int idx = scanInt("조회할 글 번호를 입력하세요 : ");
		idx = super.findIdx(idx,boardList);
		if (idx == -1) {
			System.out.println("글번호를 찾을 수 없습니다.");
		} else {
			boardList.get(idx).info();
		}
	}

}
