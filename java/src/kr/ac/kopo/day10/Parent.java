package kr.ac.kopo.day10;

public class Parent {

	private String name = "부모";
	//protected 이면 상속받는 자식들이 public/protected가능 
	//public 이면 상속받는 자식들이 public 이어야만함
	//자식은 부모의 메소드를 오버라이드 할 수 있는데 자식은 부모의 접근제한자보다 좁으면 안됨
	public void print() {
		System.out.println("나는 부모입니다.");
	}
}
