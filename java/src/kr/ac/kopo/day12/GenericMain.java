package kr.ac.kopo.day12;

import java.util.Random;

class CCC<T1, T2>{
	private T1 data;
	private T2 data2;
	
	public CCC(T1 data, T2 data2) {
		this.data = data;
		this.data2 = data2;
	}

	public T1 getData() {
		return data;
	}

	public void setData(T1 data) {
		this.data = data;
	}

	public T2 getData2() {
		return data2;
	}

	public void setData2(T2 data2) {
		this.data2 = data2;
	}
	
}

class BBB<T> {
	// 경우에 따라 random, icecream, string ... 형으로 바꿀 수 있도록 제너릭을 사용
	private T data;
	
	public BBB() {
		
	}
	
	public BBB(T data) {
		this.data = data;
	}
	
	public T getData() {
		return this.data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
}

class AAA {
	private Object data;
	public AAA(Object data) {
		this.data = data;
	}
	
	public Object getData() {
		return this.data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
}

class Icecream {
	private String name;
	private int price;
	
	public Icecream() {
		super();
	}
	
	public Icecream(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public void info() {
		System.out.println("아이스크림 : " + name + ", 가격 : " + price);
	}
}
public class GenericMain {

	public static void main(String[] args) {
		
		//제네릭에 타입이 두개있는 경우
		CCC<String, String> c = new CCC<String, String>(new String("abc"), "12345");
		CCC<Icecream, String> c2 = new CCC<Icecream, String>(new Icecream("월드콘", 1000), new String("hello world"));
		
		c2.getData();// return 타입이 Icecream형이다.
		
		
		//타입이 Object인 객체 생성
		BBB<Object> obj = new BBB<Object>();
		BBB<String> obj2 = new BBB<String>();
		BBB<Random> obj3 = new BBB<Random>();
		BBB<Icecream> obj4 = new BBB<Icecream>();
		
		obj2.setData(new String("Hello"));
		//obj4는 icecream형이기 때문에 오류가 난다.
//		obj4.setData(new String("hello"));
		
		System.out.println("obj2 길이 : " + obj2.getData().length());
		
		
		
//		AAA obj = new AAA(new Object());
//		AAA obj2 = new AAA(new String("Hello"));
//		AAA obj3 = new AAA(new Random());
//		AAA obj4 = new AAA(new Icecream("비비빅", 1000));
//		
//		System.out.println("obj	: " + obj.getData().toString());
//		/*//에러가 난다 : getData는 object형을 반환하기 때문에 명시적 형변환 필요
//		System.out.println("obj2: " + obj2.getData().length());
//		*/
//		String strObj = (String)obj2.getData();
//		System.out.println("obj2: " + strObj + "length : " + strObj.length());	
//		
//		Random r = (Random)obj3.getData();
//		System.out.println("추출된 난수: " + r.nextInt());	
//		
//		Icecream ice = (Icecream)obj4.getData();
//		ice.info();
//		
//		/*//오류가 난다. obj2는 Icecream형이 아닌 Object형이기 때문에
//		Icecream ice2 = (Icecream)obj2.getData();
//		ice2.info();
//		*/
		
		
	}
}
