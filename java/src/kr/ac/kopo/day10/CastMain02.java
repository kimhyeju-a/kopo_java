package kr.ac.kopo.day10;

public class CastMain02 {
	/* int type을 매개변수로 갖는다.
	static void print(Parent p, int type) {
		p.print();
		
		switch(type) {
		case 1 :
			Child01 c = (Child01)p;
			c.study();
			c.sleep();
			break;
		case 2 :
			Child02 c2 = (Child02)p;
			c2.play();
			c2.sing();
			break;
		}
	}
	*/
	/*#2
	static void print(Parent p) {
		//p가 instance 객체를 가지고 있니?
		System.out.println("p instanceof Child01 : " + (p instanceof Child01));
		System.out.println("p instanceof Child02 : " + (p instanceof Child02));
		//p가 Parent를 가지고 있기 때문에 true가 나온다.
		System.out.println("p instanceof Parent : " + (p instanceof Parent));
	}
	*/
	
	static void print(Parent p) {
		p.print();
		if(p instanceof Child01) {
			Child01 c = (Child01)p;
			c.study();
			c.sleep();
		}else if(p instanceof Child02) {
			Child02 c = (Child02)p;
			c.play();
			c.sing();
		}
	}
	
	public static void main(String[] args) {
		/* int type 을 넘겨주는게 마음에 안듦
		Child01 c1 = new Child01();
		print(c1, 1);
		
		/* #2
		Child02 c2 = new Child02();
		print(c2, 2);
		
		
//		Child01 c01 = new Child01();
//		print(c01);
		
		Parent p = new Parent();
		print(p); //false, false, true
		*/
		
		Child01 c01 = new Child01();
		print(c01);
		Child02 c02 = new Child02();
		print(c02);
		Parent p = new Parent();
		print(p);
		
		
		/*
		Parent p = new Child01();
		// p가 가리키는 것 조차 Child01을 가리키고 있기 떄문에 runtime 오류가 발생하지 않는다.
		Child01 c = (Child01)p;
		*/
		/*
		Parent p = new Child01();
		//p가 가리키는 것이 Child02로 바꼈으므로 런타임에러가 나온다.
		p = new Child02();
		Child01 c = (Child01)p;
		*/
		
		/*
		//RunTime시 오류 발생
		Child01 c = (Child01) new Parent();
		c.print();
		*/
	}
}
