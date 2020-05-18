package kr.ac.kopo.day200518.lotto03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//공이라는 객체, 로또 머신 , mc를 만들었다.
// has a 관계를 가지고 있다. 
public class Machine {

	private List<Ball> balls = new ArrayList<>();
	
	public Machine() {
		for(int i = 1; i <= 45; i++) {
			balls.add(new Ball(i));
		}
	}

	public void start() {
		Collections.shuffle(balls);
	}

	public Ball getBall() {
		//remove의 리턴값은 ball형 임 지워진 객체의 값을 리턴할 수 있음
		return balls.remove(0);
	}
}
