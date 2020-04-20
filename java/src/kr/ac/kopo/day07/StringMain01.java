package kr.ac.kopo.day07;

public class StringMain01 {
	
	public static void main(String[] args) {
		String str = new String("hello");
		String str2 = "Hello";
		
		System.out.println("str : [" + str + "]");
		System.out.println("str2 : [" + str2 + "]");
		
		/*
		if(str == str2) {
			System.out.println("str == str2");
		}else {
			System.out.println("str != str2"); //참조 주소값을 비교하기 때문에 같지 않다고 나옴 만약 str = "Hello"; 면 같다고 나옴
		}
		*/
		
		if(str.equals(str2)) {
			System.out.println("str.equals(str2)");
		}else {
			System.out.println("!str.equals(str2");
		}
		
		boolean bool = str.equalsIgnoreCase(str2);
		if(bool) {
			System.out.println("str == str2");
		}else {
			System.out.println("str != str2");
		}
		
		str = "hello world";
		System.out.println("[" + str + "]이 \"h\"로 시작하나요? : " + str.startsWith("h"));
		System.out.println("[" + str + "]이 \"he\"로 시작하나요? : " + str.startsWith("he"));
		System.out.println("[" + str + "]이 \"He\"로 시작하나요? : " + str.startsWith("He"));
		System.out.println("[" + str + "]이 \"world\"로 끝나나요? : " + str.endsWith("world"));
		
		
		str = "boat";
		str2 = "banana";
		
		int cmp = str.compareTo(str2);
		System.out.println("compareTo() 결과 : " + cmp);
		if(cmp == 0) {
			System.out.println(str + "==" +str2);
		}else if(cmp < 0) {
			System.out.println(str + "<" + str2);
		}else {
			System.out.println(str2 + "<" + str);
		}
		
		
		String[] names = {"홍길동", "홍길순", "강길동", "윤길동", "한길동", "김철수", "강철홍", "홍길동"};
		System.out.println("< 이름이 \"홍길동\"인 사람 검색 >");
		for(String name : names) {
			if(name.equals("홍길동"))
				System.out.println(name);
		}
		System.out.println("< 성이 \"홍\"인 사람 검색 >");
		for(String name : names) {
			if(name.startsWith("홍"))
				System.out.println(name);
		}

		System.out.println("< 이름이 \"길동\"인 사람 검색 >");
		for(String name : names) {
			if(name.endsWith("길동"))
				System.out.println(name);
		}		
		
		System.out.println("< 이름이 \"홍\"이 포함된 사람 검색 >");
		for(String name : names) {
			if(name.contains("홍")) {
				System.out.println(name);
			}
			/*
			for(int i = 0; i < name.length(); i++) {
				if(name.charAt(i) == '홍') {
					System.out.println(name);
					break;
				}
			}
			*/
		}		
		
		
	}

}
