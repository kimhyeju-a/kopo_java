package kr.ac.kopo.homework05;

public class StringUtil {
	//1. 하나의 문자를 입력받아 해당 문자가 대문자이면 true 를 반환하는 isUpperChar( char c ) 메소 드를 작성하시오  
	/*
		매개변수 c가 A~Z사이면 true를 반환한다.
	 */
	boolean isUpperChar(char c){
		boolean upper = c >= 'A' && c <= 'Z';
		
		return upper;
	}
	
	//2. 하나의 문자를 입력받아 해당 문자가 소문자이면 true를 반환하는 isLowerChar(char c) 메 소드 를 작성하시오 
	/*
		매개변수 c가 a~z사이면 true를 반환한다.
	 */
	boolean isLowerChar(char c){
		boolean lower = c >= 'a' && c <= 'z';
		return lower;
	}
	
	void oneTwo(boolean b) {
		if(b)
			System.out.println("true를 반환했습니다.");
		else
			System.out.println("false를 반환했습니다.");
	}
	
	//3. 두개의 숫자를 입력받아 큰수를 반환하는 max( int i, int j) 메소드를 작성하시오 
	int max(int i, int j) {
		return i >= j? i : j;
	}
	//4. 두개의 숫자를 입력받아 작은수를 반환하는 min(int i, int j) 메소드를 작성하시오 
	int min(int i, int j) {
		return i >= j? j : i;
	}
	//5. 문자열을 입력받아 거꾸로 변경하는 reverseString( String str ) 메소드를 작성하시오
	/*
		string형 s를 하나 선언하여 str length-1 ~ 0인덱스까지 차례대로 s에 더한다. 
	 */
	String reverseString(String str) {
		String s = "";
		for(int i = str.length()-1 ; i >= 0 ; i--) {
			s += str.charAt(i);
		}
		return s;
	}
	//6. 문자열을 입력받아 대문자로 변경하는 toUpperString( String str ) 메소드를 작성하시오 
	/*
		str의 0~str.length()를 비교하여 a~z 사이면 -32를 하여 대문자로 변환한다.
	 */
	String toUpperString(String str) {
		String s = "";
		for(int i = 0 ; i < str.length() ; i++) {
			if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
				s += (char)(str.charAt(i) -32);
				
			}else
				s += str.charAt(i);
		}
		return s;
	}
	//7. 문자열을 입력받아 소문자로 변경하는 toLowerString( String str ) 메소드를 작성하시오 
	/*
		str의 0~str.length()를 비교하여 A~Z 사이면  + 32를 하여 소문자로 변환한다.
	 */
	String toLowerString(String str) {
		String s = "";
		for(int i = 0 ; i < str.length() ; i++) {
			if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				s += (char)(str.charAt(i) + 32);
				
			}else
				s += str.charAt(i);
		}
		return s;
	}
	
}
