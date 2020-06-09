package kr.ac.kopo.day17;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class AppClientMain {

	public static void main(String[] args) {
		try {
			System.out.println("서버와의 접속을 시도합니다.");
			// 2. 클라이언트 소켓을 만든다. 호스트주소와 port번호가 필요하다.
//			Socket socket = new Socket("172.16.88.136", 10000);
			Socket socket = new Socket("localhost", 10000);
			System.out.println("socket port : " + socket.getLocalPort());

			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			
			String msg = dis.readUTF();
			System.out.println("서버에서 전송된 메시지 : " + msg);
			
			
//			String str = "이진희 바~~보";
//			OutputStream os = socket.getOutputStream();
//			DataOutputStream dos = new DataOutputStream(os);
//			dos.writeUTF(str);
//			dos.flush();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
