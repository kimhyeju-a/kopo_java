package kr.ac.kopo.homework08;

//넓이 구하기 및 print문을 담당 
public abstract class Shape {
	private double area;
	
	public abstract void area();
	public abstract void print();
	
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	
}
