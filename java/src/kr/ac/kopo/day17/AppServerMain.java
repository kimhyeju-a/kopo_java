package kr.ac.kopo.day17;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class AppServerMain {

	public static void main(String[] args) {
		//특정포트를 열어 놓고 임의의 클라이언트가 접속할 때까지 무한대기함
		try {
			//1. 포트를 열어놔야된다. 10000번이후
			ServerSocket server = new ServerSocket(10000);		
			System.out.println("애플리케이션 서버 구동");
			
			//클라이언트가 오기 전까지 대기한다. 
			Socket client = server.accept();
			System.out.println("로컬 soket port : " + client.getLocalPort());
			System.out.println("클라이언트 socket port : " + client.getPort());
			System.out.println("클라이언트 socket ip : " + client.getInetAddress().getHostAddress());
			String msg = "접속을 환영합니다.";
			
			OutputStream os = client.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF(msg);
			dos.flush();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
