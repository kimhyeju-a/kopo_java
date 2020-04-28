package kr.ac.kopo.day12;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/*
 * Set : 순서(X) , 중복허용(X)
 * 		- HashSet
 * 		- TreeSet
 */
public class SetMain {

	public static void main(String[] args) {
		
		Set<String> set = new HashSet<>();
		set = new TreeSet<String>();
		
		System.out.println("입력 전 set의 데이터 총 개수 : " + set.size() + "개");
		
		System.out.println("\"one\" 데이터 삽입 성공 여부 : " + set.add("one"));
		set.add("two");
		set.add("three");
		set.add("four");
		set.add("five");
		set.add("six");
		//중복을 허용하지 않아서 false반환됨
		System.out.println("\"one\" 데이터 삽입 성공 여부 : " + set.add("one"));
		
		System.out.println("입력 후 set의 데이터 총 개수 : " + set.size() + "개");
		
		/*
		 * set의 전체 데이터를 출력 방식 (index를 이용해서 못함)
		 * 1. 1.5버전의 for문 이용
		 * 2. Iterator 객체를 이용
		 * 3. toArray() 메소드 이용
		 */
		
		System.out.println("<1.5버전의 for문을 이용한 출력 > ");
		for(String str : set) {
			System.out.println(str);
		}
		
		/*
		 * Iterator 주요 메소드
		 * 		hasNext()	: 접근할 다음 데이터의 존재 여부 판단(boolean)
		 * 		next()		: 다음 데이터 이동
		 */
		System.out.println("< Iterator 객체를 이용한 출력 > ");
		Iterator<String> ite = set.iterator(); //순환자 
		while(ite.hasNext()) {
			System.out.println(ite.next());
		}
		
		System.out.println("< toArray() 메소드를 이용한 출력 >");
		Object[] objArr = set.toArray();
		for(int i = 0; i < objArr.length ; i++) {
			String str = (String)objArr[i]; 
			System.out.println(objArr[i] + ", 길이 : " + str.length() );
		}
		
		for(Object obj : objArr) {
			System.out.println(obj);
		}
	}
}
