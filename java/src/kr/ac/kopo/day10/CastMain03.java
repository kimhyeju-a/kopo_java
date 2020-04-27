package kr.ac.kopo.day10;

import java.util.ArrayList;
//묵시적 형변환, 명시적 형변환 언제쓸지
public class CastMain03 {

	public static void main(String[] args) {
		/*
		 * ArrayList는 좋지 않은 방법이다 => 제너릭을 사용한다
		 * ==>무시적형변환과 명시적 형변환을 설명하기 위해
		 */
		//ArrayList : 오직 참조자료형만 집합으로 가지고 있다.
		ArrayList list = new ArrayList();
		//컴퓨터는 모두 오브젝트형으로 반환한다. => 묵시적 형변환이 일어난다.
		/*
		 * list.add(10) -> arraylist는 참조자료형만을 가진다.
		 * 따라서 기본자료형은 들어갈 수 없다 따라서, Integer를 사용해여 자바가  참조자료형으로변환한다.
		 */
		list.add(10);
		list.add("hello");
		list.add(new Icecream());
		list.add(new Hotdog());
		
		//return 타입 Object형
//		list.get(0);
		//list.get의 리턴타입은 Object 이므로, 명시적 형변환을 해주어여햔다 (String : 자식, Object : 부모
		String str = (String)list.get(1);
		System.out.println("str : " + str + " , length : " + str.length());
	}
}
class Icecream{
	
}
class Hotdog{
}
 	