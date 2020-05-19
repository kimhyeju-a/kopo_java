package kr.ac.kopo.day200519;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

// iotest/photo.jpg [inputStream 읽어야된다.] --> iotest/photo2.jpg 복사 [outputStream]

/*
	작업순서
	1. Stream open
	2. 작업수행(read, write)
	3. Stream close
 */
public class FileIOMain03 {

	public static void main(String[] args) {
		// 문제가 생긴다. FileNotFound
//		FileInputStream fis = new FileInputStream("iotest/photo.jpg");
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			// 1단계 : stream open
			fis = new FileInputStream("iotest/photo.jpg");
			/*
			 * 파일이 만들어지는데 0kb이다.FileOutputStream은 file정보가 사라지기 때문에 잘봐야 함.
			 */
			fos = new FileOutputStream("iotest/photo2.jpg");

			long start = System.currentTimeMillis();
			// 2단계 : 작업수행(read, write)
			while (true) {
				int c = fis.read();
				if (c == -1)
					break;
				fos.write(c);
			}
			long end = System.currentTimeMillis();
			System.out.println("복사가 완료되었습니다.");
			//시간이 오래걸리는 이유는 1byte읽어서 1byte 작성하기 떄문에 --> 속도를 빠르게 하기 위해 중간 매개체로 buffer를 쓴다.
			System.out.println("소요시간 : " + (end-start)/1000. + "초");
		} catch (Exception fnfn) {
			fnfn.printStackTrace();
		} finally {
			// 3단계 : stream close .close()도 checked Exception이다.
			// 이런식으로 하면 안된다.
//			try {
//				fis.close();
//				fos.close();
//			}

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
