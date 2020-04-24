package kr.ac.kopo.homework08;

public class Rectangle extends Shape {
	private int width;
	private int height;

	//Square에서 높이와 밑변을 set하기 위한 setter 구현
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	//Square에서 높이와 밑변을 출려갈 수 있게 하기 위한 getter 구현
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
	public Rectangle() {}
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public void area() {
		this.setArea(width*height);
	}

	@Override
	public void print() {
		System.out.println("높이 : " + height + ", 밑변 : " + width + "인 직사각형의 넓이는 " + this.getArea() + "입니다.");
	}

}
