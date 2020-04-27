package kr.ac.kopo.day10.inter02;

public interface TV {

	int MAX_VOLUME = 30;
	
	void togglePower();
	void channeUp();
	void channelDown();
	void volumeUp();
	void volumeDown();
	void mute();
	
	/**
	 * @since JDK1.8 추가
	 */
	// 접근제한자의 default가 아님
	// 인터페이스가 있으면 중간에 추상클래스를 만든다.
	// 나중에 유지보수를 할 때 기능을 추가할때 설계가 뒤바뀌는 경우가 있어서, 그것을 방지하고자 default개념이 등장함
	// 다시 찾아보기 
	default void copyright() {
		System.out.println("저작권은 TV협회에 있습니다.");
		System.out.println("임의로 수정, 배포하실 수 없습니다.");
	}
}