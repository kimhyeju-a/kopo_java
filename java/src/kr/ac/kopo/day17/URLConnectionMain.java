package kr.ac.kopo.day17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import kr.ac.kopo.util.FileClose;

class AAA{
	
}
class BBB implements AutoCloseable{

	@Override
	public void close() throws Exception {
		System.out.println("BBB객체의 close() 호출");
	}
	
}
public class URLConnectionMain {

	public static void main(String[] args) {
//		FileOutputStream fos = null;
//		OutputStreamWriter osw = null;
//		BufferedWriter bw = null;
		
		try (
				FileOutputStream fos = new FileOutputStream("iotest/naver.html");
				OutputStreamWriter osw = new OutputStreamWriter(fos,"utf-8");
				BufferedWriter bw = new BufferedWriter(osw);
//				에러가 난다 => The resource type AAA does not implements autoCloseable
//				AAA aaa = new AAA();
				BBB bbb = new BBB();
		) {
//			fos = new FileOutputStream("iotest/naver.html");
//			osw = new OutputStreamWriter(fos,"utf-8");
//			bw = new BufferedWriter(osw);
			
			URL urlObj = new URL("https://www.naver.com");
			URLConnection uc = urlObj.openConnection();
			
//			System.out.println(uc.getContentType());
			
			//URL 객체의 전송정보를 iotest/naver.html 저장
			InputStream is = uc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"utf-8");
			//버퍼를 사용하기 위해 필요한 클래스 : BufferedReader
			BufferedReader br = new BufferedReader(isr); // 한라인씩 읽어온다.
			
			while(true) {
				String data = br.readLine(); //파일의 끝을 리턴값 null로 인식한다.
				if(data == null) break;
//				System.out.println(data);
				bw.write(data);
				//readLine() 은 enter전까지만 출력되는 것임. 따라서 newLine 을 적어 줘야함
				bw.newLine();
			}
			System.out.println("naver.html 저장하였습니다.");
			
			FileClose.close(br);
			FileClose.close(isr);
			FileClose.close(is);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			FileClose.close(bw);
//			FileClose.close(osw);
//			FileClose.close(fos);
		}
		
	}
}
