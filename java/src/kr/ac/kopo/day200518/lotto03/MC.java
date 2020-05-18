package kr.ac.kopo.day200518.lotto03;

public class MC {
	private Machine machine;
	public MC() {
		machine = new Machine();
	}
	public void ment() throws Exception{
		System.out.println("안녕하세요 mc 김혜주 입니다.");
		System.out.println("제 xx회 로또 방송을 시작하겠습니다.");
		
		machine.start();
		
		for(int i = 1; i <=6 ; i++) {
			//밀리세컨드 단위임 1000 = 1초 checked method 예외처리 해야함. 현재 방식은 간접으로 넘기는 방식
			Thread.sleep(1000);
			Ball ball = machine.getBall();
			System.out.println(i + "번째 로또 번호는 " + ball.getNumber() + " 입니다.");
		}
	}

}
