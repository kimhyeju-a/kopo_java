package kr.ac.kopo.day200520;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
	ObjectOutputStream
		writeObject(); // 파일을 저장하는 형태를 바이트방식이 아니라 object 형태로 저장하겠어.
		Object는 한번에 저장할 때 오브젝트의 크기만큼 파일에 저장하고 싶음
		
		-객체 직렬화가 이루어져야 한다. 객체에 implements Serializable 을 기입하면 자동으로 객체 직렬화가 이루어진다.
 */
public class FileIOMain09 {

	private static void write() {

		UserInfo user = new UserInfo("홍길동", 25, "경기도 광명시");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream("iotest/object_user.txt");
			oos = new ObjectOutputStream(fos);
			
			//나이제 쓸거야~ - 묵시적 형변환이 일어난다. Field 값을 빼는 것이 애매모호 할 때가 있다. 
			oos.writeObject(user);
			System.out.println("저장완료 ... ");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	
	
	private static void read() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream("iotest/object_user.txt");
			ois = new ObjectInputStream(fis);
			
			/*
			 * 하나의 객체를 읽어서 그 객체를 리턴한다.
			 * readObject 는 모든 객체를 받는 메소드이다.
			 * 반환형으로 Object가 반환된다 ==> UserInfo로 묵시적 형변환을 한다.
			 */
			UserInfo user = (UserInfo)ois.readObject(); // 객체 단위로 읽어온다.
			System.out.println("로드완료 ...");
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
//		write();
		//transient age를 하니 객체 직렬화에서 빼진다.
		read();
	}



}
