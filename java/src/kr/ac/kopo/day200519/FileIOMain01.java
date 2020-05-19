package kr.ac.kopo.day200519;

import java.io.InputStream;

public class FileIOMain01 {

	public static void main(String[] args) {

		System.out.println("입력하세요. 종료는 ctrl+z 입니다.");

		// 키보드 입력 장치를 이야기한다. System.in
		InputStream is = System.in;

		while (true) {
			// read라는 것 자체가 checked exception을 가지고 있다.
			/*
			 * Public abstract class InputStream { Public abstract int read() throws
			 * IOException
			 * 
			 *  the end of the streamhas been reached, the value -1 is returned. -> 파일의 끝이거나 ctrl + z 
			 */
			try {
				/*
				 * 문자를 입력해 EOF니? 아니면 출력해! 입력-출력-입력-출력되어야함 
				 * ==> 하지만 한줄입력하고 한줄출력되고 한줄입력하고 한출출력됨
				 * 		==> 입력 버퍼를 사용하기 때문
				 * 		==> ASKII CODE '윈도우에서는 \r\n==>Enter ==>1310' 
				 * 
				 * System.out.print((char)c);
				 * ==>안녕하세요 를 입력했을 때 이상한 글자가 나온다 --> 1byte씩 해석을 하기 때문에 한글은 2byte이다. 
				 * 		==> byte두개를 조합해서 문자로 바꿔주는 클래스가 필요 ==> filter Class ==> inputStreamReader
				 */
				int c = is.read();
				if(c == -1) break;
//				System.out.print(c);
				System.out.print((char)c);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
