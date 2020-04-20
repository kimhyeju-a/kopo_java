package kr.ac.kopo.homework06;

public class RemoveChar {
	//change 변수에 subString 을 이용하여 문자열을 더하는 방식으로 저장한다.
	public static String removeChar(String oriStr,char delChar) {
		String change = "";
		int searchIdx = -1;
		int startIdx = 0;
		while((searchIdx = oriStr.indexOf(delChar, searchIdx +1)) != -1) {
			change += oriStr.substring(startIdx,searchIdx);
			startIdx = searchIdx + 1;
		}
		change += oriStr.substring(startIdx);
		return change;
	}
	
	public static void print(char ch, String change) {
		System.out.println("delch = '" + ch + "'인 경우 => " + change +"리턴");
	}
}
