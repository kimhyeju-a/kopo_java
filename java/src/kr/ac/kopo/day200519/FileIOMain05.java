package kr.ac.kopo.day200519;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
/*
 * WriteChar <-> readChar
 */
public class FileIOMain05 {

	public static void write() {
		//file을 찍어보면 1byte로 나온다.
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		try{
			fos = new FileOutputStream("iotest/data_writer.txt");
			dos = new DataOutputStream(fos);
			char c = 'A';
			
			//하위 1byte만 들어가니까 B가 들어감 
//			c = '\u4142';
//			fos.write(c);
			// 1byte가 아닌 2byte로 저장하고 싶음 ==> dataoutputstream ==> A 로 보이게됨 공백문자가 앞에 나옴
			/*
				writeChars(String s)
					Writes a string to the underlying output stream as a sequence of characters.
				writeInt(int v)
					Writes an int to the underlying output stream as four bytes, high byte first.
			 */
			dos.writeChar(c);
			dos.writeInt(125); // 아스키코드 125에 해당하는 문자를 찍은 것 , 4byte를 할당한다.
			dos.writeDouble(12.1111);
			System.out.println("저장완료 .... ");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(fos != null) {
				try {
					fos.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(dos != null) {
				try {
					dos.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void read() throws Exception{
		//좋은 코드가 아니다.
		//FileNotFound 가 발생해야 하는데 throws Exception 때문에 예외가 안난다.
		FileInputStream fis = new FileInputStream("iotest/data_writer.txt");
		DataInputStream dis = new DataInputStream(fis);
		
		
		//넣은 순서를 명확히 알아야 한다.
		char c = dis.readChar();
		int num = dis.readInt();
		double num2 = dis.readDouble();
		System.out.println("읽어온 문자 : " + c);
		System.out.println("읽어온 정수 : " + num);
		System.out.println("읽어온 실수 : " + num2);
	
		
		dis.close();
		fis.close();
	}
	public static void main(String[] args) {
		write();
		try {
			read();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
