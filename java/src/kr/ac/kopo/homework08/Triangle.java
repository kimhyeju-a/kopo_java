package kr.ac.kopo.homework08;

public class Triangle extends Shape {
	private int height;
	private int width;
	
	public Triangle() {
	}


	public Triangle(int height, int width) {
		super();
		this.height = height;
		this.width = width;
	}


	@Override
	public void area() {
		this.setArea((height * width) /2);
	}

	@Override
	public void print() {
		System.out.println("높이 : " + height + ", 밑변 : " + width + "인 삼각형의 넓이는 " + this.getArea() + "입니다.");
	}

}
