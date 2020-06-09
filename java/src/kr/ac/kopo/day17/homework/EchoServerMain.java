package kr.ac.kopo.day17.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class EchoServerThread extends Thread {
	Socket client;

	public EchoServerThread(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		// 클라이언트가 전송해준 메시지를 수신할 객체
		InputStream is;
		try {
			is = client.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			OutputStream os = client.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw);

			while (true) {
				String msg = br.readLine();
				if (msg == null) {
					System.out.println("[" + client.getInetAddress() + "]님 접속해제");
					client.close();
					break;
				}
				System.out.println("[" + client.getInetAddress() + "] 보낸 메시지 : " + msg);

				pw.println(msg);
				pw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

public class EchoServerMain {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("-----------------------------------------------");
			System.out.println(" 	사용법 : java EchoServerMain	port번호");
			System.out.println("------------------------------------------------");
			System.exit(0);
		}

		int portNo; // 포켓번호를 담을 변수
		ServerSocket server = null;
		portNo = Integer.parseInt(args[0]);
		try {
			server = new ServerSocket(portNo);
			while (true) {

				Socket client = server.accept();
				EchoServerThread est = new EchoServerThread(client);
				System.out.println("["+client.getInetAddress()+"] 님이 접속하셨습니다.");
				est.start();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
