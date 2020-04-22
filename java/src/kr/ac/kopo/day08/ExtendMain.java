package kr.ac.kopo.day08;

class One{
	One() {
		
		System.out.println("One() 생성자 호출...");
	}
}
class Two extends One{
	Two() {
		//super(); 가 생략이 되어 있다. 
		System.out.println("Two() 생성자 호출...");
	}
}
class Three extends Two{
	Three() {
		//super(); 가 생략이 되어 있다. 
		System.out.println("Three() 생성자 호출...");
	}
}
public class ExtendMain {

	public static void main(String[] args) {
//		One one = new One();
//		Two two = new Two();
		Three three = new Three(); //One -> Two -> Three
	}
}
