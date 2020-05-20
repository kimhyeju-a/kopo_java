package kr.ac.kopo.homework0519.board;

import java.util.ArrayList;
import java.util.List;

public class BoardMode {
	List<Board> boardList = new ArrayList<>();
	
	
	public void printAll() {
		BoardPrint p = new BoardPrint(boardList);
		p.allPrint();
	}

	public void idxPrint() {
		BoardPrint p = new BoardPrint(boardList);
		p.idxPrint();
	}

	public void registration() {
		Registration r = new Registration(boardList);
		boardList = r.registration();
	}

	public void modify() {
		Modify m = new Modify(boardList);
		boardList = m.modify();
	}

	public void delete() {
		Delete d = new Delete(boardList);
		boardList = d.delete();
	}

	
}
