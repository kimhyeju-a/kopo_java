package kr.ac.kopo.day200520;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.FileClose;

public class UserListMain02 {

	public static void write() {
		//ArrayList는 Serializable 을 상속받는다 ==> ObjectOutputStream에 list를 넣는다.
		//리스트도 직렬화를 하고, 객체들도 직렬화를 해야한다. 따라서 UserVO에 implements Serializable
		List<UserVO> list = new ArrayList<>();

		list.add(new UserVO("홍길동", 25, "010-1111-2222", "서울시 서초구"));
		list.add(new UserVO("강길동", 30, "010-3333-4444", "경기도 성남시 분당구"));
		list.add(new UserVO("윤길동", 29, "010-6666-5555", "경기도 광명시"));
		list.add(new UserVO("최길동", 42, "010-7777-8888", "서울시 동작구"));

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream("iotest/object_userList.txt");
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(list);
			System.out.println("저장완료...");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(fos, oos);
		}
	}

	private static void read() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		List<UserVO> userList = null;
		try {
			fis = new FileInputStream("iotest/Object_userList.txt");
			ois = new ObjectInputStream(fis);

			userList = (List<UserVO>) ois.readObject();
			for(UserVO uv : userList) {
				System.out.println(uv);
			}
			
			System.out.println("로드완료 ...");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			FileClose.close(fis,ois);
		}

	}

	public static void main(String[] args) {
		write();
		read();
	}
}
