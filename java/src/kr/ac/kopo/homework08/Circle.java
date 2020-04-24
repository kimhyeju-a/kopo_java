package kr.ac.kopo.homework08;

public class Circle extends Shape {
	private final double PI = 3.141592;
	private int round;
	
	public Circle() {
		super();
	}

	public Circle(int round) {
		super();
		this.round = round;
	}

	@Override
	public void area() {
		this.setArea(round * round * PI);
	}

	@Override
	public void print() {
		System.out.println("반지름 : " + round + " 인 원의 넓이는 " + this.getArea() +" 입니다.");
	}

}
