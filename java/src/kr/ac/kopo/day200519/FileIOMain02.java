package kr.ac.kopo.day200519;

import java.io.InputStream;
import java.io.InputStreamReader;

/*
 * FileIOMain01에 한글이 입력되면 이상한 글자가 나오는 현상 수정
 * InputStream is = System.in;을 사용해 출력하면 이상할 글자가 나온다
 * 1byte씩 해석을 하기 때문에 ==> 한글은 2byte이다.
 * byte두개를 조합해서 문자로 바꿔주는 클래스가 필요 ==> filter Class ==> inputStreamReader
 */
public class FileIOMain02 {

	public static void main(String[] args) {

		System.out.println("입력하세요. 종료는 ctrl+z 입니다.");
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		
		while (true) {
			try {
				int c = isr.read();
				if(c == -1) break;
				System.out.print((char)c);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
