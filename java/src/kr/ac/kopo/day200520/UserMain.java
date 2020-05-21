package kr.ac.kopo.day200520;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import kr.ac.kopo.util.FileClose;
/*
	inputStream
		- FileInputStream
		- BufferedInputStream
		- InputStreamReader
		- DataInpuStream
		- ObjectInputStream : 객체들을 관리할 수 있는 클래스
 */
public class UserMain {

	public static void write() {
		UserInfo user = new UserInfo("홍길동", 25, "경기도 광명시");
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter("iotest/userInfo.txt");
			bw = new BufferedWriter(fw);
			
			bw.write(user.getName() + ":" + user.getAge() + ":" + user.getAddr());
			bw.newLine();
			bw.flush();
			
//			System.out.println("userInfo.txt에 저장완료...");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(bw,fw);
		}
	}

	private static void read() {
		
		UserInfo user = null;
		
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			
			fr = new FileReader("iotest/userInfo.txt");
			br = new BufferedReader(fr);
			
			String data = br.readLine();
			String[] dataArr = data.split(":");
			//enum클래스로 하면 더 쉽게 할 수 있음 
			/*
			//enum : 열거형 상수 , 클래스 밖(모두 사용)에 있어도 되고 클래스 안 (내클래스만 사용)에 있어도 된다.
			enum Type {
				NAME,AGE,ADDR
				//0,1,2 로 인식하게됨
			}
			
			String name = dataArr[Type.Name]; // 명료성
			 */
			String name = dataArr[0];
			int Age = Integer.parseInt(dataArr[1]);
			String Addr = dataArr[2];
			user = new UserInfo(name, Age, Addr);
			
			System.out.println("userInfo.txt 로드완료...");
			System.out.println(user);
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			FileClose.close(br,fr);
		}
		
	}
	
	public static void main(String[] args) {
		write();
		read();
	}

}
