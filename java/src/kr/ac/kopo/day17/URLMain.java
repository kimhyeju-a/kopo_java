package kr.ac.kopo.day17;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class URLMain {

	public static void main(String[] args) {
		try {
//			URL urlObj = new URL("http://www.naver.com");			
			URL urlObj = new URL("https://onland.kbstar.com/quics?page=okbland&QSL=F");			
//			URL urlObj = new URL("https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=subway");			
			System.out.println("프로토콜 : " + urlObj.getProtocol());
			System.out.println("호스트이름 : " + urlObj.getHost());
			//포트를 쓴 적이 없으면  -1
			System.out.println("포트 : " + urlObj.getPort());
			System.out.println("경로 : " + urlObj.getPath());
			System.out.println("쿼리 : " + urlObj.getQuery());
			
			System.out.println("----------------------------------------------------------------------------");
			InputStream is = urlObj.openStream();
			InputStreamReader isr = new InputStreamReader(is,"utf-8");
			while(true) {
//				한글 이상하게 나온다. ==> inputStreamReader
//				int c = is.read();
//				if(c == -1) break;
//				System.out.print((char)c);
				int c = isr.read();
				if(c == -1) break;
				System.out.print((char)c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
