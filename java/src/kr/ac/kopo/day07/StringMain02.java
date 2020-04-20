package kr.ac.kopo.day07;

import java.util.Arrays;

public class StringMain02 {

	public static void main(String[] args) {
		String str = "hello world";
		int c = 'l';
		System.out.println(c + "의 검색된 위치 : " + str.indexOf(c));
		System.out.println(c + "의 검색된 위치 : " + str.indexOf(c, 4));
		
		c = 'p';
		System.out.println(c + "의 검색된 위치 : " + str.indexOf(c));
		
		c = 'l';
		System.out.println("lastIndexOf()" + c + "의 검색된 위치" + str.lastIndexOf(c));
		
		str = "hello world";
		String searchStr = "l";
		System.out.println("<" + str + "에서 \"" + searchStr + "\" 위치 >");
		
		int searchIdx = str.indexOf(searchStr);
		while(searchIdx != -1) {
			System.out.println("검색된 위치 : " + searchIdx);
			searchIdx = str.indexOf(searchStr, searchIdx+1);
		}
		
		System.out.println("<" + str + "에서 \"" + searchStr + "\" 위치 >");
		
		searchIdx = -1;
		while((searchIdx = str.indexOf(searchStr, searchIdx+1)) != -1) {
			System.out.println("검색된 위치 : " + searchIdx);
		}
		
		str = "hello world";
		System.out.println("substring(2)" + str.substring(2));//str.substring(2, str.length())
		System.out.println("substring(2, 7)" + str.substring(2, 7));
		
		String strA = "good";
		String strB = "bye!!!";
		
		//str = strA + strB; 
		str = strA.concat(strB);
		System.out.println("str : " + str);
		
		
		str = "        hello          ";
		System.out.println("[" + str + "]의 길이" + str.length()); // 길이 23
		System.out.println("[" + str.trim() + "]의 길이" + str.length()); // 길이 23
		
		str = "홍길동전:허균:조선시대";
		System.out.println("str : " + str);
		
		String[] strArr = str.split(":");
		System.out.println(Arrays.toString(strArr));
		
		strArr = str.split(",");
		System.out.println(Arrays.toString(strArr));
		
		String data = "2020-04-20";
		String[] dataArr = data.split("-");
		System.out.println(Arrays.toString(dataArr));
		
		
		
		int num = 12345;
		System.out.println(num + 100 );// 12345100

		//num이가지고 있는 값을 문자열로 변환
		System.out.println(String.valueOf(num) + 100 );// 12345100
		
		Integer.valueOf("12"); // 문자열 12를 정수형 12로변환
		Integer.parseInt("12");
	}
	int indexOf(String str, char c) {
		int i = 0;
		while(i < str.length() && str.charAt(i) != c) {
			i++;
		}
		if(i == str.length())
			i = -1;
		return i;
	}
	
	String concat(String a, String b) {
//		String str = new String(a);
//		for(int i = 0; i < b.length(); i++) {
//			str = str + (char)b.charAt(i);
//		}
//		return str;
		
		char[] chars = new char[a.length() + b.length()];
		int loc = 0;
		for(int i = 0; i < a.length(); i++) {
			chars[loc++] = a.charAt(i);
		}
		for(int i = 0; i < b.length(); i++) {
			chars[loc++] = b.charAt(i);
		}
		return new String(chars);
	}
}
