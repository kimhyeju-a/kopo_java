package kr.ac.kopo.day200519;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

//buffer를 사용한 사진 복사
public class FileIOMain04 {

	public static void main(String[] args) {
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			// 1단계 : stream open
			fis = new FileInputStream("iotest/photo.jpg");
			fos = new FileOutputStream("iotest/photo3.jpg");
			
			// fileterclass장착 :  BufferedInputStream, BufferedOutputStream 객체 생성
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			long start = System.currentTimeMillis();
			// 2단계 : 작업수행(read, write)
			while (true) {
				int c = bis.read();
				if (c == -1)
					break;
				bos.write(c);
			}
			long end = System.currentTimeMillis();
			System.out.println("복사가 완료되었습니다.");
			//시간이 오래걸리는 이유는 1byte읽어서 1byte 작성하기 떄문에 --> 속도를 빠르게 하기 위해 중간 매개체로 buffer를 쓴다. ==> 0.008초
			System.out.println("소요시간 : " + (end-start)/1000. + "초");
		} catch (Exception fnfn) {
			fnfn.printStackTrace();
		} finally {

			//객체 만들어 진것 반대로 지운다. filter 클래스 먼저 지운다.
			if(bis != null) {
				try {
					bis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(bos != null) {
				try {
					bos.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			try {
				if(fis !=null) {
					fis.close();					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(fos !=null) {
				try {
					fos.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
