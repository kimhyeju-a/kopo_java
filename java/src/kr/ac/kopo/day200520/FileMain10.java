package kr.ac.kopo.day200520;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.FileClose;
//실패코드
public class FileMain10 {

	public static void write() {
		List<UserVO> list = new ArrayList<>();
		
		list.add(new UserVO("홍길동",25 , "010-1111-2222","서울시 서초구"));
		list.add(new UserVO("강길동",30 , "010-3333-4444","경기도 성남시 분당구"));
		list.add(new UserVO("윤길동",29 , "010-6666-5555","경기도 광명시"));
		list.add(new UserVO("최길동",42 , "010-7777-8888","서울시 동작구"));
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream("iotest/userList.txt");
			oos = new ObjectOutputStream(fos);
			for(UserVO uv : list) {
				oos.writeObject(uv);
			}
			System.out.println("저장완료...");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(fos, oos);
		}
	}
	
	
	private static void read() {
		FileInputStream fis = null;
		List<ObjectInputStream> ois = null;
		
		try {
			fis = new FileInputStream("iotest/userList.txt");
			ois = new ArrayList<>();
			ois.add(new ObjectInputStream(fis));
			
			for(int i = 0; i < ois.size() ;i++) {				
				UserVO user = (UserVO)ois.get(i).readObject(); // 객체 단위로 읽어온다.
				System.out.println(user);
			}
			System.out.println("로드완료 ...");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(fis);
		}
		
	}
	public static void main(String[] args) {
		write();
		read();
	}
}
