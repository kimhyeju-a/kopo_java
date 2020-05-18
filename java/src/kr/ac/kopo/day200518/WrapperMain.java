package kr.ac.kopo.day200518;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
	Wrapper Class (기본자료형 8가지 -> 참조자료형) , java.lang
	
		boolean			Boolean
		byte			Byte
		char			Character
		short			Short
		int				Integer
		long			Long
		float			Float
		double			Double
 */
/*
 * 기본 자료형을 감싸고 있는 형태
	class Integer {
		private int value;
	}
 */
public class WrapperMain {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
//		list.add(new Integer(100));
//		list.add(new Integer(200));
		// 객체 생성을 하지 않고 바로 100,200을 넣어도 된다.
		list.add(100); // auto boxing이 되면서 데이터가 들어가짐.
		list.add(200);
		
		System.out.println(Arrays.toString(list.toArray()));
		
		int i = 10;
		//integer는 Integer(int), Integer(String) 만 있음
		Integer i2 = new Integer(10);
		//new Integer로 객체 생성을 하지 않아도 된다.
		Integer i3 = 123;// 1.5v 이상부터 가능, auto boxing 이 일어난다고 이야기한다.
		int i4 = new Integer(200); // auto unboxing 
		
		//1.5버전 이상부터 auto unboxing과 auto boxing 이 일어난다,.
		
		
		System.out.println("i2 : " + i2);
		
		
		String str = "19455";
		System.out.println(str + " + " + 100 +"=" +(str+100));
		
		//내가 원하는 자료형이 기본자료형이면 parseInt 를 써야함 valueOf는 속도가 비교적 느리다.
		int num = Integer.parseInt(str); // 기본자료형으로 반환이 된다.
		System.out.println(num + " + " + 100 +"=" +(num+100));
		int num2 = Integer.valueOf(str); // auto unboxing이 발생되고 있다. 리턴타입이 Integer 이다.
		System.out.println(num2 + " + " + 100 +"=" +(num2+100));
	}
}
