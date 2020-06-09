package kr.ac.kopo.day17;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 	args 의 length 가 1이어야 함 
	java EchoServerMain 10001
	
	echo서버의 목적 : 클라이언트가 전달한 메시지를 다시 클라이언트에게 전송
	
 */
public class EchoServerMain {
	
	public static void main(String[] args) {
		
		if(args.length != 1) {
			System.out.println("-----------------------------------------------");
			System.out.println(" 	사용법 : java EchoServerMain	port번호");
			System.out.println("------------------------------------------------");
			System.exit(0);
		}
		
		int portNo = Integer.parseInt(args[0]);
		
		try {
			ServerSocket server = new ServerSocket(portNo);
			System.out.println("클라이언트의 접속을 기다립니다.....");
			
			Socket client = server.accept();
			System.out.println("접속된 클라이언트 정보 : [" + client.getInetAddress() + "]" );
			
			//클라이언트가 전송해준 메시지를 수신할 객체
			InputStream is = client.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			//속도를 빠르게 하기 위해
			BufferedReader br = new BufferedReader(isr);
//			
//			String str = br.toString();
//			System.out.println("클라이언트에서 받은 스트링");
			
			//수신한 메시지를 클라이언트에게 재전송할 객체
			OutputStream os = client.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw);
			
			while(true) {
				String msg = br.readLine();
				if(msg == null) {
					System.out.println("클라이언트 [" + client.getInetAddress()+"]과의 접속해제");
					client.close();
					break;
				}
				System.out.println("[" + client.getInetAddress()+"] : " + msg);
				
				pw.println(msg);
				pw.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
