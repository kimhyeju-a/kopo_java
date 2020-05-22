package kr.ac.kopo.board.service;

public class BoardServiceFactory {
	private static BoardService service = null;
	//service객체는 첫번째에만 new를 이용해서 사용한다.
	public static BoardService getBoardService() {
		if(service == null) {
			service = new BoardService();
		}
		return service;//하나를 계속 공유하고 있음
	}
}
