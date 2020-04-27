package kr.ac.kopo.day10;

public class CastMain {
	/* 묵시적 형변환 하는 이유 
	static void print(Child01 c) {
		c.print();
	}
	static void print(Child02 c) {
		c.print();
	}
	static void print(Parent p) {
		p.print();
	}
	*/
	static Child02 getInstance() {
		return new Child02();
	}
	static void print(Parent p) {
		p.print(); // 넘기는 객체가 무엇이든간에 유연하게 대처하기 위함
	}
	public static void main(String[] args) {
		
		Child02 c = getInstance();
		print(c);
		
		
		/*
		//묵시적 형변환 하는 이유
		Child01 c01 = new Child01();
		print(c01);

		Child02 c02 = new Child02();
		print(c02);
		
		Parent p = new Parent();
		print(p);
		*/
		
		/*
		Parent p = new Child01(); // 묵시적 형변환이 일어난다.
		p.print(); // 오버라이드된 메소드를 호출한다.
		
		Parent p2 = new Child02(); // 묵시적 형변환이 일어난다.
		p2.print(); // 오버라이드된 메소드를 호출한다.

		Parent p3 = new Parent(); // 묵시적 형변환이 일어난다.
		p2.print(); // 오버라이드된 메소드를 호출한다.
		*/
		
		/*
		Child02 c02 = new Child02();
		c02.print();
		c02.play();
		c02.sing();
		
		Child01 c01 = new Child01();
		c01.print();
		c01.sleep();
		c01.study();
		
		Parent p = new Parent();
		p.print();
		*/
	}
}
