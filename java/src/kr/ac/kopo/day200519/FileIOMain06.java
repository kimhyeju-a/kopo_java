package kr.ac.kopo.day200519;

import java.io.FileReader;
import java.io.FileWriter;

import kr.ac.kopo.util.FileClose;

public class FileIOMain06 {

	//iotest/FileIOMain03.java --> iotest/FileIOMain03.java.txt 복사
	public static void main(String[] args) {
		
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			fr = new FileReader("iotest/FileIOMain03.java");
			fw = new FileWriter("iotest/FileIOMain03.java.txt");
			
			while(true) {
				//문자단위의 2바이트씩
				int c = fr.read();
				if(c == -1) break;
				fw.write(c);
			}
			fw.flush(); // 버퍼를 모두 보낸다 ==> 복사가 안되는 경우가 있으므로 flush를 써주는 것
			System.out.println("복사가 완료되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(fr);
			FileClose.close(fw);
			/*
			//finally가 너무 지저분하다 ==> fr.close를 사용하기 위해 try-catch 를 사용 ==> 라이브러리 파일을 만든다.(kr.ac.kopo.util > FileClose.java)
			if(fr != null) {
				try {
					fr.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(fw != null) {
				try {
					fw.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			 */
		}
	}
}
