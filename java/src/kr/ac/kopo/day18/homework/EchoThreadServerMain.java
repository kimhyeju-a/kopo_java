package kr.ac.kopo.day18.homework;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

class EchoThread extends Thread{
	
	Socket socket;
	
	public EchoThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		InetAddress client = socket.getInetAddress();
		System.out.println("[ " + client + " ] 님이 접속하셨습니다.!");
		
		try (
				InputStream is =  socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				
				OutputStream os = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				PrintWriter pw = new PrintWriter(osw);
		){
			
			while(true) {
				String msg = br.readLine();
				if(msg == null) {
					System.out.println("[" + client + "] 님과의 접속이 종료되었습니다.");
					socket.close();
					break;
				}
				System.out.println("[" + client +"] 님이 보낸 메시지 : " + msg);
				pw.println(msg);
				pw.flush();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

public class EchoThreadServerMain {

	public static void main(String[] args) {
		System.out.println("EchoServer를 구동하겠습니다.....");
		
		try {
			ServerSocket server = new ServerSocket(10001);
			
			while(true) {
				Socket client = server.accept();
				System.out.println(client);
				
				EchoThread et = new EchoThread(client);
				et.start();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
