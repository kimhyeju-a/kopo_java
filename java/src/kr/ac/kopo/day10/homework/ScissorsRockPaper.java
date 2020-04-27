package kr.ac.kopo.day10.homework;

public class ScissorsRockPaper implements Game {
	final static int SCISSOR = 1;
	final static int ROCK = 2;
	final static int PAPER = 3;
	
	@Override
	public int startGame(int you) {
		int me = (int)(Math.random()*3) + 1;
		// me 와 you 의 값이 동일하면 "비겼습니다." 출력
		if(me == you) {
			System.out.println("비겼습니다.");
			return 2;
		}else if((me == 1 && you == 3) || (me == 2 && you == 1) || (me == 3 && you == 2)) {
			System.out.println("You lose");
			return 0;
		}else {
			System.out.println("You win");
			return 1;
		}
		
	}

}
